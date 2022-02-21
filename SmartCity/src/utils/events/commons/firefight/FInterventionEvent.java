package utils.events.commons.firefight;

import java.io.Serializable;

import utils.events.commons.AbsolutePosition;
import utils.events.commons.Event;
import utils.events.interfaces.AtomicEventI;

public class FInterventionEvent extends Event implements AtomicEventI {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AbsolutePosition p;
	
	public FInterventionEvent(AbsolutePosition p, FEType t) {
		this.p = p;

		//Type de l'incendie detectée par l'alarme feu.
		switch(t) {
		case maison : this.putProperty("type", "maison"); break;
		case immeuble : this.putProperty("type", "immeuble");
		}
	}
	
	public AbsolutePosition getPosition() {
		return p;
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
