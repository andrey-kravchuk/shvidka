package com.stfl.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.stfl.model.HospitalDispatcher;
import com.stfl.model.UserProfile;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
public class ApplicationUser {

    //@Null
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @NotBlank(message = "username should be specified")
    @JsonProperty("user_name")
    @Pattern(regexp = "^[0-9]{10}$",
            message = "username : must be only 10 numbers of your phone")
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    @Column(unique = true)
    @ApiModelProperty(name = "user_name", example = "0631234567")
    private String username;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Length
    @NotBlank(message = "password should be specified")
    @JsonProperty("password")
    private String password;

    @NotBlank(message = "email should be specified")
    @JsonProperty(defaultValue = "email")
    @Email
    private String email;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "userProfile_id")
    private UserProfile userProfile;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "hospitalDispatcher_id")
    private HospitalDispatcher hospitalDispatcher;
}
