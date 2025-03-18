
https://metanit.com/java/tutorial/8.1.php?ysclid=m8d5jw8y7t131632711

# Многопоточность в Java

Большинство языков программирования поддерживают такую важную функциональность 
как многопоточность, и Java в этом плане не исключение. 

При помощи многопоточности мы можем выделить в приложении несколько потоков, 
которые будут выполнять различные задачи одновременно. 

Если у нас, допустим, графическое приложение: 
- которое посылает запрос к какому-нибудь серверу 
- или считывает и обрабатывает огромный файл

То без многопоточности 
у нас бы блокировался графический интерфейс на время выполнения задачи. 

А благодаря потокам мы можем выделить отправку запроса или любую другую задачу, 
которая может долго обрабатываться, в отдельный поток. 

Поэтому большинство реальных приложений, 
которые многим из нас приходится использовать, практически не мыслимы без многопоточности.

___

## Класс Thread

В Java функциональность отдельного потока заключается в классе Thread. 

И чтобы создать новый поток, нам надо создать объект этого класса. 

- Но все потоки не создаются сами по себе.
- Когда запускается программа, начинает работать главный поток этой программы. 
- От этого главного потока порождаются все остальные дочерние потоки.

С помощью статического метода `Thread.currentThread()` 
мы можем получить текущий поток выполнения:

```java
public static void main(String[] args) {
    
    Thread t = Thread.currentThread(); // получаем главный поток
    System.out.println(t.getName());   // main
    
}
```

По умолчанию именем главного потока будет main.

Для управления потоком класс Thread предоставляет еще ряд методов.

Наиболее используемые из них:
- `getName()`: возвращает имя потока
- `setName(String name)`: устанавливает имя потока
- `getPriority()`: возвращает приоритет потока
- `setPriority(int proirity)`: устанавливает приоритет потока. Приоритет является одним из ключевых факторов для выбора системой потока из кучи потоков для выполнения. В этот метод в качестве параметра передается числовое значение приоритета - от 1 до 10. По умолчанию главному потоку выставляется средний приоритет - 5.
- `isAlive()`: возвращает true, если поток активен
- `isInterrupted()`: возвращает true, если поток был прерван
- `join()`: ожидает завершение потока
- `run()`: определяет точку входа в поток
- `sleep()`: приостанавливает поток на заданное количество миллисекунд
- `start()`: запускает поток, вызывая его метод run()



Мы можем вывести всю информацию о потоке:
```java
public static void main(String[] args) {
         
    Thread t = Thread.currentThread(); // получаем главный поток
    System.out.println(t); // main
}
```

Консольный вывод:
```java
Thread[main,5,main]
```

- первое main будет представлять `имя потока` (что можно получить через t.getName())
- второе значение 5 предоставляет `приоритет потока` 
(также можно получить через t.getPriority()), 
- и последнее main представляет `имя группы потоков`, 
к которому относится текущий - по умолчанию также main (также можно получить через t.getThreadGroup().getName())




### Недостатки при использовании потоков

Далее мы рассмотрим, как создавать и использовать потоки. 
Это довольно легко.
Однако при создании многопоточного приложения нам следует учитывать ряд обстоятельств, 
которые негативно могут сказаться на работе приложения.

На некоторых платформах запуск новых потоков может замедлить работу приложения. 
Что может иметь большое значение, если нам критичная производительность приложения.

1. Для каждого потока создается свой собственный стек в памяти, 
куда помещаются все локальные переменные и ряд других данных, 
связанных с выполнением потока.


2. Соответственно, чем больше потоков создается, 
тем больше памяти используется.


3. При этом надо помнить, в любой системе размеры используемой памяти ограничены. 
Кроме того, во многих системах может быть ограничение на количество потоков. 
Но даже если такого ограничения нет, 
то в любом случае имеется естественное ограничение в виде максимальной скорости процессора.



___

## Создание и выполнение потоков

Для создания нового потока мы можем создать новый класс, 
либо наследуя его от класса Thread, либо реализуя в классе интерфейс Runnable.

### Наследование от класса Thread

Создадим свой класс на основе Thread:

