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
@Path("foaf/metric3")
public class Foaf_3 { // Appropriateness of module size: 1/2 - 1/2 *cos(number of axioms* p/250)

    @Context
    private Ontology foaf;
    private JSONObject countAttributes;
    private JSONArray arr;
    private String value;
    private Double appropriateness = 0.0, axioms = 0.0;
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
        axioms = Double.parseDouble(value); //Number of axioms

        appropriateness = (1.0 / 2.0) - (1.0 / 2.0) * Math.cos(axioms * Math.PI / 250); // Calculate the appropriateness of module size

        value = String.valueOf(appropriateness); //Convert to string

        // return the the appropriateness of module size
        return value;
    }

}
