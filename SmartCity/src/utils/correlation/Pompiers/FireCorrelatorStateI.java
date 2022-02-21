package utils.correlation.Pompiers;

import utils.correlation.CorrelatorStateI;
import utils.events.commons.AbsolutePosition;
import utils.events.commons.firefight.*;

public interface FireCorrelatorStateI extends CorrelatorStateI {
	public boolean isLadderAvailable();
	public boolean isTruckAvailable();
	public boolean checkInFireStationZone(AbsolutePosition p);
	public boolean isFireStationNearest();
	public void triggerFireAlarm(FEStatus statut,FEType type, AbsolutePosition p);
	public void fireInterventionBroadcast();
	public void generalFireAlarmBroadcast();
	public boolean isSender();
	
}
