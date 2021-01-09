package Model;

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
@Path("pizza/metric3")
public class Pizza_3 {

    @Context
    private Ontology pizza;
    private JSONObject countAttributes;
    private JSONArray arr;
    private String value;
    private Double appropriateness = 0.0, axioms = 0.0;

    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public String getJson() throws IOException, JSONException {
        pizza = new Ontology("pizza");  // Ontology object type pizza       

        pizza.setQuerySpaql("Select distinct (count(?Subject) as ?countAxioms)\n" + "where {\n" + "[] a ?Subject\n" + "}"); //Sparql query
        pizza.setConnection(); //Get the data and write them in String with json format

        // Parse in the string pizza.getResponsestring() type JSON 
        countAttributes = new JSONObject(pizza.getResponsestring());
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
