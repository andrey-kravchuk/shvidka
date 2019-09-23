package com.stfl.service;

import com.stfl.user.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    @Autowired
    ApplicationUserService applicationUserService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public ApplicationUser getUserFromSession(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return applicationUserService.findByUserName(auth.getName());
    }

    public ApplicationUser saveUser(ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return applicationUserService.saveUser(user);
    }

    public String getUserNameFromSession() {
        ApplicationUser user = getUserFromSession();
        String name = user.getUsername();
        return name;
    }
}