```java
class JThread extends Thread {
      
    JThread(String name){
        super(name);
    }
      
    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        try{
            Thread.sleep(500);
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted");
        }
        System.out.printf("%s fiished... \n", Thread.currentThread().getName());
    }
}
  
public class Program {
  
    public static void main(String[] args) {
        System.out.println("Main thread started...");
        new JThread("JThread").start();
        System.out.println("Main thread finished...");
    }
    
}
```

УТОЧНИТЬ ПОЧЕМУ КРАСНЫМ ПОДСВЕЧИВАЕТ В КОДЕ (ИИ ПОКАЗЫВАЕТ ВСЕ ОК)

Класс потока называется JThread. 
- Предполагается, что в конструктор класса передается имя потока, 
которое затем передается в конструктор базового класса. 
- В конструктор своего класса потока мы можем передать различные данные, 
но главное, чтобы в нем вызывался конструктор базового класса Thread, 
в который передается имя потока.

И также в JThread переопределяется метод `run()`, 
код которого собственно и будет представлять весь тот код, который выполняется в потоке.

В методе main для запуска потока JThread у него вызывается метод `start()`, 
после чего начинается выполнение того кода, который определен в методе run:

```java
new JThread("JThread").start();
```

Консольный вывод:
```java
Main thread started...
Main thread finished...
JThread started... 
JThread finished... 
```

Здесь в методе main в конструктор JThread передается произвольное название потока, 
и затем вызывается метод start(). 
По сути этот метод как раз и вызывает переопределенный метод run() класса JThread.

Обратите внимание, что главный поток завершает работу раньше, 
чем порожденный им дочерний поток JThread.

___

Аналогично созданию одного потока мы можем запускать сразу несколько потоков:

```java
public static void main(String[] args) {
         
    System.out.println("Main thread started...");
    for(int i=1; i < 6; i++)
        new JThread("JThread " + i).start();
    System.out.println("Main thread finished...");
}
```

Консольный вывод:
```java
Main thread started...
Main thread finished...
JThread 2 started... 
JThread 5 started... 
JThread 4 started... 
JThread 1 started... 
JThread 3 started... 
JThread 1 finished... 
JThread 2 finished... 
JThread 5 finished... 
JThread 4 finished... 
JThread 3 finished... 
```

___

### Ожидание завершения потока

При запуске потоков в примерах выше Main thread завершался до дочернего потока. 

Как правило, более распространенной ситуацией является случай, 
когда Main thread завершается самым последним. 

Для этого надо применить метод join(). 

В этом случае текущий поток будет ожидать завершения потока, 
для которого вызван метод join:


```java
public static void main(String[] args) {
    System.out.println("Main thread started...");
    JThread t= new JThread("JThread ");
    t.start();
    try{
        t.join(); 
    }
    catch(InterruptedException e){
        System.out.printf("%s has been interrupted", t.getName());
    }
    System.out.println("Main thread finished...");
}
```

Метод `join()` заставляет вызвавший поток (в данном случае Main thread) 
ожидать завершения вызываемого потока, 
для которого и применяется метод join (в данном случае JThread).


Консольный вывод:
```java
Main thread started...
JThread  started... 
JThread  finished... 
Main thread finished...
```

Если в программе используется несколько дочерних потоков, и надо, 
чтобы Main thread завершался после дочерних, 
то для каждого дочернего потока надо вызвать метод join.

___

### Реализация интерфейса Runnable

Другой способ определения потока представляет реализация интерфейса `Runnable`. 

Этот интерфейс имеет один метод run:

```java
interface Runnable{
    void run();
}
```

В методе `run()` собственно определяется весь тот код, 
который выполняется при запуске потока.

После определения объекта Runnable он передается в один из конструкторов класса Thread:

```java
Thread(Runnable runnable, String threadName)
```

Для реализации интерфейса определим следующий класс MyThread:
```java
class MyThread implements Runnable {
    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        try{
            Thread.sleep(500);
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted");
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
} 
  
public class Program {
    public static void main(String[] args) {
        System.out.println("Main thread started...");
        Thread myThread = new Thread(new MyThread(),"MyThread");
        myThread.start();
        System.out.println("Main thread finished...");
    }
}
```

Реализация интерфейса Runnable во многом аналогична переопределению класса Thread. 
Также в методе run определяется простейший код, который усыпляет поток на 500 миллисекунд.

