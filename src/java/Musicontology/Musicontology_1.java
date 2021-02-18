package Musicontology;

import Model.Ontology;
import Model.Statistics;
import java.io.IOException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Tasos
 */
@Path("musicontology/metric1")
public class Musicontology_1 { 
//Size(M) = |M| = |C| + |OP| + |DP| + |I|
// |M| = number of entities in a module
// |C| = class size
// |OP| = object property size 
// |DP| = data property size
// |I| = individual size

    private String value, size;
    private int intValue = 0;
    private JSONObject countClassesObject, countObjectProp, dataPropObject, individualObject;
    private JSONArray arr;
    private Ontology musicontology;
    private Statistics stats = new Statistics();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws IOException, JSONException {
        musicontology = new Ontology("musicontology"); // Ontology object type musicontology

        // Count the number of classes
        musicontology.setQuerySpaql(stats.getStat1()); //Sparql query
        musicontology.setConnection(); //Get the data and write them in String cidoc.getResponsestring() with json format

        // Parse in the string musicontology.getResponsestring() type JSON 
        countClassesObject = new JSONObject(musicontology.getResponsestring());
        arr = countClassesObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countClass").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue

        // Count the number of objectPropertys
        musicontology.setQuerySpaql(stats.getStat2()); //Sparql query
        musicontology.setConnection(); //Get the data and write them in String cidoc.getResponsestring() with json format

        // Parse in the string musicontology.getResponsestring() type JSON 
        countObjectProp = new JSONObject(musicontology.getResponsestring());
        arr = countObjectProp.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countObject").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue

        //Count the number of datatypePropertys
        musicontology.setQuerySpaql(stats.getStat3()); //Sparql query
        musicontology.setConnection(); // Get the data and write them in String cidoc.getResponsestring() with json format

        // Parse in the string musicontology.getResponsestring() type JSON 
        dataPropObject = new JSONObject(musicontology.getResponsestring());
        arr = dataPropObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countDataType").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue

        //Count the number of individuals
        musicontology.setQuerySpaql(stats.getStat4()); //Sparql query
        musicontology.setConnection(); //Get the data and write them in String cidoc.getResponsestring() with json format

        // Parse in the string musicontology.getResponsestring() type JSON 
        individualObject = new JSONObject(musicontology.getResponsestring());
        arr = individualObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countIndividual").getString("value");
        }
        intValue += Integer.parseInt(value);  // Add the value from query in the variable intValue

        size = String.valueOf(intValue); // Final size value

        return size; // Return the number of size
    }

}
