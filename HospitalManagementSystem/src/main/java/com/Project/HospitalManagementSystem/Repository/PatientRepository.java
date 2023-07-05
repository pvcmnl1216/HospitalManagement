package com.Project.HospitalManagementSystem.Repository;

import com.Project.HospitalManagementSystem.Domain.PatientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientDetails,String> {
}
