import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public interface Parser  {
     public JSONObject fileParse(String fileWay) throws IOException, ParseException;

}
