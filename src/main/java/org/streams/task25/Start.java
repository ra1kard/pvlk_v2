package org.streams.task25;

import java.util.*;
import java.util.stream.Collectors;

public class Start {

    public static void main(String[] args) {
        Product shirt1 = new Product("shirtColl2025", 2500);
        Product shirt2 = new Product("shirtColl2024", 1500);
        Product jeans1 = new Product("jeansColl2025", 3000);
        Product jeans2 = new Product("jeansColl2023", 2000);
        Product jeans3 = new Product("jeansColl2022", 1500);
        Product coat1 = new Product("coatCollRarely2021", 25500);
        Product coat2 = new Product("coatCollStand2023", 15500);

        List<Product> products1 = new ArrayList<>(List.of(shirt1, shirt2));             //
        List<Product> products2 = new ArrayList<>(List.of(jeans1, jeans2, coat1));      //
        List<Product> products3 = new ArrayList<>(List.of(jeans3, coat2));              //

        Order order1001 = new Order(1001, "Marina", products1);
        Order order1002 = new Order(1002, "Stanislav", products2);
        Order order1003 = new Order(1003, "Pavel", products3);

        List<Order> orders = new ArrayList<>(List.of(order1001, order1002, order1003));

        // вывод одной цены
        /*for (Order order : orders) {
            System.out.println(order.getProducts().get(0).getPrice());
        }*/


        // вывод всех цен
        orders.stream()
                .flatMap(order -> order.getProducts().stream())
                .forEach(product -> System.out.println(product.getPrice()));
        System.out.println();


        // построить карту, где ключ - клиент, а значение - список названий товаров
        Map<String, List<String>> map = new HashMap<>();
        orders.forEach(order -> {
            String customerName = order.getCustomerName();
            List<String> products = order.getProducts().stream()
                    .map(Product::getName)
                    .toList();
            map.put(customerName, products);
        });

        for (Map.Entry<String, List<String>> stringListEntry : map.entrySet()) {
            System.out.println(stringListEntry.getKey() + " " + stringListEntry.getValue());
        }
        System.out.println();


        // общая сумма заказов каждого клиента (ключ - клиент, значение - сумма каждого товара)
        Map<String, Integer> map1 = new HashMap<>();
        orders.forEach(order -> {
            String customerName = order.getCustomerName();
            Optional<Integer> sum = order.getProducts().stream()
                    .map(Product::getPrice)
                    .reduce(Integer::sum);
            map1.put(customerName, sum.orElse(0));
        });

        for (String s : map1.keySet()) {

        }


    }

}
