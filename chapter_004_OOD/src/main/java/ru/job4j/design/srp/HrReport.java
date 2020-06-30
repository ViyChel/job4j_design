package ru.job4j.design.srp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

/**
 * Class HrReport.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 29.06.2020
 */
public class HrReport implements Report {
    private final Store store;

    /**
     * Instantiates a new Hr report.
     *
     * @param store the store
     */
    public HrReport(final Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        ArrayList<Employee> employees = new ArrayList<>(store.findBy(filter));
        sortBySalary(employees);
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;").append(System.lineSeparator());
        for (Employee employee : employees) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    private void sortBySalary(ArrayList<Employee> list) {
        list.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
    }
}
