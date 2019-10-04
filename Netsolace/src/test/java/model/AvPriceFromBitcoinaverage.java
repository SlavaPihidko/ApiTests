package model;

import java.sql.Timestamp;

public class AvPriceFromBitcoinaverage {

    private String time;
    private Timestamp timeInt;
    private Double average;
    private Timestamp ts;


    public String getTime() {
        return time;
    }

    public AvPriceFromBitcoinaverage withTime(String time) {
        this.time = time;
        return this;
    }

    public Timestamp getTimeInt() {
        return timeInt;
    }

    public AvPriceFromBitcoinaverage withTimeInt(Timestamp timeInt) {
        this.timeInt = timeInt;
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

    @Override
    public String toString() {
        return "AvPriceFromBitcoinaverage{" +
                "time='" + time + '\'' +
                ", timeInt=" + timeInt +
                ", average=" + average +
                ", ts=" + ts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AvPriceFromBitcoinaverage)) return false;

        AvPriceFromBitcoinaverage that = (AvPriceFromBitcoinaverage) o;

        if (getTime() != null ? !getTime().equals(that.getTime()) : that.getTime() != null) return false;
        if (getTimeInt() != null ? !getTimeInt().equals(that.getTimeInt()) : that.getTimeInt() != null) return false;
        if (getAverage() != null ? !getAverage().equals(that.getAverage()) : that.getAverage() != null) return false;
        return getTs() != null ? getTs().equals(that.getTs()) : that.getTs() == null;
    }

    @Override
    public int hashCode() {
        int result = getTime() != null ? getTime().hashCode() : 0;
        result = 31 * result + (getTimeInt() != null ? getTimeInt().hashCode() : 0);
        result = 31 * result + (getAverage() != null ? getAverage().hashCode() : 0);
        result = 31 * result + (getTs() != null ? getTs().hashCode() : 0);
        return result;
    }
}
