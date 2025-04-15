package org.example.onderhoudsbuddydomain.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private UUID userId;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String email;
    private String type;
    private String password;
}
