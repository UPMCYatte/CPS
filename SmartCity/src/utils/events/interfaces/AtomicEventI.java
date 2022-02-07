package utils.events.interfaces;

import java.io.Serializable;

public interface AtomicEventI extends EventI {
	public void putProperty(String name, Serializable value);
	public void removeProperty(String name);
}

