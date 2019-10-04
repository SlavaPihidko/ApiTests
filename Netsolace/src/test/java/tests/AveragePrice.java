package tests;

import model.AvPriceFromBitcoinaverage;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

public class AveragePrice  extends TestBase {

    @Test
    public void testAveragePrice() throws FileNotFoundException, ParseException {

        List<AvPriceFromBitcoinaverage> list = am.getApiAveragePrice().getListLast30Days();
        System.out.println("List<AvPriceFromBitcoinaverage> : " + list);
    }
}
