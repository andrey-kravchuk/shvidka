package com.stfl.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profileOwner_id")
    private UserProfile owner;

    @ManyToMany(mappedBy = "groups")
    private List<UserProfile> userProfiles = new ArrayList<>();

    public UserGroup(String name) {
        this.name = name;
    }
}
