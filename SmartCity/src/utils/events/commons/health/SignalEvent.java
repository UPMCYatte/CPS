package utils.events.commons.health;

import java.io.Serializable;


import utils.events.commons.Event;
import utils.events.interfaces.AtomicEventI;

public class SignalEvent extends Event implements AtomicEventI {

	public SignalEvent(String personId) {
		properties.put("personId", personId);
	}
	
	@Override
	public void putProperty(String name, Serializable value) {
		properties.put(name, value);
	}

	@Override
	public void removeProperty(String name) {
		properties.remove(name);
	}

}
