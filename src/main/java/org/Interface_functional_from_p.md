# Функциональные интерфейсы

## Определения

**_Функциональный интерфейс_** - это интерфейс, который содержит всего один  _abstract_-метод. Такой подход, позволяет
идентифицировать интерфейс как функциональный, в следствие чего, будет понятно какой именно метод должен быть вызван

## Существующие функциональные интерфейсы

* Predicate< T>
* Consumer< T>
* Function<T, R>
* Supplier< T>
* UnaryOperator< T>
* BinaryOperator< T>
* Comparator<T>

### Predicate

Проверяет истинность некоторого условия. Если условие соблюдается, то возвращается значение _true_.

Содержит всего один не _default_-метод `test`, принимающий параметр типа < T>.

Рассмотрим пример, как можно использовать `Predicate` для определения натуральности целого числа.

```java
public class Main {
    public static void main(String[] args) {
        Predicate<Integer> isPositive = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer >=0;
            }
        };

        System.out.println(isPositive.test(-5));
        System.out.println(isPositive.test(0));
        System.out.println(isPositive.test(10));
        System.out.println(isPositive.test(100));
    }
}
```

### Consumer

Выполняет определённые действия над объектом типа < T> и ничего не возвращает.

Содержит всего один не _default_-метод `accept`, принимающий параметр типа < T>.

Рассмотрим пример использования `Consumer`, который удаляет из списка предпоследний элемент

```java
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(10, 20, 30, 40, 50, 60, 70, 80, 90, 10));

        Consumer<ArrayList<? extends Number>> removePreLast = new Consumer<ArrayList<? extends Number>>() {
            @Override
            public void accept(ArrayList<? extends Number> numbers) {
                if (numbers.size() <= 1) return;
                numbers.remove(numbers.size() - 2);
            }
        };

        removePreLast.accept(list);
        System.out.println(list);

        removePreLast.accept(list);
        System.out.println(list);
    }
}
```

### Function<T, R>

Содержит всего один не _default_-метод `apply`, принимающий параметр типа < T>.

Функциональный интерфейс, который реализует переход от объекта типа < T> к объекту типа < R>

Рассмотрим пример использования `Function`, который вычисляет сумму значений `HashMap`.

```java
public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> peoples = new HashMap<>();
        peoples.put("Смирнова", 100_000);
        peoples.put("Семёнова", 40_000);
        peoples.put("Петров", 210_000);
        peoples.put("Иванов", 150_000);

        Function<HashMap<String, Integer>, Integer> sumValues = new Function<HashMap<String, Integer>, Integer>() {
            @Override
            public Integer apply(HashMap<String, Integer> map) {
                int sum = 0;
                for (Integer value : map.values()) {
                    sum += value;
                }
                return sum;
            }
        };

        System.out.println(sumValues.apply(peoples));

        peoples.put("Коновалов", 10_000);
        System.out.println(sumValues.apply(peoples));

    }
}
```

### Supplier< T>

Содержит всего один не _default_-метод `get`, не принимающий параметров.

Функциональный интерфейс, не принимающий параметров, но возвращающий объект типа < T>

Рассмотрим пример использования `Supplier`, который создаёт список целых чисел

```java
public class Main {
    public static void main(String[] args) {
        Supplier<ArrayList<Integer>> generateList = new Supplier<ArrayList<Integer>>() {
            @Override
            public ArrayList<Integer> get() {
                int size = new Random().nextInt(10, 50);
                ArrayList<Integer> result = new ArrayList<>();

                for (int i = 0; i < size; i++) {
                    int randomNumber = new Random().nextInt(-1000, 1000);
                    result.add(randomNumber);
                }
                return result;
            }
        };

        ArrayList<Integer> list = generateList.get();
        System.out.println(list);

    }
}
```

### UnaryOperator< T>

Содержит всего один не _default_-метод `apply`, принимающий один параметр типа< T>.

Функциональный интерфейс, принимает в качестве параметра объект типа < T>, выполняет над ним определённые операции и
возвращает рзельтат операций в виде объекта типа < T>
Рассмотрим пример использования `UnaryOperator`, который меняет строку.

```java
public class Main {
    public static void main(String[] args) {
        UnaryOperator<String> capitalize = new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                return String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1).toLowerCase();
            }
        };

        String s = "прИВЕт";
        s = capitalize.apply(s);
        System.out.println(s);

        String s2 = "МОНОПОЛИЯ";
        s2 = capitalize.apply(s2);
        System.out.println(s2);
    }
}
```

### BinaryOperator< T>

Содержит всего один не _default_-метод `apply`, принимающий два параметра типа < T>.

Функциональный интерфейс выполняет бинарную операцию над двумя переданными параметрами и возвращает результат этой
операции в виде объекта типа < T>

