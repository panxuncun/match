package com.guet.match.service;

import com.guet.match.common.RoleType;
import com.guet.match.dto.AddRoleParam;
import com.guet.match.dto.UpdateRoleParam;
import com.guet.match.mapper.UmsRoleMapper;
import com.guet.match.model.UmsRole;
import com.guet.match.model.UmsRoleExample;
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
 * @Description: 角色相关服务
 */
@Service
public class RoleService {
    Logger logger = LoggerFactory.getLogger(RoleService.class);
    @Autowired
    private UmsRoleMapper roleMapper;

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
        UmsRole role = roleMapper.selectByPrimaryKey(param.getId());
        if (role == null) {
            return 0;
        }
        BeanUtils.copyProperties(param, role);
        return roleMapper.updateByPrimaryKey(role);
    }

    //删除角色 by id
    public int deleteRole(Long id){
        return roleMapper.deleteByPrimaryKey(id);
    }




}
