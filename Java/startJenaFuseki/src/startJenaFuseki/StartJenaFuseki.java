package startJenaFuseki;

import org.apache.jena.fuseki.embedded.FusekiServer;
import org.apache.jena.query.Dataset;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.sparql.core.DatasetImpl;

public class StartJenaFuseki {

	public static void main(String[] args) {
		
		//source: https://jena.apache.org/documentation/fuseki2/fuseki-run.html
		Model model = ModelFactory.createDefaultModel() ;
		model.read("\\Ontology\\Wissensbasis- Dokument.owl");
		Dataset ds = new DatasetImpl(model);
		FusekiServer server = FusekiServer.make(3030, "ds", ds.asDatasetGraph());
		server.start();
		
	}

}
