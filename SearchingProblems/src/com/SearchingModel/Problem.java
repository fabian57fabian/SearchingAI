package com.SearchingModel;

public abstract class Problem {
	public Node initialState;

	public Problem() {
		
	}

	public Node ChildNode(Node parent, Action a) {
		Node n = new Node();
		n.state = Result(parent.state, a);
		n.parent = parent;
		n.action = a;
		n.pathCost = parent.pathCost + StepCost(parent.state, a);
		return n;
	}

	public abstract boolean GoalTest(State s);

	public abstract State Result(State state, Action a);

	public abstract int StepCost(State state, Action a);

	public abstract Action[] Actions(State s);
}
