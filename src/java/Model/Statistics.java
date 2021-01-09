package Model;

public class Statistics {

    /*
    Sparql Queries
    1. ---------- Count the number of classes ----------
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
     */
    public String stat1;
    public String stat2;
    public String stat3;
    public String stat4;
    public String stat5;

    public Statistics() {
        this.stat1 = "SELECT (COUNT(DISTINCT ?class) as ?countClass)\n" + "WHERE {\n" + "{\n" + "[] rdf:type ?class\n" + "}UNION{\n" + "?class rdf:type owl:Class\n" + "}UNION{\n" + "?class rdf:type rdfs:Class\n" + "}\n" + "}";
        this.stat2 = "SELECT (COUNT(DISTINCT ?objectProperty) as ?countObject)\n" + "WHERE {\n" + "{\n" + "[] rdf:type ?objectProperty\n" + "}UNION{\n" + "?objectProperty rdf:type owl:ObjectProperty\n" + "}UNION{\n" + "?objectProperty rdf:type rdfs:ObjectProperty\n" + "}\n" + "}";
        this.stat3 = "SELECT (COUNT(DISTINCT ?datatypeProperty) as ?countDataType)\n" + "WHERE {\n" + "{\n" + "[] rdf:type ?datatypeProperty\n" + "}UNION{\n" + "?datatypeProperty rdf:type owl:DataTypeProperty\n" + "}UNION{\n" + "?datatypeProperty rdf:type rdfs:DataTypeProperty\n" + "}\n" + "}";
        this.stat4 = "SELECT (COUNT(DISTINCT ?individual) as ?countIndividual)\n" + "WHERE {\n" + "{\n" + "[] rdf:type ?individual\n" + "}UNION{\n" + "?individual rdf:type owl:NamedIndividual\n" + "}UNION{\n" + "?individual rdf:type rdfs:NamedIndividual\n" + "}\n" + "}";
        this.stat5 = "SELECT distinct (count(?Subject) as ?countAxioms)" + "WHERE {" + "[] a ?Subject" + "}";
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
}
