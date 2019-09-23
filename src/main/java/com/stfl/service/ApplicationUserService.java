package com.stfl.service;

import com.stfl.dao.ApplicationUserRepository;
import com.stfl.dto.UserDto;
import com.stfl.exception.ApplicationUserAlreadyExistException;
import com.stfl.exception.ApplicationUserNotFoundException;
import com.stfl.user.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationUserService {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    public ApplicationUser findByUserName(String username) {
        return applicationUserRepository.findByUsername(username)
                .orElseThrow(() -> new ApplicationUserNotFoundException());
    }

    public ApplicationUser saveUser(ApplicationUser user) {
        return applicationUserRepository.save(user);
    }

    public List<UserDto> getAllUsers() {
        List<ApplicationUser> users = applicationUserRepository.findAll();
        return transformUserType(users);
    }

    private List<UserDto> transformUserType(List<ApplicationUser> list) {
        List<UserDto> listDto = new ArrayList<>(list.size());
        for (ApplicationUser user : list) {
            listDto.add(new UserDto(user));
        }
        return listDto;
    }

//    public void save(ApplicationUser applicationUser){
//        if (applicationUserRepository.findByUsername(applicationUser.getUsername()).isPresent()){
//            throw new ApplicationUserAlreadyExistException();
//        } else {
//            applicationUserRepository.save(applicationUser);
//        }
//    }
}
