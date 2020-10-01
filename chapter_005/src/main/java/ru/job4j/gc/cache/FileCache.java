package ru.job4j.gc.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class FileCache.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 01.10.2020
 */
public class FileCache implements Cache<String, String> {
    private Map<String, SoftReference<String>> map = new HashMap<>();
    private static final Logger LOG = LoggerFactory.getLogger(FileCache.class.getName());

    @Override
    public String get(String key) {
        String result;
        if (map.containsKey(key)) {
            result = map.get(key).get();
            if (result == null) {
                result = readFile(key);
                map.put(key, new SoftReference<>(result));
            }
        } else {
            result = readFile(key);
            map.put(key, new SoftReference<>(result));
        }
        return result;
    }

    private void addToCache(String key, String value) {
        map.put(key, new SoftReference<>(value));
    }

    private String readFile(String name) {
        String result = "";
        try (Stream<String> stream = Files.lines(Paths.get(name))) {
            result = stream.collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            LOG.error("Invalid file name!", e);
        }
        return result;
    }
}
