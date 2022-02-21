package utils.rules.sections.Samu;

import java.util.ArrayList;

import utils.correlation.CorrelatorStateI;
import utils.correlation.Samu.HealthCorrelatorStateI;
import utils.events.commons.health.HInterventionEvent;
import utils.events.interfaces.EventBaseI;
import utils.events.interfaces.EventI;
import utils.rules.interfaces.RuleI;

public class RuleS12 implements RuleI {

	@Override
	public ArrayList<EventI> match(EventBaseI eb) {
		EventI ie = eb.getEvent(0);
		if(ie instanceof HInterventionEvent && ie.getPropertyValue("type").equals("médicale")) {
			ArrayList<EventI> me = new ArrayList<>();
			me.add(ie);
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
		return !hc.isMedicAvalaible() && !hc.isEMSSender();
	}

	@Override
	public void act(ArrayList<EventI> matchedEvents, CorrelatorStateI c) {
		// déclencher une intervention de médecin par S
	}

	@Override
	public void update(ArrayList<EventI> matchedEvents, EventBaseI eb) {	
		eb.removeEvent(matchedEvents.get(0));
	}

}
