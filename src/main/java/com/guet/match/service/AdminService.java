package com.guet.match.service;

import com.github.pagehelper.PageHelper;
import com.guet.match.common.CommonPage;
import com.guet.match.common.CommonResult;
import com.guet.match.common.UsableStatus;
import com.guet.match.dto.AddAdminParam;
import com.guet.match.dto.UpdatePasswordParam;
import com.guet.match.dto.UpdateStatusParam;
import com.guet.match.mapper.UmsAdminMapper;
import com.guet.match.mapper.UmsRoleAdminMapper;
import com.guet.match.model.*;
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
    public CommonResult addAdmin(AddAdminParam param) {
        //查重
        String username = param.getUsername();
        String password = param.getPassword();
        if (username == null || password == null){
            return CommonResult.failed("账号密码不能为空");
        }
        if (isDuplicate(username)) {
            return CommonResult.failed("账号" + username + "已存在");
        }

        UmsAdmin admin = new UmsAdmin();
        BeanUtils.copyProperties(param, admin);

        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(password);
        admin.setPassword(encodePassword);

        try {
            //插入账号信息
            adminMapper.insertSelective(admin);
            //插入 (角色-用户) 关系
            List<Long> ids = param.getRoleIds();
            //没有角色就不插入
            if (ids == null || ids.size()<1){
                return CommonResult.success(null);
            }
            for (int i = 0; i < ids.size(); i++) {
                UmsRoleAdmin relation = new UmsRoleAdmin();
                relation.setAdminId(admin.getId());
                relation.setRoleId(ids.get(i));
                roleAdminMapper.insert(relation);
            }
            return CommonResult.success(null);
        } catch (Exception e) {
            logger.error("插入管理员信息错误, 原始请求参数{}", param.toString());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return CommonResult.failed();
        }

    }

    //获取管理员(基本信息+状态)
    public UmsAdmin getAdmin(Long id) {
        if (id == null) {
            return null;
        }
        return adminMapper.selectByPrimaryKey(id);
    }

    public UmsAdmin getAdminByUsername(String username) {
        logger.info("原始参数username->{}", username);
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsAdmin> list = adminMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            logger.error("用户不存在, list->{},size->{}", list, list.size());
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
    public int resetPassword(Long id) {
        UmsAdmin admin = adminMapper.selectByPrimaryKey(id);
        if (admin == null) {
            return 0;
        }
        admin.setPassword(admin.getUsername());
        return adminMapper.updateByPrimaryKey(admin);
    }

    //修改密码
    public int updatePassword(UpdatePasswordParam param) {
        UmsAdmin admin = adminMapper.selectByPrimaryKey(param.getId());
        if (admin == null) {
            return 0;
        }
        admin.setPassword(param.getPassword());
        return adminMapper.updateByPrimaryKey(admin);
    }

    //删除管理员 by id
    public int deleteAdmin(Long id) {
        //删除对应关系
        UmsRoleAdminExample role_admin = new UmsRoleAdminExample();
        role_admin.createCriteria().andAdminIdEqualTo(id);
        roleAdminMapper.deleteByExample(role_admin);
        return adminMapper.deleteByPrimaryKey(id);
    }


    //系统管理员登录
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

    //账号查重
    public boolean isDuplicate(String username) {
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        if (adminMapper.selectByExample(example).size() > 0) {
            return true;
        }
        return false;
    }

    //register
    public UmsAdmin register(UmsAdmin param) {
        if (isDuplicate(param.getUsername())) {
            return null;
        }
        UmsAdmin admin = new UmsAdmin();
        BeanUtils.copyProperties(param, admin);
        admin.setStatus(UsableStatus.ON.getStatus());
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(encodePassword);
        adminMapper.insertSelective(admin);
        return admin;
    }

    //获取全部管理员
    public CommonResult getAdminList(String keyword, Integer pageNum, Integer pageSize) {
        UmsAdminExample example = new UmsAdminExample();
        example.setOrderByClause("id desc");
        //昵称或账号搜索
        if (keyword != null && keyword.trim().length() > 0) {
            example.createCriteria().andUsernameLike("%" + keyword + "%");
            example.or(example.createCriteria().andNickNameLike("%" + keyword + "%"));
        }
        PageHelper.startPage(pageNum, pageSize);
        List<UmsAdmin> list = adminMapper.selectByExample(example);
        //密码置空
        list.stream().forEach(admin -> admin.setPassword(null));
        return CommonResult.success(CommonPage.restPage(list));
    }


}
