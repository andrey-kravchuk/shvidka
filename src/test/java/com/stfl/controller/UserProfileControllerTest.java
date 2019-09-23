package com.stfl.controller;

import com.stfl.dao.ApplicationUserRepository;
import com.stfl.dao.UserProfileRepository;
import com.stfl.dto.UserProfileDto;
import com.stfl.user.ApplicationUser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


//@RunWith(SpringRunner.class)
//@SpringBootTest//(webEnvironment = WebEnvironment.RANDOM_PORT)
//@DataJpaTest
public class UserProfileControllerTest {
/*
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    public ApplicationUserRepository userRepo;

    @Autowired
    public UserProfileRepository profileRepo;

    private UserProfileDto profile;
    private ApplicationUser user;


    @Before
    public void setUp() {
        profile = new UserProfileDto();
        profile.setFirstName("Nick");
        profile.setLastName("Pok");
        profile.setPatronymic("Nock");
        profile.setSex("Male");
        profile.setBirthDate(LocalDate.of(2000, 9, 7));

        user = new ApplicationUser();
        user.setUsername("0637894545");
        user.setPassword("password");
        user.setEmail("user@mail.com");
    }

    @After
    public void resetDb() {
        userRepo.deleteAll();
        userRepo.flush();
        profileRepo.deleteAll();
        profileRepo.flush();
    }

    @Test
    public void postProfileTest() {
        HttpHeaders token = userLogin(user);
        ResponseEntity<UserProfileDto> postTest = controllerPostPrfile(profile, token);

        assertThat(postTest.getStatusCode(), is(HttpStatus.CREATED));
        assertThat(postTest.getBody().getFirstName(), is("Nick"));
        assertThat(postTest.getBody().getLastName(), is("Pok"));
        assertThat(postTest.getBody().getPatronymic(), is("Nock"));
        assertThat(postTest.getBody().getSex(), is("Male"));
        assertThat(postTest.getBody().getBirthDate().toString(), is("2000-09-07"));
    }

    @Test
    public void getProfileTest() {
        HttpHeaders token = userLogin(user);
        postOperation(profile, token);
        ResponseEntity<UserProfileDto> getTest = controllerGetProfile(token);

        assertThat(getTest.getStatusCode(), is(HttpStatus.OK));
        assertThat(getTest.getBody().getFirstName(), is("Nick"));
        assertThat(getTest.getBody().getLastName(), is("Pok"));
        assertThat(getTest.getBody().getPatronymic(), is("Nock"));
        assertThat(getTest.getBody().getSex(), is("Male"));
        assertThat(getTest.getBody().getBirthDate().toString(), is("2000-09-07"));
    }

    @Test
    public void updateProfileTest() {
        HttpHeaders token = userLogin(user);
        postOperation(profile, token);
        UserProfileDto updateProfile = profile;
        updateProfile.setId(1L);
        updateProfile.setFirstName("Marry");
        updateProfile.setLastName("Anet");
        updateProfile.setPatronymic("West");
        updateProfile.setSex("Female");
        updateProfile.setBirthDate(LocalDate.of(1999, 5, 10));

        ResponseEntity<UserProfileDto> putTest = controllerPutProfile(updateProfile, token);

        assertThat(putTest.getStatusCode(), is(HttpStatus.OK));
        assertThat(putTest.getBody().getFirstName(), is("Marry"));
        assertThat(putTest.getBody().getLastName(), is("Anet"));
        assertThat(putTest.getBody().getPatronymic(), is("West"));
        assertThat(putTest.getBody().getSex(), is("Female"));
        assertThat(putTest.getBody().getBirthDate().toString(), is("1999-05-10"));
    }

    private HttpHeaders userLogin(ApplicationUser applUser) {
        restTemplate.postForEntity("/users/sign_up", applUser, ApplicationUser.class);
        ResponseEntity<ApplicationUser> login = restTemplate
                .postForEntity("/login", applUser, ApplicationUser.class);
        HttpHeaders token = login.getHeaders();
        return token;
    }

    private ResponseEntity<UserProfileDto> controllerGetProfile(HttpHeaders token) {
        ResponseEntity<UserProfileDto> resultOfGet = restTemplate
                .exchange("/users/profile?id=2", HttpMethod.GET, new HttpEntity<>(token), UserProfileDto.class);
        return resultOfGet;
    }

    private ResponseEntity<UserProfileDto> controllerPostPrfile(UserProfileDto profileDto, HttpHeaders token) {
        HttpEntity<UserProfileDto> request = new HttpEntity<>(profileDto, token);
        ResponseEntity<UserProfileDto> resultOfPost = restTemplate
                .exchange("/users/profile", HttpMethod.POST, request, UserProfileDto.class);
        return resultOfPost;
    }

    private void postOperation(UserProfileDto profileDto, HttpHeaders token) {
        HttpEntity<UserProfileDto> request = new HttpEntity<>(profileDto, token);
        restTemplate.exchange("/users/profile", HttpMethod.POST, request, UserProfileDto.class);
    }

    private ResponseEntity<UserProfileDto> controllerPutProfile(UserProfileDto profileDto, HttpHeaders token) {
        HttpEntity<UserProfileDto> request = new HttpEntity<>(profileDto, token);
        ResponseEntity<UserProfileDto> resultOfPut = restTemplate
                .exchange("/users/profile", HttpMethod.PUT, request, UserProfileDto.class);
        return resultOfPut;
    }
*/
}
