package tests;

import org.testng.annotations.Test;

import java.io.IOException;

public class Test2 extends TestBase {

    @Test
    public void test2() throws IOException {
        String latest_url = am.getApiLatesUrl().getLatest_url();
    }
}
