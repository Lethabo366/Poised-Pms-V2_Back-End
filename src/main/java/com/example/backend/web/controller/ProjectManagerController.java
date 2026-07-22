package com.example.backend.web.controller;

import com.example.backend.web.DTO.ProjectManagerDTO;
import com.example.backend.web.service.ProjectManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projectManager")

@CrossOrigin(origins = "http://localhost:5173")

public class ProjectManagerController {

    private final ProjectManagerService projectManagerService;

    public ProjectManagerController(ProjectManagerService projectManagerService) {
        this.projectManagerService = projectManagerService;
    }

    @GetMapping
    public List<ProjectManagerDTO> getAllProjManagers() {
        return this.projectManagerService.getAllProjManagers();
    }

    @GetMapping("/{id}")
    public ProjectManagerDTO getProjManager(@PathVariable(name="id") int id){

        return this.projectManagerService.getProjectManagerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectManagerDTO addProjManager(@RequestBody ProjectManagerDTO projManagerDTO){
        return this.projectManagerService.addProjectManager(projManagerDTO);
    }

    @PutMapping
    public ProjectManagerDTO updateCustomer(@RequestBody ProjectManagerDTO projManagerDTO){
        return this.projectManagerService.updateProjectManager(projManagerDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProjManager(@PathVariable(name="id") int id){
        this.projectManagerService.deleteProjectManagerById(id);
    }

}



