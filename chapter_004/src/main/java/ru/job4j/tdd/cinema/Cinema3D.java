package ru.job4j.tdd.cinema;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Class Cinema3D.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 28.08.2020
 */
public class Cinema3D implements Cinema {
    List<Session> sessions = new ArrayList<>();

    @Override
    public List<Session> find(Predicate<Session> filter) {
        return sessions.stream().filter(filter).collect(Collectors.toList());
    }

    @Override
    public Ticket buy(Account account, int row, int column, Calendar date) {
        return null;
    }

    @Override
    public void add(Session session) {
        sessions.add(session);
    }
}
