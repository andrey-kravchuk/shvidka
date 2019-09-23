package com.stfl.dto;

import com.stfl.model.UserGroup;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserGroupDto {

    private Long id;
    private String name;
    private Long ownerId;
    private List<Long> userProfiles = new ArrayList<>();

    public UserGroupDto(UserGroup userGroup) {
        this.id = userGroup.getId();
        this.name = userGroup.getName();
        this.ownerId = userGroup.getOwner().getId();
        if (!userGroup.getUserProfiles().isEmpty()) {
            userGroup.getUserProfiles().forEach(UserProfile ->
                    this.userProfiles.add(UserProfile.getId())
            );
        }
    }
}
