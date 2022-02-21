package utils.rules.sections.Pompiers;

import java.util.ArrayList;

import utils.correlation.CorrelatorStateI;
import utils.correlation.Pompiers.*;
import utils.events.commons.*;
import utils.events.commons.firefight.*;
import utils.events.interfaces.*;
import utils.rules.interfaces.RuleI;

public class RuleF5 implements RuleI {

	@Override
	public ArrayList<EventI> match(EventBaseI eb) {
		EventI fireIntervention = eb.getEvent(0);
		
		if(fireIntervention instanceof FInterventionEvent && fireIntervention.getPropertyValue("type").equals("immeuble")) {
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
		FireCorrelatorStateI fc = (FireCorrelatorStateI) c;
		return fc.isLadderAvailable();
	}

	@Override
	public void act(ArrayList<EventI> matchedEvents, CorrelatorStateI c) {
			FireCorrelatorStateI fc = (FireCorrelatorStateI)c;
			FireEvent f = (FireEvent) matchedEvents.get(0);
			AbsolutePosition p = f.getPosition();
			fc.triggerFireAlarm(FEStatus.first, FEType.immeuble,p);
	}
	
	@Override
	public void update(ArrayList<EventI> matchedEvents, EventBaseI eb) {
			FInterventionEvent fe = (FInterventionEvent) matchedEvents.get(0);
			AbsolutePosition p = fe.getPosition();			
			eb.removeEvent(matchedEvents.get(0));
			eb.addEvent(new FireEvent(p, FEStatus.first, FEType.immeuble));
	}
}