В методе main вызывается конструктор Thread, в который передается объект MyThread. 
И чтобы запустить поток, вызывается метод start(). 

ОЧ СЛОЖНО СЕЙЧАС БЫЛО

В итоге консоль выведет что-то наподобие следующего:
```java
Main thread started...
Main thread finished...
MyThread started... 
MyThread finished... 
```

Поскольку Runnable фактически представляет функциональный интерфейс, 
который определяет один метод, то объект этого интерфейса мы можем представить в виде лямбда-выражения:

```java
public class Program {
  
    public static void main(String[] args) {
        System.out.println("Main thread started...");
        Runnable r = ()->{
            System.out.printf("%s started... \n", Thread.currentThread().getName());
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){
                System.out.println("Thread has been interrupted");
            }
            System.out.printf("%s finished... \n", Thread.currentThread().getName());
        };
        Thread myThread = new Thread(r,"MyThread");
        myThread.start();
        System.out.println("Main thread finished...");
    }
    
}
```
___
___
___
___
___

## 1. Гонка потоков (Race Condition)

Гонка потоков возникает, когда два или более потока одновременно 
обращаются к общему ресурсу (например, к разделяемой переменной) 
и хотя бы один из них изменяет этот ресурс. 

Из-за неожиданного планирования потоков итоговое значение 
может получаться неверным — результат зависит от порядка выполнения операций.

Рассмотрим пример на счётчике:

```java
public class RaceConditionDemo {
    private int counter = 0;

    public void increment() {
        // Операция ++ не является атомарной!
        counter++;
    }

    public int getCounter() {
        return counter;
    }

    public static void main(String args) throws InterruptedException {
        RaceConditionDemo demo = new RaceConditionDemo();
        // Создадим 2 потока, каждый увеличивает счетчик на 1000 раз
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                demo.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                demo.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        // Ожидаем, что counter будет равен 2000,
        // но благодаря гонке потоков может получиться другое число!
        System.out.println("Final counter: " + demo.getCounter());
    }
}
```

Пояснение:
- Метод increment() использует оператор ++, который не является атомарным. Он включает: чтение значения, увеличение на 1 и запись нового значения.


- Если два потока выполняют эти операции одновременно, они могут "пересекаться", и итоговое значение счётчика будет меньше ожидаемого (например, 2000).

___

## 2. Понятие атомарности

Атомарность означает, что операция выполняется неделимо — либо операция
завершилась полностью, либо не была выполнена вовсе. 

То есть если несколько потоков работают с разделяемыми данными, 
то атомарная операция гарантирует, 
что ни один поток не "увидит" промежуточное состояние.

В Java есть атомарные операции:
- Чтение и запись переменных примитивных типов (например, int) могут быть атомарными, но не все комбинации операций атомарны (операция ++ не атомарна).
- Класс AtomicInteger (в пакете java.util.concurrent.atomic) предоставляет атомарные операции инкремента, обновления и получения значения.

Пример с использованием AtomicInteger для обеспечения атомарности:

```java
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    private AtomicInteger counter = new AtomicInteger(0);

    // Метод с атомарным инкрементом
    public void increment() {
        counter.incrementAndGet();
    }

    public int getCounter() {
        return counter.get();
    }

    public static void main(String args) throws InterruptedException {
        AtomicDemo demo = new AtomicDemo();
        // Создадим 2 потока, каждый увеличивает счетчик на 1000 раз
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                demo.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                demo.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        // Здесь counter гарантированно равен 2000
        System.out.println("Final counter: " + demo.getCounter());
    }
}
```

Пояснение:
- AtomicInteger.incrementAndGet() выполняет операцию инкремента атомарно, поэтому никакая гонка не происходит.
- Мы видим, что итоговое значение счётчика всегда будет 2000, независимо от планирования потоков.


Итог:

- Гонка потоков возникает из-за того, что некорректно синхронизированный доступ к разделяемым данным может привести к неверным результатам.


- Атомарные операции позволяют выполнять изменения, которые не могут быть прерваны, обеспечивая корректность изменений в многопоточной среде.


- Для защиты общих ресурсов можно использовать синхронизацию (например, synchronized) или атомарные классы из пакета java.util.concurrent.atomic.

ПОЯСНЕНИЕ




___
___
___
___
___
___

## Завершение и прерывание потока

