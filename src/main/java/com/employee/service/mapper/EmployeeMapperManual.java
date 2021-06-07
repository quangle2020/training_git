package com.employee.service.mapper;

import com.employee.domain.Employees;
import com.employee.service.dto.EmployeeDTO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMapperManual  {

    public List<EmployeeDTO> toDTO(List<Employees> empList) {
        List<EmployeeDTO> dtoList = new ArrayList<>();
        for (Employees emp : empList){
            EmployeeDTO empDTO = new EmployeeDTO();
            empDTO.setId(emp.getId());
            empDTO.setName(emp.getName());
            empDTO.setAge(emp.getAge());
            empDTO.setPosition((emp.getPosition()));
            empDTO.setStartDate(emp.getStartDate());
            empDTO.setAdress(emp.getAdress());
            empDTO.setSalary(emp.getSalary());
            dtoList.add(empDTO);
        }
            return dtoList;
    }
     public List<EmployeeDTO> toDto(List<Employees> employees){
        List<EmployeeDTO> listEmpDTO = new ArrayList<>();
        for (Employees employee:employees){
            EmployeeDTO empDTO = new EmployeeDTO();
            BeanUtils.copyProperties(employee,empDTO);
            listEmpDTO.add(empDTO);
        }
        return listEmpDTO;
     }

     public EmployeeDTO toDTO(Employees emp){
        EmployeeDTO empDTO = new EmployeeDTO();
         empDTO.setId(emp.getId());
         empDTO.setName(emp.getName());
         empDTO.setAge(emp.getAge());
         empDTO.setPosition((emp.getPosition()));
         empDTO.setStartDate(emp.getStartDate());
         empDTO.setAdress(emp.getAdress());
         empDTO.setSalary(emp.getSalary());
         return empDTO;
     }
}
