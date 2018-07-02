package interestprofiles;

import eventprocessing.interestprofile.AbstractInterestProfile;
import java.awt.Checkbox;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.speechTokens.EvE.events.SentenceEvent;
import com.speechTokens.EvE.events.WatsonEvent;
import com.speechTokens.tokenizer.Chunker;
import com.speechTokens.tokenizer.DetectTermin;
import com.speechTokens.tokenizer.Tokenization;

import eventprocessing.agent.NoValidEventException;
import eventprocessing.agent.NoValidTargetTopicException;
import eventprocessing.agent.interestprofile.AbstractInterestProfile;
import eventprocessing.event.AbstractEvent;
import eventprocessing.event.Property;
import eventprocessing.utils.factory.AbstractFactory;
import eventprocessing.utils.factory.FactoryProducer;
import eventprocessing.utils.factory.FactoryValues;
import eventprocessing.utils.factory.LoggerFactory;
import eventprocessing.utils.model.EventUtils;

public class Semantic extends AbstractInterestProfile{

	private static AbstractFactory eventFactory = FactoryProducer.getFactory(FactoryValues.INSTANCE.getEventFactory());
	private static final long serialVersionUID = -6108185466150892913L;
	private static Logger LOGGER = LoggerFactory.getLogger(FeedbackIP.class);

	/**
	 * Verarbeitung des empfangenen Events.
	 * 
	 * @param event
	 */
	@Override
	public void doOnReceive(AbstractEvent event) {		
		//Chunker Objekt von Token abfangen
		Chunker chunkerObject = (Chunker) 	EventUtils.findPropertyByKey(event, "Chunks").getValue();
		// Alle chunks auslesen, die übergeben sind
		ArrayList<String> list = chunkerObject.readChunks();
		// Chunk in der Ontologie durchsuchen
		for (int i = 0; i < list.size(); i++) {

			String jsonFile = getSemantic(list.get(i)); 
			chunkerObject.addSemanticToChunk(list.get(i), jsonFile);
		}
		for (int i = 0; i < chunkerObject.size; i++) {
			chunkerObject.getSemanticAt(i);	
		}
		
		
		
		// Pushen eines Events
		AbstractEvent feedbackEvent = eventFactory.createEvent("AtomicEvent");
		feedbackEvent.setType("FeedbackEvent");
		// Eigenschaften von Token wieder hinzufügen
		feedbackEvent.add(new Property<>("UserID",EventUtils.findPropertyByKey(event, "UserID")));
		feedbackEvent.add(new Property<>("Timestamp",EventUtils.findPropertyByKey(event, "Timestamp")));
		feedbackEvent.add(new Property<>("SessionID",EventUtils.findPropertyByKey(event, "SessionID")));
		feedbackEvent.add(new Property<>("Sentence",EventUtils.findPropertyByKey(event, "SentenceID")));
		//Unsere Semantic übergeben
		feedbackEvent.add(new Property<>("Chunks",chunkerObject));
		
		try {
			//Neue FeedbackEvent
			this.getAgent().send(feedbackEvent, "SemanticChunks");
			
		} catch (NoValidEventException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoValidTargetTopicException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
