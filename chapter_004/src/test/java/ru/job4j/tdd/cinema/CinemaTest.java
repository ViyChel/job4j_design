package ru.job4j.tdd.cinema;

import org.junit.Test;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class CinemaTest.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 28.08.2020
 */
public class CinemaTest {

    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Test
    public void find() {
        Cinema cinema = new Cinema3D();
        Session session3D = new Session3D();
        cinema.add(session3D);
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Collections.singletonList(session3D)));
    }

    @Test
    public void add() {
        Cinema cinema = new Cinema3D();
        Session session3D = new Session3D();
        cinema.add(session3D);
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions.get(0), is(session3D));
    }


    @Test(expected = IllegalArgumentException.class)
    public void whenHaveNotTickets() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenHaveNotSessionCurrentDate() {
        Cinema cinema = new Cinema3D();
        Session session3D = new Session3D();
        cinema.add(session3D);
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions.get(0), is(new Session3D()));
    }
}