package utils.rules.sections.Samu;

import java.util.ArrayList;

import utils.correlation.CorrelatorStateI;
import utils.correlation.Samu.EMSAgencyStatusCorrelator;
import utils.correlation.Samu.HealthCorrelatorStateI;
import utils.events.commons.health.AmbulanceEvent;
import utils.events.commons.health.ConsciousFall;
import utils.events.commons.health.InterventionEvent;
import utils.events.commons.health.MedicEvent;
import utils.events.interfaces.EventBaseI;
import utils.events.interfaces.EventI;
import utils.rules.interfaces.RuleI;

public class RuleS19 implements RuleI {

	@Override
	public ArrayList<EventI> match(EventBaseI eb) {
		EventI de = eb.getEvent(0);
		if(de instanceof MedicEvent && de.getPropertyValue("Availability").equals("no")) {
			ArrayList<EventI> me = new ArrayList<>();
			me.add(de);
			return me;
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
		return false;
	}

	@Override
	public void act(ArrayList<EventI> matchedEvents, CorrelatorStateI c) {
		EMSAgencyStatusCorrelator ec = (EMSAgencyStatusCorrelator) c;
		ec.MedicAvailabilityOff();
	}

	@Override
	public void update(ArrayList<EventI> matchedEvents, EventBaseI eb) {
		eb.removeEvent(matchedEvents.get(0));
	}
	
}
