package enrichOntologyService;

import eventprocessing.agent.AbstractAgent;
import hdm.developmentlab.ebi.eve_implementation.activityService.AbstractInterestProfile; //muss geändert werden
import hdm.developmentlab.ebi.eve_implementation.activityService.IsEventType;//muss geändert werden
import hdm.developmentlab.ebi.eve_implementation.activityService.NoValidConsumingTopicException;//muss geändert werden
import hdm.developmentlab.ebi.eve_implementation.activityService.NoValidInterestProfileException;//muss geändert werden
import hdm.developmentlab.ebi.eve_implementation.activityService.interestprofiles.XX;//muss geändert werden

public class EnrichOntologyAgent extends AbstractAgent{
	private static final long serialVersionUID = 1L;

	protected void doOnInit() {
		
		this.setId("EnrichOntologyAgent");
		/*
		 * Angabe der Topics, die konsumiert werden sollen. Es können mehrere Topics
		 * angegeben werden.
		 */
		try {
			this.add("XX"); //MUSS GEÄNDERT WERDEN
		} catch (NoValidConsumingTopicException e) {
			e.printStackTrace();
		}
		
		/*
		 * Fügt dem Agenten ein InteressenProfil hinzu. Ein Agent kann mehrere
		 * InteressenProfile besitzen
		 */
		try {
			AbstractInterestProfile ip = new TokenApplicationIP();
			ip.add(new IsEventType("EnrichOntologyEvent"));
			this.add(ip);
		
		} catch (NoValidInterestProfileException e1) {
			e1.printStackTrace();
		}
		
	}
}
