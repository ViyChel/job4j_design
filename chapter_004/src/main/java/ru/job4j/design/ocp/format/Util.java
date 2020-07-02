package ru.job4j.design.ocp.format;

/**
 * Class Util.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 21.08.2020
 */
public class Util {
    /**
     * Check title string [ ].
     *
     * @param title the title
     * @return the string [ ]
     */
    public static String[] checkTitle(String title) {
        String[] result;
        String[] temp = title.split(";");
        result = new String[temp.length];
        for (int i = 0; i < temp.length; i++) {
            if (temp[i].trim().equals("Name")) {
                result[i] = "name";
            } else if (temp[i].trim().equals("Hired")) {
                result[i] = "hired";
            } else if (temp[i].trim().equals("Fired")) {
                result[i] = "fired";
            } else if (temp[i].trim().equals("Salary")) {
                result[i] = "salary";
            }
        }
        return result;
    }
}
