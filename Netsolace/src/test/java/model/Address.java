package model;


import java.util.Arrays;

public class Address {
    private long total_received;
    private long total_sent;
    private long balance;
    private Txrefs [] txrefs;

    public long getTotal_received() {
        return total_received;
    }

    public Address withTotal_received(long total_received) {
        this.total_received = total_received;
        return this;
    }

    public long getTotal_sent() {
        return total_sent;
    }

    public Address withTotal_sent(long total_sent) {
        this.total_sent = total_sent;
        return this;
    }

    public long getBalance() {
        return balance;
    }

    public Address withBalance(long balance) {
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
