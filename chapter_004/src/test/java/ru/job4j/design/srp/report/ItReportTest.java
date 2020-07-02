package ru.job4j.design.srp.report;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import ru.job4j.design.ocp.format.DateFormatter;
import ru.job4j.design.srp.model.Employee;
import ru.job4j.design.srp.report.ItReport;
import ru.job4j.design.srp.store.MemStore;

import java.util.Calendar;


/**
 * Class ItReportTest.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 06.08.2020
 */
public class ItReportTest {
    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ItReport engine = new ItReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(DateFormatter.format(worker.getHired())).append(";")
                .append(DateFormatter.format(worker.getFired())).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}