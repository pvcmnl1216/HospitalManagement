/*
 * Author Name: Philip Meshach
 * Date: 03-07-2023
 * Praise The Lord
 */
package com.Project.HospitalManagementSystem.Service;

import com.Project.HospitalManagementSystem.Domain.PatientDetails;
import com.Project.HospitalManagementSystem.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientImpl implements PatientService {
    @Autowired
    PatientRepository patientRepository;
    @Override
    public PatientDetails addPatient(PatientDetails patientDetails) {
        if (patientRepository.findById(patientDetails.getName()).isEmpty()){
            return patientRepository.save(patientDetails);
        }
        return null;
    }

    @Override
    public List<PatientDetails> getAll() {
        return patientRepository.findAll();
    }
}
