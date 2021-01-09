package Model;

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
@Path("dublincore/metric1")
public class Dublincore_1 {

    private String value, size;
    private int intValue = 0;
    private JSONObject countClassesObject, countObjectProp, dataPropObject, individualObject;
    private JSONArray arr;
    private Ontology dublincore;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws IOException, JSONException {
        dublincore = new Ontology("dublincore"); // Ontology object type dublincore

        // Count the number of classes
        dublincore.setQuerySpaql("SELECT (COUNT(DISTINCT ?class) as ?countClass)\n" + "WHERE {\n" + "{\n" + "[] rdf:type ?class\n" + "}UNION{\n" + "?class rdf:type owl:Class\n" + "}UNION{\n" + "?class rdf:type rdfs:Class\n" + "}\n" + "}"); //Sparql query
        dublincore.setConnection(); //Get the data and write them in String dublincore.getResponsestring() with json format

        // Parse in the string dublincore.getResponsestring() type JSON 
        countClassesObject = new JSONObject(dublincore.getResponsestring());
        arr = countClassesObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countClass").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue

        // Count the number of objectPropertys
        dublincore.setQuerySpaql("SELECT (COUNT(DISTINCT ?objectProperty) as ?countObject)\n" + "WHERE {\n" + "{\n" + "[] rdf:type ?objectProperty\n" + "}UNION{\n" + "?objectProperty rdf:type owl:ObjectProperty\n" + "}UNION{\n" + "?objectProperty rdf:type rdfs:ObjectProperty\n" + "}\n" + "}");
        dublincore.setConnection(); //Get the data and write them in String dublincore.getResponsestring() with json format

        // Parse in the string cidoc.getResponsestring() type JSON 
        countObjectProp = new JSONObject(dublincore.getResponsestring());
        arr = countObjectProp.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countObject").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue

        //Count the number of datatypePropertys
        dublincore.setQuerySpaql("SELECT (COUNT(DISTINCT ?datatypeProperty) as ?countDataType)\n" + "WHERE {\n" + "{\n" + "[] rdf:type ?datatypeProperty\n" + "}UNION{\n" + "?datatypeProperty rdf:type owl:DataTypeProperty\n" + "}UNION{\n" + "?datatypeProperty rdf:type rdfs:DataTypeProperty\n" + "}\n" + "}");
        dublincore.setConnection(); // Get the data and write them in String dublincore.getResponsestring() with json format

        // Parse in the string cidoc.getResponsestring() type JSON 
        dataPropObject = new JSONObject(dublincore.getResponsestring());
        arr = dataPropObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countDataType").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue

        //Count the number of individuals
        dublincore.setQuerySpaql("SELECT (COUNT(DISTINCT ?individual) as ?countIndividual)\n" + "WHERE {\n" + "{\n" + "[] rdf:type ?individual\n" + "}UNION{\n" + "?individual rdf:type owl:NamedIndividual\n" + "}UNION{\n" + "?individual rdf:type rdfs:NamedIndividual\n" + "}\n" + "}");
        dublincore.setConnection(); //Get the data and write them in String dublincore.getResponsestring() with json format

        // Parse in the string cidoc.getResponsestring() type JSON 
        individualObject = new JSONObject(dublincore.getResponsestring());
        arr = individualObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countIndividual").getString("value");
        }
        intValue += Integer.parseInt(value);  // Add the value from query in the variable intValue

        size = String.valueOf(intValue); // Final size value

        return size; // Return the number of size
    }

}
