
# Файловая система

https://javarush.com/quests/lectures/questcollections.level01.lecture01

В Java есть специальный класс (File), 
с помощью которого можно управлять файлами на диске компьютера. 

Для того чтобы управлять содержимым файлов, есть другие классы: FileInputStream, FileOutputStream,…

Файлы можно создавать, удалять, переименовывать и еще много чего. 

Практически во все классы, которые работают 
(читают, пишут, изменяют) с содержимым файла, 
можно передавать объект класса File. 

Пример:


Можно сразу передавать имя файла в FileInputStream:
```java
 FileInputStream input = new FileInputStream("c:/path/a.txt");
```

А можно отдельно создать объект-файл, а потом передать его в FileInputStream (для понимания):
```java
File file = new File("c:/path/a.txt");
FileInputStream input = new FileInputStream(file);
```
___

Представь, что тебе нужно вывести на экран список всех файлов, 
которые находятся в определенной директории (папке). 

Вот как это можно сделать с помощью файлов:
```java
File folder = new File("c:/path/");
for (File file : folder.listFiles()) 
        {
        System.out.println(file.getName());
        }
```

Методы в примере:
- listFiles() – возвращает список файлов в директории с именем «c:/path/»
- getName() - выведет имя самого файла

___

## А какие еще методы есть у класса File?

| Метод                                                             | Описание                                                                                                                                   |
|-------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------|
| boolean isDirectory()                                             | Является ли «объект файла» директорией                                                                                                     |
| boolean isFile()                                                  | Является ли объект файлом                                                                                                                  |
| long length()                                                     | Возвращает размер/длину файла в байтах.                                                                                                    |
| boolean createNewFile()                                           | Создает файл. Если такой файл уже был, возвращает false.                                                                                   |
| boolean mkdir()                                                   | Создает директорию. Название mkdir происходит от «make directory».                                                                         |
| boolean mkdirs()                                                  | Создает директорию и все поддиректории.                                                                                                    |
| boolean delete()                                                  | Удаляет файл объекта на диске. Если объект – директория, то только, если в ней нет файлов.                                                 |
| void deleteOnExit()                                               | Добавляет файл в специальный список файлов, которые будут автоматически удалены при закрытии программы.                                    |
| File createTempFile (String prefix, String suffix,File directory) | Создает «временный файл» — файл с случайно сгенерированным уникальным именем – что-типа «dasd4d53sd». Дополнительные параметры – префикс к имени, суффикс (окончание). Если директория не указана, то файл создается в специальной директории ОС для временных файлов |
| boolean exists()                                                             | Возвращает true, если файл с таким именем существует на диске компьютера.                                                                  |
| String getAbsolutePath()                                                             | Возвращает полный путь файла со всеми поддиректориями.                                                                                     |
| String getCanonicalPath()                                                             | Возвращает канонический путь файла. Например, преобразовывает путь «c:/dir/dir2/../a.txt» к пути «c:/dir/a.txt»                            |
| String[] list()                                                             | Возвращает массив имен файлов, которые содержатся в директории, которой является текущий объект-файл.                                      |
| File[] listFiles()                                                             | Возвращает массив файлов, которые содержатся в директории, которой является текущий объект-файл.                                           |
| long getTotalSpace()                                                             | Возвращает размер диска (количество байт) на котором расположен файл.                                                                      |
| long getFreeSpace()                                                                  | Возвращает количество свободного места (количество байт) на диске, на котором расположен файл.                                             |
| boolean renameTo(File)                                                                  | Переименовывает файл – содержимое файла фактически получает новое имя. Т.е. можно переименовать файл «c:/dir/a.txt» в «d:/out/text/b.doc». |
| String getName()                                                                  | Возвращает только имя файла, без пути.                                                                                                     |
| String getParent()                                                                  | Возвращает только путь (директорию) к текущему файлу, без самого имени.                                                                    |
| Path toPath()                                                             | Возвращает объект Path, который соответствует текущему объекту File.                                                                       |

