package com.stfl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "firstName : the first name must be filled")
    @Length(min = 3, max = 20, message = "firstName : you must write from 3 to 20 symbols")
    @Pattern(regexp = "^([А-ЯЁ]{1}[а-яё'\\-\\s]{1,19})|([A-Z]{1}[a-z'\\-\\s]{1,19})$",
            message = "firstName : the first must be with the capital letter")
    private String firstName;

    @NotBlank(message = "lastName : the last name must be filled")
    @Length(min = 3, max = 20, message = "lastName : you must write from 3 to 20 symbols")
    @Pattern(regexp = "^([А-ЯЁ]{1}[а-яё'\\-\\s]{1,19})|([A-Z]{1}[a-z'\\-\\s]{1,19})$",
            message = "lastName : the first must be with the capital letter")
    private String lastName;

    @Length(min = 3, max = 20, message = "patronymic : you must write from 3 to 20 symbols")
    @Pattern(regexp = "^([А-ЯЁ]{1}[а-яё'\\-\\s]{1,19})|([A-Z]{1}[a-z'\\-\\s]{1,19})$",
            message = "patronymic : the first must be with the capital letter")
    private String patronymic;

    @NotBlank(message = "sex : the sex must be chosen")
    private String sex;

    @NotNull(message = "birthDate : the birth date must be filled yyyy.MM.dd")
    @Past(message = "birthDate : it's impossible birth date")
    //@Pattern(regexp = "[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])") //format of date YYYY-MM-DD
    private LocalDate birthDate;
    private String phone;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "profile_group",
            joinColumns = @JoinColumn(name = "userprofile_id"),
            inverseJoinColumns = @JoinColumn(name = "usergroup_id"))
    private List<UserGroup> groups = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "medicalData_id")
    private MedicalData medicalData;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @Lob
    @Column(length = 10000000)
    private byte[] photo;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital contractWith;

    public void addUserGroupList(UserGroup userGroup) {
        groups.add(userGroup);
    }
}
