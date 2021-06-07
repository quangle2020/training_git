package com.employee.service.impl;

import com.employee.domain.Employees;
import com.employee.repository.EmployeesRepository;
import com.employee.service.dto.EmployeeDTO;
import com.employee.service.EmployeesService;
import com.employee.service.dto.EmployeesSearchInput;
import com.employee.service.dto.EmployeesSearchOutput;
import com.employee.service.mapper.EmployeeMapperManual;
import com.employee.service.spec.EmployeesSpecification;
import com.employee.service.spec.SearchCriteria;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeesServiceImpl implements EmployeesService {
    @Autowired
    private EmployeesRepository repository;
    EmployeeMapperManual mapperManual = new EmployeeMapperManual();


    @Override
    public List<EmployeeDTO> getAll() {
        return mapperManual.toDTO(repository.findAll());
    }

    @Override
    public List<Employees> findAll() {
        return repository.findAll();
    }

    @Override
    public EmployeeDTO save(Employees employees) {
        return mapperManual.toDTO(repository.save(employees));
    }

    @Override
    public void delete(Long[] id) {
        for (long ids : id) {
            repository.deleteById(ids);
        }
    }

    @Override
    public EmployeesSearchOutput search(EmployeesSearchInput empInput) {
        EmployeesSearchOutput searchOutput = new EmployeesSearchOutput();
        Specification specName = null;
        Specification specAgeFrom = null;
        Specification specAgeTo = null;
        Specification specPosition = null;
        Specification specStartDateTo = null;
        Specification specStartDateFrom = null;
        Specification specAdress = null;
        Specification salaryTo = null;
        Specification salaryFrom = null;

        if (StringUtils.isNotBlank(empInput.getName()))
            specName = buiderSpec("name", "=", empInput.getName());
        if (StringUtils.isNotBlank((empInput.getAdress())))
            specAdress = buiderSpec("adress", "=", empInput.getAdress());
        if (empInput.getAgeFrom() != null)
            specAgeFrom = buiderSpec("age", ">=", empInput.getAgeFrom().toString());
        if (empInput.getAgeTo() != null)
            specAgeTo = buiderSpec("age", "<=", empInput.getAgeTo().toString());
        if (StringUtils.isNotBlank(empInput.getPosition()))
            specPosition = buiderSpec("position", "=", empInput.getPosition());
       // if (empInput.getStartDateFrom() != null)
      //      specStartDateFrom = buiderSpec("startDate", "<=", empInput.getStartDateFrom().toString());
      //  if (empInput.getStartDateFrom() != null)
     //       specStartDateTo = buiderSpec("startDate", "=>", empInput.getStartDateTo().toString());
        if (empInput.getSalaryFrom() != null)
            salaryFrom = buiderSpec("salary", ">=", empInput.getSalaryFrom());
        if (empInput.getSalaryTo() != null)
            salaryTo = buiderSpec("salary", "<=", empInput.getSalaryTo());


        Pageable page = PageRequest.of(0, 5);
        Page<Employees> employeesPage = repository.findAll(Specification.where(specName).and(specAdress).and(specAgeTo).and(specAgeFrom).and(salaryFrom)
                .and(salaryTo), page);

        searchOutput.setTotalItem(employeesPage.getTotalElements());
        searchOutput.setListItem(employeesPage.getContent().stream()
                .map(mapperManual::toDTO).collect(Collectors.toList()));
        return searchOutput;


    }

    private EmployeesSpecification buiderSpec(String key, String operation, String value) {
        return new EmployeesSpecification(new SearchCriteria(key, operation, value));
    }
}
