package Obi;

import Model.Ontology;
import Model.Pitfalls;
import java.io.IOException;
import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Path("obi/pitfalls")
public class obiPitfalls {

    private String value, pitfall_one, pitfall_two;
    private int intValue = 0;
    private JSONObject countClassesObject;   // EDW ALLAGI //
    private JSONArray arr;
    private Ontology obi;
    private Pitfalls pitfalls = new Pitfalls();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws IOException, JSONException {
        obi = new Ontology("obi"); // Ontology object type obi

        // Count the number of classes
        obi.setQuerySpaql(pitfalls.getPitfall1()); // Sparql query
        obi.setConnection(); // Get the data and write them in String obi.getResponsestring() with json format

        // Parse in the string obi.getResponsestring() type JSON 
        countClassesObject = new JSONObject(obi.getResponsestring());
        arr = countClassesObject.getJSONObject("results").getJSONArray("bindings");
        
        pitfall_one = String.valueOf(arr.length());

        // Count the number of objectProperties
        obi.setQuerySpaql(pitfalls.getPitfall2()); // Sparql query
        obi.setConnection(); // Get the data and write them in String obi.getResponsestring() with json format

        // Parse in the string obi.getResponsestring() type JSON 
        countClassesObject = new JSONObject(obi.getResponsestring());
        arr = countClassesObject.getJSONObject("results").getJSONArray("bindings");
        pitfall_two = String.valueOf(arr.length());

//        // Count the number of dataTypeProperties
//        obi.setQuerySpaql(pitfalls.getPitfall3()); // Sparql query
//        obi.setConnection(); // Get the data and write them in String obi.getResponsestring() with json format
//
//        // Parse in the string obi.getResponsestring() type JSON 
//        countClassesObject = new JSONObject(obi.getResponsestring());
//        arr = countClassesObject.getJSONObject("results").getJSONArray("bindings");
//        for (int i = 0; i < arr.length(); i++) {
//            value = arr.getJSONObject(i).getJSONObject("countDataType").getString("value");
//        }
//        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue
//
//        pitfall_three = String.valueOf(intValue);
//
//        // Count the number of individuals
//        obi.setQuerySpaql(pitfalls.getPitfall4()); // Sparql query
//        obi.setConnection(); // Get the data and write them in String obi.getResponsestring() with json format
//
//        // Parse in the string obi.getResponsestring() type JSON 
//        countClassesObject = new JSONObject(obi.getResponsestring());
//        arr = countClassesObject.getJSONObject("results").getJSONArray("bindings");
//        for (int i = 0; i < arr.length(); i++) {
//            value = arr.getJSONObject(i).getJSONObject("countIndividual").getString("value");
//        }
//        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue
//
//        pitfall_four = String.valueOf(intValue);

        String json = Json.createObjectBuilder()
                .add("MissingAnnotations", pitfall_one)
                .add("UnconnectedOntology", pitfall_two)
//                .add("UntypedProperty", pitfall_three)
//                .add("UntypedClass", pitfall_four)
                .build()
                .toString();

        return json;
    }
}
