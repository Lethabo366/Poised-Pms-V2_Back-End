package com.example.backend.web.service;

import com.example.backend.data.entity.*;
import com.example.backend.data.repository.*;
import com.example.backend.web.DTO.ProjectDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ArchitectRepository architectRepository;
    private final StructuralEngineerRepository structuralEngineerRepository;
    private final ContractorRepository contractorRepository;
    private final CustomerRepository customerRepository;
    private final ProjectManagerRepository projectManagerRepository;

    public ProjectService(ProjectRepository projectRepository
            , ArchitectRepository architectRepository
            , StructuralEngineerRepository structuralEngineerRepository
            , ContractorRepository contractorRepository
            , CustomerRepository customerRepository
            , ProjectManagerRepository projectManagerRepository) {

        this.projectRepository = projectRepository;
        this.architectRepository = architectRepository;
        this.structuralEngineerRepository = structuralEngineerRepository;
        this.customerRepository = customerRepository;
        this.projectManagerRepository = projectManagerRepository;
        this.contractorRepository = contractorRepository;
    }

    public List<ProjectDTO> getAllProjects() {
        List<ProjectEntity> entities = this.projectRepository.findAll();
        List<ProjectDTO> projectDTOS = new ArrayList<>(entities.size());
        entities.forEach(e -> projectDTOS.add(getProjectDTOFromProjectEntity(e)));
        return projectDTOS;
    }

    public ProjectDTO getProjectById(int id) {
        ProjectEntity entity = this.projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Project Not Found!"));
        return this.getProjectDTOFromProjectEntity(entity);


    }

    public ProjectDTO addProject(ProjectDTO projectDTO) {
        ProjectEntity entity = getProjectEntityFromProjectDTO(projectDTO);
        entity = projectRepository.save(entity);
        return getProjectDTOFromProjectEntity(entity);
    }

    public ProjectDTO updateProject(ProjectDTO projectDTO) {
        this.projectRepository.findById(projectDTO.getProjectNumber()).orElseThrow(() -> new RuntimeException("Project Not Found!"));
        ProjectEntity entity = getProjectEntityFromProjectDTO(projectDTO);
        entity = projectRepository.save(entity);
        return getProjectDTOFromProjectEntity(entity);
    }

    public List<ProjectDTO> getArchitectProjects(int id) {
         this.architectRepository.findById(id).orElseThrow(() -> new RuntimeException("Architect Not Found!"));
        List<ProjectEntity> projects = this.projectRepository.findByArchitectArchitectId(id);
        List<ProjectDTO> projectDTOS = new ArrayList<>(projects.size());
        projects.forEach(e -> projectDTOS.add(getProjectDTOFromProjectEntity(e)));
        return projectDTOS;

    }

    public List<ProjectDTO> getContractorProjects(int id) {
        this.contractorRepository.findById(id).orElseThrow(() -> new RuntimeException("Contractor Not Found!"));
        List<ProjectEntity> projects = this.projectRepository.findByContractorContractorId(id);
        List<ProjectDTO> projectDTOS = new ArrayList<>(projects.size());
        projects.forEach(e -> projectDTOS.add(getProjectDTOFromProjectEntity(e)));
        return projectDTOS;

    }

    public List<ProjectDTO> getProjectManagerProjects(int id) {
        this.projectManagerRepository.findById(id).orElseThrow(() -> new RuntimeException("Project Manager Not Found!"));
        List<ProjectEntity> projects = this.projectRepository.findByProjectManagerProjectManagerId(id);
        List<ProjectDTO> projectDTOS = new ArrayList<>(projects.size());
        projects.forEach(e -> projectDTOS.add(getProjectDTOFromProjectEntity(e)));
        return projectDTOS;

    }

    public List<ProjectDTO> getStructuralEngineerProjects(int id) {
        this.structuralEngineerRepository.findById(id).orElseThrow(() -> new RuntimeException("Structural Engineer Not Found!"));
        List<ProjectEntity> projects = this.projectRepository.findByStructuralEngineerStructEngineerId(id);
        List<ProjectDTO> projectDTOS = new ArrayList<>(projects.size());
        projects.forEach(e -> projectDTOS.add(getProjectDTOFromProjectEntity(e)));
        return projectDTOS;

    }

    public List<ProjectDTO> getCustomerProjects(int id) {
        this.customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer Not Found!"));
        List<ProjectEntity> projects = this.projectRepository.findByCustomerCustomerId(id);
        List<ProjectDTO> projectDTOS = new ArrayList<>(projects.size());
        projects.forEach(e -> projectDTOS.add(getProjectDTOFromProjectEntity(e)));
        return projectDTOS;

    }


    public void deleteProjectById(int id) {
        projectRepository.deleteById(id);
    }

    public ProjectDTO getProjectDTOFromProjectEntity(ProjectEntity projectEntity) {
        return new ProjectDTO(projectEntity.getProjectNumber(), projectEntity.getProjectName(), projectEntity.getBuildingType()
                , projectEntity.getPhysicalAddress(), projectEntity.getErfNumber(), projectEntity.getTotalAmountCharged(), projectEntity.getTotalAmountPaid()
                , projectEntity.getDeadlineDate(), projectEntity.getCompletionDate()
                , projectEntity.getArchitect().getArchitectId(), projectEntity.getArchitect().getName(), projectEntity.getArchitect().getSurname()
                , projectEntity.getStructuralEngineer().getStructEngineerId(), projectEntity.getStructuralEngineer().getName(), projectEntity.getStructuralEngineer().getSurname()
                , projectEntity.getCustomer().getCustomerId(), projectEntity.getCustomer().getName(), projectEntity.getCustomer().getSurname()
                , projectEntity.getContractor().getContractorId(), projectEntity.getContractor().getName(), projectEntity.getContractor().getSurname()
                , projectEntity.getProjectManager().getProjManagerId(), projectEntity.getProjectManager().getName(), projectEntity.getProjectManager().getSurname()
                , projectEntity.getFinalized()
        );
    }

    public ProjectEntity getProjectEntityFromProjectDTO(ProjectDTO projectDTO) {

        ArchitectEntity architect = architectRepository.findById(projectDTO.getArchitectId()).orElseThrow();
        CustomerEntity customer = customerRepository.findById(projectDTO.getCustomerId()).orElseThrow();
        StructuralEngineerEntity structuralEngineer = structuralEngineerRepository.findById(projectDTO.getStructuralEngineerId()).orElseThrow();
        ContractorEntity contractor = contractorRepository.findById(projectDTO.getContractorId()).orElseThrow();
        ProjectManagerEntity projectManager = projectManagerRepository.findById(projectDTO.getProjectManagerId()).orElseThrow();

        return new ProjectEntity(projectDTO.getProjectNumber(),
                projectDTO.getProjectName()
                , projectDTO.getBuildingType()
                , projectDTO.getPhysicalAddress()
                , projectDTO.getErfNumber()
                , projectDTO.getTotalAmountCharged()
                , projectDTO.getTotalAmountPaid()
                , projectDTO.getDeadlineDate()
                , projectDTO.getCompletionDate()
                , architect
                , structuralEngineer
                , customer
                , contractor
                , projectManager
                , projectDTO.getFinalized());
    }


}
