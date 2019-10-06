package model;

import org.testng.annotations.Test;

import java.text.ParseException;

public class AvPriceFromblockchain {


//    @Test
//    public  void avPriceFromblockchain1() throws ParseException {
//        long epoch = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("01/01/1970 01:00:00").getTime() / 1000;
//
//        long epoch2 = 1569888000;
//        String date = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new java.util.Date (epoch2*1000));
//        System.out.println(epoch2);
//        System.out.println(date);
//    }

    long x;
    Double y;

    public long getX() {
        return x;
    }

    public AvPriceFromblockchain withX(long x) {
        this.x = x;
        return this;
    }

    public Double getY() {
        return y;
    }

    public AvPriceFromblockchain withY(Double y) {
        this.y = y;
        return this;
    }

    @Override
    public String toString() {
        return "AvPriceFromblockchain{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AvPriceFromblockchain)) return false;

        AvPriceFromblockchain that = (AvPriceFromblockchain) o;

        if (getX() != that.getX()) return false;
        return getY() != null ? getY().equals(that.getY()) : that.getY() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getX() ^ (getX() >>> 32));
        result = 31 * result + (getY() != null ? getY().hashCode() : 0);
        return result;
    }

}
