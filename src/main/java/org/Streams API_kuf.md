# Функциональные интерфейсы (в др файле), СТРИМЫ (тут)

## История

*Стримы (Streams)* в Java были представлены в версии Java 8 
и предоставляют высокоуровневый способ обработки коллекций данных. 

Они позволяют писать код, который легче читать и поддерживать, 
используя декларативный подход к обработке данных.




## Основные концепции

1. *Что такое Stream?*
Стрим — это последовательность элементов, 
которая поддерживает ряд операций для их обработки. 

Важно отметить, что стримы не хранят данные, 
они лишь обрабатывают данные из источника
(например, коллекции, массива или генератора).

2. *Преимущества использования Stream API:*
    - *Читаемость кода:* Код, использующий струменые операции, часто более декларативен и понятен.
    - *Параллельная обработка:* Легко выполнять параллельные операции для повышения производительности.
    - *Ленивые вычисления:* Промежуточные операции выполняются только при необходимости, что может оптимизировать производительность.




## Основные операции

Стримы поддерживают два типа операций:

1. *Промежуточные операции (Intermediate Operations):*
    - Возвращают новый стрим.
    - Например: `filter`, `map`, `sorted`, `limit`.

2. *Терминальные операции (Terminal Operations):*
    - Завершают обработку стрима и возвращают результат.
    - Например: `forEach`, `collect`, `reduce`, `count`.

Важно: Промежуточные операции ленивы и не выполняются до тех пор, 
пока не будет вызвана терминальная операция.








## Примеры использования Stream API

### Пример 1: Фильтрация и вывод элементов

```java
import java.util.Arrays;
import java.util.List;

public class StreamExample1 {
   public static void main(String[] args) {
      List<String> names = Arrays.asList("Анна", "Борис", "Виктор", "Галина", "Дмитрий");
      
              // Фильтруем имена, длина которых больше 4 символов, и выводим их
              names.stream()
                   .filter(name -> name.length() > 4)
                   .forEach(System.out::println);
              
   }
}
```

*Вывод:*
```java
Борис
Виктор
Галина
Дмитрий
```

Примечание: В данном случае все кроме "Анна" имена имеют длину больше 4




___
___
___





###  Пример 2: Преобразование элементов с использованием `map`

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample2 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("анна", "борис", "виктор");

        // Преобразуем имена в верхний регистр и собираем в новый список
        List<String> upperNames = names.stream()
                                       .map(String::toUpperCase)
                                       .collect(Collectors.toList());

        System.out.println(upperNames);
        
    }
}
```

*Вывод:*
```
[АННА, БОРИС, ВИКТОР]
```

Примечание:
```
.collect(Collectors.toList());   //эта запись собирает обратно в List
```


___
___
___



### Пример 3: Сортировка и ограничение количества элементов

```java
import java.util.Arrays;
import java.util.List;

public class StreamExample3 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 9, 2, 7, 4, 6);

        // Сортируем числа, ограничиваем до первых 5 и выводим
        numbers.stream()
               .sorted()
               .limit(5)
               .forEach(System.out::println);
        
    }
}
```

*Вывод:*
```
1
2
3
4
5
```


___
___
___


### Пример 4: Сумма элементов с использованием `reduce`

```java
import java.util.Arrays;
import java.util.List;

public class StreamExample4 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        // Вычисляем сумму всех чисел
        int sum = numbers.stream()
                         .reduce(0, Integer::sum);

        System.out.println("Сумма: " + sum);
        
    }
}
```

*Вывод:*
```
Сумма: 150
```




___
___
___


### Пример 5: Группировка элементов с использованием `Collectors`

```java
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamExample5 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("яблоко", "апельсин", "банан", "авокадо", "вишня", "арахис");

        // Группируем слова по первой букве
        Map<Character, List<String>> grouped = words.stream()
                         .collect(Collectors.groupingBy(word -> word.charAt(0)));
        System.out.println(grouped);
                 
    }
}
```

*Вывод:*
```
{а=[апельсин, авокадо, арахис], б=[банан], в=[вишня], я=[яблоко]}
```



___
___
___




## Параллельные стримы

Stream API поддерживает параллельную обработку данных, 
что может повысить производительность на многопроцессорных системах.

*Пример:*

```java
import java.util.Arrays;
import java.util.List;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // Параллельная обработка: умножаем каждое число на 2 и выводим
        numbers.parallelStream()
               .map(n -> n * 2)
               .forEach(System.out::println);
        
    }
}
```


*Важно:* Параллельные стримы могут улучшить производительность 
для больших объемов данных, но их использование должно быть осознанным, 
так как есть накладные расходы на разделение задач и объединение результатов.





## Заключение

Stream API предоставляет мощные 
и гибкие средства для обработки коллекций данных в Java. 

Используя стримы, можно писать более компактный и выразительный код, 
упрощая задачи фильтрации, преобразования, сортировки и агрегации данных. 

Однако, как и любой инструмент, их следует использовать там, 
где они действительно приносят пользу, 
и понимать внутреннюю модель работы для эффективного применения.










___
___
___
___
___
___
___
___
___
___
___
___
___
___
___
___
___
___
___
___
___






















