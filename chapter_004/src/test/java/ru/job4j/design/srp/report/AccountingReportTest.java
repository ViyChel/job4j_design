package ru.job4j.design.srp.report;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import ru.job4j.design.ocp.format.DateFormatter;
import ru.job4j.design.srp.model.Employee;
import ru.job4j.design.srp.report.AccountingReport;
import ru.job4j.design.srp.store.MemStore;

import java.util.Calendar;

public class AccountingReportTest {
    @Test
    public void whenChangeSalary() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        AccountingReport report = new AccountingReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(DateFormatter.format(worker.getHired())).append(";")
                .append(DateFormatter.format(worker.getFired())).append(";")
                .append(worker.getSalary()).append(" руб.;")
                .append(System.lineSeparator());
        assertThat(report.generate(em -> true), is(expect.toString()));
    }
}