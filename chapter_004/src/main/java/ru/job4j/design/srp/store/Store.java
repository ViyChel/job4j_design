package ru.job4j.design.srp.store;

import ru.job4j.design.srp.model.Employee;

import java.util.List;
import java.util.function.Predicate;

/**
 * Interface Store.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 06.08.2020
 */
public interface Store {

    /**
     * Find by list.
     *
     * @param filter the filter
     * @return the list
     */
    List<Employee> findBy(Predicate<Employee> filter);
}