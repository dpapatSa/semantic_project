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
@Path("pizza/metric2")
public class Pizza_2 {
    @Context
    private Ontology pizza;
    private Double attributeRich;
    private JSONObject countAttributes, countClasses;
    private  JSONArray arr;
    private String value, attribute_richness, Jsonstring;
    private Double intValue1 = 0.0, intValue2 = 0.0;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    
    public String getJson() throws IOException, JSONException {
        pizza = new Ontology("pizza");  // Ontology object type pizza       
        
        pizza.setQuerySpaql("Select distinct (count(?Subject) as ?countAxioms)\n" +"where {\n" +"[] a ?Subject\n" +"}"); //Sparql query
        pizza.setConnection(); //Get the data and write them in String with json format
        
        // Parse in the string pizza.getResponsestring() type JSON 
        countAttributes = new JSONObject(pizza.getResponsestring());
        arr = countAttributes.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countAxioms").getString("value");
        }
        intValue1 = Double.parseDouble(value); //Number of axioms
        
        // Count the number of classes
        pizza.setQuerySpaql("SELECT (COUNT(DISTINCT ?class) as ?countClass)\n" +"WHERE {\n" +"{\n" +"[] rdf:type ?class\n" +"}UNION{\n" +"?class rdf:type owl:Class\n" +"}UNION{\n" +"?class rdf:type rdfs:Class\n" +"}\n" +"}"); //Sparql query
        pizza.setConnection(); //Get the data and write them in String with json format
        
        // Parse in the string pizza.getResponsestring() type JSON 
        countClasses = new JSONObject(pizza.getResponsestring());
        arr = countClasses.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countClass").getString("value");
        }
        intValue2 = Double.parseDouble(value); //Number of classes
        
        attributeRich = intValue1/intValue2; // Calculate atrribute richness
        attribute_richness=String.valueOf(attributeRich); //Convert to string
        
        //return representation object
        return attribute_richness;
    }

}