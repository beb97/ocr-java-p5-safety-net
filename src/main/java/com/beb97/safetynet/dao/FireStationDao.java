package com.beb97.safetynet.dao;

import com.beb97.safetynet.model.FireStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FireStationDao extends JpaRepository<FireStation, Integer> {

}
