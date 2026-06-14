package com.example.backend.web.controller;

import com.example.backend.web.DTO.ProjectDTO;
import com.example.backend.web.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")

public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<ProjectDTO> getAllProjects() {
        return this.projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public ProjectDTO getProject(@PathVariable(name="id") int id){

        return this.projectService.getProjectById(id);
    }

    @GetMapping("/architect/{id}")
    public List<ProjectDTO> getArchitectProjectsById(@PathVariable(name="id") int id){
        return this.projectService.getArchitectProjects(id);
    }

    @GetMapping("contractor/{id}")
    public List<ProjectDTO> getContractorProjectsById(@PathVariable(name="id") int id) {
        return this.projectService.getContractorProjects(id);
    }

    @GetMapping("projectManager/{id}")
    public List<ProjectDTO> getProjectManagerProjectsById(@PathVariable(name="id") int id) {
        return this.projectService.getProjectManagerProjects(id);
    }

    @GetMapping("structuralEngineer/{id}")
    public List<ProjectDTO> getStructuralEngineerProjectsById(@PathVariable(name="id") int id) {
        return this.projectService.getStructuralEngineerProjects(id);
    }

    @GetMapping("customer/{id}")
    public List<ProjectDTO> getCustomerProjectsById(@PathVariable(name="id") int id) {
        return this.projectService.getCustomerProjects(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectDTO addProject(@RequestBody ProjectDTO projectDTO){
        return this.projectService.addProject(projectDTO);
    }

    @PutMapping
    public ProjectDTO updateProject(@RequestBody ProjectDTO projectDTO){
        return this.projectService.updateProject(projectDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable(name="id") int id){
        this.projectService.deleteProjectById(id);
    }

}



