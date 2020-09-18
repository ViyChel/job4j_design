package ru.job4j.gc;

import org.openjdk.jol.info.ClassLayout;

/**
 * Class User.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 16.09.2020
 */
public class MemoryUsage {

    private static class User {
        private final String name;
        private final int id;

        private User(String name, int id) {
            this.name = name;
            this.id = id;
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.printf("Destroyed object user %s id %d%n", this.name, this.id);
        }
    }

    private static void info() {
        System.out.println("#### Heap utilization statistics [MB] ####");
        final int mb = 1024 * 1024;
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long maxMemory = runtime.maxMemory();
        long usedMemory = totalMemory - freeMemory;
        System.out.printf("Used : %d%n", usedMemory / mb);
        System.out.printf("Free : %d%n", freeMemory / mb);
        System.out.printf("Total: %d%n", totalMemory / mb);
        System.out.printf("Maximum : %d%n", maxMemory / mb);
    }

    public static void main(String[] args) {
        info();
        for (int i = 0; i < 10000; i++) {
            User user = new User("Ivan", i);
            user = null;
        }
        info();
    }
}

/*
    2. Создать несколько объектов User и руками рассчитать сколько он будет занимать памяти.

Объект User состоит из (openjdk14, OS x64):
- Заголовок объекта;
- Память для примитивных типов;
- Память для ссылочных типов;
- Смещение/выравнивание — по сути, это несколько неиспользуемых байт, что размещаются после данных самого объекта.
  Это сделано для того, чтобы адрес в памяти всегда был кратным машинному слову,
  для ускорения чтения из памяти + уменьшения количества бит для указателя на объект + предположительно для
  уменьшения фрагментации памяти. Стоит также отметить, что в java размер любого объекта кратен 8 байтам!

В данном случае:
- заголовок   12 байт
- смещение     4 байта
- int id       4 байта
- String name  4 байта
Итого: 24 байта

Можно посмотреть используя Java Object Layout: Core
        final User user1 = new User("Name", 34);
        System.out.println(ClassLayout.parseClass(MemoryUsage.class).toPrintable());
        System.out.println(ClassLayout.parseClass(User.class).toPrintable());
        System.out.println(ClassLayout.parseInstance(user1).toPrintable());

 */

/*
  3. Нужно найти информацию. Сколько памяти занимает пустой объект без полей.

  Пустой объект без полей состоит только из заголовка (размер объета должен быть кратным 8).
  - 8 байт (4 + 4 выравнивание) для х86 и 16 байт (12 + 4 выравнивание) для х64
 */
