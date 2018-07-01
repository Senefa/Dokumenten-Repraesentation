package owl;

import eventprocessing.agent.AbstractAgent;
import hdm.developmentlab.ebi.eve_implementation.activityService.AbstractInterestProfile; //muss geändert werden
import hdm.developmentlab.ebi.eve_implementation.activityService.IsEventType;//muss geändert werden
import hdm.developmentlab.ebi.eve_implementation.activityService.NoValidConsumingTopicException;//muss geändert werden
import hdm.developmentlab.ebi.eve_implementation.activityService.NoValidInterestProfileException;//muss geändert werden
import hdm.developmentlab.ebi.eve_implementation.activityService.interestprofiles.Chunk;//muss geändert werden

public class SemanticAgent extends AbstractAgent{
	private static final long serialVersionUID = 1L;

	protected void doOnInit() {
		
		this.setId("SemanticAgent");
		/*
		 * Angabe der Topics, die konsumiert werden sollen. Es können mehrere Topics
		 * angegeben werden.
		 */
		try {
			this.add("ChunkGeneration");
		} catch (NoValidConsumingTopicException e) {
			e.printStackTrace();
		}
		
		/*
		 * Fügt dem Agenten ein InteressenProfil hinzu. Ein Agent kann mehrere
		 * InteressenProfile besitzen
		 */
		try {
			AbstractInterestProfile ip = new SemanticChunksIP();
			ip.add(new IsEventType("FeedbackEvent"));
			this.add(ip);
		
		} catch (NoValidInterestProfileException e1) {
			e1.printStackTrace();
		}
		
	}


}
