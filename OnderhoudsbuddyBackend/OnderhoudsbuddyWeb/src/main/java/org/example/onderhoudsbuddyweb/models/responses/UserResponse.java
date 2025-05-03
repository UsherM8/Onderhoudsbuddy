package org.example.onderhoudsbuddyweb.models.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {
    private Integer userId;
    private String firstName;
    private String lastName;
    private int birthDate;
    private String email;
    private String type;
}