___

— Чтобы получить директорию текущего файла, надо вызвать getParent()?

— Ага, но он вернет не объект-файл, а строку – путь к файлу.

Фактически у класса File почти все методы дублированы: 
- одна версия возвращает String, 
- вторая File. 

Вот смотри:
``` java 
File file = new File("c:/path/a.txt");
String directory = file.getParent();
```

``` java 
File file = new File("c:/path/a.txt");
File directory = file.getParentFile();
```
___

1. Если у тебя есть строка с путем к файлу, а надо объект File, то воспользуйся конструктором.

```java 
String path = "c:/a.txt";
File file = new File(path);
```

2. Если же наоборот – есть объект File, а нужна строка – используй getAbsolutePath().
```java 
File file = new File("c:/a.txt");
String path = file.getAbsolutePath();
```

___

Вот тебе маленькое задание – выведи имена всех файлов, 
которые есть в той же директории, что и текущий файл.

```java 
//какой-то текущий файл
File originalFile = new File("c:/path/dir2/a.txt");

//объект-директория
File folder = originalFile.getParentFile();

//печать списка файлов в директории dir2 на экран
for (File file : folder.listFiles())
        {
        System.out.println(file.getName());
        }
```

— Немного путает, что и для файла и для директории используется один и тот же класс – File. Как то это не очень логично, мне кажется.

— Так исторически сложилось. Раньше директория была специальным «пустым» файлом на диске. Сейчас уже, конечно, многое изменилось, но не везде.

___
___
___




# Как записать в файл?

Для полноценной работы с текстовыми файлами цели служат совсем классы, 
которые являются наследниками абстрактных классов Reader и Writer.

### Запись файлов. Класс FileWriter

Класс FileWriter является производным от класса Writer. 

Он используется для записи текстовых файлов.

Чтобы создать объект FileWriter, 
можно использовать один из следующих конструкторов:

```java
FileWriter(File file)
FileWriter(File file, boolean append)
FileWriter(FileDescriptor fd)
FileWriter(String fileName)
FileWriter(String fileName, boolean append) 
```

Так, в конструктор передается либо путь к файлу в виде строки, 
либо объект File, 
который ссылается на конкретный текстовый файл. 

Параметр append указывает, 
должны ли данные дозаписываться в конец файла (если параметр равен true), 
либо файл должен перезаписываться.

Запишем в файл какой-нибудь текст:

```java
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Start5 {

    public static void main(String[] args) throws IOException {
        //создадим директорию
        File folder = new File("/Users/s.kufarev/fileSystemTest/test5/");
        folder.mkdir();

        //создаем файл
        File originalFile = new File("/Users/s.kufarev/fileSystemTest/test5/aa.txt");
        originalFile.createNewFile();

        //запись
        try(FileWriter writer = new FileWriter("/Users/s.kufarev/fileSystemTest/test5/aa.txt", false))
        {
            // запись всей строки
            String text = "Hello Gold!! !";
            writer.write(text);
            // запись по символам
            writer.append('\n');
            writer.append('E');
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        //чтение файла
        try(FileReader reader = new FileReader("/Users/s.kufarev/fileSystemTest/test5/aa.txt"))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){
                System.out.print((char)c);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
```

В конструкторе использовался параметр append со значением false - то есть файл будет перезаписываться. 

Затем с помощью методов, определенных в базовом классе Writer производится запись данных.

Вывод:
```java
Hello Gold!! !
E
```


# Как прочитать файл?

### Вариант 1: BufferedReader и FileReader

```java
public static void main(String[] args) throws IOException {
    //создадим директорию
    File folder = new File("/Users/s.kufarev/fileSystemTest/test2/");
    folder.mkdir();

    //создаем файл
    File originalFile = new File("/Users/s.kufarev/fileSystemTest/test2/aa.txt");
    originalFile.createNewFile();

    //чтение файла (запишем в файл что-то сами через блокнот "LisA by test2")
    BufferedReader reader = new BufferedReader(new FileReader("/Users/s.kufarev/fileSystemTest/test2/aa.txt"));
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
    reader.close();
}
```

