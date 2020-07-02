package ru.job4j.design.ocp.format;

import ru.job4j.design.srp.model.Employee;
import ru.job4j.design.srp.report.Report;

import java.util.StringJoiner;
import java.util.function.Predicate;

/**
 * Class XmlFormat.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 06.08.2020
 */
public class XmlFormat implements Format {
    private final Report report;

    /**
     * Instantiates a new Xml format.
     *
     * @param report the report
     */
    public XmlFormat(Report report) {
        this.report = report;
    }

    @Override
    public String print(Predicate<Employee> filter) {
        String[] text = report.generate(filter).split(System.lineSeparator());
        String[] elements = Util.checkTitle(text[0]);
        StringJoiner xml = new StringJoiner(System.lineSeparator());
        xml.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        xml.add("<report>");
        xml.add("<title value=\"" + text[0] + "\" />");
        for (int i = 1; i < text.length; i++) {
            xml.add("<employee>");
            String[] temp = text[i].split(";");
            for (int j = 0; j < elements.length; j++) {
                xml.add("<" + elements[j] + " value=\"" + temp[j] + "\" />");
            }
            xml.add("</employee>");
        }
        xml.add("</report>");
        return xml.toString();
    }
}
