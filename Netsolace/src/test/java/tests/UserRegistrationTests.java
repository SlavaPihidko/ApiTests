package tests;

import model.UserRegistration;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserRegistrationTests extends TestBase {

    @Test
    public void checkUserRegistrationAllValidFields() throws IOException {
        String msg = "success";
        UserRegistration user1 = new UserRegistration()
                                    .withFirstName("Slava")
                                    .withLastName("Test")
                                    .withRefStoreId(62)
                                    .withPhone("+79036788778")
                                    .withEmail("slava17puh56@gmail.com")
                                    .withPassword("qwertyU1");
        am.getApiRegistrationHelper().setRegistrationData(user1);
    }
}
