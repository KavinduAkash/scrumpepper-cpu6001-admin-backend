package com.swlc.ScrumPepperAdminCPU6001.service.impl;

import com.swlc.ScrumPepperAdminCPU6001.constant.OAuth2Constant;
import com.swlc.ScrumPepperAdminCPU6001.entity.AdminEntity;
import com.swlc.ScrumPepperAdminCPU6001.enums.StatusType;
import com.swlc.ScrumPepperAdminCPU6001.repository.AdminRepository;
import com.swlc.ScrumPepperAdminCPU6001.service.Oauth2UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

/**
 * @author hp
 */

@Service(value = "userService")
@Log4j2
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Oauth2UserServiceImpl implements Oauth2UserService, UserDetailsService {
    private final AdminRepository adminRepository;

    public Oauth2UserServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        log.info("Execute loadUserByUsername: s: " + s);
        try {
            UsernamePasswordAuthenticationToken authentication =
                    (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
            User user = (User) authentication.getPrincipal();
            String clientId = user.getUsername();

            if(clientId.equals(OAuth2Constant.ADMIN_CLIENT_ID)) {
                Optional<AdminEntity> byUsername = adminRepository.findByUsername(s);
                if(!byUsername.isPresent()) throw new RuntimeException();
                if(byUsername.get().getStatusType().equals(StatusType.DELETE)) throw new RuntimeException();
                return new org.springframework.security.core.userdetails.
                        User(byUsername.get().getUsername(), byUsername.get().getPassword(),
                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN")));
            }

            return null;
        } catch (Exception e) {
            log.error("Execute loadUserByUsername: " + e.getMessage());
            throw e;
        }
    }
}
