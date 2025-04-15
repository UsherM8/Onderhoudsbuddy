package org.example.onderhoudsbuddydal.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "service")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 100, nullable = false)
    private UUID serviceId;

    @ManyToOne
    @JoinColumn(name ="car_id", nullable = false)
    private CarEntity carEntity;
    @ManyToOne
    @JoinColumn(name="grarage_id", nullable = false)
    private GarageEntity garageEntity;

    @Column(length = 100, nullable = false)
    private String serviceType;
    @Column(length = 100, nullable = false)
    private String status;
    @Column(length = 100, nullable = false)
    private String description;
    @Column(length = 100, nullable = false)
    private Date nextServiceDate;
    @Column(length = 100, nullable = false)
    private Date date;
}
