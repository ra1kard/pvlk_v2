package org.multithreading.example1;

public class Start {

    public static void main(String[] args) {

        Thread t = Thread.currentThread();  // получаем главный поток
        System.out.println(t.getName());    // main
        t.setName("ulala");                 // изменим имя гл потока
        System.out.println(t.getName());


        System.out.println(t.getPriority());    //5
        t.setPriority(3);
        System.out.println(t.getPriority());

        System.out.println(t.isAlive());        //true если поток активен
        System.out.println(t.isInterrupted());  //true если поток был прерван

        System.out.println("выведем всю информацию о потоке:");
        //System.out.println(t);              //Thread[main,5,main] - было бы
        System.out.println(t);                  //Thread[ulala,3,main]

    }

}
