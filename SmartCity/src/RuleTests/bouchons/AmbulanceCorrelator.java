ackage RuleTests.bouchons;

import utils.correlation.Samu.AmbulanceCorrelatorStateI;
import utils.events.commons.AbsolutePosition;
import utils.events.interfaces.EventI;

public class AmbulanceCorrelator implements AmbulanceCorrelatorStateI {

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
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean checkPositionInSamuZone() {
		return true;
	}

	@Override
	public void triggerAmbulanceIntervention() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean checkInSamuZone(AbsolutePosition p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void spreadInterventionRequest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEMSCenterNearest() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void sendEvent(EventI e) {
		// TODO Auto-generated method stub
		
	}

}
