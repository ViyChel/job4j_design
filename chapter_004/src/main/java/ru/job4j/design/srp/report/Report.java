package ru.job4j.design.srp.report;

import ru.job4j.design.srp.model.Employee;

import java.util.function.Predicate;

/**
 * Interface Report.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 06.08.2020
 */
public interface Report {
    /**
     * Generate string.
     *
     * @param filter the filter
     * @return the string
     */
    String generate(Predicate<Employee> filter);
}
