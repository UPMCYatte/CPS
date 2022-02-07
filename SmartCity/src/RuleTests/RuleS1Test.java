package RuleTests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import utils.events.commons.EventBase;
import utils.events.commons.HealthEvent;
import utils.events.interfaces.EventI;
import utils.rules.sections.Samu.RuleS1;
import junit.framework.*;

public class RuleS1Test {

	public static void main(String[] args) {
		//Création de l'evenement correspondant à la règle S1 :
		HealthEvent he = new HealthEvent();
		he.putProperty("type", "urgence");
		
		
		//Ajout de he dans une Eventbase
		EventBase eb = new EventBase();
		eb.addEvent(he);
		
		
		//Instanciation de la règle S1 et vérification des éléments à faire coincider avec he :
		RuleS1 r = new RuleS1();
		ArrayList<EventI> me = new ArrayList<EventI>();
		me.add(he);
		
		//Verification du résultat de l'appel à match dans S1
		assertEquals(r.match(eb), me); 
	}

}
