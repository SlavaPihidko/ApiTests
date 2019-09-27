package tests;

import model.UserReg;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class UserRegTests extends TestBase {

    @Test
    public void checkUserRegistrationAllValidFields() throws IOException, URISyntaxException {
        String msg = "success";
        UserReg user1 = new UserReg()
                                    .withFirstName("Slava")
                                    .withLastName("Test")
                                    .withRefStoreId(62)
                                    .withPhone("+79036788778")
                                    .withEmail("slava17puh56@gmail.com")
                                    .withPassword("qwertyU1");
        am.getApiRegistrationHelper().setRegData(user1);
    }
}
