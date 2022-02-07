package utils.events.interfaces;

import java.util.ArrayList;

public interface ComplexEventI extends EventI {
	public ArrayList<EventI> getCorrelatedEvents();
}