Примеры потоков ранее представляли поток как последовательный набор операций. 
После выполнения последней операции завершался и поток. 

Однако нередко имеет место и другая организация потока в виде бесконечного цикла. 
Например, поток сервера в бесконечном цикле прослушивает определенный порт на предмет получения данных. 
И в этом случае мы также можем предусмотреть механизм завершения потока.


### Завершение потока

Распространенный способ завершения потока представляет опрос логической переменной. И если она равна, например, false, то поток завершает бесконечный цикл и заканчивает свое выполнение.

Определим следующий класс потока:

```java
class MyThread implements Runnable {
    private boolean isActive;
      
    void disable(){
        isActive = false;
    }
      
    MyThread() {
       isActive = true;
    }
      
    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        int counter=1; // счетчик циклов
        while(isActive){
            System.out.println("Loop " + counter++);
            try{
                Thread.sleep(400);
            }
            catch(InterruptedException e){
                System.out.println("Thread has been interrupted");
            }
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}
```

Переменная `isActive` указывает на активность потока. 
С помощью метода `disable()` мы можем сбросить состояние этой переменной.

Теперь используем этот класс:

```java
public static void main(String[] args) {
    
    System.out.println("Main thread started...");
    MyThread myThread = new MyThread();
    new Thread(myThread,"MyThread").start();
    
    try{
        Thread.sleep(1100);
        myThread.disable();
        Thread.sleep(1000);
    }
    catch(InterruptedException e){
        System.out.println("Thread has been interrupted");
    }
    System.out.println("Main thread finished...");
    
}
```

Итак, вначале запускается дочерний поток: `new Thread(myThread,"MyThread").start()`. 

Затем на 1100 миллисекунд останавливаем `Main thread` 
и потом вызываем метод `myThread.disable()`, который переключает в потоке флаг `isActive`. 

И дочерний поток завершается.

___

### Метод interrupt

Еще один способ вызова завершения или прерывания потока представляет метод `interrupt()`. 

Вызов этого метода устанавливает у потока статус, что он прерван. 
Сам метод возвращает `true`, если поток может быть прерван, 
в ином случае возвращается `false`.

При этом сам вызов этого метода НЕ завершает поток, 
он только устанавливает статус: в частности, 
метод `isInterrupted()` класса Thread будет возвращать значение `true`. 

Мы можем проверить значение возвращаемое данным методом и прозвести некоторые действия. 

Например:

```java
class JThread extends Thread {
      
    JThread(String name){
        super(name);
    }
    
    public void run(){
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        int counter=1; // счетчик циклов
        while(!isInterrupted()){
             
            System.out.println("Loop " + counter++);
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
    
}

public class Program {
  
    public static void main(String[] args) {
        System.out.println("Main thread started...");
        JThread t = new JThread("JThread");
        t.start();
        try{
            Thread.sleep(150);
            t.interrupt();
              
            Thread.sleep(150);
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted");
        }
        System.out.println("Main thread finished...");
    }
    
}
```

В классе, который унаследован от Thread, 
мы можем получить статус текущего потока с помощью метода `isInterrupted()`. 

И пока этот метод возвращает `false`, мы можем выполнять цикл. 

А после того, как будет вызван метод interrupt, `isInterrupted()` возвратит `true`, 
и соответственно произойдет выход из цикла.

Возможный консольный вывод:
```java
Main thread started...
JThread started...
Loop 1
Loop 2
Loop 3
Loop 4
JThread finished...
Main thread finished...
```



Если основная функциональность заключена в классе, который реализует интерфейс Runnable, 
то там можно проверять статус потока с помощью метода `Thread.currentThread().isInterrupted()`:

```java
class MyThread implements Runnable {
    
    public void run(){
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        int counter=1; // счетчик циклов
        while(!Thread.currentThread().isInterrupted()){
            System.out.println("Loop " + counter++);
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
    
}

public class Program {
  
    public static void main(String[] args) {
        System.out.println("Main thread started...");
        MyThread myThread = new MyThread();
        Thread t = new Thread(myThread,"MyThread"); 
        t.start();
        try{
            Thread.sleep(150);
            t.interrupt();
              
            Thread.sleep(150);
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted");
        }
        System.out.println("Main thread finished...");
    }
    
}
```

ПАПКА example8... ->

