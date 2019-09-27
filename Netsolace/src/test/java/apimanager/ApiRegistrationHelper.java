package apimanager;

import model.RegWithError;
import model.UserReg;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ApiRegistrationHelper extends ApiHelperBase {

    public RegWithError setRegData(UserReg user1) throws IOException, URISyntaxException, ParseException {

        //Рабочий метод, если нет инта в параметрах запроса.
        /*CloseableHttpClient client = HttpClients.createDefault();
        String header = "https://api.leroymerlin.ru/mobile/user/register";
        HttpPost httpPost = new HttpPost(header);
        String json = "{ \"lastName\": \"Тестер\",\"firstName\": \"Маша\",\"refStoreId\": 62,\"email\": \"slava17puh56@gmail.com\",\"phone\": \"+79036788778\",\"password\": \"qwertyU1\"}";
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);

        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("apikey", "NLdu-FEUbU-CCrd-otTWYJGhDfZZKYHAxVd-QksZEMMtCUkUKk");

        CloseableHttpResponse responseHeader = client.execute(httpPost);
        System.out.println("responseHeader" + responseHeader);

        HttpEntity entity2 = responseHeader.getEntity();
        String responseBody = EntityUtils.toString(entity2);
        System.out.println("responseBody" + responseBody);*/


        CloseableHttpClient client = HttpClients.createDefault();
        URIBuilder uriBuilder = new URIBuilder("https://api.leroymerlin.ru/mobile/user/register");

        HttpPost postRequest = new HttpPost(uriBuilder.build());
        postRequest.setHeader("Content-Type", "application/json");
        postRequest.setHeader("apikey", "NLdu-FEUbU-CCrd-otTWYJGhDfZZKYHAxVd-QksZEMMtCUkUKk");

        String json = "{ \"lastName\": \""+ user1.getLastName()+ "\"," +
                        "\"firstName\": \""+ user1.getFirstName() +"\"," +
                        "\"refStoreId\": "+ user1.getRefStoreId()+"," +
                        "\"email\": \""+ user1.getEmail()+"\"," +
                        "\"phone\": \""+ user1.getPhone()+"\"," +
                        "\"password\": \""+ user1.getPassword()+"\"}";
        //System.out.println("\""+user1.getEmail()+"\"");
        System.out.println("json " + json);


        HttpEntity entity = new ByteArrayEntity(json.getBytes("UTF-8"));
        postRequest.setEntity(entity);

        CloseableHttpResponse responseHeader = client.execute(postRequest);
        System.out.println("responseHeader" + responseHeader);

        HttpEntity entity2 = responseHeader.getEntity();
        String responseBody = EntityUtils.toString(entity2);
        System.out.println("responseBody" + responseBody);

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject)jsonParser.parse(responseBody);

//        RegWithError regWithError =
//                new Gson().fromJson(responseBody, new TypeToken<RegWithError>(){}.getType());

//        RegWithError regWithError2 =
//                new Gson().fromJson(parsed, new TypeToken<RegWithError>(){}.getType());
        Boolean status = (Boolean) jsonObject.get("status");

        System.out.println(status);

        JSONArray errors = (JSONArray) jsonObject.get("errors");
        JSONObject innerObj = (JSONObject) errors.iterator().next();


        System.out.println(innerObj.get("message"));
        System.out.println(innerObj.get("stringCode"));

        RegWithError regWithErrorResponse = new RegWithError()
                                             .withStatus((Boolean) jsonObject.get("status"))
                                             .withMessage((String) innerObj.get("message"))
                                             .withStringCode((String) innerObj.get("stringCode"));

        System.out.println("regWithErrorResponse " + regWithErrorResponse);

        return regWithErrorResponse;

    }
}
