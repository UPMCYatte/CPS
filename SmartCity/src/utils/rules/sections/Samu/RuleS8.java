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

public class RuleS8 implements RuleI {

	@Override
	public ArrayList<EventI> match(EventBaseI eb) {
		EventI ha = eb.getEvent(0); //HealthAlarm
		EventI ms = eb.getEvent(1); //ManualSignal
		if(ha instanceof HealthEvent && ha.getPropertyValue("type").equals("traçage")) 
			if(ms instanceof SignalEvent) {
				ArrayList<EventI> me = new ArrayList<>();
				me.add(ha);
				me.add(ms);
				return me;
		}
		return null;
	}

	@Override
	public boolean correlate(ArrayList<EventI> matchedEvents) {
		EventI ha = matchedEvents.get(0); //HealthAlarm
		EventI ms = matchedEvents.get(1); //
		int duration = Math.abs((ha.getTimeStamp().toSecondOfDay()-ms.getTimeStamp().toSecondOfDay())/60);
		boolean correlation1 = ha.getPropertyValue("personId").equals(ms.getPropertyValue("personId"));
		boolean correlation2 = duration >= 10;
		return correlation1 && correlation2;
	}

	@Override
	public boolean filter(ArrayList<EventI> matchedEvents, CorrelatorStateI c) {
		HealthCorrelatorStateI hc = (HealthCorrelatorStateI)c;
		return !hc.isMedicAvalaible() && hc.isEMSCenterNearest();
	}

	@Override
	public void act(ArrayList<EventI> matchedEvents, CorrelatorStateI c) {
		HealthCorrelatorStateI hc = (HealthCorrelatorStateI)c;
		hc.triggerAmbulanceIntervention();
	}

	@Override
	public void update(ArrayList<EventI> matchedEvents, EventBaseI eb) {
		eb.clearEvents(null);
	}

}
