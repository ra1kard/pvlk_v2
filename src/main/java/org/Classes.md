# Классы

Содержание:
1. что такое класс
2. что такое объект класса
3. как создавать класс
4. что такое поля класса (без модификаторов доступа)
5. что такое методы класса
6. что такое конструктор класса
7. статические методы в классе
8. перегрузка методов в классе
9. инкапсуляция (модификаторы доступа, геттеры и сеттеры)
10. можно ли перегрузить конструктор?
11. можно ли сделать конструктор приватным?
12. зачем нужна инкапсуляция, если с 1го взгляда она только усложняет структуру
13. вложенные классы (как зачем и почему)
14. какой-нибудь пример как все вышеописанное понятно (плюс минус все) - отразить свое понимание простым примером
___
___
___


https://proglang.su/java/classes-and-objects

https://java-online.ru/java-class.xhtml

https://topjava.ru/blog/gettery-i-settery-v-java#:~:text=%D0%93%D0%B5%D1%82%D1%82%D0%B5%D1%80%20%D0%B8%D0%BD%D0%BE%D0%B3%D0%B4%D0%B0%20%D0%BD%D0%B0%D0%B7%D1%8B%D0%B2%D0%B0%D1%8E%D1%82%20accessor%20(%D0%B0%D0%BA%D1%81%D0%B5%D1%81%D1%81%D0%BE%D1%80,%D1%81%D0%B5%D1%82%D1%82%D0%B5%D1%80%20mutator%20(%D0%BC%D1%83%D1%82%D0%B0%D1%82%D0%BE%D1%80%2C%20%D1%82.


## 1. Что такое класс:

Java является объектно-ориентированным языком программирования. 
Как язык, который имеет функцию объектно-ориентирования, 
он поддерживает следующие основные понятия:
- полиморфизм;
- наследование;
- инкапсуляция;
- абстракция;
- классы;
- объекты;
- экземпляр;
- метод;
- парсинг.

Рассмотрим объекты и классы в Java, их концепции.

___

Класс определяется с помощью ключевого слова сlass. 
Вся функциональность класса представлена его членами:
- полями (полями называются переменные класса) 
- и методами.

Класс - можно определить как шаблон, который описывает поведение объекта.

Объект в свою очередь имеет состояние и поведение.

Объект является экземпляром класса.

___

#### Например:

Шаблон собака может иметь:
- состояние – цвет, имя [поле класса]
- поведение – кивать, лаять, есть [методы класса]

Объект собака имеет:
- состояние - палевый, Ронни [поля экземпляра класса]
- поведение - кивать, лаять, есть [методы экзмепляра класса]
___
___
___









## 2. Что такое объект класса

Давайте теперь посмотрим вглубь, что является объектами. 
Если мы рассмотрим реальный мир, то найдём много предметов вокруг нас:
- автомобили
- собаки
- люди
- и т.д. 

Все они имеют состояние и поведение.

#### Например:

Класс автомобиль, то:
- состояние – марка, цвет [поля]
- поведение - движение, поворот, гудок [методы]

Объект автомобиль:
- состояние - ford, серый [поля]
- поведение - движение, поворот, гудок [методы]

Если сравнить программный объект в Java с предметом из реального мира,
то они имеют очень схожие характеристики, у них также есть состояние и поведение. 
Программное состояние хранят в полях, а поведение отображается через методы.

Таким образом, в разработке программного обеспечения: 
- методы работают на внутреннем состоянии объекта, 
- связи с другими объектами, осуществляются с помощью методов.
___
___
___








## 3. Как создавать класс

### Пример:

```java
public class Dog {
    String breed;       //поля класса
    int age;            //поля класса
    String color;       //поля класса

    void barking() {    //методы класса
    }

    void hungry() {     //методы класса
    }

    void sleeping() {   //методы класса
    }
}
```
___
___
___





## 3.1 Как создавать объект

Чтобы непосредственно использовать класс в программе, 
надо создать его объект. 

Процесс создания объекта двухступенчатый: 
1. вначале объявляется переменная данного класса,

2. а затем с помощью ключевого слова new и конструктора 
непосредственно создается объект, 
на который и будет указывать объявленная переменная :

```java
Book b;                 // объявление переменной определенного типа/класса
b = new Book();         // выделение памяти под объект Book
```
(а) После объявления переменной Book b; 
эта переменная еще не ссылается ни на какой объект и имеет значение null.

