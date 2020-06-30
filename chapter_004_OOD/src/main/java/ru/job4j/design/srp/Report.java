package ru.job4j.design.srp;

import java.util.function.Predicate;

/**
 * Interface Report.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 29.06.2020
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
