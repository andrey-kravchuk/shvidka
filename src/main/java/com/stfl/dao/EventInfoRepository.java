package com.stfl.dao;

import com.stfl.model.EventInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventInfoRepository extends JpaRepository<EventInfo, Long> {
    Optional<EventInfo> findEventById(Long id);
}