(б) Затем создаем непосредственно объект класса Book 
с помощью одного из конструкторов и ключевого слова new.

```java
Book b = new Book();    // альтернативная запись
```
___
___
___






## 4. Что такое поля класса (без модификаторов доступа)

Поле класса — это переменная, которая описывает какое-либо из свойств данного класса.

Она хранит данные, относящиеся к объектам этого класса. 

В отличие от локальных переменных, которые объявляются внутри методов
и существуют только в то время, пока метод выполняется, 
поля класса доступны для использования во всех методах класса.

___

Класс может содержать любой из следующих видов переменных:

- Локальные переменные, определенные внутри методов, конструкторов или блоков. 
Они будут объявлены и инициализированы в методе, и будут уничтожены, 
когда метод завершится.

```java
public class Dog {
    String breed;
    int age;
    String color;

    void barking() {
    }

    void hungry() {
        boolean enoughWater = false;    //локальная переменная внутри метода
        boolean enoughFood = false;     //локальная переменная внутри метода
    }

    void sleeping() {
    }

    public static void main(String[] args) {
        Dog ronny = new Dog();
        ronny.breed = "french";
        ronny.age = 5;
        ronny.color = "fawn";
    }
}
```

- Переменные экземпляра являются переменными в пределах класса, 
но и снаружи любого метода. Они инициализируются при загрузке. 
Переменные экземпляра могут быть доступны изнутри любого метода, 
конструктора или блоков этого конкретного класса.

```java
public class Dog {
    String breed;
    int age;
    String color;

    void barking() {
    }

    void hungry() {
        boolean enoughWater = false;
        boolean enoughFood = false;
    }

    void sleeping() {
    }

    public static void main(String[] args) {
        Dog ronny = new Dog();
        ronny.breed = "french";         //Переменные экземпляра
        ronny.age = 5;                  //Переменные экземпляра
        ronny.color = "fawn";           //Переменные экземпляра
    }
}
```


- Переменные класса или статические переменные класса в Java 
объявляются в классе вне любого метода с помощью статического ключевого слова.

```java
public class Dog {
    String breed;                       //Переменные класса 
    int age;                            //Переменные класса 
    String color;                       //Переменные класса 

    void barking() {
    }

    void hungry() {
        boolean enoughWater = false;
        boolean enoughFood = false;
    }

    void sleeping() {
    }

    public static void main(String[] args) {
        Dog ronny = new Dog();
        ronny.breed = "french";
        ronny.age = 5;
        ronny.color = "fawn";
    }
}
```
___
___
___






## 5. Что такое методы класса

Метод класса в объектно-ориентированном программировании — 
это функция или процедура, принадлежащая какому-либо классу или объекту.

Метод состоит:
- из некоторого количества операторов для выполнения определенного действия 
- и может иметь набор входных параметров.

Различают простые методы и статические методы:
- простые методы имеют доступ к данным объекта конкретного экземпляра (данного класса);
- статические методы не имеют доступа к данным объекта, и для их использования не нужно создавать экземпляры (данного класса).

Синтаксис метода в Java:

```java
public class Dog {
    
    возвращаемыйТип названиеМетода(аргументы) {
        //code
        return значение;
    }
    
}
```

Строка возвращаемыйТип показывает, какого типа данные вернёт метод. 
Например, если в качестве возвращаемого типа мы поставим тип String, 
то метод должен будет вернуть строку, а если int — целое число.

Чтобы вернуть значение из метода, используется специальное слово return. 
Если мы хотим, чтобы метод ничего не возвращал, 
то вместо возвращаемого типа нужно использовать специальное слово void.

Аргументы — то, что нужно передать в метод при его вызове. 
Мы можем указать сколько угодно параметров через запятую 
либо не указывать ни одного.

```java
public class Dog {
    
    возвращаемыйТип названиеМетода(аргументы) {
        //code
        return значение;
    }

    int sum(int a, int b) {
        int c = a + b;
        return c;
    }
    
}
```

Возвращаемый тип метода int, он указан перед именем sum. 
Далее идут два аргумента a и b, у обоих также указан тип int. 
Важно помнить, что возвращаемый тип и тип переменных не обязательно должны совпадать.

Аргументы метода работают как обычные переменные — 
за пределами метода к ним никак нельзя получить доступ. 
Внутри метода мы складываем значения из переменных a и b, 
записываем полученное значение в переменную c. 
После этого мы возвращаем значение переменной c — только оно доступно вне метода.

