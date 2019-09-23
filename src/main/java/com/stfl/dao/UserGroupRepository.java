package com.stfl.dao;

import com.stfl.model.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Severyn Zlochovksy
 * created at 08.03.2019
 */
@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {
    Optional<UserGroup> findById(Long id);

    Optional<UserGroup> findByName(String name);
}
