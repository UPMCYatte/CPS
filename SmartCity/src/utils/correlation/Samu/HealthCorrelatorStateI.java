package utils.correlation.Samu;

import utils.correlation.CorrelatorStateI;

public interface HealthCorrelatorStateI extends CorrelatorStateI {
	public boolean isMedicAvalaible();
	public void triggerMedicCall(String personId);
}
