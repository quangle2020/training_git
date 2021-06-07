package com.employee.service;

import com.employee.domain.Employees;
import com.employee.service.dto.EmployeeDTO;
import com.employee.service.dto.EmployeesSearchInput;
import com.employee.service.dto.EmployeesSearchOutput;

import java.util.List;

public interface EmployeesService {
    List<EmployeeDTO> getAll();

    List<Employees> findAll();

    EmployeeDTO save(Employees employees);

    void delete(Long[] id);
    EmployeesSearchOutput search(EmployeesSearchInput EmpInput);
}
