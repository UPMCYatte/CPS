package RuleTests.bouchons;

import utils.correlation.Samu.HealthCorrelatorStateI;
import utils.events.commons.AbsolutePosition;
import utils.events.interfaces.EventI;

public class HealthCorrelatorS2 implements HealthCorrelatorStateI {

	@Override
	public boolean isMedicAvalaible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void triggerMedicCall(String personId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAmbulanceAvalaible() {
		return false;
	}

	@Override
	public void triggerAmbulanceIntervention() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkInSamuZone(AbsolutePosition p) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void spreadInterventionRequest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEMSCenterNearest() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void sendEvent(EventI e) {
		// TODO Auto-generated method stub
		
	}

}
