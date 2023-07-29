package DataDriven;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JSonDataReader {

    public String Mobile, url,Email,Name,Age,cardNumber,card_expiry,card_cvv;
    public void jsonReader() throws IOException, ParseException {
        String filePath = System.getProperty("user.dir") + "/src/test/java/DataDriven/DataRead.json";
        File srcFile = new File(filePath);
        JSONParser parser = new JSONParser();
        JSONArray jarray = (JSONArray) parser.parse(new FileReader(srcFile));
        for (Object jsonObj : jarray) {
            JSONObject person = (JSONObject) jsonObj;
            Mobile = (String) person.get("Mobile");
            url = (String) person.get("url");
            Email = (String) person.get("Email");
            Name = (String) person.get("Name");
            Age = (String) person.get("Age");
            cardNumber = (String) person.get("cardNumber");
            card_expiry = (String) person.get("card_expiry");
            card_cvv = (String) person.get("card_cvv");

        }
    }
}
