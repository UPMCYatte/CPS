package utils.rules.sections.Samu;

import java.util.ArrayList;

import utils.correlation.CorrelatorStateI;
import utils.correlation.Samu.EMSStatusCorrelatorStateI;
import utils.events.commons.health.AmbulanceEvent;
import utils.events.interfaces.EventBaseI;
import utils.events.interfaces.EventI;
import utils.rules.interfaces.RuleI;

public class RuleS16 implements RuleI {

	@Override
	public ArrayList<EventI> match(EventBaseI eb) {
		EventI ae = eb.getEvent(0);
		if(ae instanceof AmbulanceEvent && ae.getPropertyValue("Availability").equals("no")) {
			ArrayList<EventI> me = new ArrayList<>();
			me.add(ae);
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
		EMSStatusCorrelatorStateI ec = (EMSStatusCorrelatorStateI) c;
		ec.AmbulanceAvailabilityOff();
	}

	@Override
	public void update(ArrayList<EventI> matchedEvents, EventBaseI eb) {
		eb.removeEvent(matchedEvents.get(0));
	}
	
}
