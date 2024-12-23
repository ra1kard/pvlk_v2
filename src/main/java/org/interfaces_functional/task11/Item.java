package org.interfaces_functional.task11;

public class Item {
    private String name;
    private int price;
    private int width;
    private int height;
    private int depth;

    public Item(String name, int price, int width, int height, int depth) {
        this.name = name;
        this.price = price;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDepth() {
        return depth;
    }

    @Override
    public String toString() {
        return "Name " + name +  "Price " + price + " Volume " + width*height*depth + " /// ";
    }

}
