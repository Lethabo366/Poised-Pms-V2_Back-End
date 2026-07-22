package com.example.backend.web.controller;

import com.example.backend.web.DTO.StructuralEngineerDTO;
import com.example.backend.web.service.StructuralEngineerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/structEngineer")
@CrossOrigin(origins = "http://localhost:5173")

public class StructuralEngineerController {

    private final StructuralEngineerService structuralEngineerService;

    public StructuralEngineerController(StructuralEngineerService structuralEngineerService) {
        this.structuralEngineerService = structuralEngineerService;
    }

    @GetMapping
    public List<StructuralEngineerDTO> getAllStructEngineers() {
        return this.structuralEngineerService.getAllStructuralEngineers();
    }

    @GetMapping("/{id}")
    public StructuralEngineerDTO getStructEngineer(@PathVariable(name="id") int id){

        return this.structuralEngineerService.getStructuralEngineerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StructuralEngineerDTO addStructEngineer(@RequestBody StructuralEngineerDTO structuralEngineerDTO){
        return this.structuralEngineerService.addStructuralEngineer(structuralEngineerDTO);
    }

    @PutMapping
    public StructuralEngineerDTO updateStructEngineer(@RequestBody StructuralEngineerDTO structuralEngineerDTO){
        return this.structuralEngineerService.updateStructuralEngineer(structuralEngineerDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteStructEngineer(@PathVariable(name="id") int id){
        this.structuralEngineerService.deleteStructuralEngineerById(id);
    }

}



