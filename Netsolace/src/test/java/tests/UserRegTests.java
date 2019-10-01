package tests;

import model.RegResponse;
import model.UserReg;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.testng.Assert.assertEquals;
import org.apache.commons.lang3.RandomStringUtils;

public class UserRegTests extends TestBase {

    @Test // Registration check. Adding uniq user. Successful registration.
    public void checkUserReg_1() throws IOException, URISyntaxException {

        String randomeString = am.getApiRegHelper().getRandomeString();
        String email = randomeString + "@gmail.com";
        System.out.println(email);

        UserReg user2 = new UserReg()
                .withFirstName("Slava")
                .withLastName("Test")
                .withRefStoreId(62)
                .withPhone("+79036788778")
                .withEmail(email)
                .withPassword("qwertyU1");


        RegResponse regResponseExpected = new RegResponse()
                .withStatus(true)
                .withMessage("Sorry, this login already exists")
                .withStringCode("LOGIN_ERROR");

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(user2);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        assertEquals(statusCodeFromApi, (200));
    }


    @Test //Registration check. User already exist in DB.
    public void checkUserReg_2() throws IOException, URISyntaxException {

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

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(user1);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        RegResponse regResponseFromApi = am.getApiRegHelper().getRegResponseFromApi(user1);
        System.out.println("regResponseExpected " + regResponseExpected);

        assertEquals(statusCodeFromApi, (400));
        assertEquals(regResponseFromApi, regResponseExpected);
    }

    @Test // Registration check. FirstName is empty.
    public void checkUserReg_3() throws IOException, URISyntaxException {

        String randomeString = am.getApiRegHelper().getRandomeString();
        String email = randomeString + "@gmail.com";
        System.out.println(email);

        UserReg user3 = new UserReg()
                .withFirstName("")
                .withLastName("Test")
                .withRefStoreId(62)
                .withPhone("+79036788778")
                .withEmail(email)
                .withPassword("qwertyU1");

        RegResponse regResponseExpected = new RegResponse()
                .withStatus(false)
                .withMessage("Obligatory parameters (firstName, lastName, email, password, phone, refStoreId) or other paramereters are specified wrong")
                .withStringCode("REQUEST_ERROR");

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(user3);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        RegResponse regResponseFromApi = am.getApiRegHelper().getRegResponseFromApi(user3);
        System.out.println("regResponseExpected " + regResponseExpected);

        assertEquals(statusCodeFromApi, (400));
        assertEquals(regResponseFromApi, regResponseExpected);
    }

    @Test // Registration check. FirstName has 101 symbols
    public void checkUserReg_4() throws IOException, URISyntaxException {

        String randomeString = am.getApiRegHelper().getRandomeString();
        String email = randomeString + "@gmail.com";
        System.out.println(email);
        String name = "slavaslavaslavaslavaslavaslavaslavaslavaslavaslavaslavaslavaslavaslavaslavaslavaslavaslavaslavaslavaw";

        UserReg user3 = new UserReg()
                .withFirstName(name)
                .withLastName("Test")
                .withRefStoreId(62)
                .withPhone("+79036788778")
                .withEmail(email)
                .withPassword("qwertyU1");

        RegResponse regResponseExpected = new RegResponse()
                .withStatus(false)
                .withMessage("Move failed (registration)")
                .withStringCode("MOVE_ERROR");

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(user3);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        RegResponse regResponseFromApi = am.getApiRegHelper().getRegResponseFromApi(user3);
        System.out.println("regResponseExpected " + regResponseExpected);

        assertEquals(statusCodeFromApi, (409));
        assertEquals(regResponseFromApi, regResponseExpected);
    }

    @Test // Registration check. FirstName has 100 symbols
    public void checkUserReg_5() throws IOException, URISyntaxException {

        String randomeString = am.getApiRegHelper().getRandomeString();
        String email = randomeString + "@gmail.com";
        System.out.println(email);
        String name = "slavaslavaslavaslavaslavaslavaslavaslavaslavaslavaslavaslavaslavaslavaslavaslavaslavaslavaslavaslava";

        UserReg user3 = new UserReg()
                .withFirstName(name)
                .withLastName("Test")
                .withRefStoreId(62)
                .withPhone("+79036788778")
                .withEmail(email)
                .withPassword("qwertyU1");

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(user3);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        assertEquals(statusCodeFromApi, (200));
    }

    @Test // Registration check. FirstName has only space symbol(s)
    public void checkUserReg_6() throws IOException, URISyntaxException {

        String randomeString = am.getApiRegHelper().getRandomeString();
        String email = randomeString + "@gmail.com";
        System.out.println(email);

        UserReg user3 = new UserReg()
                .withFirstName("  ")
                .withLastName("Test")
                .withRefStoreId(62)
                .withPhone("+79036788778")
                .withEmail(email)
                .withPassword("qwertyU1");

        RegResponse regResponseExpected = new RegResponse()
                .withStatus(false)
                .withMessage("Move failed (registration)")
                .withStringCode("MOVE_ERROR");

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(user3);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        RegResponse regResponseFromApi = am.getApiRegHelper().getRegResponseFromApi(user3);
        System.out.println("regResponseExpected " + regResponseExpected);

        assertEquals(statusCodeFromApi, (409));
        assertEquals(regResponseFromApi, regResponseExpected);
    }

    @Test // Registration check. FirstName has space symbols between characters
    public void checkUserReg_7() throws IOException, URISyntaxException {

        String randomeString = am.getApiRegHelper().getRandomeString();
        String email = randomeString + "@gmail.com";
        System.out.println(email);

        UserReg user3 = new UserReg()
                .withFirstName("slava bla bla")
                .withLastName("Test")
                .withRefStoreId(62)
                .withPhone("+79036788778")
                .withEmail(email)
                .withPassword("qwertyU1");

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(user3);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        assertEquals(statusCodeFromApi, (200));
    }


    @Test // Registration check. FirstName has symbols that are matched for this regEx ^[а-яА-ЯЁёa-zA-Z -]+$
    public void checkUserReg_8() throws IOException, URISyntaxException {

        String randomeString = am.getApiRegHelper().getRandomeString();
        String email = randomeString + "@gmail.com";
        System.out.println(email);

        UserReg user3 = new UserReg()
                .withFirstName("Slava Слава --Ёё")
                .withLastName("Test")
                .withRefStoreId(62)
                .withPhone("+79036788778")
                .withEmail(email)
                .withPassword("qwertyU1");

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(user3);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        assertEquals(statusCodeFromApi, (200));
    }

    @Test // Registration check. FirstName has not matching symbols
    public void checkUserReg_9() throws IOException, URISyntaxException {

        String randomeString = am.getApiRegHelper().getRandomeString();
        String email = randomeString + "@gmail.com";
        System.out.println(email);

        UserReg user3 = new UserReg()
                .withFirstName("1234567890_=+)(*&^%$#@!{}?><,./|")
                .withLastName("Test")
                .withRefStoreId(62)
                .withPhone("+79036788778")
                .withEmail(email)
                .withPassword("qwertyU1");

        System.out.println(user3.getFirstName());

        RegResponse regResponseExpected = new RegResponse()
                .withStatus(false)
                .withMessage("Obligatory parameters (firstName, lastName, email, password, phone, refStoreId) or other paramereters are specified wrong")
                .withStringCode("REQUEST_ERROR");

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(user3);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        RegResponse regResponseFromApi = am.getApiRegHelper().getRegResponseFromApi(user3);
        System.out.println("regResponseExpected " + regResponseExpected);

        assertEquals(statusCodeFromApi, (400));
        assertEquals(regResponseFromApi, regResponseExpected);
    }

}

