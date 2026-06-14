package com.example.backend.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="architects")
public class ArchitectEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Architect_id")
    private Integer architectId;

    @Column(name="Surname")
    private String surname;

    @Column(name="Name")
    private String name;

    @Column(name="Telephone_Number")
    private String telephoneNumber;

    @Column(name="Email_Address")
    private String emailAddress;

    @Column(name="Physical_Address")
    private String physicalAddress;

}
