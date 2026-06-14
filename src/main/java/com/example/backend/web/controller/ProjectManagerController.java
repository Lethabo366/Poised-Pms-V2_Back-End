package com.example.backend.web.controller;

import com.example.backend.web.DTO.ProjectManagerDTO;
import com.example.backend.web.service.ProjectManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projManager")

public class ProjectManagerController {

    private final ProjectManagerService projManagerService;

    public ProjectManagerController(ProjectManagerService projManagerService) {
        this.projManagerService = projManagerService;
    }

    @GetMapping
    public List<ProjectManagerDTO> getAllProjManagers() {
        return this.projManagerService.getAllProjManagers();
    }

    @GetMapping("/{id}")
    public ProjectManagerDTO getProjManager(@PathVariable(name="id") int id){

        return this.projManagerService.getProjManagerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectManagerDTO addProjManager(@RequestBody ProjectManagerDTO projManagerDTO){
        return this.projManagerService.addProjManager(projManagerDTO);
    }

    @PutMapping
    public ProjectManagerDTO updateCustomer(@RequestBody ProjectManagerDTO projManagerDTO){
        return this.projManagerService.updateProjManager(projManagerDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProjManager(@PathVariable(name="id") int id){
        this.projManagerService.deleteProjManagerById(id);
    }

}



