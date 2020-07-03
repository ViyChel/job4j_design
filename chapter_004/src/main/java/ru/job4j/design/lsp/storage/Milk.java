package ru.job4j.design.lsp.storage;

import java.time.LocalDate;

/**
 * Class Milk.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 04.07.2020
 */
public class Milk extends Food {
    /**
     * Instantiates a new Milk.
     *
     * @param name       the name
     * @param expireDate the expire date
     * @param createDate the create date
     * @param price      the price
     * @param discount   the discount
     */
    public Milk(String name, LocalDate expireDate, LocalDate createDate, double price, int discount) {
        super(name, expireDate, createDate, price, discount);
    }
}
