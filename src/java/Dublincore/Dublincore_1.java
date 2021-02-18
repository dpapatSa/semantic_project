package Dublincore;

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
@Path("dublincore/metric1") 
public class Dublincore_1 { 
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
    private Ontology dublincore;
    private Statistics stats = new Statistics();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws IOException, JSONException {
        dublincore = new Ontology("dublincore"); // Ontology object type dublincore

        // Count the number of classes
        dublincore.setQuerySpaql(stats.getStat1()); //Sparql query
        dublincore.setConnection(); //Get the data and write them in String dublincore.getResponsestring() with json format

        // Parse in the string dublincore.getResponsestring() type JSON 
        countClassesObject = new JSONObject(dublincore.getResponsestring());
        arr = countClassesObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countClass").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue

        // Count the number of objectPropertys
        dublincore.setQuerySpaql(stats.getStat2()); //Sparql query
        dublincore.setConnection(); //Get the data and write them in String dublincore.getResponsestring() with json format

        // Parse in the string cidoc.getResponsestring() type JSON 
        countObjectProp = new JSONObject(dublincore.getResponsestring());
        arr = countObjectProp.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countObject").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue

        //Count the number of datatypePropertys
        dublincore.setQuerySpaql(stats.getStat3()); //Sparql query    
        dublincore.setConnection(); // Get the data and write them in String dublincore.getResponsestring() with json format

        // Parse in the string cidoc.getResponsestring() type JSON 
        dataPropObject = new JSONObject(dublincore.getResponsestring());
        arr = dataPropObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countDataType").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue

        //Count the number of individuals
        dublincore.setQuerySpaql(stats.getStat4()); //Sparql query
        dublincore.setConnection(); //Get the data and write them in String dublincore.getResponsestring() with json format

        // Parse in the string cidoc.getResponsestring() type JSON 
        individualObject = new JSONObject(dublincore.getResponsestring());
        arr = individualObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countIndividual").getString("value");
        }
        intValue += Integer.parseInt(value);  // Add the value from query in the variable intValue

        size = String.valueOf(intValue); // Final size value

        return size; // Return the number of size
    }

}
