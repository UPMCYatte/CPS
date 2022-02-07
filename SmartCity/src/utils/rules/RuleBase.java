package utils.rules;

import utils.events.interfaces.EventBaseI;
import utils.rules.interfaces.CorrelatorStateI;
import utils.rules.interfaces.RuleI;

public class RuleBase {
	//Constructeur :
	public RuleBase() {
		// TODO Auto-generated constructor stub
	}
	
	//Methodes :
	public void addRule(RuleI r) {
		
	}
	
	public boolean fireFirstOn(EventBaseI eb, CorrelatorStateI c) {
		return false;
	}
	
	public boolean fireAllOn(EventBaseI eb, CorrelatorStateI c) {
		return false;
	}

}
