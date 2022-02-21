package utils.events.commons;

import java.io.Serializable;
import java.util.ArrayList;


import utils.events.interfaces.ComplexEventI;
import utils.events.interfaces.EventI;

public class ComplexEvent extends Event implements ComplexEventI {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Attributs
	ArrayList<EventI> correlatedEvent;
	
	//Constructeur 
	public ComplexEvent() {
		correlatedEvent = new ArrayList<EventI>();
	}
	
	//Méthodes
	@Override
	public boolean hasProperty(String name) {
		for (EventI ce : correlatedEvent) {
			if (!ce.hasProperty(name)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Serializable getPropertyValue(String name) {
		if(!hasProperty(name)) {
			System.out.println("Aucune propriété correpondante");
			return null;			
		}
		else
			return correlatedEvent.get(0).getPropertyValue(name);
	}

	@Override
	public ArrayList<EventI> getCorrelatedEvents() {
		return correlatedEvent;
	}

}
