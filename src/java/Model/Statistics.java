package Model;

public class Statistics {

    /*
    Sparql Queries
    1. ---------- Count the number of unique classes ----------
        "SELECT (COUNT(DISTINCT ?class) as ?countClass)\n" +
        "WHERE {\n" +"{\n" +"[] rdf:type ?class\n" +"}UNION{\n" +
        "?class rdf:type owl:Class\n" +"}UNION{\n" +
        "?class rdf:type rdfs:Class\n" +"}\n" +"}"
    2. ---------- Count the nubmer of objectProperties ----------
        "SELECT (COUNT(DISTINCT ?objectProperty) as ?countObject)\n" + 
        "WHERE {\n" +"{\n" +"[] rdf:type ?objectProperty\n" +
        "}UNION{\n" +"?objectProperty rdf:type owl:ObjectProperty\n" +
        "}UNION{\n" +"?objectProperty rdf:type rdfs:ObjectProperty\n" + "}\n" +"}"
    3. ---------- Count the number of datatypeProperties ----------
        "SELECT (COUNT(DISTINCT ?datatypeProperty) as ?countDataType)\n" + 
        "WHERE {\n" + "{\n" + "[] rdf:type ?datatypeProperty\n" + "}UNION{\n" + 
        "?datatypeProperty rdf:type owl:DataTypeProperty\n" + "}UNION{\n" + 
        "?datatypeProperty rdf:type rdfs:DataTypeProperty\n" + "}\n" + "}"
    4. ---------- Count the number of individuals ----------
        "SELECT (COUNT(DISTINCT ?individual) as ?countIndividual)\n" + 
        "WHERE {\n" + "{\n" + "[] rdf:type ?individual\n" + "}UNION{\n" + 
        "?individual rdf:type owl:NamedIndividual\n" + "}UNION{\n" + 
        "?individual rdf:type rdfs:NamedIndividual\n" + "}\n" + "}";
    5. ---------- Count the number of axioms/attributes ----------
        "SELECT distinct (count(?Subject) as ?countAxioms)\n" +
        "WHERE {\n" +"[] a ?Subject\n" +"}"
    6. ---------- Count the number of relationships ----------
        "SELECT (COUNT(*) as ?countTriples)\n" + 
        "WHERE {" + "?s ?p ?o\n" +"}"
    7. ---------- Count the number of all classes ----------
        "SELECT (COUNT(?class) as ?countClass)\n" + 
        "WHERE {\n" + "{\n" + "[] rdf:type ?class\n" + 
        "}UNION{\n" + "?class rdf:type owl:Class\n" + 
        "}UNION{\n" + "?class rdf:type rdfs:Class\n" + 
        "}\n" + "}";
    */
    public String stat1;
    public String stat2;
    public String stat3;
    public String stat4;
    public String stat5;
    public String stat6;
    public String stat7;

    public Statistics() {
        this.stat1 = "SELECT (COUNT(DISTINCT ?class) as ?countClass)\n" + "WHERE {\n" + "{\n" + "[] rdf:type ?class\n" + "}UNION{\n" + "?class rdf:type owl:Class\n" + "}UNION{\n" + "?class rdf:type rdfs:Class\n" + "}\n" + "}";
        this.stat2 = "SELECT (COUNT(DISTINCT ?objectProperty) as ?countObject)\n" + "WHERE {\n" + "{\n" + "[] rdf:type ?objectProperty\n" + "}UNION{\n" + "?objectProperty rdf:type owl:ObjectProperty\n" + "}UNION{\n" + "?objectProperty rdf:type rdfs:ObjectProperty\n" + "}\n" + "}";
        this.stat3 = "SELECT (COUNT(DISTINCT ?datatypeProperty) as ?countDataType)\n" + "WHERE {\n" + "{\n" + "[] rdf:type ?datatypeProperty\n" + "}UNION{\n" + "?datatypeProperty rdf:type owl:DataTypeProperty\n" + "}UNION{\n" + "?datatypeProperty rdf:type rdfs:DataTypeProperty\n" + "}\n" + "}";
        this.stat4 = "SELECT (COUNT(DISTINCT ?individual) as ?countIndividual)\n" + "WHERE {\n" + "{\n" + "[] rdf:type ?individual\n" + "}UNION{\n" + "?individual rdf:type owl:NamedIndividual\n" + "}UNION{\n" + "?individual rdf:type rdfs:NamedIndividual\n" + "}\n" + "}";
        this.stat5 = "SELECT distinct (count(?Subject) as ?countAxioms)" + "WHERE {" + "[] a ?Subject" + "}";
        this.stat6 = "SELECT (COUNT(*) as ?countTriples)" + "WHERE {" + "?s ?p ?o" +"}";
        this.stat7 = "SELECT (COUNT(?class) as ?countAllClass)\n" + "WHERE {\n" + "{\n" + "[] rdf:type ?class\n" + "}UNION{\n" + "?class rdf:type owl:Class\n" + "}UNION{\n" + "?class rdf:type rdfs:Class\n" + "}\n" + "}";
    }

    public String getStat1() {
        return this.stat1;
    }

    public String getStat2() {
        return this.stat2;
    }

    public String getStat3() {
        return this.stat3;
    }

    public String getStat4() {
        return this.stat4;
    }

    public String getStat5() {
        return this.stat5;
    }
    
    public String getStat6() {
        return stat6;
    }
    
    public String getStat7() {
        return stat7;
    }
}
