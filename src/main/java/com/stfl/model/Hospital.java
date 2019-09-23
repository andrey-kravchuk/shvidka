package com.stfl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String hospitalName;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "hospital")
    private List<HospitalDispatcher> dispatchers = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "contractWith", cascade = CascadeType.ALL)
    private List<UserProfile> listeners;

    @Lob
    @Column(length = 10000000)
    private byte[] photo;
}
