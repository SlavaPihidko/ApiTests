package tests;

import model.RegResponse;
import model.UserReg;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.testng.Assert.assertEquals;

public class UserRegTests extends TestBase {

    @Test
    public void checkUserReg_1() throws IOException, URISyntaxException {

        UserReg user1 = new UserReg()
                                    .withFirstName("Slava")
                                    .withLastName("Test")
                                    .withRefStoreId(62)
                                    .withPhone("+79036788778")
                                    .withEmail("slava17puh56@gmail.com")
                                    .withPassword("qwertyU1");

        RegResponse regResponseExpected = new RegResponse()
                                          .withStatus(false)
                                          .withMessage("Sorry, this login already exists")
                                          .withStringCode("LOGIN_ERROR");

        RegResponse regResponseFromApi = am.getApiRegHelper().getRegResponseFromApi(user1);

        System.out.println("regResponseExpected " + regResponseExpected);

        assertEquals(regResponseFromApi, regResponseExpected);
    }
}
