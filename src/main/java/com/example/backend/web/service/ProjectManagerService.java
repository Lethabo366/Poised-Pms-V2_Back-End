package com.example.backend.web.service;

import com.example.backend.data.entity.ProjectManagerEntity;
import com.example.backend.data.repository.ProjectManagerRepository;
import com.example.backend.web.DTO.ProjectManagerDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectManagerService {

    private final ProjectManagerRepository projManagerRepository;

    public ProjectManagerService(ProjectManagerRepository projManagerRepository){
        this.projManagerRepository =projManagerRepository;
    }

    public List<ProjectManagerDTO> getAllProjManagers(){
        List<ProjectManagerEntity> entities = this.projManagerRepository.findAll();
        List<ProjectManagerDTO> projManagerDTOS = new ArrayList<>(entities.size());
        entities.forEach(e -> projManagerDTOS.add(getProjManagerDTOFromEntity(e)));
        return projManagerDTOS;
    }

    public ProjectManagerDTO getProjManagerById(int id){
       ProjectManagerEntity entity = this.projManagerRepository.findById(id).orElseThrow(() -> new RuntimeException("Project Manager Not Found"));

           return this.getProjManagerDTOFromEntity(entity);
       }


    public ProjectManagerDTO addProjManager(ProjectManagerDTO projManagerDTO){
        ProjectManagerEntity entity = this.getProjManagerEntityFromProjManagerDTO(projManagerDTO);
        entity = this.projManagerRepository.save(entity);
        return this.getProjManagerDTOFromEntity(entity);
    }

    public ProjectManagerDTO updateProjManager(ProjectManagerDTO projManagerDTO){
        Optional<ProjectManagerEntity> projectManager = this.projManagerRepository.findById(projManagerDTO.getProjManagerId());
        if(projectManager.isEmpty()){
            throw new RuntimeException("Project Manager Not Found!");
        }
        ProjectManagerEntity entity = this.getProjManagerEntityFromProjManagerDTO(projManagerDTO);
        entity = this.projManagerRepository.save(entity);
        return this.getProjManagerDTOFromEntity(entity);
    }


    public void deleteProjManagerById(int id){
        this.projManagerRepository.deleteById(id);
    }

    private ProjectManagerDTO getProjManagerDTOFromEntity(ProjectManagerEntity projManagerEntity){
        return new ProjectManagerDTO(projManagerEntity.getProjManagerId(),projManagerEntity.getSurname(),projManagerEntity.getName(),
                projManagerEntity.getTelephoneNumber(),projManagerEntity.getEmailAddress(),projManagerEntity.getPhysicalAddress());

    }

    private ProjectManagerEntity getProjManagerEntityFromProjManagerDTO(ProjectManagerDTO projManagerDTO){
        return new ProjectManagerEntity(projManagerDTO.getProjManagerId(),projManagerDTO.getSurname(),
                projManagerDTO.getName(),projManagerDTO.getTelephoneNumber(),projManagerDTO.getEmailAddress(),projManagerDTO.getPhysicalAddress() );
    }

}
