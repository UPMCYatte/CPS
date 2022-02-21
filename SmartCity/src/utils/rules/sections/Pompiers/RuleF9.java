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

public class RuleF9 implements RuleI {
	/* première alarme feu en position p1 avec type = immeuble
	 * alarme feu en position p2 avec type = immeuble*/
	@Override
	public ArrayList<EventI> match(EventBaseI eb) {
		ArrayList<EventI> matchedEvent = new ArrayList<>();
		EventI fireAlarm1st = eb.getEvent(0);
		if(fireAlarm1st instanceof FireEvent && fireAlarm1st.getPropertyValue("status").equals("first") && fireAlarm1st.getPropertyValue("type").equals("immeuble")) {
			matchedEvent.add(fireAlarm1st);
			EventI fireAlarm = eb.getEvent(1);
			if(fireAlarm instanceof FireEvent && fireAlarm.getPropertyValue("status").equals("standard") && fireAlarm.getPropertyValue("type").equals("immeuble"));
				matchedEvent.add(fireAlarm);
				return matchedEvent;
			}
		else 
			return null;
	}
	
	@Override
	public boolean correlate(ArrayList<EventI> matchedEvents) {
		/*p1 est égale à p2
		délai entre les deux événements <= 15 minutes*/
		FireEvent fireAlarm1st = (FireEvent)matchedEvents.get(0);
		FireEvent fireAlarm = (FireEvent)matchedEvents.get(1);
		AbsolutePosition p1 = fireAlarm1st.getPosition();
		AbsolutePosition p2 = fireAlarm.getPosition();
		int duration = Math.abs((fireAlarm1st.getTimeStamp().toSecondOfDay()-fireAlarm.getTimeStamp().toSecondOfDay())/60);
		boolean correlation1 = p1.equals(p2); 
		boolean correlation2 = duration <= 15;
		return correlation1 && correlation2;
	}

	@Override
	public boolean filter(ArrayList<EventI> matchedEvents, CorrelatorStateI c) {
		/*p1 est dans la zone de la caserne C*/
		FireCorrelatorStateI fc = (FireCorrelatorStateI) c;
		FireEvent f = (FireEvent) matchedEvents.get(0);
		AbsolutePosition p1 = f.getPosition();
		return fc.checkInFireStationZone(p1);
	}

	@Override
	public void act(ArrayList<EventI> matchedEvents, CorrelatorStateI c) {
		FireCorrelatorStateI fc = (FireCorrelatorStateI) c;
		FireEvent f = (FireEvent) matchedEvents.get(0);
		AbsolutePosition p = f.getPosition();
		fc.triggerFireAlarm(FEStatus.general, FEType.immeuble,p);
		fc.generalFireAlarmBroadcast();
	}

	@Override
	public void update(ArrayList<EventI> matchedEvents, EventBaseI eb) {
		FireEvent f = (FireEvent)matchedEvents.get(0);
		f.removeProperty("statut");
		f.putProperty("statut", "general");
		eb.clearEvents(null);
		eb.addEvent(f);
		eb.addEvent(matchedEvents.get(1));
	}


}
