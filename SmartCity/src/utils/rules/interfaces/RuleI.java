package utils.rules.interfaces;

import java.util.ArrayList;

import utils.correlation.CorrelatorStateI;
import utils.events.*;
import utils.events.interfaces.EventBaseI;
import utils.events.interfaces.EventI;

public interface RuleI {
	public ArrayList<EventI> match(EventBaseI eb);
	public boolean correlate(ArrayList<EventI> matchedEvents);
	public boolean filter(ArrayList<EventI> matchedEvents, CorrelatorStateI c);
	public void act(ArrayList<EventI> matchedEvents, CorrelatorStateI c);
	public void update(ArrayList<EventI> matchedEvents, EventBaseI eb);
}
