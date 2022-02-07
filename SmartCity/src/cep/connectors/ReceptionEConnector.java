package cep.connectors;

import cep.components.interfaces.EventReceptionCI;
import fr.sorbonne_u.components.connectors.AbstractConnector;
import utils.events.interfaces.EventI;

public class ReceptionEConnector extends AbstractConnector implements EventReceptionCI {

	@Override
	public void receiveEvent(String emitterURI, EventI e) {
		((EventReceptionCI)offering).receiveEvent(emitterURI, e);
	}

	@Override
	public void receiveEvents(String emitterURI, EventI[] events) {
		((EventReceptionCI)offering).receiveEvents(emitterURI, events);
	}

}
