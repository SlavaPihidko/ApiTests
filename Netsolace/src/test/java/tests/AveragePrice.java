package tests;

import model.AvPrice;
import model.AvPriceFromBitcoinaverage;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class AveragePrice  extends TestBase {

    @Test
    public void testAveragePrice() throws IOException, ParseException {

        List<AvPrice> listFromBitcoinaverage = am.getApiAveragePrice().getListLast30Days();
        System.out.println("listFromBitcoinaverage : " + listFromBitcoinaverage);

        List<AvPrice> listFromBlockchain = am.getApiAveragePrice().getList2Last30Days();
        System.out.println("listFromBlockchain :" + listFromBlockchain);

        boolean x;

        for (int i=0; i <= listFromBitcoinaverage.size()-1; i++) {
           double xFromList1 =  listFromBitcoinaverage.get(i).getAverage();
           double xFromList2 = listFromBlockchain.get(i).getAverage();
              double x1 = xFromList2 - (xFromList2/1000); // lower bound
              double x2 = xFromList2 + (xFromList2/1000); // upper bound
              System.out.println("x1 " + x1);
              System.out.println("xFromList1 : " + xFromList1);
              System.out.println("x2 " + x2);
              System.out.println("=======");
            if (x1 <= xFromList1 & xFromList1 <= x2 )
            {
                x = true;
               // System.out.println("x equls :" + x);
                listFromBitcoinaverage.get(i).withCheck(true);
                listFromBlockchain.get(i).withCheck(true);
            } else {
                x = false;
               // System.out.println("x equls :" + x);
                listFromBitcoinaverage.get(i).withCheck(false);
                listFromBlockchain.get(i).withCheck(true);
              }
        }

        System.out.println("after if block :");
        System.out.println("listFromBitcoinaverage : " + listFromBitcoinaverage);
        System.out.println("listFromBlockchain :" + listFromBlockchain);

        assertEquals(listFromBitcoinaverage, listFromBlockchain);

    }
}
