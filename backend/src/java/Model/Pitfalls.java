package Model;

public class Pitfalls {

    /*
    Sparql Queries
    1. ---------- Missing Annotations ----------
                        SELECT * WHERE {
                            ?individual rdf:type ?type . 
                            OPTIONAL { ?type rdfs:subClassOf ?class 
                            } 
                            ORDER BY ?class

    2. ---------- Creating unconnected ontology elements ----------
                    select ?class {
                        { ?class a owl:Class } 
                        minus { ?class <http://www.w3.org/2002/07/owl#AnnotationProperty> ?def }}

     */
    public String pitfall1;
    public String pitfall2;
    public String pitfall3;
    public String pitfall4;

    public Pitfalls() {
        this.pitfall1 = "SELECT * WHERE {?individual rdf:type ?type . OPTIONAL { ?type rdfs:subClassOf ?class }} ORDER BY ?class";
        this.pitfall2 = "select ?class {{ ?class a owl:Class } minus { ?class <http://www.w3.org/2002/07/owl#AnnotationProperty> ?def }}";
    //    this.pitfall3 = 
    //    this.pitfall4 =  
                }
    
    public String getPitfall1() {
        return this.pitfall1;
    }

    public String getPitfall2() {
        return this.pitfall2;
    }

//    public String getPitfall3() {
//        return this.pitfall3;
//    }
//
//    public String getPitfall4() {
//        return this.pitfall4;
//    }

}
