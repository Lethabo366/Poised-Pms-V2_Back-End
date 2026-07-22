package com.example.backend.web.service;

import com.example.backend.data.entity.StructuralEngineerEntity;
import com.example.backend.data.repository.StructuralEngineerRepository;
import com.example.backend.web.DTO.StructuralEngineerDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StructuralEngineerService {

    private final StructuralEngineerRepository structuralEngineerRepository;

    public StructuralEngineerService(StructuralEngineerRepository structuralEngineerRepository) {
        this.structuralEngineerRepository = structuralEngineerRepository;
    }

    public List<StructuralEngineerDTO> getAllStructuralEngineers() {
        List<StructuralEngineerEntity> entities = this.structuralEngineerRepository.findAll();
        List<StructuralEngineerDTO> structuralEngineerDTOS = new ArrayList<>(entities.size());
        entities.forEach(e -> structuralEngineerDTOS.add(getStructuralEngineerDTOFromEntity(e)));
        return structuralEngineerDTOS;
    }

    public StructuralEngineerDTO getStructuralEngineerById(int id) {
        Optional<StructuralEngineerEntity> entity = this.structuralEngineerRepository.findById(id);
        if (entity.isEmpty()) {
            throw new RuntimeException("Structural Engineer Not Found!");
        } else {
            return this.getStructuralEngineerDTOFromEntity(entity.get());
        }
    }

    public StructuralEngineerDTO addStructuralEngineer(StructuralEngineerDTO structuralEngineerDTO) {
        StructuralEngineerEntity entity = this.getStructuralEngineerEntityFromStructuralEngineerDTO(structuralEngineerDTO);
        entity = this.structuralEngineerRepository.save(entity);
        return this.getStructuralEngineerDTOFromEntity(entity);
    }

    public StructuralEngineerDTO updateStructuralEngineer(StructuralEngineerDTO structuralEngineerDTO) {
        this.structuralEngineerRepository.findById(structuralEngineerDTO.getStructEngineerId()).orElseThrow(() -> new RuntimeException("Structural Engineer Not Found!"));
        StructuralEngineerEntity entity = this.getStructuralEngineerEntityFromStructuralEngineerDTO(structuralEngineerDTO);
        entity = this.structuralEngineerRepository.save(entity);
        return this.getStructuralEngineerDTOFromEntity(entity);
    }


    public void deleteStructuralEngineerById(int id) {
        this.structuralEngineerRepository.deleteById(id);
    }

    private StructuralEngineerDTO getStructuralEngineerDTOFromEntity(StructuralEngineerEntity structuralEngineerEntity) {
        return new StructuralEngineerDTO(structuralEngineerEntity.getStructEngineerId(), structuralEngineerEntity.getSurname(), structuralEngineerEntity.getName(),
                structuralEngineerEntity.getTelephoneNumber(), structuralEngineerEntity.getEmailAddress(), structuralEngineerEntity.getPhysicalAddress());

    }

    private StructuralEngineerEntity getStructuralEngineerEntityFromStructuralEngineerDTO(StructuralEngineerDTO structuralEngineerDTO) {
        return new StructuralEngineerEntity(structuralEngineerDTO.getStructEngineerId(), structuralEngineerDTO.getSurname(),
                structuralEngineerDTO.getName(), structuralEngineerDTO.getTelephoneNumber(), structuralEngineerDTO.getEmailAddress(), structuralEngineerDTO.getPhysicalAddress());
    }

}
