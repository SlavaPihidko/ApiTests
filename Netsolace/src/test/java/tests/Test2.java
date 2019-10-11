package tests;


import model.Address;
import model.Txrefs;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Test2 extends TestBase {

    @Test
    public void test2() throws IOException, ParseException, InterruptedException {
        String latestUrl = am.getApiTest2Helper().getLatest_url();
        String firstTxIdFromLatestUrl = am.getApiTest2Helper().getFirstTxidsFromLatestUrl();
        String address = am.getApiTest2Helper().getAddrsFromFirstTx();
        String jsonAddress = am.getApiTest2Helper().getJsonAddress();
        Address valuesAddressFromTop = am.getApiTest2Helper().getValuesFromAddressTop();
        Address valuesAddressFromArray = am.getApiTest2Helper().getValuesFromAddressArray();

        assertEquals(valuesAddressFromArray, valuesAddressFromTop);
    }
}
