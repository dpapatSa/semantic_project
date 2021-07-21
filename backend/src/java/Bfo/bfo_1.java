package Bfo;

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
@Path("bfo/metric1")
public class bfo_1 { 
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
    private Ontology bfo;
    private Statistics stats = new Statistics();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws IOException, JSONException {
        bfo = new Ontology("bfo"); // Ontology object type bfo

        // Count the number of classes
        bfo.setQuerySpaql(stats.getStat1()); //Sparql query
        bfo.setConnection(); //Get the data and write them in String cidoc.getResponsestring() with json format

        // Parse in the string bfo.getResponsestring() type JSON 
        countClassesObject = new JSONObject(bfo.getResponsestring());
        arr = countClassesObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countClass").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue

        // Count the number of objectPropertys
        bfo.setQuerySpaql(stats.getStat2()); //Sparql query
        bfo.setConnection(); //Get the data and write them in String cidoc.getResponsestring() with json format

        // Parse in the string bfo.getResponsestring() type JSON 
        countObjectProp = new JSONObject(bfo.getResponsestring());
        arr = countObjectProp.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countObject").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue

        //Count the number of datatypePropertys
        bfo.setQuerySpaql(stats.getStat3()); //Sparql query
        bfo.setConnection(); // Get the data and write them in String cidoc.getResponsestring() with json format

        // Parse in the string bfo.getResponsestring() type JSON 
        dataPropObject = new JSONObject(bfo.getResponsestring());
        arr = dataPropObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countDataType").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue

        //Count the number of individuals
        bfo.setQuerySpaql(stats.getStat4()); //Sparql query
        bfo.setConnection(); //Get the data and write them in String cidoc.getResponsestring() with json format

        // Parse in the string bfo.getResponsestring() type JSON 
        individualObject = new JSONObject(bfo.getResponsestring());
        arr = individualObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countIndividual").getString("value");
        }
        intValue += Integer.parseInt(value);  // Add the value from query in the variable intValue

        size = String.valueOf(intValue); // Final size value

        return size; // Return the number of size
    }

}
