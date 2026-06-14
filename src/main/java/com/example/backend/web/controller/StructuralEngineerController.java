package com.example.backend.web.controller;

import com.example.backend.web.DTO.StructuralEngineerDTO;
import com.example.backend.web.service.StructuralEngineerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/structEngineer")

public class StructuralEngineerController {

    private final StructuralEngineerService structEngineerService;

    public StructuralEngineerController(StructuralEngineerService structEngineerService) {
        this.structEngineerService = structEngineerService;
    }

    @GetMapping
    public List<StructuralEngineerDTO> getAllStructEngineers() {
        return this.structEngineerService.getAllStructEngineers();
    }

    @GetMapping("/{id}")
    public StructuralEngineerDTO getStructEngineer(@PathVariable(name="id") int id){

        return this.structEngineerService.getStructEngineerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StructuralEngineerDTO addStructEngineer(@RequestBody StructuralEngineerDTO structEngineerDTO){
        return this.structEngineerService.addStructEngineer(structEngineerDTO);
    }

    @PutMapping
    public StructuralEngineerDTO updateStructEngineer(@RequestBody StructuralEngineerDTO structEngineerDTO){
        return this.structEngineerService.updateStructEngineer(structEngineerDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteStructEngineer(@PathVariable(name="id") int id){
        this.structEngineerService.deleteStructEngineerById(id);
    }

}



