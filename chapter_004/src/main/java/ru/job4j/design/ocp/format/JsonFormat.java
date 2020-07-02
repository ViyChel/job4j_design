package ru.job4j.design.ocp.format;

import ru.job4j.design.srp.model.Employee;
import ru.job4j.design.srp.report.Report;

import java.util.function.Predicate;

/**
 * Class JsonFormat.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 06.08.2020
 */
public class JsonFormat implements Format {
    private final Report report;

    /**
     * Instantiates a new Json format.
     *
     * @param report the report
     */
    public JsonFormat(Report report) {
        this.report = report;
    }

    @Override
    public String print(Predicate<Employee> filter) {
        String[] text = report.generate(filter).split(System.lineSeparator());
        String[] elements = Util.checkTitle(text[0]);
        StringBuilder json = new StringBuilder();
        json.append("{")
                .append("\"title\":").append("\"").append(text[0]).append("\",").append(System.lineSeparator())
                .append("\"list\":[");
        for (int i = 1; i < text.length; i++) {
            String[] temp = text[i].split(";");
            json.append("{");
            for (int j = 0; j < elements.length; j++) {
                if (!elements[j].trim().equals("salary")) {
                    json.append("\"").append(elements[j]).append("\":\"").append(temp[j]).append("\"");
                } else {
                    json.append("\"").append(elements[j]).append("\":").append(temp[j]);
                }
                if (j < elements.length - 1) {
                    json.append(",");
                }
            }
            json.append("}");
            if (i < text.length - 1) {
                json.append(",");
            }
        }
        json.append("]}");
        return json.toString();
    }
}