Рассмотрим пример использования `UnaryOperator`, который складывает две строки.

```java
public class Main {
    public static void main(String[] args) {
        BinaryOperator<String> concatinate = new BinaryOperator<String>() {
            @Override
            public String apply(String s, String s2) {
                return s + " " + s2;
            }
        };

        String fio1 = concatinate.apply("Иван", "Иванов");
        System.out.println(fio1);

    }
}
```

### Comparator< T>

Функциональный интерфейс, содержащий абстрактный метод `compare`, который принимает два параметра типа < T>.

Компаратор - очень важный функциональный интерфейс, который позволяет использовать метод `sort` у колекций, для сортировки
кастомных классов.

Допустим, существует класс `Human`:

```java
class Human{
    private String surname;
    private String name;
    private int age;

    public Human(String surname, String name, int age) {
        this.surname = surname;
        this.name = name;
        this.age = age;
    }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return "Human{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
 }
```

Далее, создаются объекты этого класса и помещаются в список:

```java
ArrayList<Human> humans = new ArrayList<>(
    List.of(
        new Human("Максимов", "Илья", 30),
        new Human("Смирнов", "Александр", 18),
        new Human("Владимиров", "Константин", 49),
        new Human("Лукина", "Ольга", 16),
        new Human("Лапина", "Анна", 30),
        new Human("Аквинский", "Фома", 99),
        new Human("Асафьев", "Стас", 16)
    )
);
```

Чтобы отсортировать эти данные встроенными средствами, можно воспользоваться методом `sort(Comporator<T>)`. Метод `sort`
принимает в качестве параметра компаратор, благодаря которому, становится ясным как именно нужно отсортировать
данные.

Так выглядит компаратор, который упорядочивает людей в списке по возрастанию:

```java
Comparator<Human> humanComparator = new Comparator<Human>() {
    @Override
    public int compare(Human o1, Human o2) {
        if (o1.getAge() > o2.getAge()) return 1;
        if (o1.getAge() < o2.getAge()) return -1;
        return 0;
    }
};
```

Рассмотрим что же это всё значит. Компаратор сравнивает два одинаковых объекта. Компаратор должен возвращать три значения:

1. Положительное число, если первый элемент больше второго
2. Отрицательное число, если второй элемент больше первого
3. Ноль, если объекты одинаковы.

В примере выше описано сравнение людей по их возрасту.

Полный код заполнения списка и его сортировки, но компаратор оформлен в виде лямбды функции:

```java
ArrayList<Human> humans = new ArrayList<>(
    List.of(
        new Human("Максимов", "Илья", 30),
        new Human("Смирнов", "Александр", 18),
        new Human("Владимиров", "Константин", 49),
        new Human("Лукина", "Ольга", 16),
        new Human("Лапина", "Анна", 30),
        new Human("Аквинский", "Фома", 99), 
        new Human("Асафьев", "Стас", 16)
    )
);

Comparator<Human> humanComparator = (o1, o2) -> {
    if (o1.getAge() > o2.getAge()) return 1;
    if (o1.getAge() < o2.getAge()) return -1;
    return 0;
};

humans.sort(humanComparator);
System.out.println(humans);
```

В результате получаем следующий вывод:

```text
[Human{surname='Лукина', name='Ольга', age=16}, 
Human{surname='Асафьев', name='Стас', age=16}, 
Human{surname='Смирнов', name='Александр', age=18}, 
Human{surname='Максимов', name='Илья', age=30}, 
Human{surname='Лапина', name='Анна', age=30}, 
Human{surname='Владимиров', name='Константин', age=49}, 
Human{surname='Аквинский', name='Фома', age=99}]
```

Теперь, доработаем сортировку таким образом, чтобы в случае одинакового возраста объекты упорядочиваются по фамилии.

```java
Comparator<Human> humanComparator = (o1, o2) -> {
    if (o1.getAge() > o2.getAge()) return 1;
    if (o1.getAge() < o2.getAge()) return -1;
    if (o1.getSurname().compareTo(o2.getSurname()) > 0) return 1;
    if (o1.getSurname().compareTo(o2.getSurname()) < 0) return -1;
    return 0;
};
```

В результате получается следующее:

```text
[Human{surname='Асафьев', name='Стас', age=16}, 
Human{surname='Лукина', name='Ольга', age=16}, 
Human{surname='Смирнов', name='Александр', age=18}, 
Human{surname='Лапина', name='Анна', age=30}, 
Human{surname='Максимов', name='Илья', age=30}, 
Human{surname='Владимиров', name='Константин', age=49}, 
Human{surname='Аквинский', name='Фома', age=99}]
```