/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author kirkk
 */
@Path("obi/metric4")
public class obi_4 { // Class/Relation Ratio (CRR): Classes / Relationships
    private String value, crrString;
    private int intValue = 0,intValue2=0;
    private JSONObject countClassesObject,countTripleObject;
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
        obi.setConnection(); //Get the data and write them in String cidoc.getResponsestring() with json format

        // Parse in the string cidoc.getResponsestring() type JSON 
        countClassesObject = new JSONObject(obi.getResponsestring());
        arr = countClassesObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countClass").getString("value");
        }
        intValue = Integer.parseInt(value); // Add the value from query in the variable intValue
        
        // Count the number of objectPropertys
        obi.setQuerySpaql(stats.getStat6()); //Sparql query
        obi.setConnection(); //Get the data and write them in String cidoc.getResponsestring() with json format

        // Parse in the string cidoc.getResponsestring() type JSON 
        countTripleObject = new JSONObject(obi.getResponsestring());
        arr = countTripleObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countTriples").getString("value");
        }
        intValue2 = Integer.parseInt(value); // Add the value from query in the variable intValue
        crr=(double)intValue/intValue2;
        crrString = String.valueOf(crr); // Final size value
        return crrString;
    }
}
