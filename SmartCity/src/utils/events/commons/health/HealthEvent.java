package utils.events.commons.health;

import utils.events.commons.AbsolutePosition;
import utils.events.commons.Event;
import utils.events.interfaces.AtomicEventI;

public class HealthEvent extends Event implements AtomicEventI {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AbsolutePosition p;
	
	public HealthEvent(String personId, AbsolutePosition p, HEType t) {
		this.p = p;
		properties.put("personId", personId);
		switch(t) {
		case urgence : this.putProperty("type", "urgence"); break;
		case medicale : this.putProperty("type", "medicale"); break;
		case traçage : this.putProperty("type", "traçage");
		}
	}
	
	public AbsolutePosition getPosition() {
		return p;
	}



}
