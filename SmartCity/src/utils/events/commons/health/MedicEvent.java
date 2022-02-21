package utils.events.commons.health;


import utils.events.commons.Event;
import utils.events.interfaces.AtomicEventI;

public class MedicEvent extends Event implements AtomicEventI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MedicEvent(EMSAvailability a) {
		switch(a) {
		case yes : this.putProperty("Availability", "yes"); break;
		case no : this.putProperty("Availability", "no"); break;
		}
	}
}
