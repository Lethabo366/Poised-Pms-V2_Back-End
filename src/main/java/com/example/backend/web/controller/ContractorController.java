package com.example.backend.web.controller;

import com.example.backend.web.DTO.ContractorDTO;
import com.example.backend.web.service.ContractorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contractor")

public class ContractorController {

    private final ContractorService contractorService;

    public ContractorController(ContractorService contractorService) {
        this.contractorService = contractorService;
    }

    @GetMapping
    public List<ContractorDTO> getAllContractors() {
        return this.contractorService.getAllContractors();
    }

    @GetMapping("/{id}")
    public ContractorDTO getContractor(@PathVariable(name="id") int id){

        return this.contractorService.getContractorById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContractorDTO addContractor(@RequestBody ContractorDTO contractorDTO){
        return this.contractorService.addContractor(contractorDTO);
    }

    @PutMapping
    public ContractorDTO updateContractor(@RequestBody ContractorDTO contractorDTO){
        return this.contractorService.updateContractor(contractorDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteContractor(@PathVariable(name="id") int id){
        this.contractorService.deleteContractorById(id);
    }

}



