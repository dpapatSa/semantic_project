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
@Path("musicontology/metric1")
public class Musicontology_1 {
    private String value, size;
    private int intValue=0;
    private JSONObject countClassesObject,countObjectProp,dataPropObject,individualObject;
    private  JSONArray arr;
    private Ontology musicontology;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws IOException, JSONException { 
        musicontology = new Ontology("musicontology"); // Ontology object type musicontology
        
        // Count the number of classes
        musicontology.setQuerySpaql("SELECT (COUNT(DISTINCT ?class) as ?countClass)\n" +"WHERE {\n" +"{\n" +"[] rdf:type ?class\n" +"}UNION{\n" +"?class rdf:type owl:Class\n" +"}UNION{\n" +"?class rdf:type rdfs:Class\n" +"}\n" +"}"); //Sparql query
        musicontology.setConnection(); //Get the data and write them in String cidoc.getResponsestring() with json format
        
        // Parse in the string musicontology.getResponsestring() type JSON 
        countClassesObject = new JSONObject(musicontology.getResponsestring());
        arr = countClassesObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countClass").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue
        
        // Count the number of objectPropertys
        musicontology.setQuerySpaql("SELECT (COUNT(DISTINCT ?objectProperty) as ?countObject)\n" + "WHERE {\n" +"{\n" +"[] rdf:type ?objectProperty\n" +"}UNION{\n" +"?objectProperty rdf:type owl:ObjectProperty\n" +"}UNION{\n" +"?objectProperty rdf:type rdfs:ObjectProperty\n" +"}\n" +"}");
        musicontology.setConnection(); //Get the data and write them in String cidoc.getResponsestring() with json format
        
        // Parse in the string musicontology.getResponsestring() type JSON 
        countObjectProp = new JSONObject(musicontology.getResponsestring());
        arr = countObjectProp.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countObject").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue
        
         //Count the number of datatypePropertys
        musicontology.setQuerySpaql("SELECT (COUNT(DISTINCT ?datatypeProperty) as ?countDataType)\n" + "WHERE {\n" + "{\n" + "[] rdf:type ?datatypeProperty\n" + "}UNION{\n" + "?datatypeProperty rdf:type owl:DataTypeProperty\n" + "}UNION{\n" + "?datatypeProperty rdf:type rdfs:DataTypeProperty\n" + "}\n" + "}");
        musicontology.setConnection(); // Get the data and write them in String cidoc.getResponsestring() with json format
        
        // Parse in the string musicontology.getResponsestring() type JSON 
        dataPropObject = new JSONObject(musicontology.getResponsestring());
        arr = dataPropObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countDataType").getString("value");
        }
        intValue += Integer.parseInt(value); // Add the value from query in the variable intValue
       
        //Count the number of individuals
        musicontology.setQuerySpaql("SELECT (COUNT(DISTINCT ?individual) as ?countIndividual)\n" + "WHERE {\n" +"{\n" +"[] rdf:type ?individual\n" +"}UNION{\n" +"?individual rdf:type owl:NamedIndividual\n" +"}UNION{\n" +"?individual rdf:type rdfs:NamedIndividual\n" +"}\n" +"}");
        musicontology.setConnection(); //Get the data and write them in String cidoc.getResponsestring() with json format
        
        // Parse in the string musicontology.getResponsestring() type JSON 
        individualObject = new JSONObject(musicontology.getResponsestring());
        arr = individualObject.getJSONObject("results").getJSONArray("bindings");
        for (int i = 0; i < arr.length(); i++) {
            value = arr.getJSONObject(i).getJSONObject("countIndividual").getString("value");
        }
        intValue += Integer.parseInt(value);  // Add the value from query in the variable intValue
        
        size = String.valueOf(intValue); // Final size value
        
        return size; // Return the number of size
    }

}