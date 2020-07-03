package ru.job4j.design.lsp;

import org.junit.Test;
import ru.job4j.design.lsp.storage.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class ControlQualityTest.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 04.07.2020
 */
public class ControlQualityTest {

    @Test
    public void whenOneFoodTrashThreeShopTwoWarehouse() {
        Storage shop = new Shop();
        Storage warehouse = new Warehouse();
        Storage trash = new Trash();
        LocalDate currentDate = LocalDate.of(2020, 7, 4);
        ControlQuality controlQuality = new ControlQuality(Arrays.asList(shop, warehouse, trash));
        Food bread1 = new Bread("Ржаной хлеб", LocalDate.of(2020, 7, 2), LocalDate.of(2020, 7, 15), 38.0, 15);
        Food bread2 = new Bread("Отрубной хлеб", LocalDate.of(2020, 6, 30), LocalDate.of(2020, 7, 3), 35.0, 15);
        Food bread3 = new Bread("Гречневый хлеб", LocalDate.of(2020, 6, 30), LocalDate.of(2020, 7, 16), 52.0, 15);
        controlQuality.distribute(bread1, currentDate);
        controlQuality.distribute(bread2, currentDate);
        controlQuality.distribute(bread3, currentDate);
        assertEquals(shop.getFoods().get(0).getName(), "Гречневый хлеб");
        assertEquals(warehouse.getFoods().get(0).getName(), "Ржаной хлеб");
        assertEquals(trash.getFoods().get(0).getName(), "Отрубной хлеб");
    }

    @Test
    public void whenFoodHasDiscount() {
        Storage shop = new Shop();
        LocalDate currentDate = LocalDate.of(2020, 7, 4);
        ControlQuality controlQuality = new ControlQuality(Arrays.asList(shop));
        Food milk = new Milk("Молоко 2.5%", LocalDate.of(2020, 6, 29), LocalDate.of(2020, 7, 4), 48.0, 20);
        controlQuality.distribute(milk, currentDate);
        assertThat(shop.getFoods().get(0).getPrice(), is(38.4));
    }

    @Test
    public void whenFoodsResorting() {
        Storage shop = new Shop();
        Storage warehouse = new Warehouse();
        Storage trash = new Trash();
        LocalDate currentDate = LocalDate.of(2020, 7, 9);
        ControlQuality controlQuality = new ControlQuality(Arrays.asList(shop, warehouse, trash));
        Food bread1 = new Bread("Ржаной хлеб", LocalDate.of(2020, 7, 2), LocalDate.of(2020, 7, 15), 38.0, 15);
        Food bread2 = new Bread("Отрубной хлеб", LocalDate.of(2020, 6, 30), LocalDate.of(2020, 7, 3), 35.0, 15);
        Food bread3 = new Bread("Гречневый хлеб", LocalDate.of(2020, 6, 30), LocalDate.of(2020, 7, 16), 52.0, 15);
        Food bread4 = new Bread("Бездрожжевой хлеб", LocalDate.of(2020, 7, 3), LocalDate.of(2020, 7, 18), 28.0, 15);
        Food milk1 = new Milk("Молоко 3.2%", LocalDate.of(2020, 6, 30), LocalDate.of(2020, 7, 8), 54.0, 20);
        Food milk2 = new Milk("Молоко 2.5%", LocalDate.of(2020, 6, 29), LocalDate.of(2020, 7, 4), 48.0, 20);
        controlQuality.distribute(bread1, currentDate);
        controlQuality.distribute(bread2, currentDate);
        controlQuality.distribute(bread3, currentDate);
        controlQuality.distribute(bread4, currentDate);
        controlQuality.distribute(milk1, currentDate);
        controlQuality.distribute(milk2, currentDate);
        controlQuality.resort(currentDate);
        List<String> expectedShop = shop.getFoods().stream().map(Food::getName).collect(Collectors.toList());
        List<String> expectedTrash = trash.getFoods().stream().map(Food::getName).collect(Collectors.toList());
        assertArrayEquals(expectedShop.toArray(), new String[]{"Ржаной хлеб", "Гречневый хлеб", "Бездрожжевой хлеб"});
        assertArrayEquals(expectedTrash.toArray(), new String[]{"Отрубной хлеб", "Молоко 3.2%", "Молоко 2.5%"});
    }
}