package model;

public class AvPriceFromBitcoinaverage {

    private String time;
    private int timeInt;
    private Double average;

    public String getTime() {
        return time;
    }

    public AvPriceFromBitcoinaverage withTime(String time) {
        this.time = time;
        return this;
    }

    public int getTimeInt() {
        return timeInt;
    }

    public AvPriceFromBitcoinaverage withTimeInt(int timeInt) {
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

    @Override
    public String toString() {
        return "AvPriceFromBitcoinaverage{" +
                "time='" + time + '\'' +
                ", timeInt=" + timeInt +
                ", average=" + average +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AvPriceFromBitcoinaverage)) return false;

        AvPriceFromBitcoinaverage that = (AvPriceFromBitcoinaverage) o;

        if (getTimeInt() != that.getTimeInt()) return false;
        if (getTime() != null ? !getTime().equals(that.getTime()) : that.getTime() != null) return false;
        return getAverage() != null ? getAverage().equals(that.getAverage()) : that.getAverage() == null;
    }

    @Override
    public int hashCode() {
        int result = getTime() != null ? getTime().hashCode() : 0;
        result = 31 * result + getTimeInt();
        result = 31 * result + (getAverage() != null ? getAverage().hashCode() : 0);
        return result;
    }
}
