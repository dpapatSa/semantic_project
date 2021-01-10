package Pizza;

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
@Path("pizza/metric1")
public class Pizza_1 {

    private String value, size;
    private int intValue = 0;
    private JSONObject countClassesObject, countObjectProp, dataPropObject, individualObject;
    private JSONArray arr;
    private Ontology pizza;
    private Statistics stats = new Statistics();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws IOException, JSONException {
        pizza = new Ontology("pizza"); // Ontology object type pizza

        // Count the number of classes
        pizza.setQuerySpaql(stats.getStat1()); //Sparql query      
        pizza.setConnection(); //Get the data and write them in String foaf.getResponsestring() with json format

        // Parse in the string cidoc.getResponsestring() type JSON 
        countClassesObject = new JSONObject(pizza.getResponsestring());
        arr = countClassesObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countClass").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue

        // Count the number of objectPropertys
        pizza.setQuerySpaql(stats.getStat2()); //Sparql query      
        pizza.setConnection(); //Get the data and write them in String foaf.getResponsestring() with json format

        // Parse in the string pizza.getResponsestring() type JSON 
        countObjectProp = new JSONObject(pizza.getResponsestring());
        arr = countObjectProp.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countObject").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue

        //Count the number of datatypePropertys
        pizza.setQuerySpaql(stats.getStat3()); //Sparql query      
        pizza.setConnection(); //Get the data and write them in String foaf.getResponsestring() with json format

        // Parse in the string pizza.getResponsestring() type JSON 
        dataPropObject = new JSONObject(pizza.getResponsestring());
        arr = dataPropObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countDataType").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue

        //Count the number of individuals
        pizza.setQuerySpaql(stats.getStat4()); //Sparql query      
        pizza.setConnection(); //Get the data and write them in String foaf.getResponsestring() with json format

        // Parse in the string pizza.getResponsestring() type JSON 
        individualObject = new JSONObject(pizza.getResponsestring());
        arr = individualObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countIndividual").getString("value");
        }
        intValue += Integer.parseInt(value);  // Add the value from query in the variable intValue

        size = String.valueOf(intValue); // Final size value

        return size; // Return the number of size
    }

}
