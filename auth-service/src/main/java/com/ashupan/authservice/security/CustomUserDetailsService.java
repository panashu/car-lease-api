package com.ashupan.authservice.security;

import com.ashupan.authservice.feignInterface.AppUserInterface;
import com.ashupan.authservice.responseDTO.AppUserResponseDTO;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private AppUserInterface appUserInterface;

    public CustomUserDetailsService(AppUserInterface appUserInterface) {
        this.appUserInterface = appUserInterface;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUserResponseDTO appUserResponseDTO = appUserInterface.fetchAppUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username:" + username + " not found"));

        List<GrantedAuthority> grantedAuthorities = appUserResponseDTO.getRoles()
                .stream().map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return new User(String.join("-", username, appUserResponseDTO.getEmailAddress()),
                appUserResponseDTO.getPassword(), true, true, true,
                true, grantedAuthorities);
    }
}
