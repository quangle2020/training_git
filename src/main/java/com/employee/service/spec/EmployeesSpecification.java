package com.employee.service.spec;

import com.employee.domain.Employees;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class EmployeesSpecification implements Specification<Employees> {

    private SearchCriteria searchCriteria;

    public EmployeesSpecification(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<Employees> root, CriteriaQuery<?> criteriaQuery
            , CriteriaBuilder criteriaBuilder) {
        if (searchCriteria.getOperation().equals("=")){
            return criteriaBuilder.equal(root.get(searchCriteria.getKey()),searchCriteria.getValue());

        }else if(searchCriteria.getOperation().equals(">=")){
            return criteriaBuilder.greaterThanOrEqualTo(root.get(searchCriteria.getKey()),searchCriteria.getValue());

        }else if(searchCriteria.getOperation().equals("<=")){
            return criteriaBuilder.lessThanOrEqualTo(root.get(searchCriteria.getKey()),searchCriteria.getValue());

        }else if(searchCriteria.getOperation().equals(":")){
            return criteriaBuilder.like(root.get(searchCriteria.getKey()),"%"+searchCriteria.getValue()+"%");

        }else return criteriaBuilder.equal(root.get(searchCriteria.getKey()),searchCriteria.getValue());

    }
}
