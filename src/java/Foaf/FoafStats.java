package Foaf;

import Model.Ontology;
import Model.Statistics;
import java.io.IOException;
import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Path("foaf/stats")
public class FoafStats {

    private String value, noOfClasses, noObjProperties, noDTProperties, noOfIndividuals, noOfAxioms;
    private int intValue = 0;
    private JSONObject countClassesObject;
    private JSONArray arr;
    private Ontology foaf;
    private Statistics stats = new Statistics();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws IOException, JSONException {
        foaf = new Ontology("foaf"); // Ontology object type foaf

        // Count the number of classes
        foaf.setQuerySpaql(stats.getStat1()); // Sparql query
        foaf.setConnection(); // Get the data and write them in String foaf.getResponsestring() with json format

        // Parse in the string foaf.getResponsestring() type JSON 
        countClassesObject = new JSONObject(foaf.getResponsestring());
        arr = countClassesObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countClass").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue

        noOfClasses = String.valueOf(intValue);

        // Count the number of objectProperties
        foaf.setQuerySpaql(stats.getStat2()); // Sparql query
        foaf.setConnection(); // Get the data and write them in String foaf.getResponsestring() with json format

        // Parse in the string foaf.getResponsestring() type JSON 
        countClassesObject = new JSONObject(foaf.getResponsestring());
        arr = countClassesObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countObject").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue

        noObjProperties = String.valueOf(intValue);

        // Count the number of dataTypeProperties
        foaf.setQuerySpaql(stats.getStat3()); // Sparql query
        foaf.setConnection(); // Get the data and write them in String foaf.getResponsestring() with json format

        // Parse in the string foaf.getResponsestring() type JSON 
        countClassesObject = new JSONObject(foaf.getResponsestring());
        arr = countClassesObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countDataType").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue

        noDTProperties = String.valueOf(intValue);

        // Count the number of individuals
        foaf.setQuerySpaql(stats.getStat4()); // Sparql query
        foaf.setConnection(); // Get the data and write them in String foaf.getResponsestring() with json format

        // Parse in the string foaf.getResponsestring() type JSON 
        countClassesObject = new JSONObject(foaf.getResponsestring());
        arr = countClassesObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countIndividual").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue

        noOfIndividuals = String.valueOf(intValue);

        // Count the number of axioms/attributes
        foaf.setQuerySpaql(stats.getStat5()); // Sparql query
        foaf.setConnection(); // Get the data and write them in String foaf.getResponsestring() with json format

        // Parse in the string foaf.getResponsestring() type JSON 
        countClassesObject = new JSONObject(foaf.getResponsestring());
        arr = countClassesObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countAxioms").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue

        noOfAxioms = String.valueOf(intValue);

        String json = Json.createObjectBuilder()
                .add("noOfClasses", noOfClasses)
                .add("noObjProperties", noObjProperties)
                .add("noDTProperties", noDTProperties)
                .add("noOfIndividuals", noOfIndividuals)
                .add("noOfAxioms", noOfAxioms)
                .build()
                .toString();

        return json;
    }
}
