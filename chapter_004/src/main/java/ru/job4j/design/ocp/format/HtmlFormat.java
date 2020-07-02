package ru.job4j.design.ocp.format;

import ru.job4j.design.srp.model.Employee;
import ru.job4j.design.srp.report.Report;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.function.Predicate;

/**
 * Class HtmlFormat.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 06.08.2020
 */
public class HtmlFormat implements Format {
    private final Report report;

    /**
     * Instantiates a new Html format.
     *
     * @param report the report
     */
    public HtmlFormat(Report report) {
        this.report = report;
    }

    @Override
    public String print(Predicate<Employee> filter) {
        String[] text = report.generate(filter).split(System.lineSeparator());
        StringJoiner html = new StringJoiner(System.lineSeparator());
        html.add("<!DOCTYPE html>");
        html.add("<html lang=\"en\">");
        html.add("<head>");
        html.add("<meta charset=\"UTF-8\">");
        html.add("<title>Report</title>");
        html.add("</head>");
        html.add("<body>");
        Arrays.stream(text).map(s -> s + "<br>").forEach(html::add);
        html.add("</body>");
        html.add("</html>");
        return html.toString();
    }
}
