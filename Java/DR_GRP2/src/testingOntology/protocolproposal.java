
public class protocolproposal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String participant1 = "jennifer";
		 String participant2 = "vanessa";
		 getQuery(participant1, participant2);
	}
	public static void getQuery(String participant1, String participant2) {
		
		

				 
		 String sQuery = "PREFIX asdf: <http://www.semanticweb.org/jennifertran/ontologies/2018/0/dokumentenRepraesentation#>\n" + 
		 		"PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n" + 
		 		"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" + 
		 		"PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" + 
		 		"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" + 
		 		"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" + 
		 		"\n" + 
		 		"\n" + 
		 		"SELECT DISTINCT ?Participant1 ?Participant2 ?Conversation ?Document ?FileName ?DocumentType ?URL ?Category ?Project ?LastChangeDate\n" + 
		 		"WHERE {\n" + 
		 		" 	?Conversation asdf:ConversationHasMember ?Participant1 .\n" + 
		 		"  	?Conversation asdf:ConversationHasMember ?Participant2.\n" + 
		 		"\n" + 
		 		"	?Participant1 asdf:Keyword ?Keyword1 . "
		 		+ "FILTER regex( str(?Keyword1), \""
		 		+ participant1
		 		+ "\").\n" + 
		 		"	?Participant2 asdf:Keyword ?Keyword2 . "
		 		+ "FILTER regex( str(?Keyword2), \""
		 		+ participant2
		 		+ "\").\n" + 
		 		"\n" + 
		 		"?Conversation asdf:HasTopicOf ?Project.\n" + 
		 		"?Conversation asdf:IsDescribedByProtocol ?Document.\n" + 
		 		"?Document asdf:LastChangeDate ?LastChangeDate;\n" + 
		 		"          asdf:FileName ?FileName; \n" + 
		 		"			asdf:DocumentType ?DocumentType; \n"	+
		 		"          asdf:URL ?URL;\n" + 
		 		"          asdf:FileID ?FileID;\n" + 
		 		"          rdf:type ?Category .\n" + 
		 		"?Category rdf:type owl:Class .\n" + 
		 		"}\n" + 
		 		"ORDER BY DESC(?LastChangeDate)";
		 
		getProposal(sQuery);
	}
	
	
	
	public static String getProposal(String sQuery) {
		QueryExecution queryExecution = QueryExecutionFactory.sparqlService("http://localhost:3030/ds" , sQuery);
		
		ResultSet resultSet = queryExecution.execSelect();		
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ResultSetFormatter.outputAsJSON(outputStream, resultSet);
		
		String json = new String(outputStream.toByteArray());
		System.out.println(json);
		queryExecution.close();
		return json;
	}

}
