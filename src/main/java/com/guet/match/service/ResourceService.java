package com.guet.match.service;

import com.guet.match.common.ResourceType;
import com.guet.match.dto.AddResourceParam;
import com.guet.match.dto.UpdateResourceParam;
import com.guet.match.mapper.UmsResourceMapper;
import com.guet.match.mapper.UmsResourceMapper;
import com.guet.match.model.UmsResource;
import com.guet.match.model.UmsResourceExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

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
            logger.error("不合法的参数, 资源id->{}",id);
            return null;
        }
        return resourceMapper.selectByPrimaryKey(id);
    }


    //获取资源list by 类型
    public List<UmsResource> getResourceListByType(Integer type) {
        if (type == null) {
            logger.error("不合法的参数, 资源类型, type->{}",type);
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
            logger.error("不存在的资源, id->{}",param.getId());
            return 0;
        }
        BeanUtils.copyProperties(param, resource);
        return resourceMapper.updateByPrimaryKey(resource);
    }

    //删除资源 by id todo 要不要判断是否具有删除的权限
    public int deleteResource(Long id){
        return resourceMapper.deleteByPrimaryKey(id);
    }
}