Вывод:
```java
LisA by test2
```

___


### Вариант 2: Scanner

```java
public static void main(String[] args) throws IOException {
        //создадим директорию
        File folder = new File("/Users/s.kufarev/fileSystemTest/test3/");
        folder.mkdir();

        //создаем файл
        File originalFile = new File("/Users/s.kufarev/fileSystemTest/test3/aa.txt");
        originalFile.createNewFile();

        //чтение файла (запишем в файл что-то сами через блокнот "LisA by test3")
        Scanner scanner = new Scanner(new File("/Users/s.kufarev/fileSystemTest/test3/aa.txt"));
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }
```

Вывод:
```java
LisA by test3
```

___


### Вариант 3: Files и Paths (Java 7 и выше)

```java
```

Вывод:
```java

```

___


### Вариант 4: Чтение файлов. Класс FileReader

Класс FileReader наследуется от абстрактного класса Reader
и предоставляет функциональность для чтения текстовых файлов.

Для создания объекта FileReader мы можем использовать один из его конструкторов:

```java
FileReader(String fileName) 
FileReader(File file)
FileReader(FileDescriptor fd) 
```

А используя методы, определенные в базом классе Reader,
произвести чтение файла:

```java
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Start5 {

    public static void main(String[] args) throws IOException {
        //создадим директорию
        File folder = new File("/Users/s.kufarev/fileSystemTest/test5/");
        folder.mkdir();

        //создаем файл
        File originalFile = new File("/Users/s.kufarev/fileSystemTest/test5/aa.txt");
        originalFile.createNewFile();

        //запись
        try(FileWriter writer = new FileWriter("/Users/s.kufarev/fileSystemTest/test5/aa.txt", false))
        {
            // запись всей строки
            String text = "Hello Gold!! !";
            writer.write(text);
            // запись по символам
            writer.append('\n');
            writer.append('E');
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        //чтение файла
        try(FileReader reader = new FileReader("/Users/s.kufarev/fileSystemTest/test5/aa.txt"))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){
                System.out.print((char)c);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
```

Вывод:
```java
Hello Gold!! !
E
```

___

Также мы можем считывать в промежуточный буфер из массива символов:

```java
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Start6 {

    public static void main(String[] args) throws IOException {
        //создадим директорию
        File folder = new File("/Users/s.kufarev/fileSystemTest/test5/");
        folder.mkdir();

        //создаем файл
        File originalFile = new File("/Users/s.kufarev/fileSystemTest/test5/aa.txt");
        originalFile.createNewFile();

        //запись
        try(FileWriter writer = new FileWriter("/Users/s.kufarev/fileSystemTest/test5/aa.txt", false))
        {
            // запись всей строки
            String text = "Hello Gold!! !";
            writer.write(text);
            // запись по символам
            writer.append('\n');
            writer.append('E');
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        //чтение файла
        try(FileReader reader = new FileReader("/Users/s.kufarev/fileSystemTest/test5/aa.txt"))
        {
            char[] buf = new char[256];
            int c;
            while((c = reader.read(buf))>0){

                if(c < 256){
                    buf = Arrays.copyOf(buf, c);
                }
                System.out.print(buf);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }

}
```

Вывод:
```java
Hello Gold!! !
E
```

В данном случае считываем последовательно символы из файла в массив из 256 символов, 
пока не дойдем до конца файла в этом случае метод read возвратит число -1.

Поскольку считанная порция файла может быть меньше 256 символов (например, в файле всего 73 символа), 
и если количество считанных данных меньше размера буфера (256), 
то выполняем копирование массива с помощью метода Arrays.copy. 
То есть фактически обрезаем массив buf, оставляя в нем только те символы, которые считаны из файла.

