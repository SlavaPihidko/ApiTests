package apimanager;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import model.AvPrice;
import model.AvPriceFromBitcoinaverage;
import model.AvPriceFromblockchain;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ApiAveragePrice extends ApiHelperBase {

    public List<AvPrice> getListLast30Days() throws FileNotFoundException, ParseException {

        List<AvPrice> listFromBitcoinAverage = new ArrayList<>();

        FileReader jsonFile = new FileReader("src/test/resources/json1.json");

        JsonParser jsonParser = new JsonParser();
        JsonArray parsed = (JsonArray) jsonParser.parse(jsonFile);

        List<AvPriceFromBitcoinaverage> avPrice_1 =
                new Gson().fromJson(parsed, new TypeToken<List<AvPriceFromBitcoinaverage>>(){}.getType());
        System.out.println("avPrice_1 : " + avPrice_1);

        for(AvPriceFromBitcoinaverage i : avPrice_1) {
            Double average = i.getAverage();
            String time = i.getTime();
            String time2 = "2019-10-03 00:00:00";

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Timestamp ts = new Timestamp(df.parse(time).getTime());

            System.out.println("ts : " + ts);

            AvPrice avPriceFromBitcoinAverage = new AvPrice()
                    .withAverage(average)
                    .withTs(ts);

            System.out.println("avPriceFromBitcoinAverage : " + avPriceFromBitcoinAverage);

            listFromBitcoinAverage.add(avPriceFromBitcoinAverage);
        }

        System.out.println("listFromBitcoinAverage :" + listFromBitcoinAverage);

        listFromBitcoinAverage.sort(Comparator.comparing(AvPrice::getTs));
        System.out.println("listFromBitcoinAverage :" + listFromBitcoinAverage);

        return listFromBitcoinAverage;
    }

    public List<AvPriceFromBitcoinaverage> getList2Last30Days() throws FileNotFoundException, ParseException {
        List<AvPriceFromBitcoinaverage> list_2 = new ArrayList<>();

        FileReader jsonFile = new FileReader("src/test/resources/json2.json");

        JsonParser jsonParser = new JsonParser();
        JsonArray parsed =  jsonParser.parse(jsonFile).getAsJsonObject().getAsJsonArray("values");

        List<AvPriceFromblockchain> list =
                new Gson().fromJson(parsed, new TypeToken<List<AvPriceFromblockchain>>(){}.getType());

        for(AvPriceFromblockchain i: list ) {
            long epoch = i.getX();
            double average = i.getY();

            String time = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date (epoch*1000));

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Timestamp ts = new Timestamp(df.parse(time).getTime());

            System.out.println("i.getX() :" + i.getX());
            System.out.println("i.getY() :" + i.getY());



            AvPriceFromBitcoinaverage av = new AvPriceFromBitcoinaverage()
                    .withAverage(average)
                    .withTs(ts);

            list_2.add(av);
        }

        list_2.sort(Comparator.comparing(AvPriceFromBitcoinaverage::getTs));
        return  list_2;
    }
}
