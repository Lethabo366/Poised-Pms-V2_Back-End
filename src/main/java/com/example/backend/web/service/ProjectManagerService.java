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

    private final ProjectManagerRepository projectManagerRepository;

    public ProjectManagerService(ProjectManagerRepository projectManagerRepository){
        this.projectManagerRepository = projectManagerRepository;
    }

    public List<ProjectManagerDTO> getAllProjManagers(){
        List<ProjectManagerEntity> entities = this.projectManagerRepository.findAll();
        List<ProjectManagerDTO> projectManagerDTOS = new ArrayList<>(entities.size());
        entities.forEach(e -> projectManagerDTOS.add(getProjectManagerDTOFromEntity(e)));
        return projectManagerDTOS;
    }

    public ProjectManagerDTO getProjectManagerById(int id){
       ProjectManagerEntity entity = this.projectManagerRepository.findById(id).orElseThrow(() -> new RuntimeException("Project Manager Not Found"));

           return this.getProjectManagerDTOFromEntity(entity);
       }


    public ProjectManagerDTO addProjectManager(ProjectManagerDTO projManagerDTO){
        ProjectManagerEntity entity = this.getProjectManagerEntityFromProjectManagerDTO(projManagerDTO);
        entity = this.projectManagerRepository.save(entity);
        return this.getProjectManagerDTOFromEntity(entity);
    }

    public ProjectManagerDTO updateProjectManager(ProjectManagerDTO projManagerDTO){
        Optional<ProjectManagerEntity> projectManager = this.projectManagerRepository.findById(projManagerDTO.getProjectManagerId());
        if(projectManager.isEmpty()){
            throw new RuntimeException("Project Manager Not Found!");
        }
        ProjectManagerEntity entity = this.getProjectManagerEntityFromProjectManagerDTO(projManagerDTO);
        entity = this.projectManagerRepository.save(entity);
        return this.getProjectManagerDTOFromEntity(entity);
    }


    public void deleteProjectManagerById(int id){
        this.projectManagerRepository.deleteById(id);
    }

    private ProjectManagerDTO getProjectManagerDTOFromEntity(ProjectManagerEntity projectManagerEntity){
        return new ProjectManagerDTO(projectManagerEntity.getProjectManagerId(),projectManagerEntity.getSurname(),projectManagerEntity.getName(),
                projectManagerEntity.getTelephoneNumber(),projectManagerEntity.getEmailAddress(),projectManagerEntity.getPhysicalAddress());

    }

    private ProjectManagerEntity getProjectManagerEntityFromProjectManagerDTO(ProjectManagerDTO projectManagerDTO){
        return new ProjectManagerEntity(projectManagerDTO.getProjectManagerId(),projectManagerDTO.getSurname(),
                projectManagerDTO.getName(),projectManagerDTO.getTelephoneNumber(),projectManagerDTO.getEmailAddress(),projectManagerDTO.getPhysicalAddress() );
    }

}
