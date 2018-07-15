package startJenaFuseki;

import org.apache.jena.query.Dataset;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.sparql.core.DatasetImpl;
import org.apache.jena.fuseki.embedded.FusekiServer;


public class StartJenaFuseki {

	public static void main(String[] args) {
		
		// source: https://jena.apache.org/documentation/javadoc/fuseki2-embedded/org/apache/jena/fuseki/embedded/FusekiServer.html
		
				Model model = ModelFactory.createDefaultModel() ;
				model.read("\\Ontology\Wissensbasis- Dokumente.owl");
				Dataset ds = new DatasetImpl(model);
				FusekiServer server = FusekiServer.make(3030, "ds", ds.asDatasetGraph());
				server.start();

	}

}
