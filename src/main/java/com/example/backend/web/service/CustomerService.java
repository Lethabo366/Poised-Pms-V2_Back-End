package com.example.backend.web.service;

import com.example.backend.data.entity.CustomerEntity;
import com.example.backend.data.repository.CustomerRepository;
import com.example.backend.web.DTO.CustomerDTO;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<CustomerDTO> getAllCustomers(){
        List<CustomerEntity> entities = this.customerRepository.findAll();
        List<CustomerDTO> customerDTOS = new ArrayList<>(entities.size());
        entities.forEach(entity -> customerDTOS.add(getCustomerDTOFromEntity(entity)));
        return customerDTOS;
    }

    public CustomerDTO getCustomerById(int id){
       CustomerEntity entity = this.customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer Not Found"));
       return this.getCustomerDTOFromEntity(entity);
       }

    public CustomerDTO addCustomer(CustomerDTO customerDTO){
        CustomerEntity entity = this.getCustomerEntityFromCustomerDTO(customerDTO);
        entity = this.customerRepository.save(entity);
        return this.getCustomerDTOFromEntity(entity);
    }

    public CustomerDTO updateCustomer(CustomerDTO customerDTO){
        Optional<CustomerEntity> customer = this.customerRepository.findById(customerDTO.getCustomerId());
        CustomerEntity entity = this.getCustomerEntityFromCustomerDTO(customerDTO);
        entity = this.customerRepository.save(entity);
        return this.getCustomerDTOFromEntity(entity);
    }


    public void deleteCustomerById(int id){
        this.customerRepository.deleteById(id);
    }

    private CustomerDTO getCustomerDTOFromEntity(CustomerEntity customerEntity){
        return new CustomerDTO(customerEntity.getCustomerId(),customerEntity.getSurname(),customerEntity.getName(),
                customerEntity.getTelephoneNumber(),customerEntity.getEmailAddress(),customerEntity.getPhysicalAddress());

    }

    private CustomerEntity getCustomerEntityFromCustomerDTO(CustomerDTO customerDTO){
        return new CustomerEntity(customerDTO.getCustomerId(),customerDTO.getSurname(),
                customerDTO.getName(),customerDTO.getTelephoneNumber(),customerDTO.getEmailAddress(),customerDTO.getPhysicalAddress() );
    }

}
