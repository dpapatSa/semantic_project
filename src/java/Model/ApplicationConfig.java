/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Tasos
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(Cidoc.CidocPitfalls.class);
        resources.add(Cidoc.CidocStats.class);
        resources.add(Cidoc.Cidoc_1.class);
        resources.add(Cidoc.Cidoc_2.class);
        resources.add(Cidoc.Cidoc_3.class);
        resources.add(Cidoc.Cidoc_4.class);
        resources.add(Cidoc.Cidoc_5.class);
        resources.add(Cidoc.Cidoc_6.class);
        resources.add(Dublincore.DublincorePitfalls.class);
        resources.add(Dublincore.DublincoreStats.class);
        resources.add(Dublincore.Dublincore_1.class);
        resources.add(Dublincore.Dublincore_2.class);
        resources.add(Dublincore.Dublincore_3.class);
        resources.add(Dublincore.Dublincore_4.class);
        resources.add(Dublincore.Dublincore_5.class);
        resources.add(Dublincore.Dublincore_6.class);
        resources.add(Foaf.FoafPitfalls.class);
        resources.add(Foaf.FoafStats.class);
        resources.add(Foaf.Foaf_1.class);
        resources.add(Foaf.Foaf_2.class);
        resources.add(Foaf.Foaf_3.class);
        resources.add(Foaf.Foaf_4.class);
        resources.add(Foaf.Foaf_5.class);
        resources.add(Foaf.Foaf_6.class);
        resources.add(Model.CORSResponseFilter.class);
        resources.add(Musicontology.MusicontologyPitfalls.class);
        resources.add(Musicontology.MusicontologyStats.class);
        resources.add(Musicontology.Musicontology_1.class);
        resources.add(Musicontology.Musicontology_2.class);
        resources.add(Musicontology.Musicontology_3.class);
        resources.add(Musicontology.Musicontology_4.class);
        resources.add(Musicontology.Musicontology_5.class);
        resources.add(Musicontology.Musicontology_6.class);
        resources.add(Pizza.PizzaPitfalls.class);
        resources.add(Pizza.PizzaStats.class);
        resources.add(Pizza.Pizza_1.class);
        resources.add(Pizza.Pizza_2.class);
        resources.add(Pizza.Pizza_3.class);
        resources.add(Pizza.Pizza_4.class);
        resources.add(Pizza.Pizza_5.class);
        resources.add(Pizza.Pizza_6.class);
    }
    
}
