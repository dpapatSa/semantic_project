package Foaf;

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
@Path("foaf/metric2")
public class Foaf_2 { // Attribute richness AR(M) = Number of attributes of all entities / Number of classes

    @Context
    private Ontology foaf;
    private Double attributeRich;
    private JSONObject countAttributes, countClasses;
    private JSONArray arr;
    private String value, attribute_richness, Jsonstring;
    private Double intValue1 = 0.0, intValue2 = 0.0;
    private Statistics stats = new Statistics();

    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public String getJson() throws IOException, JSONException {
        foaf = new Ontology("foaf");  // Ontology object type foaf       

        foaf.setQuerySpaql(stats.getStat5()); //Sparql query      
        foaf.setConnection(); //Get the data and write them in String foaf.getResponsestring() with json format

        // Parse in the string foaf.getResponsestring() type JSON 
        countAttributes = new JSONObject(foaf.getResponsestring());
        arr = countAttributes.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countAxioms").getString("value");
        }
        intValue1 = Double.parseDouble(value); //Number of axioms

        // Count the number of classes
        foaf.setQuerySpaql(stats.getStat1()); //Sparql query      
        foaf.setConnection(); //Get the data and write them in String foaf.getResponsestring() with json format

        // Parse in the string foaf.getResponsestring() type JSON 
        countClasses = new JSONObject(foaf.getResponsestring());
        arr = countClasses.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countClass").getString("value");
        }
        intValue2 = Double.parseDouble(value); //Number of classes

        attributeRich = intValue1 / intValue2; // Calculate atrribute richness
        attribute_richness = String.valueOf(attributeRich); //Convert to string

        //return representation object
        return attribute_richness;
    }

}
