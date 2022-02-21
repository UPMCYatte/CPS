package utils.rules.sections.Samu;

import java.util.ArrayList;

import utils.correlation.CorrelatorStateI;
import utils.correlation.Samu.HealthCorrelatorStateI;
import utils.events.commons.health.ConsciousFall;
import utils.events.commons.health.InterventionEvent;
import utils.events.interfaces.EventBaseI;
import utils.events.interfaces.EventI;
import utils.rules.interfaces.RuleI;

public class RuleS13 implements RuleI {

	@Override
	public ArrayList<EventI> match(EventBaseI eb) {
		EventI cf = eb.getEvent(0);
		if(cf instanceof ConsciousFall) {
			ArrayList<EventI> me = new ArrayList<>();
			me.add(cf);
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
		HealthCorrelatorStateI hc = (HealthCorrelatorStateI)c;
		return hc.isMedicAvalaible();
	}

	@Override
	public void act(ArrayList<EventI> matchedEvents, CorrelatorStateI c) {
		EventI cf = matchedEvents.get(0);
		HealthCorrelatorStateI hc = (HealthCorrelatorStateI)c;
		hc.triggerMedicCall((String)cf.getPropertyValue("personId"));
	}

	@Override
	public void update(ArrayList<EventI> matchedEvents, EventBaseI eb) {
		eb.removeEvent(matchedEvents.get(0));
	}
	
}
