package models;

import types.StateValue;

public class State {

	protected StateValue stateValue;
	
	public State() {
		this.stateValue = StateValue.INITIAL;
	}


	public void next() {
	
	}
	
	public void reset() {
	}

	public StateValue getStateValue() {
		return null;
	}
	
	public void setStateValue(StateValue stateValue) {
       this.stateValue = stateValue;
	}
}