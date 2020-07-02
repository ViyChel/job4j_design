package ru.job4j.design.ocp.format;

import org.junit.Test;
import ru.job4j.design.ocp.format.DateFormatter;
import ru.job4j.design.ocp.format.Format;
import ru.job4j.design.ocp.format.JsonFormat;
import ru.job4j.design.srp.model.Employee;
import ru.job4j.design.srp.report.ItReport;
import ru.job4j.design.srp.report.Report;
import ru.job4j.design.srp.store.MemStore;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class JsonFormatTest.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 20.08.2020
 */
public class JsonFormatTest {
    @Test
    public void whenJsonGenerate() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Vasya", now, now, 150);
        store.add(worker1);
        store.add(worker2);
        Report report = new ItReport(store);
        Format jsonFormat = new JsonFormat(report);
        StringBuilder expect = new StringBuilder()
                .append("{\"title\":\"Name; Hired; Fired; Salary;\",").append(System.lineSeparator())
                .append("\"list\":[{\"name\":\"")
                .append(worker1.getName()).append("\",")
                .append("\"hired\":\"")
                .append(DateFormatter.format(worker1.getHired())).append("\",")
                .append("\"fired\":\"")
                .append(DateFormatter.format(worker1.getFired())).append("\",")
                .append("\"salary\":")
                .append(worker1.getSalary()).append("},")
                .append("{\"name\":\"")
                .append(worker2.getName()).append("\",")
                .append("\"hired\":\"")
                .append(DateFormatter.format(worker2.getHired())).append("\",")
                .append("\"fired\":\"")
                .append(DateFormatter.format(worker2.getFired())).append("\",")
                .append("\"salary\":")
                .append(worker2.getSalary()).append("}]}");
        assertThat(jsonFormat.print(em -> true), is(expect.toString()));
    }
}