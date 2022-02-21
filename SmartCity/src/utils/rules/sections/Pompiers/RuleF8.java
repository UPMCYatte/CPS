package utils.rules.sections.Pompiers;

import java.util.ArrayList;

import utils.correlation.CorrelatorStateI;
import utils.correlation.Pompiers.*;
import utils.events.commons.*;
import utils.events.commons.firefight.*;
import utils.events.interfaces.*;
import utils.rules.interfaces.RuleI;

public class RuleF8 implements RuleI {

	@Override
	public ArrayList<EventI> match(EventBaseI eb) {
		//Demande d’intervention dans une maison en position p reçu de C’
		EventI fireIntervention = eb.getEvent(0);
		if(fireIntervention instanceof FInterventionEvent && fireIntervention.getPropertyValue("type").equals("maison")) {
			ArrayList<EventI> matchedEvents = new ArrayList<>();
			matchedEvents.add(fireIntervention);
			return matchedEvents;
		}
		return null;
	}

	@Override
	public boolean correlate(ArrayList<EventI> matchedEvents) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean filter(ArrayList<EventI> matchedEvents, CorrelatorStateI c) {
		/*grande échelle non disponible en C
		  caserne C” est la suivante la plus près de p dont ne provient pas la demande
		*/
		FireCorrelatorStateI fc = (FireCorrelatorStateI)c;
		return !fc.isTruckAvailable() && fc.isFireStationNearest() && !fc.isSender();
	}

	@Override
	public void act(ArrayList<EventI> matchedEvents, CorrelatorStateI c) {
		//propager l’événement apparié de C à C”
		FireCorrelatorStateI fc = (FireCorrelatorStateI)c;
		fc.fireInterventionBroadcast();
		}
	
	@Override
	public void update(ArrayList<EventI> matchedEvents, EventBaseI eb) {		
		/*retirer l’événement apparié*/
		eb.removeEvent(matchedEvents.get(0));
	}
}
