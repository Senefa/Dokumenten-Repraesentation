package documentProposalService;

import eventprocessing.agent.AbstractAgent;
import hdm.developmentlab.ebi.eve_implementation.activityService.AbstractInterestProfile;
import hdm.developmentlab.ebi.eve_implementation.activityService.IsEventType;
import hdm.developmentlab.ebi.eve_implementation.activityService.NoValidConsumingTopicException;
import hdm.developmentlab.ebi.eve_implementation.activityService.NoValidInterestProfileException;
import hdm.developmentlab.ebi.eve_implementation.activityService.interestprofiles.Document;

public class documentProposalAgent extends AbstractAgent{
	
	private static final long serialVersionUID = 1L;

	protected void doOnInit() {
		
		this.setId("DocumentProposalAgent");
		/*
		 * Angabe der Topics, die konsumiert werden sollen. Es können mehrere Topics
		 * angegeben werden.
		 */
		try {
			this.add("DocumentProposal");
		} catch (NoValidConsumingTopicException e) {
			e.printStackTrace();
		}
		
		/*
		 * Fügt dem Agenten ein InteressenProfil hinzu. Ein Agent kann mehrere
		 * InteressenProfile besitzen
		 */
		try {
			AbstractInterestProfile ip = new DocumentProposalIP();
			ip.add(new IsEventType("DocumentProposalEvent"));
			this.add(ip);
		
		} catch (NoValidInterestProfileException e1) {
			e1.printStackTrace();
		}
		
	}

}
