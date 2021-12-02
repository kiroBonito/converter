import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class operations implements Parser{
    public static String fileName = "/Users/kapipa/Desktop/sample2.json";
    private String basePoint;
    private String desirePoint;
    private float currancy;
    private float finalCurrancy;
    public String getFileName() {
        System.out.println(fileName);
        return fileName;
    }

    public static List<operations> operationsList = new ArrayList<>();
    public static void watchOperations(){
        List<operations> a  = operationsList;
        for(operations m : a) {
            System.out.println(m);
        }
    }
    public float converter(String basePoint, String desirePoint, float currancy) throws IOException, ParseException {
        JSONObject currancyConvert = fileParse(fileName);
        float basePointFloat = Float.parseFloat((String) currancyConvert.get(basePoint));
        float desirePointFloat = Float.parseFloat((String) currancyConvert.get(desirePoint));
        float finalyPointFloat = (basePointFloat * currancy)/ desirePointFloat;
        return  finalyPointFloat;
    }
    public operations(String basePoint, String desirePoint, float currancy) throws IOException, ParseException {
        this.basePoint = basePoint;
        this.desirePoint = desirePoint;
        this.currancy = currancy;
        float finalyPoint = converter(basePoint,desirePoint,currancy);
        this.finalCurrancy = finalyPoint;
        operationsList.add(this);
        System.out.println(this);
    }

    @Override
    public JSONObject fileParse(String fileWay) throws IOException, ParseException {
        JSONParser jsonparser = new JSONParser();
        FileReader file = new FileReader(fileWay);
        JSONObject jsonObject = (JSONObject) jsonparser.parse(file);
        return jsonObject;
    }

    @Override
    public String toString() {
        return "Операция: " + currancy + " " + basePoint + " ->  " + finalCurrancy + " " + desirePoint  + '\n';
    }
}

