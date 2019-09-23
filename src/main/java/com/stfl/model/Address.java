package com.stfl.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Data
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @NotBlank(message = "country : the country field must be filled")
//    @Length(min = 1, max = 19, message = "country : you must write from 3 to 19 symbols")
//    @Pattern(regexp = "(^[A-Z]{1}[a-z]{1,19}$)|(^[А-Я]{1}[а-я]{1,19}$)",
//            message = "country : the first must be with the letter")
    private String country;

//    @NotBlank(message = "city : the city field must be filled")
//    @Length(min = 1, max = 19, message = "city : you must write from 3 to 19 symbols")
//    @Pattern(regexp = "(^[A-Z]{1}[a-z]{1,19}$)|(^[А-Я]{1}[а-я]{1,19}$)",
//            message = "city : the first must be with the letter")
    private String city;

//    @NotBlank(message = "the state field must be filled")
//    @Length(min = 1, max = 19, message = "state : you must write from 3 to 19 symbols")
//    @Pattern(regexp = "(^[A-Z]{1}[a-z]{1,19}$)|(^[А-Я]{1}[а-я]{1,19}$)",
//            message = "state : the first must be with the letter")
    private String state;

//    @NotBlank(message = "street : the street field must be filled")
//    @Length(min = 1, max = 19, message = "street : you must write from 1 to 19 symbols")
//    @Pattern(regexp = "(^[A-Z]{1}[a-z]{1,19}$)|(^[А-Я]{1}[а-я]{1,19}$)",
//            message = "street : the first must be with the letter")
    private String street;

//    @NotBlank(message = "build : the build field must be filled")
//    @Length(min = 1, max = 10, message = "build : you must write from 1 to 10 symbols")
//    @Pattern(regexp = "^[0-9A-Za-zА-Яа-я]{1}([0-9]{0,10})?$",
//            message = "build : a building can have only one letter and digits or only digits")
    private String build;

//    @Length(min = 1, max = 10, message = "corps : you must write from 1 to 10 symbols")
//    @Pattern(regexp = "^[0-9]{1,10}$",
//            message = "corps : a corps can have only one letter and digits or only digits")
    private String corps;

//    @NotBlank(message = "apartment :the apartment field must be filled")
//    @Length(min = 1, max = 10, message = "apartment : you must write from 1 to 10 symbols")
//    @Pattern(regexp = "^[0-9]{1,10}$",
//            message = "apartment : apartment number can only consist of digits")
    private String apartment;

//    @Length(min = 1, max = 5, message = "floor : you must write from 1 to 5 symbols")
//    @Pattern(regexp = "^[0-9]{1,10}$",
//            message = "floor : floor can only consist of digits")
    private String floor;

//    @Length(min = 1, max = 10, message = "entranceCode : you must write from 1 to 10 symbols")
//    @Pattern(regexp = "^[0-9]{1,10}$",
//            message = "entranceCode : the code from the entrance can consist only of digits")
    private String entranceCode;

//    @OneToOne(mappedBy = "address")
//    private UserProfile userProfile;

    private boolean track;
}
