### Анализ проведен утилитами jmap и YourKit Java Profiler.

Статистика до создание 1 миллиона объектов:
```
C:\Users\User>jhsdb jmap --heap --pid 1712
Attaching to process ID 1712, please wait...
Debugger attached successfully.
Server compiler detected.
JVM version is 14+36-1461

using thread-local object allocation.
Garbage-First (G1) GC with 6 thread(s)

Heap Configuration:
   MinHeapFreeRatio         = 40
   MaxHeapFreeRatio         = 70
   MaxHeapSize              = 209715200 (200.0MB)
   NewSize                  = 1363144 (1.2999954223632812MB)
   MaxNewSize               = 125829120 (120.0MB)
   OldSize                  = 5452592 (5.1999969482421875MB)
   NewRatio                 = 2
   SurvivorRatio            = 8
   MetaspaceSize            = 21807104 (20.796875MB)
   CompressedClassSpaceSize = 1073741824 (1024.0MB)
   MaxMetaspaceSize         = 17592186044415 MB
   G1HeapRegionSize         = 1048576 (1.0MB)

Heap Usage:
G1 Heap:
   regions  = 200
   capacity = 209715200 (200.0MB)
   used     = 5242880 (5.0MB)
   free     = 204472320 (195.0MB)
   2.5% used
G1 Young Generation:
Eden Space:
   regions  = 5
   capacity = 24117248 (23.0MB)
   used     = 5242880 (5.0MB)
   free     = 18874368 (18.0MB)
   21.73913043478261% used
Survivor Space:
   regions  = 0
   capacity = 0 (0.0MB)
   used     = 0 (0.0MB)
   free     = 0 (0.0MB)
   0.0% used
G1 Old Generation:
   regions  = 0
   capacity = 185597952 (177.0MB)
   used     = 0 (0.0MB)
   free     = 185597952 (177.0MB)
   0.0% used
   ```

После создание 1 миллиона объектов Item:
```
Heap Usage:
G1 Heap:
   regions  = 200
   capacity = 209715200 (200.0MB)
   used     = 180355072 (172.0MB)
   free     = 29360128 (28.0MB)
   86.0% used
G1 Young Generation:
Eden Space:
   regions  = 5
   capacity = 9437184 (9.0MB)
   used     = 5242880 (5.0MB)
   free     = 4194304 (4.0MB)
   55.55555555555556% used
Survivor Space:
   regions  = 2
   capacity = 2097152 (2.0MB)
   used     = 2097152 (2.0MB)
   free     = 0 (0.0MB)
   100.0% used
G1 Old Generation:
   regions  = 165
   capacity = 198180864 (189.0MB)
   used     = 173015040 (165.0MB)
   free     = 25165824 (24.0MB)
   87.3015873015873% used
```
Размер Eden Space 9 мбайт, Survivor Space 2 мбайта.
По мере создания объектов было сделано 12 minor GC (сборка мусора в Young Generation и перемещение объектов в Old Generation)
Большинство объектов уже находится в Old Generation.

![img](https://github.com/ViyChel/job4j_design/blob/master/chapter_005/src/main/java/ru/job4j/gc/profiling/MinorGC.png)

При добавлении функционала обнуления ссылок и вызова принудительно GC:

```java
public static void main(String[] args) throws InterruptedException {
        info();
        Thread.sleep(5_000);
        Tracker tracker = new Tracker();
        for (int i = 0; i < 1000_000; i++) {
            Item item = new Item("item " + i);
            tracker.add(item);
        }
        System.out.println(tracker.getItems().size());
        info();
        Thread.sleep(2_000);
        tracker.getItems().clear();
        System.out.println(tracker.getItems().size());
        System.gc();
        info();
        new StartUI(new ValidateInput(new ConsoleInput()), tracker, System.out::println).init();
    }
```
На графике видно, что была произведена одна major сборка мусора. На графике Heap Memory видно, как появилась свободная память.

![img](https://github.com/ViyChel/job4j_design/blob/master/chapter_005/src/main/java/ru/job4j/gc/profiling/gc.png)

3. Попробовать добиться состояния выхода за пределы памяти и посмотреть состояние виртуальной машины.

При запуске с параметром -Xmx100m -XX:+UseSerialGC и созданием в цикле одного миллиона заявок
приложение падает с исключением:
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space

Т.к. создаваемые объекты заявок "живые" (имеют переменную с сылкой на объект)
и есть ограничение по памяти кучи, при достижении предела памяти в 100 мбайт
приложение не может добавлять новые объекты в кучу и завершается с выбрасыванием
исключения java.lang.OutOfMemoryError: Java heap space.
Все потоки были остановлены, данные выгружены из памяти.

![img](https://github.com/ViyChel/job4j_design/blob/master/chapter_005/src/main/java/ru/job4j/gc/profiling/OutOfMemoryError.png)
