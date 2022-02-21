package utils.events.commons;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.HashMap;

import utils.events.interfaces.EventI;

/**
 * Creation d'une classe Event, representant un evenement. 
 * @author 3671586
 */

public abstract class Event implements EventI {
	//Attributs
	protected LocalTime timestamp;
	protected HashMap<String,Serializable> properties;
	
	public Event() {
		timestamp = LocalTime.now();
		properties = new HashMap<String, Serializable>();
	}

	@Override
	/**
	 * Recuperer l'estampille de temps correspondant au moment auquel l’événement a été créé
	 * @return
	 */
	public LocalTime getTimeStamp() {
		return timestamp;
	}

	@Override
	/**
	 * Verification de l'existence d'une propriete propre a l'evenement courant 
	 * @param name : nom de la propriete a verifier
	 * @return vrai si l'evenement possede la propriete specifie par le nom donne en argument
	 */
	public boolean hasProperty(String name) {
		return properties.containsKey(name);
	}

	@Override
	/**
	 * Retourne la valeur d'une propriete a partir d'un nom.
	 * @param name : Nom d'une propriete.
	 * @return La valeur associé au nom d'une propriete donnee.
	 */
	public Serializable getPropertyValue(String name) {
		return properties.get(name);
	}
	
	
	public boolean propertyEquals(String name, Serializable value) {
		return this.getPropertyValue(name).equals(value);
	}

}
