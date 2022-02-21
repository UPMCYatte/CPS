package utils.events.commons.firefight;


import utils.events.commons.AbsolutePosition;
import utils.events.commons.Event;
import utils.events.interfaces.AtomicEventI;

public class FireEvent extends Event implements AtomicEventI {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AbsolutePosition p;
	public FireEvent(AbsolutePosition p, FEStatus s, FEType t) {
		this.p = p;
		//Statut d'une alarme feu.
		switch(s) {
		case standard : this.putProperty("status", "standard"); break;
		case first : this.putProperty("status", "first"); break;
		case second : this.putProperty("status", "first"); break;
		case general : this.putProperty("status", "first");
		}
		
		//Type de l'incendie detectée par l'alarme feu.
		switch(t) {
		case maison : this.putProperty("type", "maison"); break;
		case immeuble : this.putProperty("type", "immeuble");
		}
	}
	
	public AbsolutePosition getPosition() {
		return p;
	}

}
