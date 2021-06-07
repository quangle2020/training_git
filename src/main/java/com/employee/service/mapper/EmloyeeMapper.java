package com.employee.service.mapper;

import java.util.List;

/**
 *
 * @param <D>
 * @param <E>
 */
public interface EmloyeeMapper<D,E> {

    List<D> toDTO (List<E> empList);

}
