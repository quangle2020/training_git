package com.employee.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesSearchOutput {
    private Long totalItem;
    List<EmployeeDTO> listItem;
}
