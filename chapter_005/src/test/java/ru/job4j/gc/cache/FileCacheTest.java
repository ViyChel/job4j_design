package ru.job4j.gc.cache;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.NoSuchFileException;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class FileCacheTest.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 01.10.2020
 */
public class FileCacheTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenAddToCashAndGetFromCash() throws IOException {
        File sourceFile = folder.newFile("Names.txt");
        try (PrintWriter out = new PrintWriter(sourceFile)) {
            out.println("Ivan");
            out.println("Oleg");
        }
        String exp = new StringJoiner(System.lineSeparator()).add("Ivan").add("Oleg").toString();
        String rsl = new FileCache().get(sourceFile.getAbsolutePath());
        assertThat(rsl, is(exp));
    }

    @Test
    public void whenGetFromCache() throws IOException {
        File sourceFile = folder.newFile("Names.txt");
        try (PrintWriter out = new PrintWriter(sourceFile)) {
            out.println("Ivan");
            out.println("Oleg");
        }
        Cache<String, String> cache = new FileCache();
        String exp = new StringJoiner(System.lineSeparator()).add("Ivan").add("Oleg").toString();
        cache.get(sourceFile.getAbsolutePath());
        String rsl = cache.get(sourceFile.getAbsolutePath());
        assertThat(rsl, is(exp));
    }
}