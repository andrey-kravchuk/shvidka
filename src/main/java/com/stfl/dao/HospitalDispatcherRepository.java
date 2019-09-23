package com.stfl.dao;

import com.stfl.model.HospitalDispatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HospitalDispatcherRepository extends JpaRepository<HospitalDispatcher, Long> {

    Optional<HospitalDispatcher> findHospitalDispatcherById(Long Id);
}

