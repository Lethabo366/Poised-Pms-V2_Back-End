package com.example.backend.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="struct_engineers")
public class StructuralEngineerEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Struct_Engineer_id")
    private Integer structEngineerId;

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
