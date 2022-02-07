package cep.connectors;

import cep.components.interfaces.CEPBusManagementCI;
import fr.sorbonne_u.components.connectors.AbstractConnector;

/**
 * Classe pour un connecteur au BUS CEP
 * @author 3671586
 *
 */
public class CEPBusConnector extends AbstractConnector implements CEPBusManagementCI {

	public CEPBusConnector() {
		super();
	}
	
	@Override
	public String registerEmitter(String uri) {
		return ((CEPBusManagementCI)offering).registerEmitter(uri);
	}

	@Override
	public void unregisterEmitter(String uri) {
		((CEPBusManagementCI)offering).unregisterEmitter(uri);
	}

	@Override
	public String registerCorrelator(String uri, String InboundPortURI) {
		return ((CEPBusManagementCI)offering).registerCorrelator(uri, InboundPortURI);
	}

	@Override
	public void unregisterCorrelator(String uri) {
		((CEPBusManagementCI)offering).unregisterCorrelator(uri);
	}

	@Override
	public String registerExecutor(String uri, String inboundPortURI) {
		return ((CEPBusManagementCI)offering).registerExecutor(uri, inboundPortURI);
	}

	@Override
	public void unregisterExecutor(String uri) {
		((CEPBusManagementCI)offering).unregisterExecutor(uri);
	}

	@Override
	public void subscribe(String subscribeURI, String emitterURI) {
		((CEPBusManagementCI)offering).subscribe(subscribeURI, emitterURI);
	}

	@Override
	public void unsubscribe(String subscribeURI, String emitterURI) {
		((CEPBusManagementCI)offering).unsubscribe(subscribeURI, emitterURI);
	}

}
