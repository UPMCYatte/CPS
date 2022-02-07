package cep.components.interfaces;

import fr.sorbonne_u.components.interfaces.RequiredCI;
import utils.events.interfaces.EventI;

public interface EventReceptionCI extends RequiredCI {
	public void receiveEvent(String emitterURI, EventI e);
	public void receiveEvents(String emitterURI, EventI[] events);
}
