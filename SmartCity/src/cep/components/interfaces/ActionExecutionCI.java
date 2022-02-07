package cep.components.interfaces;

import java.io.Serializable;

import cep.interfaces.*;
import fr.sorbonne_u.components.interfaces.*;

public interface ActionExecutionCI extends OfferedCI, RequiredCI {
	ResponseI execute(ActionI a, Serializable[] params);
}
