package utils.events.commons;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;

import utils.events.interfaces.EventBaseI;
import utils.events.interfaces.EventI;

public class EventBase implements EventBaseI {
	
	ArrayList<EventI> base;
	
	public EventBase() {
		base = new ArrayList<EventI>();
	}

	@Override
	public void addEvent(EventI e) {
		base.add(e);
	}

	@Override
	public void removeEvent(EventI e) {
		base.remove(e);
	}

	@Override
	public EventI getEvent(int i) {
		return base.get(i);
	}

	@Override
	public int numberOfEvents() {
		return base.size();
	}

	@Override
	public boolean appearsIn(EventI e) {
		return base.contains(e);
	}


	@Override
	public void clearEvents(Duration d) {
		if(d==null)
			base.clear();
		else {
			LocalTime ts = LocalTime.now().minus(d);
			for (EventI e : base) {
				LocalTime eventTimeStamp = e.getTimeStamp();
				if(eventTimeStamp.isBefore(ts))
					removeEvent(e);
			}
		}		
	}

}
