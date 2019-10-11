package tests;

import model.AvPrice;
import org.testng.annotations.Test;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import static org.testng.Assert.assertEquals;

public class Test1 extends TestBase {

    @Test
    public void test1() throws IOException, ParseException {

        List<AvPrice> listFromBitcoinAverage = am.getApiAveragePrice().getListLast30DaysFromBitcoinAverage();
        List<AvPrice> listFromBlockchain = am.getApiAveragePrice().getListLast30DaysFromBlockchain();


        for (int i=0; i <= listFromBitcoinAverage.size()-1; i++) {
           double xFromList1 =  listFromBitcoinAverage.get(i).getAverage();
           double xFromList2 = listFromBlockchain.get(i).getAverage();
              double x1 = xFromList2 - (xFromList2/1000); // lower bound
              double x2 = xFromList2 + (xFromList2/1000); // upper bound
              System.out.println("x1 " + x1);
              System.out.println("xFromList1 : " + xFromList1);
              System.out.println("x2 " + x2);
              System.out.println("=======");
            if (x1 <= xFromList1 & xFromList1 <= x2 )
            {
                listFromBitcoinAverage.get(i).withCheck(true);
                listFromBlockchain.get(i).withCheck(true);
            } else {
                listFromBitcoinAverage.get(i).withCheck(false);
                listFromBlockchain.get(i).withCheck(true);
              }
        }

        System.out.println("after if block :");
        System.out.println("listFromBitcoinaverage : " + listFromBitcoinAverage);
        System.out.println("listFromBlockchain :" + listFromBlockchain);

        assertEquals(listFromBitcoinAverage, listFromBlockchain);

    }
}
