package ru.job4j.design.srp.report;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import ru.job4j.design.srp.model.Employee;
import ru.job4j.design.srp.report.HrReport;
import ru.job4j.design.srp.store.MemStore;

import java.util.Calendar;

public class HrReportTest {

    @Test
    public void whenSalaryDescending() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Bob", now, now, 150);
        Employee worker3 = new Employee("Vova", now, now, 75);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        HrReport engine = new HrReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker3.getName()).append(";")
                .append(worker3.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}