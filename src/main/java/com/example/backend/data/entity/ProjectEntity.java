package com.example.backend.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="projects")
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Project_Number")
    private Integer projectNumber;

    @Column(name="Project_Name")
    private String projectName;

    @Column(name="Building_Type")
    private String buildingType;

    @Column(name="Physical_Address")
    private String physicalAddress;

    @Column(name="Erf_Number")
    private Integer erfNumber;

    @Column(name="Total_Amount_Charged")
    private Long totalAmountCharged;

    @Column(name="Total_Amount_Paid")
    private Long totalAmountPaid;

    @Column(name="Deadline_Date")
    private LocalDate deadlineDate;

    @Column(name="Completion_Date")
    private LocalDate completionDate;

    @ManyToOne
    @JoinColumn(name="Architect_id")
    private ArchitectEntity architect;

    @ManyToOne
    @JoinColumn(name="Structural_Engineer_id")
    private StructuralEngineerEntity structuralEngineer;

    @ManyToOne
    @JoinColumn(name="Customer_id")
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name="Contractor_id")
    private ContractorEntity contractor;

    @ManyToOne
    @JoinColumn(name="Project_Manager_id")
    private ProjectManagerEntity projectManager;

    @Column(name="Finalized")
    private Boolean finalized;


}
