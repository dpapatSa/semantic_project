package Foaf;

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
@Path("foaf/metric1")
public class Foaf_1 {

    private String value, size;
    private int intValue = 0;
    private JSONObject countClassesObject, countObjectProp, dataPropObject, individualObject;
    private JSONArray arr;
    private Ontology foaf;
    private Statistics stats = new Statistics();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws IOException, JSONException {
        foaf = new Ontology("foaf"); // Ontology object type foaf

        // Count the number of classes
        foaf.setQuerySpaql(stats.getStat1()); //Sparql query      
        foaf.setConnection(); //Get the data and write them in String foaf.getResponsestring() with json format

        // Parse in the string cidoc.getResponsestring() type JSON 
        countClassesObject = new JSONObject(foaf.getResponsestring());
        arr = countClassesObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countClass").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue

        // Count the number of objectPropertys
        foaf.setQuerySpaql(stats.getStat2()); //Sparql query      
        foaf.setConnection(); //Get the data and write them in String foaf.getResponsestring() with json format

        // Parse in the string cidoc.getResponsestring() type JSON 
        countObjectProp = new JSONObject(foaf.getResponsestring());
        arr = countObjectProp.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countObject").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue

        //Count the number of datatypePropertys
        foaf.setQuerySpaql(stats.getStat3()); //Sparql query      
        foaf.setConnection(); //Get the data and write them in String foaf.getResponsestring() with json format

        // Parse in the string cidoc.getResponsestring() type JSON 
        dataPropObject = new JSONObject(foaf.getResponsestring());
        arr = dataPropObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countDataType").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue

        //Count the number of individuals
        foaf.setQuerySpaql(stats.getStat4()); //Sparql query      
        foaf.setConnection(); //Get the data and write them in String foaf.getResponsestring() with json format

        // Parse in the string cidoc.getResponsestring() type JSON 
        individualObject = new JSONObject(foaf.getResponsestring());
        arr = individualObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countIndividual").getString("value");
        }
        intValue += Integer.parseInt(value);  // Add the value from query in the variable intValue

        size = String.valueOf(intValue); // Final size value

        return size; // Return the number of size
    }

}
