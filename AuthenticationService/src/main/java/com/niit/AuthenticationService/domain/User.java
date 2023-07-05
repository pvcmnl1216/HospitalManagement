/*
 * Author Name: Philip Meshach
 * Date: 18-01-2023
 * Praise The Lord
 */
package com.niit.AuthenticationService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
