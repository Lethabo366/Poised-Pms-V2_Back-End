package com.example.backend.web.service;

import com.example.backend.data.entity.ArchitectEntity;
import com.example.backend.data.repository.ArchitectRepository;
import com.example.backend.web.DTO.ArchitectDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArchitectService {

    private final ArchitectRepository architectRepository;

    public ArchitectService(ArchitectRepository architectRepository) {
        this.architectRepository = architectRepository;
    }

    public List<ArchitectDTO> getAllArchitects() {
        List<ArchitectEntity> entities = this.architectRepository.findAll();
        List<ArchitectDTO> architectDTOS = new ArrayList<>(entities.size());
        entities.forEach(entity -> architectDTOS.add(getArchitectDTOFromEntity(entity)));
        return architectDTOS;
    }

    public ArchitectDTO getArchitectById(int id) {
        Optional<ArchitectEntity> entity = this.architectRepository.findById(id);

        ArchitectEntity architect = entity.orElseThrow(() -> new RuntimeException("Architect Not Found"));
        return this.getArchitectDTOFromEntity(architect);

    }

    public ArchitectDTO addArchitect(ArchitectDTO architectDTO) {
        ArchitectEntity entity = this.getArchitectEntityFromArchitectDTO(architectDTO);
        entity = this.architectRepository.save(entity);
        return this.getArchitectDTOFromEntity(entity);
    }

    public ArchitectDTO updateArchitect(ArchitectDTO architectDTO) {
        Optional<ArchitectEntity> architect = this.architectRepository.findById(architectDTO.getArchitectId());
        if (architect.isEmpty()) {
            throw new RuntimeException("Architect Not Found");
        } else {
            ArchitectEntity entity = this.getArchitectEntityFromArchitectDTO(architectDTO);
            entity = this.architectRepository.save(entity);
            return this.getArchitectDTOFromEntity(entity);
        }
    }


    public void deleteArchitectById(int id) {
        this.architectRepository.deleteById(id);
    }


    private ArchitectDTO getArchitectDTOFromEntity(ArchitectEntity architectEntity) {
        return new ArchitectDTO(architectEntity.getArchitectId(), architectEntity.getSurname(), architectEntity.getName(),
                architectEntity.getTelephoneNumber(), architectEntity.getEmailAddress(), architectEntity.getPhysicalAddress());

    }

    private ArchitectEntity getArchitectEntityFromArchitectDTO(ArchitectDTO architectDTO) {
        return new ArchitectEntity(architectDTO.getArchitectId(), architectDTO.getSurname(),
                architectDTO.getName(), architectDTO.getTelephoneNumber(), architectDTO.getEmailAddress(), architectDTO.getPhysicalAddress());
    }

}
