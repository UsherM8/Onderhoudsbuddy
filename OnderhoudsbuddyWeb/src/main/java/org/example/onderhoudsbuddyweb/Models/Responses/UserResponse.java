package org.example.onderhoudsbuddyweb.Models.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
public class UserResponse {
    private UUID userId;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String email;
    private String type;
    private String password;
}

