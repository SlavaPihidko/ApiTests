package apimanager;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import model.AvPriceFromBitcoinaverage;
import model.LatesBlock;

import org.apache.http.client.fluent.Request;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApiTest2Helper extends ApiHelperBase {

    public String getLatest_url() throws IOException, InterruptedException {
        String header = "https://api.blockcypher.com/v1/btc/main";
        Thread.sleep(3000);
        String json = Request.Get(header)
                .addHeader("Content-Type", "application/json")
                .execute().returnContent().asString();
        //System.out.println( "json*** :"  + json);


        JsonParser jsonParser = new JsonParser();
        JsonElement parsed =  jsonParser.parse(json);

        LatesBlock latestUrl =
                new Gson().fromJson(parsed, new TypeToken<LatesBlock>(){}.getType());
        System.out.println("latestUrl: " + latestUrl);

        String latestUrl2 = latestUrl.getLatest_url();

        return latestUrl2;
    }

    public List<String> getTxidsFromLatestUrl() throws IOException, ParseException, InterruptedException {

        List<String> txIdsList = new ArrayList<>();

        String header = getLatest_url();
        String json = Request.Get(header)
                .addHeader("Content-Type", "application/json")
                .execute().returnContent().asString();

        System.out.println("json : " + json);



        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject)jsonParser.parse(json);

        JSONArray txids = (JSONArray) jsonObject.get("txids");
//        JSONObject innerObj = (JSONObject) txids.iterator().next();
        System.out.println("JSONArray txids :" + txids);

        for(int i=0; i<=txids.size()-1; i++) {
            txIdsList.add((String) txids.get(i));
        }

        System.out.println("txIdsList :" + txIdsList);
        return txIdsList;
    }


    public List<String> getAddrsFromFirstTx() throws IOException, ParseException, InterruptedException {

        List<String> listAddrs = new ArrayList<>();
        Thread.sleep(3000);

        String header = "https://api.blockcypher.com/v1/btc/main/txs/" + getTxidsFromLatestUrl().get(0);
        System.out.println("header :" + header);

        String json = Request.Get(header)
                .addHeader("Content-Type", "application/json")
                .execute().returnContent().asString();

        System.out.println("json : " + json);

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(json);
        JSONArray addrs = (JSONArray) jsonObject.get("addresses");

        System.out.println("JSONArray addrs :" +  addrs);

        for (int i=0; i<=addrs.size()-1; i++) {
            listAddrs.add((String) addrs.get(i));
        }

        return listAddrs;
    }


}
