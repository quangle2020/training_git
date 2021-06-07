package com.employee.controller;

import com.employee.domain.Employees;
import com.employee.service.dto.EmployeeDTO;
import com.employee.service.dto.EmployeesSearchInput;
import com.employee.service.dto.EmployeesSearchOutput;
import com.employee.service.impl.EmployeesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/emp")
public class EmployeesController {
    @Autowired
    private EmployeesServiceImpl service;

    @GetMapping(value = "/get-all",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeDTO> getAll(){
        return service.getAll();
    }
    @GetMapping(value = "/find-all",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employees> findAll(){
        return service.findAll();
    }

    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeDTO saveAndUpdate(@RequestBody Employees employees) {
        return service.save(employees);
    }

     @DeleteMapping (value = "/delete-by-id",consumes = MediaType.APPLICATION_JSON_VALUE)
     public void delete(@RequestBody Long[] ids){
            service.delete(ids);
        }

    // Để là POST method nhé, ko thì để là request param, chạy postman vẫn ok, nhưng mà lên FE nó ko chạy đc.
     @GetMapping(value = "/search",consumes = MediaType.APPLICATION_JSON_VALUE,
     produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeesSearchOutput search(@RequestBody EmployeesSearchInput input){
        return service.search(input);
     }
}
