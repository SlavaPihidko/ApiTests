package tests;


import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class Test2 extends TestBase {

    @Test
    public void test2() throws IOException, ParseException {
        String latestUrl = am.getApiTest2Helper().getLatest_url();
        List<String> txIds = am.getApiTest2Helper().getTxidsFromLatestUrl();
    }
}
