package com.stfl.dao;

import com.stfl.model.MedicalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicalDataRepository extends JpaRepository<MedicalData, Long> {
    @Override
    Optional<MedicalData> findById(Long id);
}
