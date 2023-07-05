package com.Project.HospitalManagementSystem.Service;

import com.Project.HospitalManagementSystem.Domain.PatientDetails;

import java.util.List;

public interface PatientService {
public PatientDetails addPatient(PatientDetails patientDetails);
public List<PatientDetails>getAll();
}
