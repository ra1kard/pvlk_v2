package org.streams.task25;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private String customerName;
    private List<Product> products = new ArrayList<>();

    Order(int orderId, String customerName, List<Product> products) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.products = products;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<Product> getProducts() {
        return products;
    }

}
