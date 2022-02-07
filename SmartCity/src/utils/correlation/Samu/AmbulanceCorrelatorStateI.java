package utils.correlation.Samu;

import utils.correlation.Position;

public interface AmbulanceCorrelatorStateI extends HealthCorrelatorStateI {
	public boolean isAmbulanceAvalaible();
	public boolean checkPositionInSamuZone();
	public void triggerAmbulanceIntervention();
}
