package model;

public class AddressAll {
    private int total_received;
    private int total_sent;
    private int balance;
    private int value;
    String spent;


    public int getTotal_received() {
        return total_received;
    }

    public AddressAll withTotal_received(int total_received) {
        this.total_received = total_received;
        return this;
    }

    public int getTotal_sent() {
        return total_sent;
    }

    public AddressAll withTotal_sent(int total_sent) {
        this.total_sent = total_sent;
        return this;
    }

    public int getBalance() {
        return balance;
    }

    public AddressAll withBalance(int balance) {
        this.balance = balance;
        return this;
    }

    public int getValue() {
        return value;
    }

    public AddressAll withValue(int value) {
        this.value = value;
        return this;
    }

    public String getSpent() {
        return spent;
    }

    public AddressAll withSpent(String spent) {
        this.spent = spent;
        return this;
    }

    @Override
    public String toString() {
        return "AddressAll{" +
                "total_received=" + total_received +
                ", total_sent=" + total_sent +
                ", balance=" + balance +
                ", value=" + value +
                ", spent='" + spent + '\'' +
                '}';
    }
}
