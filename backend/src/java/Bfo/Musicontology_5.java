package Bfo;

import Model.Ontology;
import Model.Statistics;
import java.io.IOException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Tasos
 */
@Path("musicontology/metric5")
public class Musicontology_5{ // Average population P: P = Number of individuals / Classes

    @Context
    private Ontology musicontology;
    private JSONObject individualObject, countClasses;
    private JSONArray arr;
    private String size, value;
    private Double doubleValue = 0.0;
    private Statistics stats = new Statistics();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public String getJson() throws IOException, JSONException {
        musicontology = new Ontology("foaf");  // Ontology object type musicontology       

        // Count the number of classes
        musicontology.setQuerySpaql(stats.getStat1()); //Sparql query
        musicontology.setConnection(); //Get the data and write them in String with json format

        // Parse in the string cidoc.getResponsestring() type JSON 
        countClasses = new JSONObject(musicontology.getResponsestring());
        arr = countClasses.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countClass").getString("value");
        }
        doubleValue = Double.parseDouble(value); //Number of classes

         //Count the number of individuals
        musicontology.setQuerySpaql(stats.getStat4()); //Sparql query
        musicontology.setConnection(); //Get the data and write them in String cidoc.getResponsestring() with json format

        // Parse in the string cidoc.getResponsestring() type JSON 
        individualObject = new JSONObject(musicontology.getResponsestring());
        arr = individualObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countIndividual").getString("value");
        }
        doubleValue += Double.parseDouble(value);  // Add the value from query in the variable value

        size = String.valueOf(doubleValue); // Final size value
        
        // return the the average population
        return size;
    }

}
