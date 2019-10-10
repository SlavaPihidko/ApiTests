package model;

public class Txrefs {

    public int getValue() {
        return value;
    }

    public Txrefs withValue(int value) {
        this.value = value;
        return this;
    }

    public boolean isSpent() {
        return spent;
    }

    public Txrefs withSpent(boolean spent) {
        this.spent = spent;
        return this;
    }

    private int value;
    boolean spent;

    @Override
    public String toString() {
        return "Txrefs{" +
                "value=" + value +
                ", spent=" + spent +
                '}';
    }
}
