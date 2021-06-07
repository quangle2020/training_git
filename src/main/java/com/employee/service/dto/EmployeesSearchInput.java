package com.employee.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmployeesSearchInput {
    private String name;
    private Integer ageFrom;
    private Integer ageTo;
    private String position;
    private Date startDateTo;
    private Date startDateFrom;
    private String adress;
    private String salaryTo;
    private String salaryFrom;

}
