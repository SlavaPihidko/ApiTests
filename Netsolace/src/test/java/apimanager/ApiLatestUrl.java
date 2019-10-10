package apimanager;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import model.AvPriceFromBitcoinaverage;
import model.LatesBlock;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.util.List;

public class ApiLatestUrl extends ApiHelperBase {

    public String getLatest_url() throws IOException {
        String header = "https://api.blockcypher.com/v1/btc/main";
        String json = Request.Get(header)
                .addHeader("Content-Type", "application/json")
                .execute().returnContent().asString();
        //System.out.println( "json*** :"  + json);


        JsonParser jsonParser = new JsonParser();
        JsonElement parsed =  jsonParser.parse(json);

        LatesBlock latestUrl =
                new Gson().fromJson(parsed, new TypeToken<LatesBlock>(){}.getType());
        System.out.println("latestUrl: " + latestUrl);

        return "d";
    }
}
