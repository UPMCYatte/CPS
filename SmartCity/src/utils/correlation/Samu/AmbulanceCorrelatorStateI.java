package utils.correlation.Samu;

public interface AmbulanceCorrelatorStateI extends HealthCorrelatorStateI {
	public boolean isAmbulanceAvalaible();
	public boolean checkPositionInSamuZone();
	public void triggerAmbulanceIntervention();
}
