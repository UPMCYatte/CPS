package utils.rules.sections.Samu;

import java.util.ArrayList;

import utils.correlation.CorrelatorStateI;
import utils.correlation.Samu.HealthCorrelatorStateI;
import utils.events.commons.health.HealthEvent;
import utils.events.commons.Event;
import utils.events.commons.health.*;
import utils.events.interfaces.EventBaseI;
import utils.events.interfaces.EventI;
import utils.rules.interfaces.RuleI;

public class RuleS9 implements RuleI {

	@Override
	public ArrayList<EventI> match(EventBaseI eb) {
		EventI ie = eb.getEvent(0); //InterventionEvent
		if(ie instanceof InterventionEvent && ie.getPropertyValue("type").equals("urgence")) 
			if(ie instanceof InterventionEvent) {
				ArrayList<EventI> me = new ArrayList<>();
				me.add(ie);
				return me;
		}
		return null;
	}

	@Override
	public boolean correlate(ArrayList<EventI> matchedEvents) {
		return false;
	}

	@Override
	public boolean filter(ArrayList<EventI> matchedEvents, CorrelatorStateI c) {
		HealthCorrelatorStateI hc = (HealthCorrelatorStateI)c;
		return !hc.isAmbulanceAvalaible();
	}

	@Override
	public void act(ArrayList<EventI> matchedEvents, CorrelatorStateI c) {
		HealthCorrelatorStateI hc = (HealthCorrelatorStateI)c;
		hc.triggerAmbulanceIntervention();
	}

	@Override
	public void update(ArrayList<EventI> matchedEvents, EventBaseI eb) {
		eb.removeEvent(matchedEvents.get(0));
	}

}
