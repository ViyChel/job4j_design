package ru.job4j.design.srp;

import java.util.function.Predicate;

/**
 * Class AccountingReport.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 29.06.2020
 */
public class AccountingReport implements Report {
    private final Store store;

    /**
     * Instantiates a new Accounting report.
     *
     * @param store the store
     */
    public AccountingReport(final Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(" руб.;")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