Однако при получении статуса потока с помощью метода `isInterrupted()` следует учитывать, 
что если мы обрабатываем в цикле исключение InterruptedException в блоке `catch`, 
то при перехвате исключения статус потока автоматически сбрасывается, 
и после этого `isInterrupted` будет возвращать `false`.

Например, добавим в цикл потока задержку с помощью метода sleep:
```java
public void run() {
    
    System.out.printf("%s started... \n", Thread.currentThread().getName());
    int counter=1; // счетчик циклов
    
    while(!isInterrupted()) {
        System.out.println("Loop " + counter++);
        try{
            Thread.sleep(100);
        }
        catch(InterruptedException e){
            System.out.println(getName() + " has been interrupted");
            System.out.println(isInterrupted());    // false
            interrupt();    // повторно сбрасываем состояние
        }
    }
    System.out.printf("%s finished... \n", Thread.currentThread().getName());
    
}
```

Когда поток вызовет метод `interrupt`, 
метод sleep сгенерирует исключение `InterruptedException`, 
и управление перейдет к блоку `catch`. 

Но если мы проверим статус потока, то увидим, что метод `isInterrupted` возвращает `false`. 
Как вариант, в этом случае мы можем повторно прервать текущий поток, 
опять же вызвав метод `interrupt()`. 

Тогда при новой итерации цикла while метода `isInterrupted` возвратит `true`, 
и поизойдет выход из цикла.



Либо мы можем сразу же в блоке catch выйти из цикла с помощью `break`:
```java
while(!isInterrupted()) {
         
    System.out.println("Loop " + counter++);
    try{
        Thread.sleep(100);
    }
    catch(InterruptedException e){
        System.out.println(getName() + " has been interrupted");
        break;  // выход из цикла
    }
    
}
```

Если бесконечный цикл помещен в конструкцию `try...catch`, 
то достаточно обработать `InterruptedException`:

```java
public void run(){
          
    System.out.printf("%s started... \n", Thread.currentThread().getName());
    int counter=1; // счетчик циклов
    try{
        while(!isInterrupted()){
            System.out.println("Loop " + counter++);
            Thread.sleep(100);
        }
    }
    catch(InterruptedException e){
        System.out.println(getName() + " has been interrupted");
    }
         
    System.out.printf("%s finished... \n", Thread.currentThread().getName());
    
}
```

___

## Синхронизация потоков. Оператор synchronized

При работе потоки нередко обращаются к каким-то общим ресурсам,
которые определены вне потока, например, обращение к какому-то файлу. 

Если одновременно несколько потоков обратятся к общему ресурсу, 
то результаты выполнения программы могут быть неожиданными и даже непредсказуемыми. 

Например, определим следующий код:

```java
public class Program {
    public static void main(String[] args) {
        CommonResource commonResource= new CommonResource();
        for (int i = 1; i < 6; i++){
            Thread t = new Thread(new CountThread(commonResource));
            t.setName("Thread "+ i);
            t.start();
        }
    }
}
 
class CommonResource{
    int x=0;
}
 
class CountThread implements Runnable{
    CommonResource res;
    CountThread(CommonResource res){
        this.res=res;
    }
    public void run(){
        res.x=1;
        for (int i = 1; i < 5; i++){
            System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
            res.x++;
            try{
                Thread.sleep(100);
            }
            catch(InterruptedException e){}
        }
    }
}
```

Здесь определен класс CommonResource, 
который представляет общий ресурс и в котором определено одно целочисленное поле x.

Этот ресурс используется классом потока CountThread. 
Этот класс просто увеличивает в цикле значение x на единицу. 
Причем при входе в поток значение x=1:

```java
res.x=1;
```

То есть в итоге мы ожидаем, что после выполнения цикла res.x будет равно 4.

В главном классе программы запускается пять потоков. 
То есть мы ожидаем, что каждый поток будет увеличивать res.x с 1 до 4 и так пять раз. 

Но если мы посмотрим на результат работы программы, то он будет иным:

```java
Thread 1 1 
Thread 2 1 
Thread 3 1 
Thread 5 1 
Thread 4 1 
Thread 5 6 
Thread 2 6 
Thread 1 6 
Thread 3 6 
Thread 4 6 
Thread 4 11 
Thread 2 11 
Thread 5 11 
Thread 3 11 
Thread 1 11 
Thread 4 16 
Thread 1 16 
Thread 3 16 
Thread 5 16 
Thread 2 16
```

