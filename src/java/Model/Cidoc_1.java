package Model;

import java.io.IOException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
/**
 *
 * @author Tasos
 */
@Path("cidoc/metric1")
public class Cidoc_1 {
    Ontology cidoc = new Ontology("cidoc");
    @Context
    private UriInfo context;
    public String Jsonstring;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws IOException { 
        cidoc.setQuerySpaql("SELECT (COUNT(DISTINCT ?class) as ?countClass)\n" +"WHERE {\n" +"{\n" +"[] rdf:type ?class\n" +"}UNION{\n" +"?class rdf:type owl:Class\n" +"}UNION{\n" +"?class rdf:type rdfs:Class\n" +"}\n" +"}"); //Sparql query
        cidoc.setConnection(); //Get the data and write them in String with json format
        
        
        cidoc.setQuerySpaql("SELECT (COUNT(DISTINCT ?objectProperty) as ?countObject)\n" +"WHERE {\n" +"{\n" +"[] rdf:type ?objectProperty\n" +"}UNION{\n" +"?objectProperty rdf:type owl:ObjectProperty\n" +"}UNION{\n" +"?objectProperty rdf:type rdfs:ObjectProperty\n" +"}\n" +"}");
        cidoc.setConnection(); //Get the data and write them in String with json format
        
        cidoc.setQuerySpaql("SELECT (COUNT(DISTINCT ?datatypeProperty) as ?countDataType)\n" +"WHERE {\n" +"{\n" +"[] rdf:type ?datatypeProperty\n" +"}UNION{\n" +"?datatypeProperty rdf:type owl:DataTypeProperty\n" +"}UNION{\n" +"?datatypeProperty rdf:type rdfs:DataTypeProperty\n" +"}\n" +"}");
        cidoc.setConnection(); //Get the data and write them in String with json format
        
        cidoc.setQuerySpaql("SELECT (COUNT(DISTINCT ?individual) as ?countIndividual)\n" +"WHERE {\n" +"{\n" +"[] rdf:type ?individual\n" +"}UNION{\n" +"?individual rdf:type owl:NamedIndividual\n" +"}UNION{\n" +"?individual rdf:type rdfs:NamedIndividual\n" +"}\n" +"}");
        cidoc.setConnection(); //Get the data and write them in String with json format
        
        //TODO return proper representation object
        return cidoc.getResponsestring();
    }

}
