package utils.events.commons.health;

import java.io.Serializable;

import utils.events.commons.Availability;
import utils.events.commons.Event;
import utils.events.interfaces.AtomicEventI;

public class AmbulanceEvent extends Event implements AtomicEventI {

	public AmbulanceEvent(Availability a) {
		switch(a) {
		case yes : this.putProperty("Availability", "yes"); break;
		case no : this.putProperty("Availability", "no"); break;
		}
	}
	
	@Override
	public void putProperty(String name, Serializable value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeProperty(String name) {
		// TODO Auto-generated method stub

	}

}
