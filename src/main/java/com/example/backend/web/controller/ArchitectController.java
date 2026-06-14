package com.example.backend.web.controller;

import com.example.backend.web.DTO.ArchitectDTO;
import com.example.backend.web.DTO.ProjectDTO;
import com.example.backend.web.service.ArchitectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/architect")

public class ArchitectController {

    private final ArchitectService architectService;

    public ArchitectController(ArchitectService architectService) {
        this.architectService = architectService;
    }

    @GetMapping
    public List<ArchitectDTO> getAllArchitects() {
        return this.architectService.getAllArchitects();
    }

    @GetMapping("/{id}")
    public ArchitectDTO getArchitect(@PathVariable(name="id") int id){

        return this.architectService.getArchitectById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ArchitectDTO addArchitect(@RequestBody ArchitectDTO architectDTO){
        return this.architectService.addArchitect(architectDTO);
    }

    @PutMapping
    public ArchitectDTO updateArchitect(@RequestBody ArchitectDTO architectDTO){
        return this.architectService.updateArchitect(architectDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteArchitect(@PathVariable(name="id") int id){
        this.architectService.deleteArchitectById(id);
    }

}



