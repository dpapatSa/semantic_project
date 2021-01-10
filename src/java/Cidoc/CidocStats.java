package Cidoc;

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

@Path("cidoc/stats")
public class CidocStats {

    private String value, noOfClasses, noObjProperties, noDTProperties, noOfIndividuals, noOfAxioms;
    private int intValue = 0;
    private JSONObject countClassesObject;
    private JSONArray arr;
    private Ontology cidoc;
    private Statistics stats = new Statistics();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws IOException, JSONException {
        cidoc = new Ontology("cidoc"); // Ontology object type cidoc

        // Count the number of classes
        cidoc.setQuerySpaql(stats.getStat1()); // Sparql query
        cidoc.setConnection(); // Get the data and write them in String cidoc.getResponsestring() with json format

        // Parse in the string cidoc.getResponsestring() type JSON 
        countClassesObject = new JSONObject(cidoc.getResponsestring());
        arr = countClassesObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countClass").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue

        noOfClasses = String.valueOf(intValue);

        // Count the number of objectProperties
        cidoc.setQuerySpaql(stats.getStat2()); // Sparql query
        cidoc.setConnection(); // Get the data and write them in String cidoc.getResponsestring() with json format

        // Parse in the string cidoc.getResponsestring() type JSON 
        countClassesObject = new JSONObject(cidoc.getResponsestring());
        arr = countClassesObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countObject").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue

        noObjProperties = String.valueOf(intValue);

        // Count the number of dataTypeProperties
        cidoc.setQuerySpaql(stats.getStat3()); // Sparql query
        cidoc.setConnection(); // Get the data and write them in String cidoc.getResponsestring() with json format

        // Parse in the string cidoc.getResponsestring() type JSON 
        countClassesObject = new JSONObject(cidoc.getResponsestring());
        arr = countClassesObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countDataType").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue

        noDTProperties = String.valueOf(intValue);

        // Count the number of individuals
        cidoc.setQuerySpaql(stats.getStat4()); // Sparql query
        cidoc.setConnection(); // Get the data and write them in String cidoc.getResponsestring() with json format

        // Parse in the string cidoc.getResponsestring() type JSON 
        countClassesObject = new JSONObject(cidoc.getResponsestring());
        arr = countClassesObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countIndividual").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue

        noOfIndividuals = String.valueOf(intValue);

        // Count the number of axioms/attributes
        cidoc.setQuerySpaql(stats.getStat5()); // Sparql query
        cidoc.setConnection(); // Get the data and write them in String cidoc.getResponsestring() with json format

        // Parse in the string cidoc.getResponsestring() type JSON 
        countClassesObject = new JSONObject(cidoc.getResponsestring());
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
