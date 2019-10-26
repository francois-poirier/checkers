package models;

public class State {

	protected StateValue stateValue;
	
	public State(StateValue stateValue) {
		this.stateValue = stateValue;
	}
	
	public void next() {
	
	}
	
	public void reset() {
	}

	public StateValue getStateValue() {
		return null;
	}
	
}