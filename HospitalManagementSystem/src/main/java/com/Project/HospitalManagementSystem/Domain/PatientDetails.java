/*
 * Author Name: Philip Meshach
 * Date: 03-07-2023
 * Praise The Lord
 */
package com.Project.HospitalManagementSystem.Domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientDetails {
    @Id
    String name;
    int contactDetails;
    String address;
    int pinCode;
}
