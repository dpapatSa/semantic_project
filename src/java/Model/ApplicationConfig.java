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
        resources.add(Model.CidocStats.class);
        resources.add(Model.Cidoc_1.class);
        resources.add(Model.Cidoc_2.class);
        resources.add(Model.Cidoc_3.class);
        resources.add(Model.DublincoreStats.class);
        resources.add(Model.Dublincore_1.class);
        resources.add(Model.Dublincore_2.class);
        resources.add(Model.Dublincore_3.class);
        resources.add(Model.FoafStats.class);
        resources.add(Model.Foaf_1.class);
        resources.add(Model.Foaf_2.class);
        resources.add(Model.Foaf_3.class);
        resources.add(Model.MusicontologyStats.class);
        resources.add(Model.Musicontology_1.class);
        resources.add(Model.Musicontology_2.class);
        resources.add(Model.Musicontology_3.class);
        resources.add(Model.PizzaStats.class);
        resources.add(Model.Pizza_1.class);
        resources.add(Model.Pizza_2.class);
        resources.add(Model.Pizza_3.class);
    }
    
}
