package com.employee.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employees {

    @Id
    @SequenceGenerator(name = "employee_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")

    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "position")
    private String position;

    @Column(name = "startdate")
    private Date startDate;

    @Column(name = "adress")
    private String adress;

    @Column(name = " salary")
    private BigDecimal salary;


}
