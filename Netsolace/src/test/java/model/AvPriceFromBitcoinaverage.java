package model;

import java.sql.Timestamp;

public class AvPriceFromBitcoinaverage {

    private String time;
    private Double average;
    private Timestamp ts;
    private boolean check;


    public String getTime() {
        return time;
    }

    public AvPriceFromBitcoinaverage withTime(String time) {
        this.time = time;
        return this;
    }


    public Double getAverage() {
        return average;
    }

    public AvPriceFromBitcoinaverage withAverage(Double average) {
        this.average = average;
        return this;
    }

    public Timestamp getTs() {
        return ts;
    }

    public AvPriceFromBitcoinaverage withTs(Timestamp ts) {
        this.ts = ts;
        return this;
    }

    public boolean isCheck() {
        return check;
    }

    public AvPriceFromBitcoinaverage withCheck(boolean check) {
        this.check = check;
        return this;
    }

    @Override
    public String toString() {
        return "AvPriceFromBitcoinaverage{" +
                "time='" + time + '\'' +
                ", average=" + average +
                ", ts=" + ts +
                ", check=" + check +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AvPriceFromBitcoinaverage)) return false;

        AvPriceFromBitcoinaverage that = (AvPriceFromBitcoinaverage) o;

        if (isCheck() != that.isCheck()) return false;
        return getTs() != null ? getTs().equals(that.getTs()) : that.getTs() == null;
    }

    @Override
    public int hashCode() {
        int result = getTs() != null ? getTs().hashCode() : 0;
        result = 31 * result + (isCheck() ? 1 : 0);
        return result;
    }

}
