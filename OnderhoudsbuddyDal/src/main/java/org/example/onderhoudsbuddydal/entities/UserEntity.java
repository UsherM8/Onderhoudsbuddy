package org.example.onderhoudsbuddydal.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 100, nullable = false)
    private Integer userId;
    @Column(length = 100, nullable = false)
    private String firstName;
    @Column(length = 100, nullable = false)
    private String lastName;
    @Column(length = 100, nullable = false)
    private Date birthDate;
    @Column(length = 100, nullable = false)
    private String email;
    @Column(length = 100)
    private String password;
    @Column(length = 100, nullable = true)
    private String type;

    // Geen directe relatie met auto's meer
}
