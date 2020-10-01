package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class SimpleGeneratorTest.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 04.09.2020
 */
public class SimpleGeneratorTest {
    @Ignore
    @Test
    public void whenTemplateContainsAllKeys() {
        final SimpleGenerator simpleGenerator = new SimpleGenerator();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> keys = Map.of("name", "Petr Arsentev", "subject", "you");
        String result = simpleGenerator.produce(template, keys);
        assertThat(result, is("I am a Petr Arsentev, Who are you? "));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenTemplateDoesNotMatchKeys() {
        final SimpleGenerator simpleGenerator = new SimpleGenerator();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> keys = Map.of("description", "Petr Arsentev", "subject", "you");
        String result = simpleGenerator.produce(template, keys);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenMapContainsExtraKeys() {
        final SimpleGenerator simpleGenerator = new SimpleGenerator();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> keys = Map.of("name", "Petr Arsentev", "subject", "you", "age", "25");
        String result = simpleGenerator.produce(template, keys);
    }
}