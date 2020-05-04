package com.guet.match.config;

import com.guet.match.common.UsableStatus;
import com.guet.match.model.UmsAdmin;
import com.guet.match.model.UmsOrganizer;
import com.guet.match.model.UmsResource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: sefer
 * @Date: 2020/4/13
 * @Description:
 */
public class OrganizerUserDetails implements UserDetails {
    private UmsOrganizer organizer;
    private List<String> list;
    public OrganizerUserDetails(UmsOrganizer organizer) {
        this.organizer = organizer;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return organizer.getPassword();
    }

    @Override
    public String getUsername() {
        return organizer.getUsername();
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
        //todo 这里搞一下主办方状态？
        //return umsAdmin.getStatus().equals(UsableStatus.ON.getStatus());
        return true;
    }
}
