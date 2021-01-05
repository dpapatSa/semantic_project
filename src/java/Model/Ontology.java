package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Tasos
 */
public class Ontology {
    public String responsestring = "";
    public String defaultGraph;
    public String querySpaql;
    public String contextType;
    public String urlString;
    public URL url;
    public HttpURLConnection c;
    public BufferedReader in;
    public String str;

    public Ontology(String x) {
        this.setDefaultGraph("http://localhost:8890/" + x);
    }

    public void setConnection() throws IOException {
        // Ftiaxnei to aitima pou tha kanoume get ta dedomena
        this.contextType = "application/json";
        this.urlString = "http://139.91.210.25:8890/sparql?default-graph-uri=" + URLEncoder.encode(getDefaultGraph(),StandardCharsets.UTF_8.toString()) + "&query=" 
        + URLEncoder.encode(getQuerySpaql(),StandardCharsets.UTF_8.toString()) + "&format=" + URLEncoder.encode(this.contextType,StandardCharsets.UTF_8.toString()) + "&timeout=0&debug=on";
        this.url = new URL(urlString);
        this.c = (HttpURLConnection) url.openConnection();    // connecting to url
        this.c.setRequestMethod("GET");
        this.in = new BufferedReader(new InputStreamReader(c.getInputStream()));    // stream to resource
        responsestring = "";
        while ((this.str = this.in.readLine()) != null )    // reading data
        {
            this.responsestring += str + "\n";             // process the response and save it in some string or so
        }
        this.in.close();    // closing stream
        System.out.println(this.responsestring);
    }

    public String getDefaultGraph() {
        return defaultGraph;
    }

    public void setDefaultGraph(String defaultGraph) {
        this.defaultGraph = defaultGraph;
    }

    public String getResponsestring() {
        return responsestring;
    }

    public String getQuerySpaql() {
        return querySpaql;
    }

    public void setQuerySpaql(String querySpaql) {
        this.querySpaql = querySpaql;
    }

    public void setUrlString(String urlString) {
        this.urlString = urlString;
    }
}