package com.example.project_19.Service;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.project_19.Models.User;

public class CustomUserDetail implements UserDetails {


    private User user;


    public CustomUserDetail(User user) {
        this.user = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }


    public String getusername() {
        return user.getusername();
    }


    public String getPassword() {
        return user.getPassword();
    }


    public String getUsername() {
       
        return user.getEmail();
    }


    public boolean isAccountNonExpired() {
   
        return true;
    }


    public boolean isAccountNonLocked() {
   
        return true;
    }


    @Override
    public boolean isCredentialsNonExpired() {
   
        return true;
    }


   @Override
   public boolean isEnabled() {
	   return true;
   }
}