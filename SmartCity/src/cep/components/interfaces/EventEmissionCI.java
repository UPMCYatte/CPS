package cep.components.interfaces;

import fr.sorbonne_u.components.interfaces.OfferedCI;
import fr.sorbonne_u.components.interfaces.RequiredCI;
import utils.events.interfaces.EventI;

public interface EventEmissionCI extends OfferedCI, RequiredCI {
	public void sendEvent(String emitterURI, EventI e);
	public void sendEvents(String emitterURI, EventI[] events);
}
