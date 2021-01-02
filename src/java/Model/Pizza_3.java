/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.IOException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Tasos
 */
@Path("pizza/metric3")
public class Pizza_3 {
    
Ontology pizza = new Ontology("pizza");
    @Context
    private UriInfo context;
    public String Jsonstring;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws IOException {
               
        pizza.setQuerySpaql("select distinct ?Concept where {[] a ?Concept} LIMIT 100"); //Sparql query
        pizza.setConnection(); //Get the data and write them in String with json format

        //TODO return proper representation object
        return pizza.getResponsestring();
    }

}