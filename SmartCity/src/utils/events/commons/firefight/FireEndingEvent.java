package utils.events.commons.firefight;

import java.io.Serializable;
import java.time.LocalTime;

import utils.events.commons.Event;
import utils.events.interfaces.AtomicEventI;

public class FireEndingEvent extends Event implements AtomicEventI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public LocalTime getTimeStamp() {
		return null;
	}

	@Override
	public boolean hasProperty(String name) {
		return false;
	}

	@Override
	public Serializable getPropertyValue(String name) {
		return null;
	}

}
