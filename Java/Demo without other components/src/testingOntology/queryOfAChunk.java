package testingOntology;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;

/**
 * @author Jennifer Tran, Vanessa Keller, Di Cui, Aaron Humm, Finia Igel.
 * 
 */

public class queryOfAChunk {

	// Programmstart
	
	public static void main(String[] args) {
		String chunk = "cost";
		getSemantic(chunk);
	}
	
		/**
	 * Erstellt die SPARQL-Abfrage aus Bausteinen.
	 * 
	 * @param chunk von der ST.
	 * @return Gibt die Antwort aus der SPARQL-Abfrage in der Ontologie als String zurueck.
	 * 		
	 */
	
	public static String getSemantic(String chunk) {
		System.out.println("Start der Semantic Suche");
		String keyword = chunk.toLowerCase();
		System.out.println("keyword: " + keyword);
		String sQuery = 
				"\n" + 
				"PREFIX asdf: <http://www.semanticweb.org/jennifertran/ontologies/2018/0/dokumentenRepraesentation#>\n" + 
				"PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n" + 
				"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" + 
				"PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" + 
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" + 
				"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" + 
				"\n" + 
				"SELECT DISTINCT ?Instanzname ?Beziehung ?Instanzname2 ?Oberklasse ?Attribut ?Name ?Keyword\n" + 
				"WHERE {\n" + 
				"?Instanzname rdf:type ?Classname .\n" + 
				"?Classname rdf:type owl:Class .\n" + 
				"?Classname rdfs:subClassOf ?Oberklasse .\n" + 
				"  \n" + 
				"?Instanzname ?Beziehung ?Instanzname2 .\n" + 
				"?Beziehung rdf:type owl:ObjectProperty .\n" + 
				"  \n" + 
				"?Instanzname ?Attribut ?Name.\n" + 
				"?Attribut rdf:type owl:DatatypeProperty .\n" + 
				"  \n" + 
				"FILTER regex( str(?Attribut), \"Name\" ) .\n" + 
				"\n" + 
				"\n" + 
				"  \n" + 
				"?Instanzname asdf:Keyword ?Keyword \n" + 
				"FILTER regex( str(?Keyword), \""+
				keyword + 
				"\") \n" + 
				"\n" + 
				"}";
		
		System.out.println("sQuery: \n" + sQuery);
		QueryExecution queryExecution = QueryExecutionFactory.sparqlService("http://localhost:3030/ds/" , sQuery);
		ResultSet resultSet = queryExecution.execSelect();		
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ResultSetFormatter.outputAsJSON(outputStream, resultSet);
		
		String json = new String(outputStream.toByteArray());
		System.out.println("Return: \n" + json);

		queryExecution.close();
		
		return(json);
	
	}
}