Мы передали в метод sum два значения 1 и 2, 
а на выходе получили результат их сложения 3. 

___

Также можно создать метод, который принимает значение типа String, 
а возвращает длину этой строки:

```java
public class Dog {
    
    возвращаемыйТип названиеМетода(аргументы) {
        //code
        return значение;
    }

    int lengthOfString(String str) {
        return str.length();
    }
    
}
```
В этом случае у нас возвращаемый типа int, а параметр str — типа String.
___
___
___









## 6. Что такое конструктор класса

Кроме обычных методов в классах используются также и специальные методы, 
которые называются конструкторами.

Конструкторы нужны для создания нового объекта данного класса и, 
как правило, выполняют начальную инициализацию объекта. 

___

Название конструктора должно совпадать с названием класса:

```java
class Book {
    public String name;
    public String author;
    public int year;

    Book() {
        this.name = "неизвестно";
        this.author = "неизвестно";
        this.year = 0;
    }

    Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public void Info() {
        System.out.printf("Книга '%s' (автор %s) была издана в %d году \n", name, author, year);
    }
}
```

Класс Book имеет два конструктора. 

1. Первый конструктор без параметров присваивает "неопределенные" 
начальные значения полям. 

2. Второй конструктор присваивает полям класса значения, 
которые передаются через его параметры.

P.S. можно в коде нажать ctrl и посмотреть что куда ссылается (открой Book.java)
___

Так как имена параметров и имена полей класса в данном случае у нас совпадают:
- name, 
- author, 
- year,

То мы используем ключевое слово this. 

Это ключевое слово представляет ссылку на текущий объект. 

Поэтому в выражении this.name = name:
- первая часть this.name означает, что name - это поле текущего класса, 
- а не название параметра name. 
- Если бы у нас параметры и поля назывались по-разному, 
то использовать слово this было бы необязательно.


### Инициализаторы

Кроме конструктора начальную инициализацию полей объекта можно проводить 
с помощью инициализатора объекта. 

Так можно заменить конструктор без параметров следующим блоком :

```java
public class Book
{
    public String name;
    public String author;
    public int year;
     
    /* начало блока инициализатора */
    {
        name = "неизвестно";
        author = "неизвестно";
        year = 0;
    }
    /* конец блока инициализатора */
     
    Book(String name, String author, int year){
        this.name = name;
        this.author = author;
        this.year = year;
    }  
}
```
___
___
___










## 7. Статические методы в классе

Возникает типичная проблема в Java, когда программисты начинают работать с методами.
Они сталкиваются с концепцией статических методов и иногда бывает сложно определить, 
когда именно стоит использовать статические методы.

### Пример:
Допустим, есть класс Car с методом drive(). 

- Если drive() объявлен как статический метод, он может быть вызван напрямую из класса, 
как показано ниже:
```java
Car.drive();            //drive() объявлен как статический метод (вызов через класс)
```

- Если drive() не является статическим методом, то он должен быть вызван из объекта
класса Car, как показано ниже:
```java
Car myCar = new Car();
myCar.drive();          //drive() не является статическим методом (вызов через объект)
```

Итак, Статические методы:
- являются методами уровня класса, 
- принадлежат самому классу, а не его экземплярам
- в связи с этим, они могут быть вызваны без создания объекта класса.

Нестатические методы:
- являются методами уровня объекта 
- принадлежат экземплярам класса (объектам)
- могут быть вызваны только после создания объекта

Так когда же стоит использовать статические методы?

1. Когда метод не взаимодействует с полями объекта и не зависит от состояния объекта. 
В этом случае метод может быть объявлен как статический, 
потому что он не влияет на состояние объекта.

2. Когда метод должен быть доступен без необходимости создания объекта класса. 
Например, вспомогательные методы, такие как методы для выполнения математических
операций.

3. Когда метод должен быть доступен перед созданием объекта. 
Например, методы, используемые для создания объектов в шаблонах проектирования, 
таких как Singleton.

Однако стоит помнить, что чрезмерное использование статических методов может
привести к проблемам с тестированием и модульностью, 
поскольку статические методы не могут быть переопределены или скрыты подклассами.

Важным свойством статического метода является то, что он может обратиться 
только к статическим переменным/методам.

В итоге, статические методы в Java являются мощным инструментом, который, 
при правильном использовании, может сделать код более читаемым и эффективным. 
Но, как и все инструменты, они должны использоваться с осторожностью и пониманием.

