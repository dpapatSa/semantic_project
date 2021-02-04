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
@Path("foaf/metric6")
public class Foaf_6 { //Equivalence Ratio (ER): ER = SameClasses / Number of All Classes 
    private String value, crrString;
    private int intValue1 = 0, intValue2 = 0;
    private JSONObject countClassesObject, countSameObject;
    private JSONArray arr;
    private Ontology foaf;
    private Statistics stats = new Statistics();
    private double crr=0;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws IOException, JSONException {
        foaf = new Ontology("foaf"); // Ontology object type cidoc

        // Count the number of classes
        foaf.setQuerySpaql(stats.getStat1()); //Sparql query
        foaf.setConnection(); //Get the data and write them in String foaf.getResponsestring() with json format

        // Parse in the string foaf.getResponsestring() type JSON 
        countClassesObject = new JSONObject(foaf.getResponsestring());
        arr = countClassesObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countClass").getString("value");
        }
        intValue1 = Integer.parseInt(value); // Add the value from query in the variable intValue
        
        // Count the number of same classes
        foaf.setQuerySpaql(stats.getStat7()); //Sparql query
        foaf.setConnection(); //Get the data and write them in String foaf.getResponsestring() with json format

        // Parse in the string foaf.getResponsestring() type JSON 
        countSameObject = new JSONObject(foaf.getResponsestring());
        arr = countSameObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countAllClass").getString("value");
        }
        intValue2 = Integer.parseInt(value); // Add the value from query in the variable intValue
        
         intValue2 = intValue2 - intValue1; // Same classes = All classes - Unique classes
        
        crr = (double)intValue2 / intValue1;
        crrString = String.valueOf(crr); // Final size value
        return crrString;
    }
}