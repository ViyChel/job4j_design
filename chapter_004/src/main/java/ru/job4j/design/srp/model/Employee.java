package ru.job4j.design.srp.model;

import java.util.Calendar;
import java.util.Objects;

/**
 * Class Employee.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 06.08.2020
 */
public class Employee {
    private String name;
    private Calendar hired;
    private Calendar fired;
    private double salary;

    /**
     * Instantiates a new Employee.
     *
     * @param name   the name
     * @param hired  the hired
     * @param fired  the fired
     * @param salary the salary
     */
    public Employee(String name, Calendar hired, Calendar fired, double salary) {
        this.name = name;
        this.hired = hired;
        this.fired = fired;
        this.salary = salary;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets hired.
     *
     * @return the hired
     */
    public Calendar getHired() {
        return hired;
    }

    /**
     * Sets hired.
     *
     * @param hired the hired
     */
    public void setHired(Calendar hired) {
        this.hired = hired;
    }

    /**
     * Gets fired.
     *
     * @return the fired
     */
    public Calendar getFired() {
        return fired;
    }

    /**
     * Sets fired.
     *
     * @param fired the fired
     */
    public void setFired(Calendar fired) {
        this.fired = fired;
    }

    /**
     * Gets salary.
     *
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets salary.
     *
     * @param salary the salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
