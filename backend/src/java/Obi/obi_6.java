package Obi;

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
@Path("obi/metric6")
public class obi_6 { //Equivalence Ratio (ER): ER = SameClasses / Number of All Classes 
    private String value, crrString;
    private int intValue1 = 0, intValue2 = 0;
    private JSONObject countClassesObject, countSameObject;
    private JSONArray arr;
    private Ontology obi;
    private Statistics stats = new Statistics();
    private double crr=0;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws IOException, JSONException {
        obi = new Ontology("obi"); // Ontology object type cidoc

        // Count the number of classes
        obi.setQuerySpaql(stats.getStat1()); //Sparql query
        obi.setConnection(); //Get the data and write them in String obi.getResponsestring() with json format

        // Parse in the string obi.getResponsestring() type JSON 
        countClassesObject = new JSONObject(obi.getResponsestring());
        arr = countClassesObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countClass").getString("value");
        }
        intValue1 = Integer.parseInt(value); // Add the value from query in the variable intValue
        
        // Count the number of same classes
        obi.setQuerySpaql(stats.getStat7()); //Sparql query
        obi.setConnection(); //Get the data and write them in String obi.getResponsestring() with json format

        // Parse in the string obi.getResponsestring() type JSON 
        countSameObject = new JSONObject(obi.getResponsestring());
        arr = countSameObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countSameClass").getString("value");
        }
        intValue2 = Integer.parseInt(value); // Add the value from query in the variable intValue
        
        crr = (double)intValue2 / intValue1; // SameClasses / Number of All Classes 
        crrString = String.valueOf(crr); // Final size value
        return crrString;
    }
}