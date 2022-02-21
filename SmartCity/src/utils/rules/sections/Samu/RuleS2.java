package utils.rules.sections.Samu;

import java.util.ArrayList;

import utils.correlation.CorrelatorStateI;
import utils.correlation.Samu.AmbulanceCorrelatorStateI;
import utils.correlation.Samu.HealthCorrelatorStateI;
import utils.events.commons.AbsolutePosition;
import utils.events.commons.HEType;
import utils.events.commons.health.HealthEvent;
import utils.events.interfaces.EventBaseI;
import utils.events.interfaces.EventI;
import utils.rules.interfaces.RuleI;

public class RuleS2 implements RuleI {
	
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
		return false;
	}

	@Override
	public boolean filter(ArrayList<EventI> matchedEvents, CorrelatorStateI c) {
		HealthCorrelatorStateI hc = (HealthCorrelatorStateI) c;
		HealthEvent he = (HealthEvent) matchedEvents.get(0);
		return (!hc.isAmbulanceAvalaible() && hc.checkInSamuZone(he.getPosition()) && hc.isEMSCenterNearest());		
	}

	@Override
	public void act(ArrayList<EventI> matchedEvents, CorrelatorStateI c) {
		HealthEvent he = (HealthEvent) matchedEvents.get(0);
		HealthCorrelatorStateI hc = (HealthCorrelatorStateI) c;
		
		String personId = (String) he.getPropertyValue("personId");
		AbsolutePosition p = he.getPosition();
		
		HealthEvent interventionRequest = new HealthEvent(personId, p, HEType.urgence);
		hc.sendEvent(interventionRequest);
	}

	@Override
	public void update(ArrayList<EventI> matchedEvents, EventBaseI eb) {
		eb.removeEvent(matchedEvents.get(0));
	}
}
