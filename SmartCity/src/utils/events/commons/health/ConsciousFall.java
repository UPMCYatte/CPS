package utils.events.commons.health;

import java.util.ArrayList;

import utils.events.commons.ComplexEvent;
import utils.events.interfaces.ComplexEventI;
import utils.events.interfaces.EventI;

public class ConsciousFall extends ComplexEvent implements ComplexEventI {
	public ConsciousFall(ArrayList<EventI> correlatedEvents) {
		//Chute consciente de personne est un evenement complexe
		//elle correspond à la correlation de deux événements atomiques
		//-> 1er evenement : HealthEvent
		//-> 2eme evenement : SignalEvent 
		EventI he = correlatedEvents.get(0);
		EventI se = correlatedEvents.get(1);
		if(he instanceof HealthEvent && se instanceof SignalEvent && he.getPropertyValue("personId").equals(se.getPropertyValue("personId"))) {
				correlatedEvents.add(he);
				correlatedEvents.add(se);
		}
		else{
			System.err.println("Création de l'événement complexe Chute de personne a échouer");
		}
	}
}