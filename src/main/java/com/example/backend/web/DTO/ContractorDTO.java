package com.example.backend.web.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContractorDTO {
    private Integer contractorId;
    private String surname;
    private String name;
    private String telephoneNumber;
    private String emailAddress;
    private String physicalAddress;
}
