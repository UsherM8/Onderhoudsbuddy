package org.example.onderhoudsbuddydal.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "car")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 100, nullable = false)
    private Integer carId;
    @Column(length = 100, nullable = false)
    private String licencePlate;
    @Column(length = 100, nullable = false)
    private String carType;
    @Column(length = 100, nullable = false)
    private int mileage;
    @Column(length = 100, nullable = false)
    private int expiryDateApk;

    @ManyToMany(mappedBy = "car")
    private List<UserEntity> userEntities;

}
