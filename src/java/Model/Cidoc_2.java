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
@Path("cidoc/metric2")
public class Cidoc_2 {
    Ontology cidoc = new Ontology("cidoc");
    @Context
    private UriInfo context;
    public String Jsonstring;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws IOException {
               
        cidoc.setQuerySpaql("select distinct ?Concept where {[] a ?Concept} LIMIT 100"); //Sparql query
        cidoc.setConnection(); //Get the data and write them in String with json format

        //TODO return proper representation object
        return cidoc.getResponsestring();
    }

}