package com.stfl.security;

import com.stfl.dao.ApplicationUserRepository;
import com.stfl.exception.ApplicationUserNotFoundException;
import com.stfl.service.ApplicationUserService;
import com.stfl.user.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    ApplicationUserService applicationUserService;
//    private ApplicationUserRepository applicationUserRepository;
//
//    public UserDetailsServiceImpl(ApplicationUserRepository applicationUserRepository) {
//        this.applicationUserRepository = applicationUserRepository;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = applicationUserService.findByUserName(username);
//                applicationUserRepository.findByUsername(username).orElseThrow(()-> new ApplicationUserNotFoundException());
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
    }
}