package eventprocessing.consume.kafka.runner.logging.state;

import eventprocessing.agent.NoValidEventException;
import eventprocessing.agent.NoValidTargetTopicException;
import eventprocessing.consume.kafka.runner.logging.LoggingValues;
import eventprocessing.event.AbstractEvent;
import eventprocessing.event.Property;
import eventprocessing.utils.factory.AbstractFactory;
import eventprocessing.utils.factory.FactoryProducer;
import eventprocessing.utils.factory.FactoryValues;

/**
 * Zustand für das Reporting aller gesendeten Events.
 * 
 * @author IngoT
 *
 */
public class CountSendState extends CountState {

	private static final long serialVersionUID = -4430325373423724244L;
	private static AbstractFactory eventFactory = FactoryProducer.getFactory(FactoryValues.INSTANCE.getEventFactory());

	/**
	 * Methode die im Zustand CountSendState ausgeführt wird.
	 */
	@Override
	public void run() {
		// Erzeugung des Events für das Reporting
		AbstractEvent event = eventFactory.createEvent(FactoryValues.INSTANCE.getAtomicEvent());
		event.setType("CountSend");
		// Befüllen des Events mit AgentName sowie dem Counter aller gesendeten Events.
		event.add(new Property<String>("AgentName", this.getAgent().getId()));
		this.getCountedEvents().forEach(countedEvent -> {
			event.add(new Property<AbstractEvent>("CountedEvent", countedEvent));
		});
		
		// Senden des Events an das Zieltopic
		try {
			this.getAgent().send(event, LoggingValues.INSTANCE.getLoggingTopic());
		} catch (NoValidEventException e) {
			e.printStackTrace();
		} catch (NoValidTargetTopicException e) {
			e.printStackTrace();
		}
		// setzt den Counter wieder auf 0 zurück
		resetCounter();
	}

}
