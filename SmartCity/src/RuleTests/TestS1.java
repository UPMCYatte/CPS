package RuleTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import RuleTests.bouchons.AmbulanceCorrelator;
import utils.correlation.Samu.AmbulanceCorrelatorStateI;
import utils.events.commons.AbsolutePosition;
import utils.events.commons.EventBase;
import utils.events.commons.health.HEType;
import utils.events.commons.health.HealthEvent;
import utils.events.interfaces.EventI;
import utils.rules.sections.Samu.RuleS1;

public class TestS1 {

	
	@Test
	public void test() {
		
		//Création de l'evenement Alarme de santé de type urgence en p(4,5) pour p1234
		HealthEvent HealthAlarm1 = new HealthEvent("p1234", new AbsolutePosition(4, 5), HEType.urgence);
		HealthEvent HealthAlarm2 = new HealthEvent("p5678", new AbsolutePosition(6, 7), HEType.medicale);
		HealthEvent HealthAlarm3 = new HealthEvent("p91011", new AbsolutePosition(4, 5), HEType.traçage);
		
		assertEquals(HealthAlarm1.getPropertyValue("type"), "urgence");
		assertEquals(HealthAlarm2.getPropertyValue("type"), "medicale");
		assertEquals(HealthAlarm3.getPropertyValue("type"), "traçage");
		
		//Ajout de HealthAlarm dans une base d'evenements eb
		EventBase eb = new EventBase();
		eb.addEvent(HealthAlarm1);
		
		//Verification :
		assertEquals(HealthAlarm1, eb.getEvent(0));
		
		//Instanciation de la règle S1
		RuleS1 r = new RuleS1();
		
		//Verification de la méthode match
		assertEquals(HealthAlarm1, r.match(eb).get(0));
		ArrayList<EventI> me = r.match(eb);
		
		//Verification de la methode filter :
		AmbulanceCorrelatorStateI ambuCS = new AmbulanceCorrelator();
		assertEquals(true, r.filter(me, ambuCS));
		
		//Verification de la méthode update :
		r.update(me, eb);
		assertEquals(0, eb.numberOfEvents());
		
		
	}

}