```java
public class Counter {
   static int count;

   public static void invokeCounter() {
      count++;
      System.out.println("Текущее значение счётчика - " + count);
   }
}
```

Вызовем его в main:
```java
Counter.invokeCounter();
Counter.invokeCounter();
Counter.invokeCounter();
```
Получим:
```java
Текущее значение счётчика - 1
Текущее значение счётчика - 2
Текущее значение счётчика - 3
```
___
___
___












## 8. Перегрузка методов в классе, Overload

В программе мы можем использовать методы с одним и тем же именем,
но с разными типами и/или количеством параметров.

Такой механизм называется перегрузкой методов (method overloading).

```java
public class Program{
    
    public static void main(String[] args) {
        System.out.println(sum(2, 3));          // 5
        System.out.println(sum(4.5, 3.2));      // 7.7
        System.out.println(sum(4, 3, 7));       // 14
    }
    
    static int sum(int x, int y){
        return x + y;
    }
    
    static double sum(double x, double y){
        return x + y;
    }
    
    static int sum(int x, int y, int z){
        return x + y + z;
    }
    
}
```

Стоит отметить, что:
- на перегрузку методов влияют количество и типы параметров
- однако различие в типе возвращаемого значения для перегрузки не имеют никакого значения.
___
___
___








## Переопределение метода, @Override

Представь, что у нас есть один общий метод,
но он должен делать разные вещи в зависимости от того, в каком классе он был вызван.

Как реализовать такое поведение?

Чтобы разобраться, возьмем:
1. родительский класс Animal, обозначающий животных,
2. и создадим в нем метод voice — «голос»:

```java
public class Animal {

   public void voice() {
       System.out.println("Голос!");
   }
   
}
```
Наша цель проста: избежать создания кучи методов для подачи голоса.
Вместо того, чтобы создавать методы voiceCat() для мяуканья,
voiceSnake() для шипения и т.д., мы хотим, чтобы при вызове метода voice() змея шипела,
кошка мяукала, а собака лаяла.

Мы легко добьемся этого с помощью механизма переопределения методов (Override в Java).

Переопределение - позволяет взять какой-то метод родительского класса
и написать в каждом классе-наследнике свою реализацию этого метода.
Новая реализация «заменит» родительскую в дочернем классе.

```java
public class Bear extends Animal {
   @Override
   public void voice() {
       System.out.println("Р-р-р!");
   }
}

public class Cat extends Animal {
   @Override
   public void voice() {
       System.out.println("Мяу!");
   }
}

public class Dog extends Animal {
   @Override
   public void voice() {
       System.out.println("Гав!");
   }
}

public class Snake extends Animal {
   @Override
   public void voice() {
       System.out.println("Ш-ш-ш!");
   }
}
```

Чтобы задать нужное нам поведение, мы сделали несколько вещей:

1. Создали в каждом классе-наследнике метод с таким же названием,
   как и у метода в родительском классе.
2. Сообщили компилятору, что мы не просто так назвали метод так же,
   как в классе-родителе: хотим переопределить его поведение. Для этого «сообщения» компилятору мы поставили над методом аннотацию @Override («переопределен»).
3. Проставленная над методом аннотация @Override сообщает компилятору
   (да и читающим твой код программистам тоже):
   «Все ок, это не ошибка и не моя забывчивость.
   Я помню, что такой метод уже есть, и хочу переопределить его».

Посмотрим, как это будет работать в программе:

```java
public class Main {

   public static void main(String[] args) {

       Animal animal1 = new Dog();
       Animal animal2 = new Cat();
       Animal animal3 = new Bear();
       Animal animal4 = new Snake();

       animal1.voice();
       animal2.voice();
       animal3.voice();
       animal4.voice();
   }
}
```

```java
Гав!
Мяу!
Р-р-р!
Ш-ш-ш!
```
___

У переопределения есть ряд ограничений:
1. У переопределенного метода должны быть те же аргументы, что и у метода родителя.
2. У переопределенного метода должен быть тот же тип возвращаемого значения,
   что и у метода родителя.
3. Модификатор доступа у переопределенного метода также не может отличаться
   от «оригинального»:
___
___
___











## 9. Инкапсуляция (модификаторы доступа, геттеры и сеттеры)

### Модификаторы метода

