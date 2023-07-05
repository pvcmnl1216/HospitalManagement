/*
 * Author Name: Philip Meshach
 * Date: 03-07-2023
 * Praise The Lord
 */
package com.Project.HospitalManagementSystem.Controller;

import com.Project.HospitalManagementSystem.Domain.PatientDetails;
import com.Project.HospitalManagementSystem.Service.PatientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Api/V1")
public class PatientController {
    @Autowired
    PatientImpl patient;

    @PostMapping("/Adding")
    public ResponseEntity<?> addPatient(@RequestBody PatientDetails patientDetails) {
        return new ResponseEntity<>(patient.addPatient(patientDetails), HttpStatus.OK);
    }

    @GetMapping("/Getting")
    public ResponseEntity<?>getPatient(){
        return new ResponseEntity<>(patient.getAll(),HttpStatus.OK);
    }
}
