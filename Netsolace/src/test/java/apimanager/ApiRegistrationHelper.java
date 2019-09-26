package apimanager;

import model.UserRegistration;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ApiRegistrationHelper extends ApiHelperBase {

    public void setRegistrationData(UserRegistration user1) throws IOException {

        CloseableHttpClient client = HttpClients.createDefault();
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
        System.out.println("responseBody" + responseBody);
    }
}
