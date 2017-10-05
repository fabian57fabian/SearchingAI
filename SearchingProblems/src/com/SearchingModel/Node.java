package com.SearchingModel;

public class Node {
	public Node parent;
	public State state;
	public Action action;
	public int pathCost;

	public Node() {
		parent=null;
		state=null;
		action=null;
		pathCost=0;
	}
	@Override
	public boolean equals(Object n) {
		return state.equals(((Node)n).state);
	}
}