Из чего состоит метод:
- набор модификаторов (public, protected, private);
- тип возвращаемого значения;
- имя метода;
- набор аргументов (параметров);
- тело метода

```java
public class Dog {
    
    модификатор возвращаемыйТип названиеМетода(аргументы) {
        //code
        return значение;
    }

    public int sum(int a, int b) {
        int c = a + b;
        return c;
    }
    
}
```

### Модификаторы метода - public, protected, private

Модификаторы метода определяют уровень доступа.
В зависимости от того, какой уровень доступа предоставляет тот или иной метод, выделяют:

- public : открытый — общий интерфейс для всех пользователей данного класса;
- protected : защищённый — внутренний интерфейс для всех наследников данного класса;
- private : закрытый — интерфейс, доступный только изнутри данного класса.

___

Еще определение (без привязки к методам):

Модификаторы доступа позволяют задать допустимую область ВИДИМОСТИ для членов класса,
то есть контекст, в котором можно употреблять данную переменную или метод.

1. public: публичный, общедоступный класс или член класса. 
ПОЛЯ и МЕТОДЫ, объявленные с модификатором public, 
ВИДНЫ ДРУГИМ КЛАССАМ из текущего пакета и из внешних пакетов.


2. protected: такой класс или член класса доступен из любого места
в ТЕКУЩЕМ классе или пакете или в ПРОИЗВОДНЫХ классах, даже если они находятся
в других пакетах


3. private: закрытый класс или член класса, противоположность модификатору public.
Закрытый класс или член класса ДОСТУПЕН ТОЛЬКО из кода В ТОМ ЖЕ КЛАССЕ.


4. Модификатор по умолчанию. Отсутствие модификатора у поля или метода
класса предполагает применение к нему модификатора по умолчанию. 
Такие поля или методы видны ВСЕМ КЛАССАМ в ТЕКУЩЕМ ПАКЕТЕ.

Пример в одном пакете два класса:
```java
public class Program {
    public static void main(String[] args) {
        Person kate = new Person("Kate", 32, "Baker Street", "+12334567");
        kate.displayName();     // норм, метод public
        kate.displayAge();      // норм, метод имеет модификатор по умолчанию
        kate.displayPhone();    // норм, метод protected
        kate.displayAddress();  // ! Ошибка, метод private
 
        System.out.println(kate.name);      // норм, модификатор по умолчанию
        System.out.println(kate.address);   // норм, модификатор public
        System.out.println(kate.age);       // норм, модификатор protected
        System.out.println(kate.phone);   // ! Ошибка, модификатор private
    }
}
```

```java
class Person {
    String name;
    protected int age;
    public String address;
    private String phone;
 
    public Person(String name, int age, String address, String phone){
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }
    public void displayName(){
        System.out.printf("Name: %s \n", name);
    }
    void displayAge(){
        System.out.printf("Age: %d \n", age);
    }
    private void displayAddress(){
        System.out.printf("Address: %s \n", address);
    }
    protected void displayPhone(){
        System.out.printf("Phone: %s \n", phone);
    }
}
```

___
Казалось бы, ПОЧЕМУ БЫ не объявить ВСЕ ПЕРЕМЕННЫЕ И МЕТОДЫ с модификатором
PUBLIC, чтобы они были доступны в любой точке программы вне зависимости
от пакета или класса? 

1. Возьмем, например, поле age которое представляет возраст. 
Если другой класс имеет прямой доступ к этому полю, то есть ВЕРОЯТНОСТЬ,
что в процессе работы программы ему будет передано НЕКОРРЕКТНОЕ ЗНАЧЕНИЕ,
например, отрицательное число. 
Подобное изменение данных не является желательным.


2. Либо же мы ХОТИМ, ЧТОБЫ некоторые ДАННЫЕ БЫЛИ ДОСТУПНЫ НАПРЯМУЮ, 
чтобы их можно было вывести на консоль или просто узнать их значение. 
В этой связи рекомендуется как можно больше ограничивать доступ к данным, 
чтобы ЗАЩИТИТЬ ИХ ОТ НЕЖЕЛАТЕЛЬНОГО ДОСТУПА ИЗВНЕ 
(как ДЛЯ ПОЛУЧЕНИЯ ЗНАЧЕНИЯ, так И ДЛЯ ЕГО ИЗМЕНЕНИЯ).


