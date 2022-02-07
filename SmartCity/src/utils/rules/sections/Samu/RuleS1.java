package utils.rules.sections.Samu;

import java.util.ArrayList;

import utils.correlation.CorrelatorStateI;
import utils.correlation.Samu.AmbulanceCorrelatorStateI;
import utils.events.commons.HealthEvent;
import utils.events.interfaces.EventBaseI;
import utils.events.interfaces.EventI;
import utils.rules.interfaces.RuleI;

public class RuleS1 implements RuleI {
	
	//Méthodes
	@Override
	public ArrayList<EventI> match(EventBaseI eb) {
		EventI he = eb.getEvent(0);
		if (he instanceof HealthEvent && he.hasProperty("type") && he.getPropertyValue("type").equals("urgence")) {
			ArrayList<EventI> matchedEvent = new ArrayList<EventI>();
			matchedEvent.add(he);
			return matchedEvent;
		}
		return null;
	}

	@Override
	public boolean correlate(ArrayList<EventI> matchedEvents) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean filter(ArrayList<EventI> matchedEvents, CorrelatorStateI c) {
		AmbulanceCorrelatorStateI as = (AmbulanceCorrelatorStateI)c;
		return (as.isAmbulanceAvalaible() && as.checkPositionInSamuZone());		
	}

	@Override
	public void act(ArrayList<EventI> matchedEvents, CorrelatorStateI c) {
		AmbulanceCorrelatorStateI as = (AmbulanceCorrelatorStateI)c;
		as.triggerAmbulanceIntervention();
	}

	@Override
	public void update(ArrayList<EventI> matchedEvents, EventBaseI eb) {
		eb.removeEvent(matchedEvents.get(0));
	}
}
