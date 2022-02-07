package cep.connectors;

import cep.components.interfaces.EventEmissionCI;
import fr.sorbonne_u.components.connectors.AbstractConnector;
import utils.events.interfaces.EventI;

public class EmissionEConnector extends AbstractConnector implements EventEmissionCI {

	@Override
	public void sendEvent(String emitterURI, EventI e) {
		((EventEmissionCI)offering).sendEvent(emitterURI, e);
	}

	@Override
	public void sendEvents(String emitterURI, EventI[] events) {
		((EventEmissionCI)offering).sendEvents(emitterURI, events);
	}

}
