package ru.job4j.template;

import java.util.Map;

/**
 * Interface Generator.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 04.09.2020
 */
public interface Generator {
    String produce(String template, Map<String, String> args);
}
