package com.example.backend.web.service;

import com.example.backend.data.entity.ContractorEntity;
import com.example.backend.data.repository.ContractorRepository;
import com.example.backend.web.DTO.ContractorDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContractorService {

    private final ContractorRepository contractorRepository;

    public ContractorService(ContractorRepository contractorRepository) {
        this.contractorRepository = contractorRepository;
    }

    public List<ContractorDTO> getAllContractors() {
        List<ContractorEntity> entities = this.contractorRepository.findAll();
        List<ContractorDTO> contractorDTOS = new ArrayList<>(entities.size());
        entities.forEach(entity -> contractorDTOS.add(getContractorDTOFromEntity(entity)));
        return contractorDTOS;
    }

    public ContractorDTO getContractorById(int id) {
        ContractorEntity entity = this.contractorRepository.findById(id).orElseThrow(() -> new RuntimeException("Contractor Not Found!"));
        return this.getContractorDTOFromEntity(entity);
    }

    public ContractorDTO addContractor(ContractorDTO contractorDTO) {
        ContractorEntity entity = this.getContractorEntityFromContractorDTO(contractorDTO);
        entity = this.contractorRepository.save(entity);
        return this.getContractorDTOFromEntity(entity);
    }

    public ContractorDTO updateContractor(ContractorDTO contractorDTO) {
        Optional<ContractorEntity> contractor = this.contractorRepository.findById(contractorDTO.getContractorId());

        if (contractor.isEmpty()) {
            throw new RuntimeException("Contractor Not Found!");
        } else {
            ContractorEntity entity = this.getContractorEntityFromContractorDTO(contractorDTO);
            entity = this.contractorRepository.save(entity);
            return this.getContractorDTOFromEntity(entity);
        }

    }


    public void deleteContractorById(int id) {
        this.contractorRepository.deleteById(id);
    }

    private ContractorDTO getContractorDTOFromEntity(ContractorEntity contractorEntity) {
        return new ContractorDTO(contractorEntity.getContractorId(), contractorEntity.getSurname(), contractorEntity.getName(),
                contractorEntity.getTelephoneNumber(), contractorEntity.getEmailAddress(), contractorEntity.getPhysicalAddress());

    }

    private ContractorEntity getContractorEntityFromContractorDTO(ContractorDTO contractorDTO) {
        return new ContractorEntity(contractorDTO.getContractorId(), contractorDTO.getSurname(),
                contractorDTO.getName(), contractorDTO.getTelephoneNumber(), contractorDTO.getEmailAddress(), contractorDTO.getPhysicalAddress());
    }

}
