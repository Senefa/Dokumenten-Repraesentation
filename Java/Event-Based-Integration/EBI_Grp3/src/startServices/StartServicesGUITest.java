package startServices;

import java.util.logging.Level;

import eventprocessing.agent.AbstractAgent;
import eventprocessing.consume.kafka.ConsumerSettings;
import eventprocessing.consume.spark.streaming.NoValidAgentException;
import eventprocessing.consume.spark.streaming.StreamingExecution;
import eventprocessing.event.AbstractEvent;
import eventprocessing.event.Property;
import eventprocessing.produce.kafka.Despatcher;
import eventprocessing.produce.kafka.ProducerSettings;
import eventprocessing.utils.factory.AbstractFactory;
import eventprocessing.utils.factory.FactoryProducer;
import eventprocessing.utils.factory.FactoryValues;
import eventprocessing.utils.factory.LoggerFactory;
import eventprocessing.utils.mapping.MessageMapper;
import hdm.developmentlab.ebi.eve_implementation.events.TimeReference;
import hdm.developmentlab.ebi.eve_implementation.sessionContextService.SessionContextAgent;

/**
 * Startpunkt der Anwendung.
 * 
 * hier werden die Agenten initialisiert und die Sparkumgebung ausgefÃ¼hrt.
 * 
 * @author RobertRapp
 *
 */
public class StartServicesGUITest {


		
		 // FÃ¼r die Versendung der DemoEvents an das Topic nötig.
	private static Despatcher despatcher = null;
	// wandelt die Events in Nachrichten um.
	private static final MessageMapper messageMapper = new MessageMapper();
	private static AbstractFactory eventFactory = FactoryProducer.getFactory(FactoryValues.INSTANCE.getEventFactory());
	private static AbstractFactory agentFactory = FactoryProducer.getFactory(FactoryValues.INSTANCE.getAgentFactory());
	
	
	public static void main(String[] args) throws NoValidAgentException, InterruptedException
	 {
		despatcher = new Despatcher(new ProducerSettings("10.142.0.2","9092"));
		AbstractAgent sessionContextAgent = new SessionContextAgent();
		
		sessionContextAgent.setConsumerSettings(new ConsumerSettings("10.142.0.2","9092", "GUiTest"));
		sessionContextAgent.setProducerSettings(new ProducerSettings("10.142.0.2","9092"));
		
			
	
	
		//StreamingExecution.add(activityService);
		//StreamingExecution.add(protocolService);
		StreamingExecution.add(sessionContextAgent);

		
		Runnable myRunnable = new Runnable() {
			public void run() {
				try {
					publishDemoEvents();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		// Thread wird erzeugt und gestartet
		Thread thread = new Thread(myRunnable);
		thread.start();

		
		StreamingExecution.start();
	}

	
	private static void publish(AbstractEvent event, String topic) {
		
		String message = messageMapper.toJSON(event);	
		if(message != null && topic != null) {
			despatcher.deliver(message, topic);	
		}
		
	}

	
	private static void publishDemoEvents() throws InterruptedException {		
			
			for (int i = 0; i < 20; i++) {
				
				
				AbstractEvent event = eventFactory.createEvent("AtomicEvent");
				event.setType("DocProposalEvent");
				Property<String> projekt = new Property<String>("projekt", "Highnet");
				Property<String> thema = new Property<String>("thema", "Kosten");
				Property<String> user = new Property<String>("user", "Robert Rapp"+i);
				Property<String> user2 = new Property<String>("user", "Detlef Gabe"+i);
				Property<TimeReference> timereference = new Property<TimeReference>("timereference", TimeReference.INSTANCE);
				event.add(projekt);			
				event.add(thema);			
				event.add(user);			
				event.add(user2);			
				event.add(timereference);			
				
				if( i == 10) {
					Property<String> context = new Property<String>("contextupdate", "Das Token ändert den Kontext");
					event.add(context);
				}
				publish(event,"test");
				
				java.util.logging.Logger logger = LoggerFactory.getLogger("StartServices!");				
				logger.log(Level.WARNING, "SESSIONSTATE AUF SESSIONSTATE GEPUSHT");
				
//				AbstractEvent event2 = eventFactory.createEvent("AtomicEvent");
//				event2.setType("SpeedEvent");
//				Property<String> repo = new Property<String>("REPORT", "EVENT GEHT INS DIAGNOSIS IP");
//				event2.add(repo);				
//				publish(event2,"SessionState");					
//				logger.log(Level.WARNING, "SESSIONSTATE AUF SESSIONSTATE GEPUSHT");				
				Thread.sleep(1000);
				
			}
			

			/*
			TokenEvent event3 = (TokenEvent) new TokenEvent();
			event.setSessionID("2");
			Property<Long> sessionStart = new Property<Long>("sessionStart", System.currentTimeMillis());
			event3.add(sessionStart);
			int zaehler = 5;
			for(int i = 0 ; i < zaehler; i++) {
				Thread.sleep(ShowcaseValues.INSTANCE.getThreadSleep());
				publish(event3,"test");
				Logger l = LoggerFactory.getLogger("PUBLISHDEMOEVENTS");
				l.log(Level.WARNING, "Event wurde direkt durch Dispatcher auf Test gepusht");
			}
			
					
			publish(event3,"test");
			Logger l = LoggerFactory.getLogger("PUBLISHDEMOEVENTS");
			l.log(Level.WARNING, "Event wurde direkt durch Dispatcher auf Test gepusht");
			}
			
			*/
	}	 
	
}