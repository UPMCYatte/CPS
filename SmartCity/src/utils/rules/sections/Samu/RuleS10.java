package utils.rules.sections.Samu;

import java.util.ArrayList;

import utils.correlation.CorrelatorStateI;
import utils.correlation.Samu.HealthCorrelatorStateI;
import utils.events.commons.health.InterventionEvent;
import utils.events.interfaces.EventBaseI;
import utils.events.interfaces.EventI;
import utils.rules.interfaces.RuleI;

public class RuleS10 implements RuleI {

	@Override
	public ArrayList<EventI> match(EventBaseI eb) {
		EventI ie = eb.getEvent(0);
		if(ie instanceof InterventionEvent && ie.getPropertyValue("type").equals("urgence")) {
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
		return hc.isAmbulanceAvalaible() && !hc.isEMSSender();
		//S’ est un centre SAMU dont ne provient pas la demande
		//Voir plus comment est géré l'envoi et reception des EMS 
	}

	@Override
	public void act(ArrayList<EventI> matchedEvents, CorrelatorStateI c) {
		// Propager l'évenement apparié de S à S'
	}

	@Override
	public void update(ArrayList<EventI> matchedEvents, EventBaseI eb) {	
		eb.removeEvent(matchedEvents.get(0));
	}

}
