package utils.rules.sections.Pompiers;

import java.util.ArrayList;

import utils.correlation.CorrelatorStateI;
import utils.correlation.Pompiers.*;
import utils.events.commons.*;
import utils.events.commons.firefight.*;
import utils.events.interfaces.*;
import utils.rules.interfaces.RuleI;

public class RuleF7 implements RuleI {

	@Override
	public ArrayList<EventI> match(EventBaseI eb) {
		//Demande d’intervention dans une maison en position p reçu de C’
		EventI fireIntervention = eb.getEvent(0);
		if(fireIntervention instanceof FInterventionEvent && fireIntervention.getPropertyValue("type").equals("maison")) {
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
		/*grande échelle non disponible en C
		  caserne C” est la suivante la plus près de p dont ne provient pas la demande
		*/
		FireCorrelatorStateI fc = (FireCorrelatorStateI)c;
		return fc.isTruckAvailable();
	}

	@Override
	public void act(ArrayList<EventI> matchedEvents, CorrelatorStateI c) {
		//propager l’événement apparié de C à C”
		FireCorrelatorStateI fc = (FireCorrelatorStateI)c;
		FireEvent f = (FireEvent) matchedEvents.get(0);
		AbsolutePosition p = f.getPosition();
		fc.triggerFireAlarm(FEStatus.first, FEType.maison,p);		}
	
	@Override
	public void update(ArrayList<EventI> matchedEvents, EventBaseI eb) {		
		/*remplacer l’événement apparié par 
		un évenement complexe première alarme feu causé 
		par l’événement apparié*/
			FInterventionEvent fi = (FInterventionEvent) matchedEvents.get(0);
			AbsolutePosition p = fi.getPosition();
			eb.removeEvent(matchedEvents.get(0));
			FireEvent f = new FireEvent(p, FEStatus.first, FEType.maison);
			eb.addEvent(f);
	}
}
