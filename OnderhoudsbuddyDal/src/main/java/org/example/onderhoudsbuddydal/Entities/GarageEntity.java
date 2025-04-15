package org.example.onderhoudsbuddydal.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "garage")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GarageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID garageId;

    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 100, nullable = false)
    private String streetName;
    @Column(length = 100, nullable = false)
    private String houseNumber;
    @Column(length = 100, nullable = false)
    private String city;
    @Column(length = 100, nullable = false)
    private String state;
    @Column(length = 100, nullable = false)
    private String country;
    @Column(length = 100, nullable = false)
    private String postalCode;
    @Column(length = 100, nullable = false)
    private String extraAddressInfo;
    @Column(length = 100, nullable = false)
    private String phoneNumber;
    @Column(length = 100, nullable = false)
    private String email;
}
