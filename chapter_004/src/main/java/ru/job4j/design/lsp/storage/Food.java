package ru.job4j.design.lsp.storage;

import java.time.LocalDate;
import java.time.Period;

/**
 * Class Food.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 02.07.2020
 */
public abstract class Food {
    private String name;
    private LocalDate createDate;
    private LocalDate expireDate;
    private double price;
    private int discount;

    /**
     * Instantiates a new Food.
     *
     * @param name       the name
     * @param createDate the create date
     * @param expireDate the expire date
     * @param price      the price
     * @param discount   the discount
     */
    public Food(String name, LocalDate createDate, LocalDate expireDate, double price, int discount) {
        this.name = name;
        this.expireDate = expireDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    /**
     * Gets percent shelf life.
     *
     * @param currentDate the current date
     * @return the percent shelf life
     */
    public int getPercentShelfLife(LocalDate currentDate) {
        Period shelfLifePeriod = Period.between(getCreateDate(), getExpireDate());
        Period expPeriod = Period.between(getCreateDate(), currentDate);
        int shelfLife = shelfLifePeriod.getDays();
        int exp = expPeriod.getDays();
        return (int) Math.round((double) exp * 100 / shelfLife);
    }

    /**
     * Gets price with discount.
     *
     * @return the price with discount
     */
    public double getPriceWithDiscount() {
        return price * (100 - this.discount) / 100;
    }

    /**
     * Gets expire date.
     *
     * @return the expire date
     */
    public LocalDate getExpireDate() {
        return expireDate;
    }

    /**
     * Sets expire date.
     *
     * @param expireDate the expire date
     */
    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    /**
     * Gets create date.
     *
     * @return the create date
     */
    public LocalDate getCreateDate() {
        return createDate;
    }

    /**
     * Sets create date.
     *
     * @param createDate the create date
     */
    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
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
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets discount.
     *
     * @return the discount
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * Sets discount.
     *
     * @param discount the discount
     */
    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
