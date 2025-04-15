package org.example.onderhoudsbuddydal.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "reminder")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReminderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 100, nullable = false)
    private Integer reminderId;
    @Column(length = 100, nullable = false)
    private String message;
    @Column(length = 100, nullable = false)
    private Date reminderDate;
    @Column(length = 100, nullable = false)
    private String status;
}