3. Использование различных модификаторов гарантирует, что данные не будут
искажены или изменены не надлежащим образом. Подобное СОКРЫТИЕ ДАННЫХ
внутри некоторой области видимости называется ИНКАПСУЛЯЦИЕЙ.

___

Так, как правило, вместо непосредственного применения полей используют 
методы доступа. Например:

```java
public class Program{
    
    public static void main(String[] args) {
        Person kate = new Person("Kate", 30);
        System.out.println(kate.getAge());      // 30
       
        kate.setAge(33);
        System.out.println(kate.getAge());      // 33
       
        kate.setAge(123450);    
        System.out.println(kate.getAge());      // 33
    }
}
```

```java
class Person{
    
    private String name;
    private int age = 1;
 
    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public void setAge(int age) {
        if(age > 0 && age < 110)
            this.age = age;
    }
}
```

И затем ВМЕСТО непосредственной РАБОТЫ С ПОЛЯМИ name и age в классе Person
мы БУДЕМ РАБОТАТЬ С МЕТОДАМИ, которые устанавливают и возвращают значения
этих полей: 

- Методы setName, setAge и наподобие еще называют СЕТТЕРАМИ
(мьютейтерами mutator), так как они изменяют значения поля. 


- Методы getName, getAge и наподобие называют ГЕТТЕРАМИ
(аксессерами accessor), так как с их помощью мы получаем значение поля.
___







## Итак, что такое геттеры и сеттеры?

В Java геттер и сеттер — это два обычных метода, 
которые используются для:
- ПОЛУЧЕНИЯ значения поля класса
- ИЗМЕНЕНИЯ значения поля класса
___

Следующий код является примером простого класса с private-переменной
и реализованных, для доступа к ней извне, геттера и сеттера:

```java
public class SimpleGetterSetter {
    private int number;
 
    public int getNumber() {
        return number;
    }
 
    public void setNumber(int number) {
        this.number = number;
    }
}
```

Поскольку number является private, то обратиться к ней напрямую
за пределами данного класса не получится:
```java
SimpleGetterSetter obj = new SimpleGetterSetter();

obj.number = 10;   // возникнет ошибка компиляции, т.к. number является private
int number = obj.number;    // то же самое
```

Чтобы таких проблем не было, внешний код должен вызывать 
геттер getNumber() и сеттер setNumber(), 
чтобы получить или обновить значение переменной:

```java
SimpleGetterSetter obj = new SimpleGetterSetter();
 
obj.setNumber(10);              // ок
int number = obj.getNumber();   // ок
```







## Зачем нужны геттеры и сеттеры?

Представьте ситуацию, когда нам необходимо изменить состояние объекта 
(значение его полей) на основе некоторого условия. 


Как мы могли бы достичь этого без сеттера:
- сделать поля public, protected или default
- изменять их значения с помощью оператора точки (.)


Давайте посмотрим на последствия этих действий:
1. Во-первых, сделав поля public, protected или default, 
мы теряем контроль над данными и ставим под угрозу один из 
основополагающих принципов ООП — инкапсуляцию.


2. Во-вторых, поскольку поля не private, то кто угодно может 
изменить их за пределами класса. Это значит, что мы не сможем добиться
их неизменяемости. 
(ПО СУТИ САМОЕ ВАЖНАЯ И КЛЮЧЕВАЯ ОСОБЕННОСТЬ ИСПОЛЬЗОВАНИЯ - 
добиться неизменяемости)


3. В-третьих, мы не можем предоставить никакой логики для изменения
полей по каким-то условиям.


### Итого, можно выделить ряд плюсов при исп. геттеров и сеттеров:

- они помогают достичь инкапсуляции для скрытия состояния объекта 
и предотвращения прямого доступа к его полям


- при реализации только геттера (без сеттера) можно достичь 
неизменяемости объекта


- они могут предоставлять дополнительные функции: 
проверка корректности значения перед его присваиванием полю 
или обработка ошибок. Таким образом, мы можем добавить условную логику 
и обеспечить поведение в соответствии с потребностями (если сеттер 
не имеет подобной логики, а лишь присваивает полю какое-то значение, 
то его наличие не обеспечивает инкапсуляцию, а его присутствие становится
фиктивным)


- можем предоставить полям разные уровни доступа: 

   а) например, get (доступ для чтения) может быть public, 

   б) в то время как set (доступ для записи) может быть protected


- с их помощью мы достигаем еще одного ключевого принципа ООП —
абстракции, которая скрывает детали реализации, чтобы никто не мог
использовать поля непосредственно в других классах или модулях

