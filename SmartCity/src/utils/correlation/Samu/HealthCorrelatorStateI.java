package utils.correlation.Samu;

import utils.correlation.CorrelatorStateI;
import utils.events.commons.AbsolutePosition;
import utils.events.interfaces.EventI;

public interface HealthCorrelatorStateI extends CorrelatorStateI {
	public boolean isMedicAvalaible();
	public void triggerMedicCall(String personId);
	public boolean isAmbulanceAvalaible();
	public void triggerAmbulanceIntervention();
	public boolean checkInSamuZone(AbsolutePosition p);
	public void spreadInterventionRequest();
	public boolean isEMSCenterNearest();
	public boolean isEMSSender();
	public boolean isEMSAuxAccessible();
	public void sendEvent(EventI e);
	
}
