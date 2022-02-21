package utils.rules;

import java.util.ArrayList;

import utils.correlation.CorrelatorStateI;
import utils.events.interfaces.EventBaseI;
import utils.rules.interfaces.RuleI;

public class RuleBase {
	//Attributs 
	ArrayList<RuleI> rules = new ArrayList<>();
	
	//Methodes :
	public void addRule(RuleI r) {
		rules.add(r);
	}
	
	public boolean fireFirstOn(EventBaseI eb, CorrelatorStateI c) {
		return false;
	}
	
	public boolean fireAllOn(EventBaseI eb, CorrelatorStateI c) {
		return false;
	}

}
