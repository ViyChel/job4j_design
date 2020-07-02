package ru.job4j.design.ocp.format;

import org.junit.Test;
import ru.job4j.design.ocp.format.Format;
import ru.job4j.design.ocp.format.XmlFormat;
import ru.job4j.design.srp.model.Employee;
import ru.job4j.design.srp.report.HrReport;
import ru.job4j.design.srp.report.Report;
import ru.job4j.design.srp.store.MemStore;

import java.util.Calendar;
import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class XmlFormatTest.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 21.08.2020
 */
public class XmlFormatTest {
    @Test
    public void whenXmlGenerate() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report report = new HrReport(store);
        Format xmlFormat = new XmlFormat(report);
        StringJoiner expect = new StringJoiner(System.lineSeparator());
        expect.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        expect.add("<report>");
        expect.add("<title value=\"Name; Salary;\" />");
        expect.add("<employee>");
        expect.add(String.format("<name value=\"%s\" />", worker.getName()));
        expect.add(String.format("<salary value=\"%s\" />", worker.getSalary()));
        expect.add("</employee>");
        expect.add("</report>");
        assertThat(xmlFormat.print(em -> true), is(expect.toString()));
    }
}