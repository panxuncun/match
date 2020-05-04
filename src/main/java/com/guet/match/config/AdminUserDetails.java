package com.guet.match.config;
import com.guet.match.common.UsableStatus;
import com.guet.match.model.UmsAdmin;
import com.guet.match.model.UmsResource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: sefer
 * @Date: 2020/3/29
 * @Description: security需要的用户详情，这个配置非常重要
 * @Source： 来源：http://www.macrozheng.com/#/architect/mall_arch_04?id=%e6%b7%bb%e5%8a%a0adminuserdetails
 */
public class AdminUserDetails implements UserDetails {
    private UmsAdmin umsAdmin;
    private List<UmsResource> resourceList;
    public AdminUserDetails(UmsAdmin umsAdmin, List<UmsResource> resourceList) {
        this.umsAdmin = umsAdmin;
        this.resourceList = resourceList;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return resourceList.stream()
                .filter(resource->resource.getPermission()!=null)
                .map(resource->new SimpleGrantedAuthority(resource.getPermission()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return umsAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return umsAdmin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    //启用状态
    @Override
    public boolean isEnabled() {
        return umsAdmin.getStatus().equals(UsableStatus.ON.getStatus());
    }
}
