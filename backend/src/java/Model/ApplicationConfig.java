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
        resources.add(Bfo.BfoPitfalls.class);
        resources.add(Bfo.BfoStats.class);
        resources.add(Bfo.bfo_1.class);
        resources.add(Bfo.bfo_2.class);
        resources.add(Bfo.bfo_3.class);
        resources.add(Bfo.bfo_4.class);
        resources.add(Bfo.bfo_5.class);
        resources.add(Bfo.bfo_6.class);
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
        resources.add(Obi.obiPitfalls.class);
        resources.add(Obi.obiStats.class);
        resources.add(Obi.obi_1.class);
        resources.add(Obi.obi_2.class);
        resources.add(Obi.obi_3.class);
        resources.add(Obi.obi_4.class);
        resources.add(Obi.obi_5.class);
        resources.add(Obi.obi_6.class);
    }
    
}
