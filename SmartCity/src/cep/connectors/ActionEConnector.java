package cep.connectors;

import java.io.Serializable;

import cep.components.interfaces.ActionExecutionCI;
import cep.interfaces.ActionI;
import cep.interfaces.ResponseI;
import fr.sorbonne_u.components.connectors.AbstractConnector;


public class ActionEConnector extends AbstractConnector implements ActionExecutionCI {

	@Override
	public ResponseI execute(ActionI a, Serializable[] params) {
		return ((ActionExecutionCI)offering).execute(a, params);
	}

}
