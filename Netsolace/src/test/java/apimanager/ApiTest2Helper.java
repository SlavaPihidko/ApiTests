package apimanager;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import model.Address;
import model.AvPriceFromBitcoinaverage;
import model.LatesBlock;

import model.Txrefs;
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


    public Address getAddressObjects() throws ParseException, InterruptedException, IOException {

        //3Bmb9Jig8A5kHdDSxvDZ6eryj3AXd3swuJ
        //getAddrsFromFirstTx().get(0)
        String header = "https://api.blockcypher.com/v1/btc/main/addrs/" + "3Bmb9Jig8A5kHdDSxvDZ6eryj3AXd3swuJ";
        Thread.sleep(2000);
        String json = Request.Get(header)
                .addHeader("Content-Type", "application/json")
                .execute().returnContent().asString();

        //System.out.println("json : " + json);

        String json_1 = json.replace("\"spent\": false","\"spent\": \"false\"");
        String json_2 = json_1.replace("\"spent\": true","\"spent\": \"true\"");
        System.out.println("json_2 :" + json_2);

        JsonParser jsonParser = new JsonParser();
        JsonElement parsed_1 =  jsonParser.parse(json_2);
        JsonArray parsed_2 =  jsonParser.parse(json_2).getAsJsonObject().getAsJsonArray("txrefs");

        Address addrs =
                new Gson().fromJson(parsed_1, new TypeToken<Address>(){}.getType());
        System.out.println("addrs :" + addrs);

        List<Txrefs> txrefs = new Gson().fromJson(parsed_2, new TypeToken<List<Txrefs>>(){}.getType());
        System.out.println("txrefs :" + txrefs);

        System.out.println(
                "  addrs.getBalance() :" + addrs.getBalance() +
                "  addrs.getTotal_sent() :" + addrs.getTotal_sent()+
                "  addrs.getTotal_received() :" + addrs.getTotal_received()
        );

        for(Txrefs i: txrefs) {

            String spent = i.getSpent();

            if(spent == null) {
                System.out.println("null");
            } else {

                if (spent.equals("false")) {
                    System.out.println("false :");
                    System.out.println(i.getValue());
                }
                else   {
                    System.out.println("true :");
                    System.out.println(i.getValue());
                }
            }
        }




        return addrs;
    }
}
