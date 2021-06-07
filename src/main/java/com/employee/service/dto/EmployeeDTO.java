package com.employee.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;

    private String name;

    private Integer age;

    private String position;

    private Date startDate;

    private String adress;

    private BigDecimal salary;
}