### Правила именования геттеров и сеттеров

Принцип именования геттеров и сеттеров должен соответствовать 
конвенции Java об именовании: getXXX() и setXXX(),


Где ХХХ — это имя переменной для которой реализуются эти методы. 

Например, для следующей переменной, имена геттера и сеттера будут такие:
```java
private String name;

public void setName(String name)

public String getName()
```

Если переменная имеет тип boolean, то геттер будет содержать префикс isXXX():
```java
private boolean single;

public String isSingle()

public void setSingle(boolean single)
```

___
___
___









## 10. Можно ли перегрузить конструктор?

Начнем по порядку - что такое перегрузка и конструктор: 

Перегрузка в методах:

В программе мы можем использовать методы с одним и тем же именем,
но с разными типами и/или количеством параметров.

Такой механизм называется перегрузкой методов (method overloading).

```java
public class Program{
    
    public static void main(String[] args) {
        System.out.println(sum(2, 3));          // 5
        System.out.println(sum(4.5, 3.2));      // 7.7
        System.out.println(sum(4, 3, 7));       // 14
    }
    
    static int sum(int x, int y){
        return x + y;
    }
    
    static double sum(double x, double y){
        return x + y;
    }
    
    static int sum(int x, int y, int z){
        return x + y + z;
    }
    
}
```
___

### Что касается вопроса - Можно ли перегрузить конструктор?

Конструктор класса, как и любой другой метод, может быть перегружен.

Что такое конструктор в Java?

Конструктор — это специальный метод, который используется для 
инициализации вновь созданного объекта и вызывается сразу после 
выделения памяти для объекта. Его можно использовать для инициализации
объектов с желаемыми значениями или значениями по умолчанию во время
создания объекта. Программисту не обязательно писать конструктор для класса.

Если для класса не предусмотрен пользовательский конструктор, 
компилятор инициализирует переменные-члены значениями ПО УМОЛЧАНИЮ:

- числовые типы данных установлены на 0
- Типы данных char имеют значение нулевой символ ('\0')
- ссылочным переменным присвоено значение null

___

Если ваш конструктор перегрузки в Java переопределен и вы хотите
использовать конструктор Java по умолчанию, его необходимо указать.

Кроме обычных методов в классах используются также и специальные методы,
которые называются конструкторами.

Конструкторы нужны для создания нового объекта данного класса и,
как правило, выполняют начальную инициализацию объекта.

___

Название конструктора должно совпадать с названием класса:

```java
class Book {
    public String name;
    public String author;
    public int year;

    Book() {
        this.name = "неизвестно";
        this.author = "неизвестно";
        this.year = 0;
    }

    Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public void Info() {
        System.out.printf("Книга '%s' (автор %s) была издана в %d году \n", name, author, year);
    }
}
```

Класс Book имеет два конструктора.

1. Первый конструктор без параметров присваивает "неопределенные"
   начальные значения полям.

2. Второй конструктор присваивает полям класса значения,
   которые передаются через его параметры.

P.S. можно в коде нажать ctrl и посмотреть что куда ссылается (открой Book.java)

___
___
___










## 11. Можно ли сделать конструктор приватным?

Мы можем сделать конструктор приватным (private), 
что не позволит создавать его экземпляры.

Какой в этом смысл? 

Например, в паттерне проектирования Одиночка (Singleton) 
приватный конструктор используется для контроля над КОЛИЧЕСТВОМ 
создаваемых экземпляров. Всегда можно будет создать только ОДИН ОБЪЕКТ.

Рассмотрим следующий пример:
```java
import java.time.LocalDateTime;

public class BankAccount {
    private static BankAccount instance;

    String name;
    LocalDateTime opened = LocalDateTime.now();
    double balance = 0.0f;

    private BankAccount(String name) {
        this.name = name;
    }

    public static BankAccount getInstance(String name) {
        if (instance == null) {
            instance = new BankAccount(name);
        }
        return instance;
    }

    @Override
    public String toString() {
        return String.format("Имя: %s \nДата создания: %s \nБаланс: %f\n", name, opened.toString(), balance);
    }
}
```

