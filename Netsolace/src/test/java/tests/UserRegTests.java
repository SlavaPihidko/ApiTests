package tests;

import model.RegWithError;
import model.UserReg;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.testng.Assert.assertEquals;

public class UserRegTests extends TestBase {

    @Test
    public void checkUserRegistrationAllValidFields() throws IOException, URISyntaxException, ParseException {
        String msg = "success";
        UserReg user1 = new UserReg()
                                    .withFirstName("Slava")
                                    .withLastName("Test")
                                    .withRefStoreId(62)
                                    .withPhone("+79036788778")
                                    .withEmail("slava17puh56@gmail.com")
                                    .withPassword("qwertyU1");
        RegWithError regWithErrorResponse = am.getApiRegistrationHelper().setRegData(user1);
        RegWithError regWithErrorExpected = new RegWithError()
                .withStatus(false)
                .withMessage("Sorry, this login already exists")
                .withStringCode("LOGIN_ERROR");

        System.out.println("regWithErrorExpected " + regWithErrorExpected);

        assertEquals(regWithErrorResponse,regWithErrorExpected);
    }
}
