package com.example.backend.web.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {

    private Integer projectNumber;
    private String projectName;
    private String buildingType;
    private String physicalAddress;
    private Integer erfNumber;
    private Long totalAmountCharged;
    private Long totalAmountPaid;
    private LocalDate deadlineDate;
    private LocalDate completionDate;

    private Integer architectId;
    private String architectName;
    private String architectSurname;

    private Integer structuralEngineerId;
    private String structuralEngineerName;
    private String structuralEngineerSurname;

    private Integer customerId;
    private String customerName;
    private String customerSurname;

    private Integer contractorId;
    private String contractorName;
    private String contractorSurname;

    private Integer projectManagerId;
    private String projectManagerName;
    private String projectManagerSurname;

    private Boolean finalized;

}