То есть пока один поток не окончил работу с полем res.x, 
с ним начинает работать другой поток.

Чтобы избежать подобной ситуации, надо синхронизировать потоки. 
Одним из способов синхронизации является использование ключевого слова synchronized. 
Этот оператор предваряет блок кода или метод, который подлежит синхронизации. 

Для его применения изменим класс CountThread:

```java
class CountThread implements Runnable {
 
    CommonResource res;
    CountThread(CommonResource res) {
        this.res=res;
    }
    
    public void run() {
        synchronized(res) {
            res.x=1;
            for (int i = 1; i < 5; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
                res.x++;
                try{
                    Thread.sleep(100);
                }
                catch(InterruptedException e){}
            }
        }
    }
    
}
```

При создании синхронизированного блока кода после оператора synchronized идет объект-заглушка: 
synchronized(res). 

Причем в качестве объекта может использоваться только объект какого-нибудь класса, 
но не примитивного типа.

Каждый объект в Java имеет ассоциированный с ним `монитор`. 

Монитор представляет своего рода инструмент для управления доступа к объекту. 
Когда выполнение кода доходит до оператора synchronized, 
монитор объекта res блокируется, 
и на время его блокировки монопольный доступ к блоку кода имеет только один поток, 
который и произвел блокировку. 

После окончания работы блока кода, монитор объекта res освобождается 
и становится доступным для других потоков.

После освобождения монитора его захватывает другой поток, 
а все остальные потоки продолжают ожидать его освобождения.

В итоге консольный вывод изменится:

```java
Thread 1 1 
Thread 1 2
Thread 1 3
Thread 1 4
Thread 3 1 
Thread 3 2
Thread 3 3
Thread 3 4
Thread 5 1 
Thread 5 2
Thread 5 3
Thread 5 4
Thread 4 1 
Thread 4 2
Thread 4 3
Thread 4 4
Thread 2 1 
Thread 2 2
Thread 2 3
Thread 2 4
```

При применении оператора synchronized к методу пока этот метод не завершит выполнение, 
монопольный доступ имеет только один поток - первый, который начал его выполнение. 

Для применения synchronized к методу, изменим классы программы:

```java
public class Program {
    public static void main(String[] args) {
        CommonResource commonResource= new CommonResource();
        for (int i = 1; i < 6; i++){
             
            Thread t = new Thread(new CountThread(commonResource));
            t.setName("Thread "+ i);
            t.start();
        }
    }
}
 
class CommonResource {
    int x;
    synchronized void increment(){
        x=1;
        for (int i = 1; i < 5; i++){
            System.out.printf("%s %d \n", Thread.currentThread().getName(), x);
            x++;
            try{
                Thread.sleep(100);
            }
            catch(InterruptedException e){}
        }
    }
}
 
class CountThread implements Runnable{
    CommonResource res;
    CountThread(CommonResource res){
        this.res=res;
    }
     
    public void run(){
        res.increment();
    }
}
```

Результат работы в данном случае будет аналогичен примеру выше с блоком synchronized. 
Здесь опять в дело вступает монитор объекта CommonResource - общего объекта
для всех потоков. 

Поэтому синхронизированным объявляется не метод run() в классе CountThread, 
а метод increment класса CommonResource. 

Когда первый поток начинает выполнение метода increment, 
он захватывает монитор объекта CommonResource. 
А все потоки также продолжают ожидать его освобождения.

___
___
___

## Методы wait и notify

Иногда при взаимодействии потоков встает вопрос о извещении одних потоков 
о действиях других. 

Например, действия одного потока зависят от результата действий другого потока, 
и надо как-то известить один поток, что второй поток произвел некую работу. 
И для подобных ситуаций у класса `Object` определено ряд методов:

- `wait()`: освобождает монитор и переводит вызывающий поток в состояние ожидания до тех пор, пока другой поток не вызовет метод notify()


- `notify()`: продолжает работу потока, у которого ранее был вызван метод `wait()`


- `notifyAll()`: возобновляет работу всех потоков, у которых ранее был вызван метод `wait()`


Все эти методы вызываются только из синхронизированного контекста - синхронизированного блока или метода.

