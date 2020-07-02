package ru.job4j.design.ocp.format;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import ru.job4j.design.ocp.format.DateFormatter;
import ru.job4j.design.ocp.format.Format;
import ru.job4j.design.ocp.format.HtmlFormat;
import ru.job4j.design.srp.model.Employee;
import ru.job4j.design.srp.report.ItReport;
import ru.job4j.design.srp.report.Report;
import ru.job4j.design.srp.store.MemStore;

import java.util.Calendar;

/**
 * Class HtmlFormatTest.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 13.08.2020
 */
public class HtmlFormatTest {
    @Test
    public void whenHtmlFormatGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Vasya", now, now, 150);
        store.add(worker1);
        store.add(worker2);
        Report report = new ItReport(store);
        Format htmlFormat = new HtmlFormat(report);
        StringBuilder expect = new StringBuilder()
                .append("<!DOCTYPE html>").append(System.lineSeparator())
                .append("<html lang=\"en\">").append(System.lineSeparator())
                .append("<head>").append(System.lineSeparator())
                .append("<meta charset=\"UTF-8\">").append(System.lineSeparator())
                .append("<title>Report</title>").append(System.lineSeparator())
                .append("</head>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append("Name; Hired; Fired; Salary;")
                .append("<br>").append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(DateFormatter.format(worker1.getHired())).append(";")
                .append(DateFormatter.format(worker1.getFired())).append(";")
                .append(worker1.getSalary()).append(";")
                .append("<br>").append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(DateFormatter.format(worker1.getHired())).append(";")
                .append(DateFormatter.format(worker1.getFired())).append(";")
                .append(worker2.getSalary()).append(";")
                .append("<br>").append(System.lineSeparator())
                .append("</body>").append(System.lineSeparator())
                .append("</html>");
        assertThat(htmlFormat.print(em -> true), is(expect.toString()));
    }
}