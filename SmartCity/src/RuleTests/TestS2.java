package RuleTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import RuleTests.bouchons.HealthCorrelatorS2;
import utils.events.commons.AbsolutePosition;
import utils.events.commons.EventBase;
import utils.events.commons.health.HEType;
import utils.events.commons.health.HealthEvent;
import utils.events.interfaces.EventBaseI;
import utils.events.interfaces.EventI;
import utils.rules.interfaces.RuleI;
import utils.rules.sections.Samu.RuleS2;

class TestS2 {

	@Test
	void test() {
		
		HealthEvent HealthAlarm = new HealthEvent("p1232", new AbsolutePosition(4, 5), HEType.urgence);
		assertNotNull(HealthAlarm);
		
		EventBaseI eb = new EventBase();
		eb.addEvent(HealthAlarm);
		
		assertEquals(1, eb.numberOfEvents());
		assertEquals(HealthAlarm, eb.getEvent(0));
		
		RuleI r = new RuleS2();
		ArrayList<EventI> matchedEvents = r.match(eb);
		assertEquals(HealthAlarm, matchedEvents.get(0));
	
		assertEquals(true,r.filter(matchedEvents, new HealthCorrelatorS2()));
		
	}

}
