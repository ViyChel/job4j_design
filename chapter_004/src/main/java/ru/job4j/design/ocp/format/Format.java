package ru.job4j.design.ocp.format;

import ru.job4j.design.srp.model.Employee;

import java.util.function.Predicate;

/**
 * Interface Format.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 06.08.2020
 */
public interface Format {
    /**
     * Print string.
     *
     * @param filter the filter
     * @return the string
     */
    String print(Predicate<Employee> filter);
}
