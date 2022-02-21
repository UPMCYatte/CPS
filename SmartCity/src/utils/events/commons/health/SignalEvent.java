package utils.events.commons.health;

import utils.events.commons.Event;
import utils.events.interfaces.AtomicEventI;

public class SignalEvent extends Event implements AtomicEventI {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SignalEvent(String personId) {
		properties.put("personId", personId);
	}
}