___

Рассмотрим, как мы можем использовать эти методы. 

Возьмем стандартную задачу из прошлой темы - "Производитель-Потребитель" ("Producer-Consumer"): 
- пока производитель не произвел продукт, потребитель не может его купить. 

- пусть производитель должен произвести 5 товаров, соответственно потребитель должен их все купить. 

- но при этом одновременно на складе может находиться не более 3 товаров.

Для решения этой задачи задействуем методы `wait()` и `notify()`:

```java
public class Program {
  
    public static void main(String[] args) {
        Store store=new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

// Класс Магазин, хранящий произведенные товары
class Store{
   private int product=0;
   public synchronized void get() {
      while (product<1) {
         try {
            wait();
         }
         catch (InterruptedException e) {
         }
      }
      product--;
      System.out.println("Покупатель купил 1 товар");
      System.out.println("Товаров на складе: " + product);
      notify();
   }
   public synchronized void put() {
       while (product>=3) {
         try {
            wait();
         }
         catch (InterruptedException e) { 
         } 
      }
      product++;
      System.out.println("Производитель добавил 1 товар");
      System.out.println("Товаров на складе: " + product);
      notify();
   }
}

// класс Производитель
class Producer implements Runnable{
    Store store;
    Producer(Store store){
       this.store=store; 
    }
    public void run(){
        for (int i = 1; i < 6; i++) {
            store.put();
        }
    }
}

// Класс Потребитель
class Consumer implements Runnable{
    Store store;
    Consumer(Store store){
       this.store=store; 
    }
    public void run(){
        for (int i = 1; i < 6; i++) {
            store.get();
        }
    }
}
```


Итак, здесь определен класс магазина, потребителя и покупателя. 

Производитель в методе `run()` добавляет в объект Store 
с помощью его метода `put()` 5 товаров. 

Потребитель в методе `run()` в цикле обращается к методу get объекта Store 
для получения этих товаров. 

Оба метода Store - `put` и `get` являются синхронизированными.



Для отслеживания наличия товаров в классе Store 
проверяем значение переменной product. 

По умолчанию товара нет, поэтому переменная равна 0. 
Метод `get()` - получение товара должен срабатывать 
только при наличии хотя бы одного товара. 

Поэтому в методе `get` проверяем, отсутствует ли товар:

```java
while (product<1)
```

Если товар отсутсвует, вызывается метод `wait()`. 

Этот метод освобождает монитор объекта Store 
и блокирует выполнение метода get, пока для этого же монитора 
не будет вызван метод `notify()`.


Когда в методе put() добавляется товар и вызывается notify(), 
то метод get() получает монитор и выходит из конструкции while (product<1), 
так как товар добавлен. Затем имитируется получение покупателем товара. 

Для этого выводится сообщение, и уменьшается значение product: product--. 
И в конце вызов метода notify() дает сигнал методу put() продолжить работу.




В методе put() работает похожая логика, только теперь метод put() должен срабатывать, 
если в магазине не более трех товаров. 

Поэтому в цикле проверяется наличие товара, и если товар уже есть, 
то освобождаем монитор с помощью wait() и ждем вызова notify() в методе get().

И теперь программа покажет нам другие результаты:

```java
Производитель добавил 1 товар
Товаров на складе: 1
Производитель добавил 1 товар
Товаров на складе: 2
Производитель добавил 1 товар
Товаров на складе: 3
Покупатель купил 1 товар
Товаров на складе: 2
Покупатель купил 1 товар
Товаров на складе: 1
Покупатель купил 1 товар
Товаров на складе: 0
Производитель добавил 1 товар
Товаров на складе: 1
Производитель добавил 1 товар
Товаров на складе: 2
Покупатель купил 1 товар
Товаров на складе: 1
Покупатель купил 1 товар
Товаров на складе: 0
```

Таким образом, с помощью wait() в методе get() мы ожидаем, 
когда производитель добавит новый продукт. 

А после добавления вызываем notify(), как бы говоря, 
что на складе освободилось одно место, и можно еще добавлять.

А в методе put() с помощью wait() мы ожидаем освобождения места на складе. 
После того, как место освободится, добавляем товар и через notify() уведомляем покупателя о том, что он может забирать товар.














```java
```



























