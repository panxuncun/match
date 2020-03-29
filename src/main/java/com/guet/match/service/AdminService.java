package com.guet.match.service;

import com.guet.match.common.UsableStatus;
import com.guet.match.dto.AddAdminParam;
import com.guet.match.dto.UpdatePasswordParam;
import com.guet.match.dto.UpdateStatusParam;
import com.guet.match.mapper.UmsAdminMapper;
import com.guet.match.mapper.UmsRoleAdminMapper;
import com.guet.match.model.UmsAdmin;
import com.guet.match.model.UmsAdminExample;
import com.guet.match.model.UmsRoleAdmin;
import com.guet.match.model.UmsRoleAdminExample;
import com.guet.match.util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
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

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${jwt.tokenHead}")
    private String tokenHead;



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

    public UmsAdmin getAdminByUsername(String username){
        logger.info("原始参数username->{}", username);
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsAdmin> list = adminMapper.selectByExample(example);
        if (list == null || list.size()==0){
            logger.error("用户不存在, list->{},size->{}",list,list.size());
            return null;
        }
        return list.get(0);
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

    //更新管理员状态
    public int updateAdminStatus(UpdateStatusParam param) {
        UmsAdmin admin = adminMapper.selectByPrimaryKey(param.getId());
        if (admin == null) {
            return 0;
        }
        BeanUtils.copyProperties(param, admin);
        return adminMapper.updateByPrimaryKey(admin);
    }

    //重置管理员密码，使密码 = 用户名
    public int resetPassword(Long id){
        UmsAdmin admin = adminMapper.selectByPrimaryKey(id);
        if (admin == null) {
            return 0;
        }
        admin.setPassword(admin.getUsername());
        return adminMapper.updateByPrimaryKey(admin);
    }

    //修改密码
    public int updatePassword(UpdatePasswordParam param){
        UmsAdmin admin = adminMapper.selectByPrimaryKey(param.getId());
        if (admin == null) {
            return 0;
        }
        admin.setPassword(param.getPassword());
        return adminMapper.updateByPrimaryKey(admin);
    }

    //删除管理员 by id
    public int deleteAdmin(Long id){
        return adminMapper.deleteByPrimaryKey(id);
    }



    //login
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            logger.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    //register
    public UmsAdmin register(UmsAdmin umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(UsableStatus.ON.getStatus());
        //查询是否有相同用户名的用户


        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        adminMapper.insert(umsAdmin);
        return umsAdmin;
    }



}
