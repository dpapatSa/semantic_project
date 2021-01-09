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
@Path("foaf/metric1")
public class Foaf_1 {

    private String value, size;
    private int intValue = 0;
    private JSONObject countClassesObject, countObjectProp, dataPropObject, individualObject;
    private JSONArray arr;
    private Ontology foaf;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws IOException, JSONException {
        foaf = new Ontology("foaf"); // Ontology object type foaf

        // Count the number of classes
        foaf.setQuerySpaql("SELECT (COUNT(DISTINCT ?class) as ?countClass)\n" + "WHERE {\n" + "{\n" + "[] rdf:type ?class\n" + "}UNION{\n" + "?class rdf:type owl:Class\n" + "}UNION{\n" + "?class rdf:type rdfs:Class\n" + "}\n" + "}"); //Sparql query
        foaf.setConnection(); //Get the data and write them in String foaf.getResponsestring() with json format

        // Parse in the string cidoc.getResponsestring() type JSON 
        countClassesObject = new JSONObject(foaf.getResponsestring());
        arr = countClassesObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countClass").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue

        // Count the number of objectPropertys
        foaf.setQuerySpaql("SELECT (COUNT(DISTINCT ?objectProperty) as ?countObject)\n" + "WHERE {\n" + "{\n" + "[] rdf:type ?objectProperty\n" + "}UNION{\n" + "?objectProperty rdf:type owl:ObjectProperty\n" + "}UNION{\n" + "?objectProperty rdf:type rdfs:ObjectProperty\n" + "}\n" + "}");
        foaf.setConnection(); //Get the data and write them in String foaf.getResponsestring() with json format

        // Parse in the string cidoc.getResponsestring() type JSON 
        countObjectProp = new JSONObject(foaf.getResponsestring());
        arr = countObjectProp.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countObject").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue

        //Count the number of datatypePropertys
        foaf.setQuerySpaql("SELECT (COUNT(DISTINCT ?datatypeProperty) as ?countDataType)\n" + "WHERE {\n" + "{\n" + "[] rdf:type ?datatypeProperty\n" + "}UNION{\n" + "?datatypeProperty rdf:type owl:DataTypeProperty\n" + "}UNION{\n" + "?datatypeProperty rdf:type rdfs:DataTypeProperty\n" + "}\n" + "}");
        foaf.setConnection(); // Get the data and write them in String foaf.getResponsestring() with json format

        // Parse in the string cidoc.getResponsestring() type JSON 
        dataPropObject = new JSONObject(foaf.getResponsestring());
        arr = dataPropObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countDataType").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue

        //Count the number of individuals
        foaf.setQuerySpaql("SELECT (COUNT(DISTINCT ?individual) as ?countIndividual)\n" + "WHERE {\n" + "{\n" + "[] rdf:type ?individual\n" + "}UNION{\n" + "?individual rdf:type owl:NamedIndividual\n" + "}UNION{\n" + "?individual rdf:type rdfs:NamedIndividual\n" + "}\n" + "}");
        foaf.setConnection(); //Get the data and write them in String foaf.getResponsestring() with json format

        // Parse in the string cidoc.getResponsestring() type JSON 
        individualObject = new JSONObject(foaf.getResponsestring());
        arr = individualObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countIndividual").getString("value");
        }
        intValue += Integer.parseInt(value);  // Add the value from query in the variable intValue

        size = String.valueOf(intValue); // Final size value

        return size; // Return the number of size
    }

}
