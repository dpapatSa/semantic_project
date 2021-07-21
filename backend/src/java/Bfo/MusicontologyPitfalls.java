package Bfo;

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

@Path("musicontology/pitfalls")
public class MusicontologyPitfalls {

    private String value, pitfall_one, pitfall_two;
    private int intValue = 0;
    private JSONObject countClassesObject;   // EDW ALLAGI //
    private JSONArray arr;
    private Ontology musicontology;
    private Pitfalls pitfalls = new Pitfalls();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws IOException, JSONException {
        musicontology = new Ontology("musicontology"); // Ontology object type musicontology

        // Count the number of classes
        musicontology.setQuerySpaql(pitfalls.getPitfall1()); // Sparql query
        musicontology.setConnection(); // Get the data and write them in String musicontology.getResponsestring() with json format

        // Parse in the string musicontology.getResponsestring() type JSON 
        countClassesObject = new JSONObject(musicontology.getResponsestring());
        arr = countClassesObject.getJSONObject("results").getJSONArray("bindings");
        
        pitfall_one = String.valueOf(arr.length());

        // Count the number of objectProperties
        musicontology.setQuerySpaql(pitfalls.getPitfall2()); // Sparql query
        musicontology.setConnection(); // Get the data and write them in String musicontology.getResponsestring() with json format

        // Parse in the string musicontology.getResponsestring() type JSON 
        countClassesObject = new JSONObject(musicontology.getResponsestring());
        arr = countClassesObject.getJSONObject("results").getJSONArray("bindings");
        pitfall_two = String.valueOf(arr.length());

//        // Count the number of dataTypeProperties
//        musicontology.setQuerySpaql(pitfalls.getPitfall3()); // Sparql query
//        musicontology.setConnection(); // Get the data and write them in String musicontology.getResponsestring() with json format
//
//        // Parse in the string musicontology.getResponsestring() type JSON 
//        countClassesObject = new JSONObject(musicontology.getResponsestring());
//        arr = countClassesObject.getJSONObject("results").getJSONArray("bindings");
//        for (int i = 0; i < arr.length(); i++) {
//            value = arr.getJSONObject(i).getJSONObject("countDataType").getString("value");
//        }
//        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue
//
//        pitfall_three = String.valueOf(intValue);
//
//        // Count the number of individuals
//        musicontology.setQuerySpaql(pitfalls.getPitfall4()); // Sparql query
//        musicontology.setConnection(); // Get the data and write them in String musicontology.getResponsestring() with json format
//
//        // Parse in the string musicontology.getResponsestring() type JSON 
//        countClassesObject = new JSONObject(musicontology.getResponsestring());
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
