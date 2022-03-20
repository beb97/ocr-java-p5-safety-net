package com.beb97.safetynet.repository;

import com.beb97.safetynet.model.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalRecordDao extends JpaRepository<MedicalRecord, Integer> {
    
}
