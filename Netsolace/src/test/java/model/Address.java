package model;


import java.util.Arrays;

public class Address {
    private int total_received;
    private int total_sent;
    private int balance;
    private Txrefs [] txrefs;

    public int getTotal_received() {
        return total_received;
    }

    public Address withTotal_received(int total_received) {
        this.total_received = total_received;
        return this;
    }

    public int getTotal_sent() {
        return total_sent;
    }

    public Address withTotal_sent(int total_sent) {
        this.total_sent = total_sent;
        return this;
    }

    public int getBalance() {
        return balance;
    }

    public Address withBalance(int balance) {
        this.balance = balance;
        return this;
    }

    public Txrefs[] getTxrefs() {
        return txrefs;
    }

    public Address withTxrefs(Txrefs[] txrefs) {
        this.txrefs = txrefs;
        return this;
    }

    @Override
    public String toString() {
        return "Address{" +
                "total_received=" + total_received +
                ", total_sent=" + total_sent +
                ", balance=" + balance +
                ", txrefs=" + Arrays.toString(txrefs) +
                '}';
    }
}
