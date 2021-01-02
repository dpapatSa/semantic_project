/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Path("dublincore/metric3")
public class Dublincore_3 {
    Ontology dublincore = new Ontology("dublincore");
    @Context
    private UriInfo context;
    public String Jsonstring;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws IOException {
               
        dublincore.setQuerySpaql("select distinct ?Concept where {[] a ?Concept} LIMIT 100"); //Sparql query
        dublincore.setConnection(); //Get the data and write them in String with json format

        //TODO return proper representation object
        return dublincore.getResponsestring();
    }  
}