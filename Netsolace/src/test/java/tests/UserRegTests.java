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

  /*  //FirstName
    @Test // Registration check. FirstName is empty.
    public void checkUserReg_3_1() throws IOException, URISyntaxException {
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

    @Test // Registration check. FirstName has 100 symbols
    public void checkUserReg_3_2() throws IOException, URISyntaxException {
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

    @Test // Registration check. FirstName has 101 symbols
    public void checkUserReg_3_3() throws IOException, URISyntaxException {
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

    @Test // Registration check. FirstName has only space symbol(s)
    public void checkUserReg_3_4() throws IOException, URISyntaxException {
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
    public void checkUserReg_3_5() throws IOException, URISyntaxException {
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
    public void checkUserReg_3_6() throws IOException, URISyntaxException {
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
    public void checkUserReg_3_7() throws IOException, URISyntaxException {
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

    @Test // Registration check. Request without FirstName.
    public void checkUserReg_3_8() throws IOException, URISyntaxException {
        System.out.println("// Registration check. Request without FirstName.");

        UserReg user1 = new UserReg()
                .withLastName("Test")
                .withRefStoreId(62)
                .withPhone("+79036788778")
                .withEmail(email)
                .withPassword("qwertyU1");

        String json = "{ \"lastName\": \""+ user1.getLastName()+ "\"," +
                "\"refStoreId\": "+ user1.getRefStoreId()+"," +
                "\"email\": \""+ user1.getEmail()+"\"," +
                "\"phone\": \""+ user1.getPhone()+"\"," +
                "\"password\": \""+ user1.getPassword()+"\"}";

        System.out.println("json " + json);

        RegResponse regResponseExpected = new RegResponse()
                .withStatus(false)
                .withMessage("Obligatory parameters (firstName, lastName, email, password, phone, refStoreId) or other paramereters are specified wrong")
                .withStringCode("REQUEST_ERROR");

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(json);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        RegResponse regResponseFromApi = am.getApiRegHelper().getRegResponseFromApi(json);
        System.out.println("regResponseExpected " + regResponseExpected);

        assertEquals(statusCodeFromApi, (400));
        assertEquals(regResponseFromApi, regResponseExpected);
    }

    //LastName
    @Test // Registration check. LastName has symbols that are matched for this regEx ^[а-яА-ЯЁёa-zA-Z -]+$
    public void checkUserReg_4_1() throws IOException, URISyntaxException {
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
    public void checkUserReg_4_2() throws IOException, URISyntaxException {
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
    public void checkUserReg_4_3() throws IOException, URISyntaxException {
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
    public void checkUserReg_4_4() throws IOException, URISyntaxException {
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
    public void checkUserReg_4_5() throws IOException, URISyntaxException {
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
    public void checkUserReg_4_6() throws IOException, URISyntaxException {
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
    public void checkUserReg_4_7() throws IOException, URISyntaxException {
        System.out.println("// Registration check. Request without LastName.");

        UserReg user1 = new UserReg()
                .withFirstName("Test")
                .withRefStoreId(62)
                .withPhone("+79036788778")
                .withEmail(email)
                .withPassword("qwertyU1");

        String json = "{ \"firstName\": \""+ user1.getFirstName() +"\"," +
                "\"refStoreId\": "+ user1.getRefStoreId()+"," +
                "\"email\": \""+ user1.getEmail()+"\"," +
                "\"phone\": \""+ user1.getPhone()+"\"," +
                "\"password\": \""+ user1.getPassword()+"\"}";

        RegResponse regResponseExpected = new RegResponse()
                .withStatus(false)
                .withMessage("Obligatory parameters (firstName, lastName, email, password, phone, refStoreId) or other paramereters are specified wrong")
                .withStringCode("REQUEST_ERROR");

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(json);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        RegResponse regResponseFromApi = am.getApiRegHelper().getRegResponseFromApi(json);
        System.out.println("regResponseExpected " + regResponseExpected);

        assertEquals(statusCodeFromApi, (400));
        assertEquals(regResponseFromApi, regResponseExpected);
    }

    @Test // Registration check. LastName is int.
    public void checkUserReg_4_8() throws IOException, URISyntaxException {
        System.out.println("// Registration check. Request  lastName is int.");

        UserReg user1 = new UserReg()
                .withFirstName("Test")
                .withRefStoreId(62)
                .withPhone("+79036788778")
                .withEmail(email)
                .withPassword("qwertyU1");

        String json = "{ \"lastName\": "+ 12 + "," +
                "\"firstName\": \""+ user1.getFirstName() +"\"," +
                "\"refStoreId\": "+ user1.getRefStoreId()+"," +
                "\"email\": \""+ user1.getEmail()+"\"," +
                "\"phone\": \""+ user1.getPhone()+"\"," +
                "\"password\": \""+ user1.getPassword()+"\"}";

        RegResponse regResponseExpected = new RegResponse()
                .withStatus(false)
                .withMessage("Obligatory parameters (firstName, lastName, email, password, phone, refStoreId) or other paramereters are specified wrong")
                .withStringCode("REQUEST_ERROR");

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(json);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        RegResponse regResponseFromApi = am.getApiRegHelper().getRegResponseFromApi(json);
        System.out.println("regResponseExpected " + regResponseExpected);

        assertEquals(statusCodeFromApi, (400));
        assertEquals(regResponseFromApi, regResponseExpected);
    }

    //Phone number field
    @Test  // Registration check. Phone number is less than one character
    public void checkUserReg_5_1() throws IOException, URISyntaxException {
        System.out.println("// Registration check. Phone number is less than one character");

        UserReg user3 = new UserReg()
                .withFirstName("Test")
                .withLastName("Test")
                .withRefStoreId(62)
                .withPhone("+7903678877")
                .withEmail(email)
                .withPassword("qwertyU1");

        System.out.println(user3.getFirstName());

        RegResponse regResponseExpected = new RegResponse()
                .withStatus(false)
                .withMessage("Phone does not match regular expression")
                .withStringCode("PHONE_ERROR");

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(user3);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        RegResponse regResponseFromApi = am.getApiRegHelper().getRegResponseFromApi(user3);
        System.out.println("regResponseExpected " + regResponseExpected);

        assertEquals(statusCodeFromApi, (400));
        assertEquals(regResponseFromApi, regResponseExpected);
    }

    @Test  // Registration check. Phone number is more than one character
    public void checkUserReg_5_2() throws IOException, URISyntaxException {
        System.out.println("// Registration check. Phone number is more than one character");

        UserReg user3 = new UserReg()
                .withFirstName("Test")
                .withLastName("Test")
                .withRefStoreId(62)
                .withPhone("+790367887787")
                .withEmail(email)
                .withPassword("qwertyU1");

        System.out.println(user3.getFirstName());

        RegResponse regResponseExpected = new RegResponse()
                .withStatus(false)
                .withMessage("Phone does not match regular expression")
                .withStringCode("PHONE_ERROR");

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(user3);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        RegResponse regResponseFromApi = am.getApiRegHelper().getRegResponseFromApi(user3);
        System.out.println("regResponseExpected " + regResponseExpected);

        assertEquals(statusCodeFromApi, (400));
        assertEquals(regResponseFromApi, regResponseExpected);
    }

    @Test  // Registration check. Phone number without country code
    public void checkUserReg_5_3() throws IOException, URISyntaxException {
        System.out.println("// Registration check. Phone number without country code");

        UserReg user3 = new UserReg()
                .withFirstName("Test")
                .withLastName("TestLast")
                .withRefStoreId(62)
                .withPhone("90367887787")
                .withEmail(email)
                .withPassword("qwertyU1");

        System.out.println(user3.getFirstName());

        RegResponse regResponseExpected = new RegResponse()
                .withStatus(false)
                .withMessage("Phone does not match regular expression")
                .withStringCode("PHONE_ERROR");

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(user3);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        RegResponse regResponseFromApi = am.getApiRegHelper().getRegResponseFromApi(user3);
        System.out.println("regResponseExpected " + regResponseExpected);

        assertEquals(statusCodeFromApi, (400));
        assertEquals(regResponseFromApi, regResponseExpected);
    }

    @Test  // Registration check. Phone number is empty
    public void checkUserReg_5_4() throws IOException, URISyntaxException {
        System.out.println("// Registration check. Phone number is empty");

        UserReg user3 = new UserReg()
                .withFirstName("Test")
                .withLastName("TestLast")
                .withRefStoreId(62)
                .withPhone("")
                .withEmail(email)
                .withPassword("qwertyU1");

        System.out.println(user3.getFirstName());

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(user3);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        assertEquals(statusCodeFromApi, (200));
    }

    @Test  // Registration check. Phone number is double
    public void checkUserReg_5_5() throws IOException, URISyntaxException {
        System.out.println("// Registration check. Phone number is double");

        UserReg user1 = new UserReg()
                .withFirstName("Test")
                .withLastName("TestLast")
                .withRefStoreId(62)
                .withPhone("+79036788778")
                .withEmail(email)
                .withPassword("qwertyU1");

        String json = "{ \"lastName\": \""+ user1.getLastName() +"\"," +
                "\"firstName\": \""+ user1.getFirstName() +"\"," +
                "\"refStoreId\": "+ user1.getRefStoreId()+"," +
                "\"email\": \""+ user1.getEmail()+"\"," +
                "\"phone\": "+ 790367887787.0 + "," +
                "\"password\": \""+ user1.getPassword()+"\"}";

        RegResponse regResponseExpected = new RegResponse()
                .withStatus(false)
                .withMessage("Obligatory parameters (firstName, lastName, email, password, phone, refStoreId) or other paramereters are specified wrong")
                .withStringCode("REQUEST_ERROR");

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(json);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        RegResponse regResponseFromApi = am.getApiRegHelper().getRegResponseFromApi(json);
        System.out.println("regResponseExpected " + regResponseExpected);

        assertEquals(statusCodeFromApi, (400));
        assertEquals(regResponseFromApi, regResponseExpected);
    }

    @Test  // Registration check. Without phone field
    public void checkUserReg_5_6() throws IOException, URISyntaxException {
        System.out.println("// Registration check. Without phone field");

        UserReg user1 = new UserReg()
                .withFirstName("Test")
                .withLastName("TestLast")
                .withRefStoreId(62)
                .withEmail(email)
                .withPassword("qwertyU1");

        String json = "{ \"lastName\": \""+ user1.getLastName() +"\"," +
                "\"firstName\": \""+ user1.getFirstName() +"\"," +
                "\"refStoreId\": "+ user1.getRefStoreId()+"," +
                "\"email\": \""+ user1.getEmail()+"\"," +
                "\"password\": \""+ user1.getPassword()+"\"}";

        RegResponse regResponseExpected = new RegResponse()
                .withStatus(false)
                .withMessage("Obligatory parameters (firstName, lastName, email, password, phone, refStoreId) or other paramereters are specified wrong")
                .withStringCode("REQUEST_ERROR");

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(json);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        RegResponse regResponseFromApi = am.getApiRegHelper().getRegResponseFromApi(json);
        System.out.println("regResponseExpected " + regResponseExpected);

        assertEquals(statusCodeFromApi, (400));
        assertEquals(regResponseFromApi, regResponseExpected);
    }

    @Test // Registration check. Registration with phone that already exist in DB.
    public void checkUserReg_5_7() throws IOException, URISyntaxException {
        System.out.println("// Registration check. Registration with phone that already exist in DB.");

        UserReg user2 = new UserReg()
                .withFirstName("Slava")
                .withLastName("Test")
                .withRefStoreId(62)
                .withPhone("+79036788778")
                .withEmail(email)
                .withPassword("qwertyU1");


        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(user2);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        assertEquals(statusCodeFromApi, (200));
    }

    @Test  // Registration check. Phone number is some word
    public void checkUserReg_5_8() throws IOException, URISyntaxException {
        System.out.println("// Registration check. Phone number is double");

        UserReg user1 = new UserReg()
                .withFirstName("Test")
                .withLastName("TestLast")
                .withRefStoreId(62)
                .withPhone("slavaPhone")
                .withEmail(email)
                .withPassword("qwertyU1");

        String json = "{ \"lastName\": \""+ user1.getLastName() +"\"," +
                "\"firstName\": \""+ user1.getFirstName() +"\"," +
                "\"refStoreId\": "+ user1.getRefStoreId()+"," +
                "\"email\": \""+ user1.getEmail() +"\"," +
                "\"phone\": \""+ user1.getPhone() + "\"," +
                "\"password\": \""+ user1.getPassword()+"\"}";

        RegResponse regResponseExpected = new RegResponse()
                .withStatus(false)
                .withMessage("Phone does not match regular expression")
                .withStringCode("PHONE_ERROR");

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(json);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        RegResponse regResponseFromApi = am.getApiRegHelper().getRegResponseFromApi(json);
        System.out.println("regResponseExpected " + regResponseExpected);

        assertEquals(statusCodeFromApi, (400));
        assertEquals(regResponseFromApi, regResponseExpected);
    }

    @Test // Registration check. RefstoreId is max 999
    public void checkUserReg_6_1() throws IOException, URISyntaxException {
        System.out.println("// Registration check. RefstoreId is max 999");

        UserReg user3 = new UserReg()
                .withFirstName("Test")
                .withLastName("TestLast")
                .withRefStoreId(999)
                .withPhone("+79036788778")
                .withEmail(email)
                .withPassword("qwertyU1");

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(user3);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        assertEquals(statusCodeFromApi, (200));
    }

    @Test // Registration check. RefstoreId is zero
    public void checkUserReg_6_2() throws IOException, URISyntaxException {
        System.out.println("// Registration check. RefstoreId is zero");

        UserReg user3 = new UserReg()
                .withFirstName("Test")
                .withLastName("TestLast")
                .withRefStoreId(0)
                .withPhone("+79036788778")
                .withEmail(email)
                .withPassword("qwertyU1");

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(user3);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        assertEquals(statusCodeFromApi, (200));
    }

    @Test  // Registration check. RefstoreId is max+1
    public void checkUserReg_6_3() throws IOException, URISyntaxException {
        System.out.println("// Registration check. RefstoreId is max+1");

        UserReg user3 = new UserReg()
                .withFirstName("Test")
                .withLastName("TestName")
                .withRefStoreId(1000)
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

    @Test  // Registration check. RefstoreId has minus sign
    public void checkUserReg_6_4() throws IOException, URISyntaxException {
        System.out.println("// Registration check. RefstoreId is max+1");

        UserReg user3 = new UserReg()
                .withFirstName("Test")
                .withLastName("TestName")
                .withRefStoreId(-10)
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

    @Test  // Registration check. RefstoreId is string
    public void checkUserReg_6_5() throws IOException, URISyntaxException {
        System.out.println("// Registration check. RefstoreId is string");

        UserReg user1 = new UserReg()
                .withFirstName("Test")
                .withLastName("TestName")
                .withRefStoreId(62)
                .withPhone("+79036788778")
                .withEmail(email)
                .withPassword("qwertyU1");

        String json = "{ \"lastName\": \""+ user1.getLastName() +"\"," +
                "\"firstName\": \""+ user1.getFirstName() +"\"," +
                "\"refStoreId\": \""+ user1.getFirstName() +"\"," +
                "\"email\": \""+ user1.getEmail() +"\"," +
                "\"phone\": \""+ user1.getPhone() + "\"," +
                "\"password\": \""+ user1.getPassword()+"\"}";

        RegResponse regResponseExpected = new RegResponse()
                .withStatus(false)
                .withMessage("Obligatory parameters (firstName, lastName, email, password, phone, refStoreId) or other paramereters are specified wrong")
                .withStringCode("REQUEST_ERROR");

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(json);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        RegResponse regResponseFromApi = am.getApiRegHelper().getRegResponseFromApi(json);
        System.out.println("regResponseExpected " + regResponseExpected);

        assertEquals(statusCodeFromApi, (400));
        assertEquals(regResponseFromApi, regResponseExpected);
    }

    @Test  // Registration check. Without RefstoreId field
    public void checkUserReg_6_6() throws IOException, URISyntaxException {
        System.out.println("// Registration check. Without RefstoreId field");

        UserReg user1 = new UserReg()
                .withFirstName("Test")
                .withLastName("TestName")
                .withPhone("+79036788778")
                .withEmail(email)
                .withPassword("qwertyU1");

        String json = "{ \"lastName\": \""+ user1.getLastName() +"\"," +
                "\"firstName\": \""+ user1.getFirstName() +"\"," +
                "\"email\": \""+ user1.getEmail() +"\"," +
                "\"phone\": \""+ user1.getPhone() + "\"," +
                "\"password\": \""+ user1.getPassword()+"\"}";

        RegResponse regResponseExpected = new RegResponse()
                .withStatus(false)
                .withMessage("Obligatory parameters (firstName, lastName, email, password, phone, refStoreId) or other paramereters are specified wrong")
                .withStringCode("REQUEST_ERROR");

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(json);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        RegResponse regResponseFromApi = am.getApiRegHelper().getRegResponseFromApi(json);
        System.out.println("regResponseExpected " + regResponseExpected);

        assertEquals(statusCodeFromApi, (400));
        assertEquals(regResponseFromApi, regResponseExpected);
    }

    @Test // Registration check. RefstoreId is float 22.0
    public void checkUserReg_6_7() throws IOException, URISyntaxException {
        System.out.println("// Registration check. RefstoreId is float 22.0");

        UserReg user1 = new UserReg()
                .withFirstName("Test")
                .withLastName("TestLast")
                .withRefStoreId(22)
                .withPhone("+79036788778")
                .withEmail(email)
                .withPassword("qwertyU1");

        String json = "{ \"lastName\": \""+ user1.getLastName()+ "\"," +
                "\"firstName\": \""+ user1.getFirstName() +"\"," +
                "\"refStoreId\": "+ 22.0 +"," +
                "\"email\": \""+ user1.getEmail()+"\"," +
                "\"phone\": \""+ user1.getPhone()+"\"," +
                "\"password\": \""+ user1.getPassword()+"\"}";

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(json);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        assertEquals(statusCodeFromApi, (200));
    }

    @Test  // Registration check. RefstoreId is float 22.1
    public void checkUserReg_6_8() throws IOException, URISyntaxException {
        System.out.println("// Registration check. Without RefstoreId field");

        UserReg user1 = new UserReg()
                .withFirstName("Test")
                .withLastName("TestName")
                .withPhone("+79036788778")
                .withEmail(email)
                .withPassword("qwertyU1");

        String json = "{ \"lastName\": \""+ user1.getLastName() +"\"," +
                "\"firstName\": \""+ user1.getFirstName() +"\"," +
                "\"email\": \""+ user1.getEmail() +"\"," +
                "\"phone\": \""+ 22.1 + "\"," +
                "\"password\": \""+ user1.getPassword()+"\"}";

        RegResponse regResponseExpected = new RegResponse()
                .withStatus(false)
                .withMessage("Obligatory parameters (firstName, lastName, email, password, phone, refStoreId) or other paramereters are specified wrong")
                .withStringCode("REQUEST_ERROR");

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(json);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        RegResponse regResponseFromApi = am.getApiRegHelper().getRegResponseFromApi(json);
        System.out.println("regResponseExpected " + regResponseExpected);

        assertEquals(statusCodeFromApi, (400));
        assertEquals(regResponseFromApi, regResponseExpected);
    }


    //Email field
    @Test(enabled = false)  // Registration check. Email is short
    public void checkUserReg_7_1() throws IOException, URISyntaxException {
        System.out.println("// Registration check. Email is short");

        UserReg user1 = new UserReg()
                .withFirstName("Test")
                .withLastName("TestName")
                .withPhone("+79036788778")
                .withEmail("s@i.ua")
                .withPassword("qwertyU1");

        String json = "{ \"lastName\": \""+ user1.getLastName() +"\"," +
                "\"firstName\": \""+ user1.getFirstName() +"\"," +
                "\"email\": \""+ user1.getEmail() +"\"," +
                "\"phone\": \""+ user1.getPhone()+ "\"," +
                "\"password\": \""+ user1.getPassword()+"\"}";


        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(json);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        assertEquals(statusCodeFromApi, (200));
    }

    @Test(enabled = false)  // Registration check. Email is long
    public void checkUserReg_7_2() throws IOException, URISyntaxException {
        System.out.println("// Registration check. Email is long");

        UserReg user1 = new UserReg()
                .withFirstName("Test")
                .withLastName("TestName")
                .withPhone("+79036788778")
                .withEmail("slavaslavaslavaslavaslavaslavaslavaslavaslavaslava@slavaslavaslavaslavaslavaslavaslavaslavaslavaslava.netf")
                .withPassword("qwertyU1");

        String json = "{ \"lastName\": \""+ user1.getLastName() +"\"," +
                "\"firstName\": \""+ user1.getFirstName() +"\"," +
                "\"email\": \""+ user1.getEmail() +"\"," +
                "\"phone\": \""+ user1.getPhone()+ "\"," +
                "\"password\": \""+ user1.getPassword()+"\"}";

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(json);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        RegResponse regResponseFromApi = am.getApiRegHelper().getRegResponseFromApi(json);

        assertEquals(statusCodeFromApi, (200));
    }

    //Password field
    @Test // Registration check. Password has all small letters 8 symbols
    public void checkUserReg_8_1() throws IOException, URISyntaxException {
        //slaU!@#$%^&*()_+=-0987654321<>/?|
        //12345678abcdefABCDEF
        System.out.println("// Registration check. Password has all small letters 8 symbols");

        UserReg user3 = new UserReg()
                .withFirstName("Test")
                .withLastName("TestName")
                .withRefStoreId(22)
                .withPhone("+79036788778")
                .withEmail(email)
                .withPassword("qwertyu1");

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

    @Test // Registration check. Password has all digits 8 symbols
    public void checkUserReg_8_2() throws IOException, URISyntaxException {
        //slaU!@#$%^&*()_+=-0987654321<>/?|
        //12345678abcdefABCDEF
        System.out.println("// Registration check. Password has all digits 8 symbols");

        UserReg user3 = new UserReg()
                .withFirstName("Test")
                .withLastName("TestName")
                .withRefStoreId(22)
                .withPhone("+79036788778")
                .withEmail(email)
                .withPassword("12345678");

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

    @Test // Registration check. Password without digits 8 symbols
    public void checkUserReg_8_3() throws IOException, URISyntaxException {
        //slaU!@#$%^&*()_+=-0987654321<>/?|
        //12345678abcdefABCDEF
        System.out.println("// Registration check. Password without digits 8 symbols");

        UserReg user3 = new UserReg()
                .withFirstName("Test")
                .withLastName("TestName")
                .withRefStoreId(22)
                .withPhone("+79036788778")
                .withEmail(email)
                .withPassword("qwertyUU");

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

    @Test // Registration check. Password is long with special symbols
    public void checkUserReg_8_4() throws IOException, URISyntaxException {
        System.out.println("// Registration check. Password is long with special symbols");

        UserReg user2 = new UserReg()
                .withFirstName("Slava")
                .withLastName("Test")
                .withRefStoreId(62)
                .withPhone("+79036788778")
                .withEmail(email)
                .withPassword("slaU!@#$%^&*()_+=-0987654321<>/?|");

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(user2);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        assertEquals(statusCodeFromApi, (200));
    }

    @Test // Registration check. Password 7 symbols
    public void checkUserReg_8_5() throws IOException, URISyntaxException {
        //slaU!@#$%^&*()_+=-0987654321<>/?|
        //12345678abcdefABCDEF
        System.out.println("// Registration check. Password 7 symbols");

        UserReg user3 = new UserReg()
                .withFirstName("Test")
                .withLastName("TestName")
                .withRefStoreId(22)
                .withPhone("+79036788778")
                .withEmail(email)
                .withPassword("123abcA");

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

    @Test // Registration check. Password is empty
    public void checkUserReg_8_6() throws IOException, URISyntaxException {
        //slaU!@#$%^&*()_+=-0987654321<>/?|
        //12345678abcdefABCDEF
        System.out.println("// Registration check. Password is empty");

        UserReg user3 = new UserReg()
                .withFirstName("Test")
                .withLastName("TestName")
                .withRefStoreId(22)
                .withPhone("+79036788778")
                .withEmail(email)
                .withPassword("");

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

    @Test // Registration check. Password has only 8 spaces
    public void checkUserReg_8_7() throws IOException, URISyntaxException {
        //slaU!@#$%^&*()_+=-0987654321<>/?|
        //12345678abcdefABCDEF
        System.out.println("// Registration check. Password has only 8 spaces");

        UserReg user3 = new UserReg()
                .withFirstName("Test")
                .withLastName("TestName")
                .withRefStoreId(22)
                .withPhone("+79036788778")
                .withEmail(email)
                .withPassword("        ");

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

    @Test // Registration check. Without Password field
    public void checkUserReg_8_8() throws IOException, URISyntaxException {
        //slaU!@#$%^&*()_+=-0987654321<>/?|
        //12345678abcdefABCDEF
        System.out.println("// Registration check. Without Password field");

        UserReg user1 = new UserReg()
                .withFirstName("Test")
                .withLastName("TestName")
                .withRefStoreId(22)
                .withPhone("+79036788778")
                .withEmail(email);

        String json = "{ \"lastName\": \""+ user1.getLastName()+ "\"," +
                "\"firstName\": \""+ user1.getFirstName() +"\"," +
                "\"refStoreId\": "+ user1.getRefStoreId()+"," +
                "\"email\": \""+ user1.getEmail()+"\"," +
                "\"phone\": \""+ user1.getPhone()+"\"}" ;

        RegResponse regResponseExpected = new RegResponse()
                .withStatus(false)
                .withMessage("Obligatory parameters (firstName, lastName, email, password, phone, refStoreId) or other paramereters are specified wrong")
                .withStringCode("REQUEST_ERROR");

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(json);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        RegResponse regResponseFromApi = am.getApiRegHelper().getRegResponseFromApi(json);
        System.out.println("regResponseExpected " + regResponseExpected);

        assertEquals(statusCodeFromApi, (400));
        assertEquals(regResponseFromApi, regResponseExpected);
    }

    @Test // Registration check. Password more than 8 symbols, has digits, upperCase and LowerCase characters
    public void checkUserReg_8_9() throws IOException, URISyntaxException {
        System.out.println("// Registration check. Password more than 8 symbols, has digits, upperCase and LowerCase characters");

        UserReg user2 = new UserReg()
                .withFirstName("Slava")
                .withLastName("Test")
                .withRefStoreId(62)
                .withPhone("+79036788778")
                .withEmail(email)
                .withPassword("12345678abcdefABCDEF");

        int statusCodeFromApi = am.getApiRegHelper().getRegStatusCodeFromApi(user2);
        System.out.println("statusCodeFromApi " + statusCodeFromApi);

        assertEquals(statusCodeFromApi, (200));
    }
*/
}

