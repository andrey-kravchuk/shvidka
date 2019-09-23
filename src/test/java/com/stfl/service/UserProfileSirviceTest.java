package com.stfl.service;

import com.stfl.dao.ApplicationUserRepository;
import com.stfl.dto.UserProfileDto;
import com.stfl.model.UserProfile;
import com.stfl.service.convertation.userProfile.ConvertationUserProfile;
import com.stfl.user.ApplicationUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@DataJpaTest
public class UserProfileSirviceTest {

//    @TestConfiguration
//    static class UserProfileServiceTestContextConfiguration {
//
//        @Bean
//        public UserProfileService userProfileService() { return new UserProfileService();}
//
//        @Bean
//        public ConvertationUserProfile convertationUserProfile() { return new ConvertationUserProfile();}
//    }
//
//    @Autowired
//    private ApplicationUserRepository userRepo;
//
//    @Autowired
//    private UserProfileService userProfileService;
//
//    @MockBean
//    private SecurityService securityService;
//
//    private ApplicationUser user;
//    private String userName;
//
//    @Before
//    public void setUp() {
//        user = new ApplicationUser();
//        userName = "0637894545";
//        user.setUsername(userName);
//        user.setPassword("test");
//        user.setEmail("test12@test.com");
//        userRepo.save(user);
//
//        Mockito.when(securityService.getUserFromSession()).thenReturn(user);
//    }
//
//    @Test
//    public void saveProfileTest() {
//        UserProfileDto profileDto = new UserProfileDto();
//        profileDto.setFirstName("Amy");
//        profileDto.setLastName("Elly");
//        profileDto.setPatronymic("Mass");
//        profileDto.setSex("F");
//        profileDto.setBirthDate(LocalDate.of(1999,12,28));
//        userProfileService.saveProfile(profileDto);
//
//        Optional<ApplicationUser> userTest = userRepo.findByUsername(userName);
//        UserProfile profileTest = userTest.get().getUserProfile();
//        assertThat(profileTest.getFirstName()).contains("Amy");
//        assertThat(profileTest.getLastName()).contains("Elly");
//        assertThat(profileTest.getPatronymic()).contains("Mass");
//        assertThat(profileTest.getSex()).contains("F");
//        assertThat(profileTest.getPhone()).contains("0637894545");
//        assertThat(profileTest.getBirthDate().toString()).contains("1999-12-28");
//        assertThat(profileTest.getMedicalData()).isNull();
//        assertThat(profileTest.getUserGroupsList()).isEmpty();
//    }
//
//    @Test
//    public void findByIdTest() {
//        UserProfileDto profileDto = new UserProfileDto();
//        profileDto.setFirstName("Amy");
//        profileDto.setLastName("Elly");
//        profileDto.setPatronymic("Mass");
//        profileDto.setSex("F");
//        profileDto.setBirthDate(LocalDate.of(1999,12,28));
//        userProfileService.saveProfile(profileDto);
//
//        Optional<ApplicationUser> userTest = userRepo.findByUsername(userName);
//        Long profileId = userTest.get().getUserProfile().getId();
//
//        UserProfileDto profileDtoSec = userProfileService.findById(profileId);
//        assertThat(profileDtoSec.getFirstName()).contains("Amy");
//        assertThat(profileDtoSec.getLastName()).contains("Elly");
//        assertThat(profileDtoSec.getPatronymic()).contains("Mass");
//        assertThat(profileDtoSec.getSex()).contains("F");
//        assertThat(profileDtoSec.getBirthDate().toString()).contains("1999-12-28");
//        assertThat(profileDtoSec.getMedicalData_id()).isZero();
//        assertThat(profileDtoSec.getUserGroupsIdList()).isEmpty();
//    }
//
//    @Test
//    public void updateProfileTest() {
//        UserProfileDto profileDto = new UserProfileDto();
//        profileDto.setFirstName("Amy");
//        profileDto.setLastName("Elly");
//        profileDto.setPatronymic("Mass");
//        profileDto.setSex("F");
//        profileDto.setBirthDate(LocalDate.of(1999,12,28));
//        userProfileService.saveProfile(profileDto);
//
//        profileDto.setId(1L);
//        profileDto.setFirstName("Dorra");
//        profileDto.setLastName("Liontev");
//        profileDto.setBirthDate(LocalDate.of(2005,7,12));
//        userProfileService.updateProfile(profileDto);
//
//        Optional<ApplicationUser> userTest = userRepo.findByUsername(userName);
//        UserProfile profileTest = userTest.get().getUserProfile();
//
//        assertThat(profileTest.getFirstName()).contains("Dorra");
//        assertThat(profileTest.getLastName()).contains("Liontev");
//        assertThat(profileTest.getPatronymic()).contains("Mass");
//        assertThat(profileTest.getSex()).contains("F");
//        assertThat(profileTest.getPhone()).contains("0637894545");
//        assertThat(profileTest.getBirthDate().toString()).contains("2005-07-12");
//        assertThat(profileTest.getMedicalData()).isNull();
//        assertThat(profileTest.getUserGroupsList()).isEmpty();
//    }
}
