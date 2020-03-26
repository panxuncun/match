package com.guet.match.service;

import com.guet.match.dto.AddAdminParam;
import com.guet.match.mapper.UmsAdminMapper;
import com.guet.match.mapper.UmsRoleAdminMapper;
import com.guet.match.model.UmsAdmin;
import com.guet.match.model.UmsAdminExample;
import com.guet.match.model.UmsRoleAdmin;
import com.guet.match.model.UmsRoleAdminExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: sefer
 * @Date: 2020/3/26
 * @Description: 系统管理员相关服务
 */
@Service
public class AdminService {
    Logger logger = LoggerFactory.getLogger(AdminService.class);
    @Autowired
    private UmsAdminMapper adminMapper;

    @Autowired
    private UmsRoleAdminMapper roleAdminMapper;

    //添加管理员(内管系统管理员)
    @Transactional
    public int addAdmin(AddAdminParam param) {
        UmsAdmin admin = new UmsAdmin();
        BeanUtils.copyProperties(param, admin);
        try {
            //插入用户信息
            adminMapper.insertSelective(admin);
            //插入 (角色-用户) 关系
            for (int i = 0; i < param.getRoleIds().length; i++) {
                UmsRoleAdmin relation = new UmsRoleAdmin();
                relation.setAdminId(admin.getId());
                relation.setRoleId(param.getRoleIds()[i]);
                roleAdminMapper.insert(relation);
            }
            return 1;
        } catch (Exception e) {
            logger.error("插入管理员信息错误, 原始请求参数{}", param.toString());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }

    }

    //获取管理员(基本信息+状态)
    public UmsAdmin getAdmin(Long id) {
        if (id == null) {
            return null;
        }
        return adminMapper.selectByPrimaryKey(id);
    }


    //获取管理员list by 角色 id
    //roleid -> adminid[] -> admin
    public List<UmsAdmin> getAdminListByRoleId(Long roleId) {
        if (roleId == null) {
            return null;
        }
        UmsRoleAdminExample example = new UmsRoleAdminExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        //拿到 （角色-用户） 关系
        List<UmsRoleAdmin> relationList = roleAdminMapper.selectByExample(example);
        //分别去查
        List<UmsAdmin> adminList = relationList.stream().map(item -> adminMapper.selectByPrimaryKey(item.getAdminId())).collect(Collectors.toList());
        return adminList;
    }
    //
    ////更新管理员
    //public int updateAdmin(UpdateAdminParam param) {
    //    UmsAdmin admin = adminMapper.selectByPrimaryKey(param.getId());
    //    if (admin == null) {
    //        return 0;
    //    }
    //    BeanUtils.copyProperties(param, admin);
    //    return adminMapper.updateByPrimaryKey(admin);
    //}

    //删除管理员 by id
    public int deleteAdmin(Long id){
        return adminMapper.deleteByPrimaryKey(id);
    }


}
