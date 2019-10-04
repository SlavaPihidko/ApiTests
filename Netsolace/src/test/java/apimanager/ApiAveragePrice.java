package apimanager;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import model.AvPriceFromBitcoinaverage;

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

    public List<AvPriceFromBitcoinaverage> getListLast30Days() throws FileNotFoundException, ParseException {

        List<AvPriceFromBitcoinaverage> list_1 = new ArrayList<>();

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

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Timestamp ts = new Timestamp(df.parse(time).getTime());

            System.out.println("ts : " + ts);

            AvPriceFromBitcoinaverage avPriceFromBitcoinaverage = new AvPriceFromBitcoinaverage()
                    .withAverage(average)
                    .withTs(ts);

            System.out.println("avPriceFromBitcoinaverage : " + avPriceFromBitcoinaverage);

            list_1.add(avPriceFromBitcoinaverage);
        }

        System.out.println("list_1 :" + list_1);

        list_1.sort(Comparator.comparing(AvPriceFromBitcoinaverage::getTs));
        System.out.println("list_1 :" + list_1);

        return list_1;
    }
}
