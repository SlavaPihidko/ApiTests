package tests;

import model.RegResponse;
import model.UserReg;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.testng.Assert.assertEquals;
import org.apache.commons.lang3.RandomStringUtils;

public class UserRegTests extends TestBase {
    String email;

    @BeforeMethod
    public String getRandomEmail() {
    String randomString = am.getApiRegHelper().getRandomeString();
     email = randomString + "@gmail.com";
    System.out.println(email);
    return email;
    }

    @Test // Registration check. Adding uniq user. Successful registration.
    public void checkUserReg_1() throws IOException, URISyntaxException {
        System.out.println("// Registration check. Adding uniq user. Successful registration.");

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
        System.out.println("//Registration check. User already exist in DB.");

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

    //FirstName
    @Test // Registration check. FirstName is empty.
    public void checkUserReg_3() throws IOException, URISyntaxException {
        System.out.println("// Registration check. FirstName is empty.");

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
        System.out.println("// Registration check. FirstName has 101 symbols");

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
        System.out.println("// Registration check. FirstName has 100 symbols");
        System.out.println("");

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
        System.out.println("// Registration check. FirstName has only space symbol(s)");

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
        System.out.println("// Registration check. FirstName has space symbols between characters");

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
        System.out.println("// Registration check. FirstName has symbols that are matched for this regEx ^[а-яА-ЯЁёa-zA-Z -]+$");

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
        System.out.println("// Registration check. FirstName has not matching symbols");

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

    //LastName
    @Test // Registration check. LastName has symbols that are matched for this regEx ^[а-яА-ЯЁёa-zA-Z -]+$
    public void checkUserReg_10() throws IOException, URISyntaxException {
        System.out.println("// Registration check. LastName has symbols that are matched for this regEx ^[а-яА-ЯЁёa-zA-Z -]+$");

        UserReg user3 = new UserReg()
                .withFirstName("Test")
                .withLastName("Slava Слава --Ёё")
                .withRefStoreId(62)
                .withPhone("+79036788778")
                .withEmail(email)
                .withPassword("qwertyU1");

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(user3);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        assertEquals(statusCodeFromApi, (200));
    }

    @Test // Registration check. LastName has 50 symbols
    public void checkUserReg_11() throws IOException, URISyntaxException {
        System.out.println("// Registration check. LastName has 50 symbols");
        String lastName = "slavaslavaslavaslavaslavaslavaslavaslavaslavaslava";

        UserReg user3 = new UserReg()
                .withFirstName("Test")
                .withLastName(lastName)
                .withRefStoreId(62)
                .withPhone("+79036788778")
                .withEmail(email)
                .withPassword("qwertyU1");

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(user3);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        assertEquals(statusCodeFromApi, (200));
    }

    @Test // Registration check. LastName has 51 symbols
    public void checkUserReg_12() throws IOException, URISyntaxException {
        System.out.println("// Registration check. LastName has 51 symbols");
        String lastName = "slavaslavaslavaslavaslavaslavaslavaslavaslavaslavaw";

        UserReg user3 = new UserReg()
                .withFirstName("Test")
                .withLastName(lastName)
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

    @Test // Registration check. LastName has not matching symbols
    public void checkUserReg_13() throws IOException, URISyntaxException {
        System.out.println("// Registration check. LastName has not matching symbols");

        UserReg user3 = new UserReg()
                .withFirstName("Test")
                .withLastName("1234567890_=+)(*&^%$#@!{}?><,./|")
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

    @Test // Registration check. LastName has only space symbol(s)
    public void checkUserReg_14() throws IOException, URISyntaxException {
        System.out.println("// Registration check. LastName has only space symbol(s)");

        UserReg user3 = new UserReg()
                .withFirstName("Test")
                .withLastName("  ")
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

    @Test // Registration check. LastName is empty.
    public void checkUserReg_15() throws IOException, URISyntaxException {
        System.out.println("// Registration check. LasttName is empty.");

        UserReg user3 = new UserReg()
                .withFirstName("Test")
                .withLastName("")
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



    @Test // Registration check. Request without LastName.
    public void checkUserReg_16() throws IOException, URISyntaxException {
        System.out.println("// Registration check. Request without LastName.");

        UserReg user3 = new UserReg()
                .withFirstName("Test")
                .withRefStoreId(62)
                .withPhone("+79036788778")
                .withEmail(email)
                .withPassword("qwertyU1");

        RegResponse regResponseExpected = new RegResponse()
                .withStatus(false)
                .withMessage("Obligatory parameters (firstName, lastName, email, password, phone, refStoreId) or other paramereters are specified wrong")
                .withStringCode("REQUEST_ERROR");

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeWithoutLastNameFromApi(user3);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        RegResponse regResponseFromApi = am.getApiRegHelper().getRegResponseWithoutLastNameFromApi(user3);
        System.out.println("regResponseExpected " + regResponseExpected);

        assertEquals(statusCodeFromApi, (400));
        assertEquals(regResponseFromApi, regResponseExpected);
    }

}

