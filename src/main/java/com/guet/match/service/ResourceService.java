package com.guet.match.service;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.guet.match.common.CommonPage;
import com.guet.match.common.CommonResult;
import com.guet.match.common.ResourceType;
import com.guet.match.common.UsableStatus;
import com.guet.match.dto.AddResourceParam;
import com.guet.match.dto.AllocParam;
import com.guet.match.dto.UpdateResourceParam;
import com.guet.match.mapper.*;
import com.guet.match.mapper.UmsResourceMapper;
import com.guet.match.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @Auther: sefer
 * @Date: 2020/3/26
 * @Description: 资源服务
 */
@Service
public class ResourceService {
    Logger logger = LoggerFactory.getLogger(ResourceService.class);
    @Autowired
    private UmsResourceMapper resourceMapper;

    @Autowired
    private UmsRoleMapper roleMapper;

    @Autowired
    private UmsRoleResourceMapper roleResourceMapper;

    @Autowired
    private UmsRoleAdminMapper roleAdminMapper;

    //获取资源种类(表头)(parent_id = 0)可以合并下面
    public List<UmsResource> getResourceCateList() {
        UmsResourceExample example = new UmsResourceExample();
        example.setOrderByClause("sort asc");
        example.createCriteria().andParentIdEqualTo(0L);
        return resourceMapper.selectByExample(example);
    }

    //获取所有子资源(parent_id != 0)可以合并上面
    public List<UmsResource> getAllResourceList() {
        UmsResourceExample example = new UmsResourceExample();
        example.createCriteria().andParentIdNotEqualTo(0L);
        return resourceMapper.selectByExample(example);
    }

    //获取所有子资源(分页)
    public CommonResult getResourceListWithPage(Long parentId, String nameKeyword, String urlKeyword, Integer pageNum, Integer pageSize) {
        UmsResourceExample example = new UmsResourceExample();
        example.setOrderByClause("id desc");
        UmsResourceExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdNotEqualTo(0L);
        if (parentId != null) {
            criteria.andParentIdEqualTo(parentId);
        }
        if (StrUtil.isNotEmpty(nameKeyword)) {
            criteria.andNameLike('%' + nameKeyword + '%');
        }
        if (StrUtil.isNotEmpty(urlKeyword)) {
            criteria.andUrlLike('%' + urlKeyword + '%');
        }
        PageHelper.startPage(pageNum, pageSize);
        List<UmsResource> list = resourceMapper.selectByExample(example);
        return CommonResult.success(CommonPage.restPage(list));
    }

