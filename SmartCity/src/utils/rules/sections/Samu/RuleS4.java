package utils.rules.sections.Samu;

import java.util.ArrayList;

import utils.correlation.CorrelatorStateI;
import utils.correlation.Samu.HealthCorrelatorStateI;
import utils.events.commons.health.HealthEvent;
import utils.events.interfaces.EventBaseI;
import utils.events.interfaces.EventI;
import utils.rules.interfaces.RuleI;

public class RuleS4 implements RuleI {

	@Override
	public ArrayList<EventI> match(EventBaseI eb) {
		EventI healthAlarm = eb.getEvent(0);
		if(healthAlarm instanceof HealthEvent && healthAlarm.getPropertyValue("type").equals("medicale")) {
			ArrayList<EventI> me = new ArrayList<>();
			me.add(healthAlarm);
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
		HealthEvent he = (HealthEvent) matchedEvents.get(0);
		HealthCorrelatorStateI hc = (HealthCorrelatorStateI)c;
		return (hc.checkInSamuZone(he.getPosition()) && !hc.isMedicAvalaible() && hc.isEMSCenterNearest());
	}

	@Override
	public void act(ArrayList<EventI> matchedEvents, CorrelatorStateI c) {
		HealthCorrelatorStateI hc = (HealthCorrelatorStateI) c;
		hc.spreadInterventionRequest();
	}

	@Override
	public void update(ArrayList<EventI> matchedEvents, EventBaseI eb) {
		eb.removeEvent(matchedEvents.get(0));
	}

}
