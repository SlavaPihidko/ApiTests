package tests;

import org.testng.annotations.Test;

public class AveragePrice  extends TestBase {

    @Test
    public void testAveragePrice() {

        am.getApiAveragePrice().getListLast30Days();
    }
}
