package utils.rules.sections.Pompiers;

import java.util.ArrayList;

import utils.correlation.CorrelatorStateI;
import utils.correlation.Pompiers.FireCorrelatorStateI;
import utils.events.commons.AbsolutePosition;
import utils.events.commons.firefight.FEStatus;
import utils.events.commons.firefight.FEType;
import utils.events.commons.firefight.FireEvent;
import utils.events.interfaces.EventBaseI;
import utils.events.interfaces.EventI;
import utils.rules.interfaces.RuleI;

public class RuleF3 implements RuleI {

	@Override
	public ArrayList<EventI> match(EventBaseI eb) {
		EventI fireAlarm = eb.getEvent(0);
		if(fireAlarm instanceof FireEvent && fireAlarm.getPropertyValue("type").equals("immeuble")) {
			ArrayList<EventI> matchedEvents = new ArrayList<>();
			matchedEvents.add(fireAlarm);
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
		FireEvent fe = (FireEvent) matchedEvents.get(0);
		AbsolutePosition p = fe.getPosition();
		return !fc.isLadderAvailable() && fc.isFireStationNearest();
	}

	@Override
	public void act(ArrayList<EventI> matchedEvents, CorrelatorStateI c) {
			FireCorrelatorStateI fc = (FireCorrelatorStateI)c;
			fc.fireInterventionBroadcast();
	}

	@Override
	public void update(ArrayList<EventI> matchedEvents, EventBaseI eb) {
			eb.removeEvent(matchedEvents.get(0));
	}

}
