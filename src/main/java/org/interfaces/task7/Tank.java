package org.interfaces.task7;

public class Tank extends TranportItem implements Transportable {

    Tank(int costDelivery, int width, int height, int length) {
        super(costDelivery, width, height, length);
    }

    @Override
    public String toString() {
        return "Танк";
    }

    @Override
    public int costDelivery() {
        return 0;
    }

}
