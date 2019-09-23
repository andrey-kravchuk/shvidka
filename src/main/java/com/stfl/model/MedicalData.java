package com.stfl.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class MedicalData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @NotBlank(message = "height : the height field must be filled")
//    @Length(min = 1, max = 3, message = "height : you must write from 1 to 3 symbols")
//    @Pattern(regexp = "^[0-9]{1,3}$",
//            message = "height : height is indicated only in centimeters")
    private String height;

//    @NotBlank(message = "weight : the weight field must be filled")
//    @Length(min = 1, max = 3, message = "weight : you must write from 1 to 3 symbols")
//    @Pattern(regexp = "^[0-9]{1,3}$",
//            message = "weight : weight is indicated only in kilograms")
    private String weight;


    @ElementCollection
    private List<String> allergies = new ArrayList<>();

    @ElementCollection
    private List<String> chronicDiseases = new ArrayList<>();

    @ElementCollection
    private List<String> medications = new ArrayList<>();
}
