package tests;

import model.AvPriceFromBitcoinaverage;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class AveragePrice  extends TestBase {

    @Test
    public void testAveragePrice() throws FileNotFoundException, ParseException {

        List<AvPriceFromBitcoinaverage> list = am.getApiAveragePrice().getListLast30Days();
        System.out.println("list : " + list);


        List<AvPriceFromBitcoinaverage> list2 = am.getApiAveragePrice().getList2Last30Days();
        System.out.println("list2 :" + list2);

        boolean x;

        for (int i=0; i <= list.size()-1; i++) {
           double xFromList1 =  list.get(i).getAverage();
           double xFromList2 = list2.get(i).getAverage();
              double x1 = xFromList2 - (xFromList2/1000); // lower bound
              double x2 = xFromList2 + (xFromList2/1000); // upper bound
            System.out.println("x1 " + x1);
            System.out.println("x2 " + x2);
            if (x1 <= xFromList1 & xFromList1 <= x2 ){
                x = true;
                System.out.println("x equls :" + x);
                list.get(i).withCheck(true);
                list2.get(i).withCheck(true);
            } else {
                x = false;
                System.out.println("x equls :" + x);
                list.get(i).withCheck(false);
                list2.get(i).withCheck(true);
            }
        }

        assertEquals(list, list2);
    }
}
