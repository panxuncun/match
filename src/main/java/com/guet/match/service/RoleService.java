package com.guet.match.service;

import com.github.pagehelper.PageHelper;
import com.guet.match.common.CommonResult;
import com.guet.match.common.RoleType;
import com.guet.match.dto.AddRoleParam;
import com.guet.match.dto.UpdateRoleParam;
import com.guet.match.dto.UpdateStatusParam;
import com.guet.match.mapper.UmsRoleAdminMapper;
import com.guet.match.mapper.UmsRoleMapper;
import com.guet.match.mapper.UmsRoleResourceMapper;
import com.guet.match.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: sefer
 * @Date: 2020/3/26
 * @Description: 角色相关服务
 */
@Service
public class RoleService {
    Logger logger = LoggerFactory.getLogger(RoleService.class);
    @Autowired
    private UmsRoleMapper roleMapper;

    @Autowired
    private UmsRoleAdminMapper roleAdminMapper;

    @Autowired
    private UmsRoleResourceMapper roleResourceMapper;

    //添加角色(内管系统角色)
    @Transactional
    public int addRole(AddRoleParam param) {
        UmsRole role = new UmsRole();
        BeanUtils.copyProperties(param, role);
        role.setType(RoleType.ADMIN.getType());
        try {
            return roleMapper.insertSelective(role);
        } catch (Exception e) {
            logger.error("插入角色错误, 参数{}", param.toString());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }

    }

    //获取角色
    public UmsRole getRole(Long id) {
        if (id == null) {
            return null;
        }
        return roleMapper.selectByPrimaryKey(id);
    }

    //获取全部角色
    //todo pricipal
    public List<UmsRole> listAllRole(String keyword, Integer pageNum, Integer pageSize) {
        UmsRoleExample example = new UmsRoleExample();
        example.setOrderByClause("id desc");

        //角色名称搜索
        if (keyword != null && keyword.trim().length() > 0) {
            example.createCriteria().andNameLike("%" + keyword + "%");
        }
        PageHelper.startPage(pageNum, pageSize);
        return roleMapper.selectByExample(example);
    }

    //获取全部角色by admin
    public List<UmsRole> listByAdmin(Long adminId) {
        //获得角色ids
        UmsRoleAdminExample role_admin_example = new UmsRoleAdminExample();
        role_admin_example.createCriteria().andAdminIdEqualTo(adminId);
        List<Long> ids = roleAdminMapper.selectByExample(role_admin_example).stream().map(UmsRoleAdmin::getRoleId).collect(Collectors.toList());

        //判空
        if (ids.size() < 1) {
            return new ArrayList<>();
        }

        //获得角色
        UmsRoleExample example = new UmsRoleExample();
        example.createCriteria().andIdIn(ids);
        return roleMapper.selectByExample(example);

    }


    //获取角色list by 类型
    public List<UmsRole> getRoleListByType(Integer type) {
        if (type == null) {
            return null;
        }
        UmsRoleExample example = new UmsRoleExample();
        example.createCriteria().andTypeEqualTo(type);
        return roleMapper.selectByExample(example);
    }

    //更新角色
    public int updateRole(UpdateRoleParam param) {
        logger.info("=====pre update");
        UmsRole role = roleMapper.selectByPrimaryKey(param.getId());
        if (role == null) {
            return 0;
        }
        logger.info("=====update1");
        BeanUtils.copyProperties(param, role);
        logger.info("=====update2");
        return roleMapper.updateByPrimaryKey(role);
    }

    //更新角色状态
    public int updateRoleStatus(UpdateStatusParam param) {
        UmsRole role = roleMapper.selectByPrimaryKey(param.getId());
        if (role == null) {
            return 0;
        }
        role.setStatus(param.getStatus());
        return roleMapper.updateByPrimaryKey(role);
    }


    //删除角色 by id
    public int deleteRole(Long id) {

        //删除 角色-用户 关系
        UmsRoleAdminExample role_admin_example = new UmsRoleAdminExample();
        role_admin_example.createCriteria().andRoleIdEqualTo(id);
        roleAdminMapper.deleteByExample(role_admin_example);

        //删除 角色-资源 关系
        UmsRoleResourceExample role_resource_example = new UmsRoleResourceExample();
        role_resource_example.createCriteria().andRoleIdEqualTo(id);
        roleResourceMapper.deleteByExample(role_resource_example);

        //删除角色
        return roleMapper.deleteByPrimaryKey(id);
    }


}