```java
public class Main {
   public static void main(String[] args) {
       BankAccount bankAccount1 = BankAccount.getInstance("Tom");
       BankAccount bankAccount2 = BankAccount.getInstance("Elena");

       System.out.println(bankAccount1);
       System.out.println(bankAccount2);
   }
}
```
Класс BankAccount (реализует упрощенный паттерн одиночка) 
предоставляет статический метод getInstance(), который проверяет
создан ли уже экземпляр класса или нет. Если создан, то новый не создается,
а возвращается ссылка на существующий.

Результат выполнения программы подтверждает, что в программе 
создается только один объект.


Иногда класс может быть служебным и хранить какие-то статические поля 
и статические методы. Необходимости в создании экземпляров таких 
классов нет, поэтому и в конструкторе нет смысла, но как мы уже знаем,
компилятор создаст конструктор по умолчанию. Чтобы этого не произошло,
мы можем сами создать пустой конструктор и сделать его закрытым, 
используя модификатор доступа private. Такой конструктор называется закрытый.

___
___
___





## 12. Зачем нужна инкапсуляция, если с 1го взгляда она только усложняет структуру

Было ваше, дублирую:

Казалось бы, ПОЧЕМУ БЫ не объявить ВСЕ ПЕРЕМЕННЫЕ И МЕТОДЫ с модификатором
PUBLIC, чтобы они были доступны в любой точке программы вне зависимости
от пакета или класса?

1. Возьмем, например, поле age которое представляет возраст.
   Если другой класс имеет прямой доступ к этому полю, то есть ВЕРОЯТНОСТЬ,
   что в процессе работы программы ему будет передано НЕКОРРЕКТНОЕ ЗНАЧЕНИЕ,
   например, отрицательное число.
   Подобное изменение данных не является желательным.


2. Либо же мы ХОТИМ, ЧТОБЫ некоторые ДАННЫЕ БЫЛИ ДОСТУПНЫ НАПРЯМУЮ,
   чтобы их можно было вывести на консоль или просто узнать их значение.
   В этой связи рекомендуется как можно больше ограничивать доступ к данным,
   чтобы ЗАЩИТИТЬ ИХ ОТ НЕЖЕЛАТЕЛЬНОГО ДОСТУПА ИЗВНЕ
   (как ДЛЯ ПОЛУЧЕНИЯ ЗНАЧЕНИЯ, так И ДЛЯ ЕГО ИЗМЕНЕНИЯ).


3. Использование различных модификаторов гарантирует, что данные не будут
   искажены или изменены не надлежащим образом. Подобное СОКРЫТИЕ ДАННЫХ
   внутри некоторой области видимости называется ИНКАПСУЛЯЦИЕЙ.
___
___
___








## 13. Вложенные классы (как зачем и почему)
___
___
___
___
___
___
___
___







## 14. Какой-нибудь пример как все вышеописанное понятно (плюс минус все) - отразить свое понимание простым примером
___
___
___
___
___
___
___
___




## Вопросы:
1. понять блок:
"Типичные ошибки при использовании геттеров и сеттеров"
https://topjava.ru/blog/gettery-i-settery-v-java#:~:text=%D0%93%D0%B5%D1%82%D1%82%D0%B5%D1%80%20%D0%B8%D0%BD%D0%BE%D0%B3%D0%B4%D0%B0%20%D0%BD%D0%B0%D0%B7%D1%8B%D0%B2%D0%B0%D1%8E%D1%82%20accessor%20(%D0%B0%D0%BA%D1%81%D0%B5%D1%81%D1%81%D0%BE%D1%80,%D1%81%D0%B5%D1%82%D1%82%D0%B5%D1%80%20mutator%20(%D0%BC%D1%83%D1%82%D0%B0%D1%82%D0%BE%D1%80%2C%20%D1%82.


2. прошерстить все примеры:
https://topjava.ru/blog/gettery-i-settery-v-java#:~:text=%D0%93%D0%B5%D1%82%D1%82%D0%B5%D1%80%20%D0%B8%D0%BD%D0%BE%D0%B3%D0%B4%D0%B0%20%D0%BD%D0%B0%D0%B7%D1%8B%D0%B2%D0%B0%D1%8E%D1%82%20accessor%20(%D0%B0%D0%BA%D1%81%D0%B5%D1%81%D1%81%D0%BE%D1%80,%D1%81%D0%B5%D1%82%D1%82%D0%B5%D1%80%20mutator%20(%D0%BC%D1%83%D1%82%D0%B0%D1%82%D0%BE%D1%80%2C%20%D1%82.


3. в левой части один класс, в правой части другой класс


4. геттеры boolean isName, а не getName???