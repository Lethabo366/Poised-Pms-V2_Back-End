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

    private final StructuralEngineerRepository structEngineerRepository;

    public StructuralEngineerService(StructuralEngineerRepository structEngineerRepository) {
        this.structEngineerRepository = structEngineerRepository;
    }

    public List<StructuralEngineerDTO> getAllStructEngineers() {
        List<StructuralEngineerEntity> entities = this.structEngineerRepository.findAll();
        List<StructuralEngineerDTO> structEngineerDTOS = new ArrayList<>(entities.size());
        entities.forEach(e -> structEngineerDTOS.add(getStructEngineerDTOFromEntity(e)));
        return structEngineerDTOS;
    }

    public StructuralEngineerDTO getStructEngineerById(int id) {
        Optional<StructuralEngineerEntity> entity = this.structEngineerRepository.findById(id);
        if (entity.isEmpty()) {
            throw new RuntimeException("Structural Engineer Not Found!");
        } else {
            return this.getStructEngineerDTOFromEntity(entity.get());
        }
    }

    public StructuralEngineerDTO addStructEngineer(StructuralEngineerDTO structEngineerDTO) {
        StructuralEngineerEntity entity = this.getStructEngineerEntityFromStructEngineerDTO(structEngineerDTO);
        entity = this.structEngineerRepository.save(entity);
        return this.getStructEngineerDTOFromEntity(entity);
    }

    public StructuralEngineerDTO updateStructEngineer(StructuralEngineerDTO structEngineerDTO) {
        this.structEngineerRepository.findById(structEngineerDTO.getStructEngineerId()).orElseThrow(() -> new RuntimeException("Structural Engineer Not Found!"));
        StructuralEngineerEntity entity = this.getStructEngineerEntityFromStructEngineerDTO(structEngineerDTO);
        entity = this.structEngineerRepository.save(entity);
        return this.getStructEngineerDTOFromEntity(entity);
    }


    public void deleteStructEngineerById(int id) {
        this.structEngineerRepository.deleteById(id);
    }

    private StructuralEngineerDTO getStructEngineerDTOFromEntity(StructuralEngineerEntity structEngineerEntity) {
        return new StructuralEngineerDTO(structEngineerEntity.getStructEngineerId(), structEngineerEntity.getSurname(), structEngineerEntity.getName(),
                structEngineerEntity.getTelephoneNumber(), structEngineerEntity.getEmailAddress(), structEngineerEntity.getPhysicalAddress());

    }

    private StructuralEngineerEntity getStructEngineerEntityFromStructEngineerDTO(StructuralEngineerDTO structEngineerDTO) {
        return new StructuralEngineerEntity(structEngineerDTO.getStructEngineerId(), structEngineerDTO.getSurname(),
                structEngineerDTO.getName(), structEngineerDTO.getTelephoneNumber(), structEngineerDTO.getEmailAddress(), structEngineerDTO.getPhysicalAddress());
    }

}
