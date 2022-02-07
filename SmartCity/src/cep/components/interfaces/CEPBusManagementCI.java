package cep.components.interfaces;

import fr.sorbonne_u.components.interfaces.OfferedCI;
import fr.sorbonne_u.components.interfaces.RequiredCI;

public interface CEPBusManagementCI extends RequiredCI, OfferedCI {
	public String registerEmitter(String uri);
	public void unregisterEmitter(String uri);
	public String registerCorrelator(String uri, String InboundPortURI);
	public void unregisterCorrelator(String uri);
	public String registerExecutor(String uri, String inboundPortURI);
	public void unregisterExecutor(String uri);
	public void subscribe(String subscribeURI, String emitterURI);
	public void unsubscribe(String subscribeURI, String emitterURI);

}
