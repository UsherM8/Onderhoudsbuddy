package org.example.onderhoudsbuddydal.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 100, nullable = false)// Better for UUIDs
    private UUID userId;
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

    @ManyToMany
    @JoinTable(
            name = "user_car",
            joinColumns = @JoinColumn(name ="user_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id")
    )
    private List<CarEntity> car;
}
