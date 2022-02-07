package utils.events.commons;

import java.io.Serializable;

import utils.events.interfaces.AtomicEventI;

public class HealthEvent extends Event implements AtomicEventI {

	@Override
	public void putProperty(String name, Serializable value) {
		properties.put(name, value);
	}

	@Override
	public void removeProperty(String name) {
		properties.remove(name);
	}

}