    //添加资源
    @Transactional
    public int addResource(AddResourceParam param) {
        UmsResource resource = new UmsResource();
        BeanUtils.copyProperties(param, resource);
        try {
            return resourceMapper.insertSelective(resource);
        } catch (Exception e) {
            logger.error("插入资源错误, 原始参数{}", param.toString());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }

    //获取资源
    public UmsResource getResource(Long id) {
        if (id == null) {
            logger.error("不合法的参数, 资源id->{}", id);
            return null;
        }
        return resourceMapper.selectByPrimaryKey(id);
    }


    //获取资源by 角色,todo左连接
    public List<UmsResource> getResourceByRole(Long roleId) {
        UmsRoleResourceExample role_resourceExample = new UmsRoleResourceExample();
        role_resourceExample.createCriteria().andRoleIdEqualTo(roleId);
        List<Long> resourceIds = roleResourceMapper.selectByExample(role_resourceExample).stream().map(role_Resource -> role_Resource.getResourceId()).collect(Collectors.toList());
        logger.info("得到资源ids, 大小->{},resourceIds->{}", resourceIds.size(), resourceIds.toString());
        if (resourceIds.size() == 0) {
            //return null;4.20注释
            return new ArrayList<>();
        }
        //由资源ids得到资源
        UmsResourceExample resourceExample = new UmsResourceExample();
        resourceExample.createCriteria().andIdIn(resourceIds);
        return resourceMapper.selectByExample(resourceExample);
    }



    //获取资源by admin id,改造成sql语句更简单 5.13改动
    public List<UmsResource> getResourceListByAdminId(Long adminId) {
        if (adminId == null) {
            logger.error("不合法的参数, AdminId->{}", adminId);
            return null;
        }
        List<UmsResource> list = resourceMapper.getResourceByAdminId(adminId);
        if (list == null || list.size() == 0){
            return new ArrayList<>();
        }
        return list;
    }

    //获取资源权限名称，用于前端动态路由
    public List getResourceNameForRouter(Long id) {
        List<String> res = getResourceListByAdminId(id).stream().map(item -> item.getPermission()).collect(Collectors.toList());
        res.add("base");//为了防止0长数组而加进去，因为前端不允许0长数组
        return res;
    }


    //获取资源list by 类型
    public List<UmsResource> getResourceListByType(Integer type) {
        if (type == null) {
            logger.error("不合法的参数, 资源类型, type->{}", type);
            return null;
        }
        UmsResourceExample example = new UmsResourceExample();
        example.createCriteria().andTypeEqualTo(type);
        return resourceMapper.selectByExample(example);
    }

    //更新资源
    public int updateResource(UpdateResourceParam param) {
        UmsResource resource = resourceMapper.selectByPrimaryKey(param.getId());
        if (resource == null) {
            logger.error("不存在的资源, id->{}", param.getId());
            return 0;
        }
        BeanUtils.copyProperties(param, resource);
        return resourceMapper.updateByPrimaryKey(resource);
    }

    //删除资源 by id 这个不好写触发器，角色那个可以，没有特殊性的容易写
    public int deleteResource(Long id) {
        logger.info("=====资源id->{}", id);

        //如果是父类资源，则删除所有子资源，以及所有 角色-资源关系
        UmsResource resource = resourceMapper.selectByPrimaryKey(id);
        if (resource.getParentId() == 0L) {
            //得到子资源
            UmsResourceExample resourceExample = new UmsResourceExample();
            resourceExample.createCriteria().andParentIdEqualTo(id);


            //清除子资源，得到ids
            List<Long> ids = new ArrayList<>();
            resourceMapper.selectByExample(resourceExample).stream().forEach(item -> {
                ids.add(item.getId());
                resourceMapper.deleteByPrimaryKey(item.getId());
            });
            ids.add(id);

            //清除 角色-资源关系，根据ids
            UmsRoleResourceExample role_resource_example = new UmsRoleResourceExample();
            role_resource_example.createCriteria().andResourceIdIn(ids);
            int count = roleResourceMapper.deleteByExample(role_resource_example);
            logger.info("删除了{}条 角色-资源 关系", count);

            //删除自身
            return resourceMapper.deleteByPrimaryKey(id);
        }

        //否则，就是子类资源
        //删除关系
        UmsRoleResourceExample role_resource_example = new UmsRoleResourceExample();
        role_resource_example.createCriteria().andResourceIdEqualTo(id);
        int count = roleResourceMapper.deleteByExample(role_resource_example);
        logger.info("删除了{}条 角色-资源 关系", count);

        //删除资源
        logger.info("删除资源,id->{}", id);
        return resourceMapper.deleteByPrimaryKey(id);
    }

    //为角色分配资源
    public CommonResult allocResource(AllocParam param) {
        Long roleId = param.getId();
        List<Long> ids = param.getIds();
        if (ids == null || ids == null) {
            return CommonResult.failed();
        }
        try {
            //删除原来的关系
            UmsRoleResourceExample role_resource_example = new UmsRoleResourceExample();
            role_resource_example.createCriteria().andRoleIdEqualTo(roleId);
            roleResourceMapper.deleteByExample(role_resource_example);

            //插入新关系
            ids.stream().forEach(item -> {
                UmsRoleResource role_resource = new UmsRoleResource();
                role_resource.setRoleId(roleId);
                role_resource.setResourceId(item);
                roleResourceMapper.insertSelective(role_resource);
            });
            return CommonResult.success(null);
        } catch (Exception e) {
            return CommonResult.failed();
        }

    }
}
