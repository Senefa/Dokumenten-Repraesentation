package readAndUpdateOWL;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;


/**
 * @author Jennifer Tran, Vanessa Keller, Di Cui, Aaron Humm, Finia Igel.
 * 
 */
public class V5_OWLReaderAndUpdater {	
	/**
	 * Programmeinstieg.<br>
	 * Abhaengig von dem ersten Argument wird: <br>
	 * args[0] == "-query":<br>
	 * 	<ol>	Das Ergebnis auf die in args[2] angegebene Abfrage 
	 * 		der in args[1] angegebenen Ontologie ausgegeben. </ol> 
	 * 	<ol> Siehe: {@link #printQuery(String pOWLPath, String pSPARQLPath)} </ol>
	 * 
	 * args[0] == "-update":<br>
	 * 	<ol>	Die Ontologie (args[1]) um weitere Instanzen 
	 * 		aus dem Statement (args[2]) auf den Server (args[3]) 
	 * 		erweitert.</ol>
	 * <ol> Siehe: {@link #updateOWL(String pOWLPath, String pSPARQLPath, String pServerURL)} </ol>
	 * 
	 * @param args Mindestens drei Kommandozeilenparameter:<br>
	 * 1. Flag ("-query" oder "-update"), <br>
	 * 2. OWLPath  (Pfad zur Ontologie in XML Format), <br>
	 * 3. SPARQLPath (Pfad zur SPARQL-Abfrage in ASCII Format),<br>
	 * 4. ServerPath (Pfad zum Server).
	 */
	public static void main(String[] args) {
		if(args.length <= 3){
			System.out.println("wrong arguments");
			return;
		}
		switch (args[0]) {
			case "-query": printQuery(args[1], args[2]);
				break;
			case "-update": updateOWL(args[1], args[2], args[3]);
				break;
		}
		
	}
	
	/**
	 * Liest eine uebergebene Textdatei ein und gibt diese als String zurueck.
	 * 
	 * @param pFilePath Pfad der einzulesene Datei.
	 * @return Gibt eingelesene Datei als String zurueck und endet mit newline.
	 * 		   Gibt einen leeren String zurueck wenn die Datei nicht gelesen werden kann.
	 */
	public static String readFile(String pFilePath) {
		BufferedReader bufferedReader = null;
	    StringBuilder stringBuilder = new StringBuilder();
		try {
			bufferedReader = new BufferedReader(new FileReader(pFilePath));
			bufferedReader.lines().forEach((s) -> { stringBuilder.append(s + "\n"); });	
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (stringBuilder != null && stringBuilder.toString().equals("")) {
			return "";
		} else {
			return stringBuilder.toString();
		}
	}

	/**
	 * Gibt das Ergebnis auf die Abfrage in der eingelesene Ontologie zurueck.
	 * 
	 * @param pOWLPath  Pfad zur Ontologie in XML Format.
	 * @param pSPARQLPath  Pfad zur SPARQL-Abfrage in ASCII Format.
	 */
	public static void printQuery(String pOWLPath, String pSPARQLPath) {
		System.out.println("Methode Query");
		String sQuery = readFile(pSPARQLPath);
		if (sQuery.equals("")) {
			return;
		} 
		OntModel ontologyModel = ModelFactory
				.createOntologyModel(OntModelSpec.OWL_DL_MEM);
		try {
			ontologyModel.read(new FileInputStream(pOWLPath), null, "RDF/XML");
			Query query = QueryFactory.create(sQuery);
			QueryExecution queryExecution = QueryExecutionFactory.create(query,
					ontologyModel);
			ResultSet resultSet = queryExecution.execSelect();
			System.out.println("Ergebnis:");	
			while (resultSet.hasNext() == true) {
				QuerySolution querySolution = resultSet.nextSolution();
				for (int i = 0; i < resultSet.getResultVars().size(); i++) {
					String result = resultSet.getResultVars().get(i);
					String[] temp = querySolution.get(result).toString().split("#");
					System.out.println(temp[1]);
				}
			}
			queryExecution.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Erweitert die Ontologie um weitere Instanzen 
	 * auf dem angegebenen Server.
	 * 
	 * @param pOWLPath Pfad zur Ontologie in XML Format.
	 * @param pSPARQLPath Pfad zur SPARQL-Statement in ASCII Format.
	 * @param pServerURL URL zum Server.
	 */
	public static void updateOWL(String pOWLPath, String pSPARQLPath, String pServerURL) {
		System.out.println("Methode Update");
		String stringBuilder = readFile(pSPARQLPath);
		System.out.println(stringBuilder);
		try {
			String randomID = UUID.randomUUID().toString();
			UpdateProcessor updateProcessor = UpdateExecutionFactory
					.createRemote(UpdateFactory.create(String.format(
							stringBuilder, randomID)),
							pServerURL
							);
			updateProcessor.execute();
			System.out.println("OWL updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}