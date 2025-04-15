package org.example.onderhoudsbuddyweb.Models.Requests;

import lombok.Data;

import java.util.Date;

@Data
public class CreateUserRequest {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String email;
    private String password;
    private String type;
}
