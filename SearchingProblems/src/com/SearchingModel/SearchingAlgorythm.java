package com.SearchingModel;

import java.util.HashSet;

import com.PuzzleProblem.PuzzleSolution;

public class SearchingAlgorythm {
	
	public static Solution BreadthFirstSearch(Problem problem) {
		Node node = problem.initialState;
		if (problem.GoalTest(node.state)) {
			return new PuzzleSolution(node);
		}
		FifoQueue<Node> frontier = new FifoQueue<>();
		frontier.put(node);
		HashSet<State> explored = new HashSet<>();
		while (!frontier.isEmpty()) {
			node = frontier.pop();
			explored.add(node.state);
			if (node.pathCost > 31) {
				continue;
			}
			Action[] acts = problem.Actions(node.state);
			for (Action action : acts) {
				Node child = problem.ChildNode(node, action);
				if (!explored.contains(child.state) && !containsState(frontier, child.state)) {
					if (problem.GoalTest(child.state)) {
						return new PuzzleSolution(child);
					}
					frontier.put(child);
					System.out.println("Frontier: " + frontier.size() + ", Explored: " + explored.size());
				}
			}
		}
		return null;
	}

	private static boolean containsState(FifoQueue<Node> frontier, State state) {
		for (int i = 0; i < frontier.size(); i++) {
			if (frontier.get(i).state.equals(state)) {
				return true;
			}
		}
		return false;
	}
}
