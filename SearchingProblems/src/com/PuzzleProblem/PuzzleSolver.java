package com.PuzzleProblem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.SearchingModel.Action;
import com.SearchingModel.FifoQueue;
import com.SearchingModel.Node;
import com.SearchingModel.Problem;
import com.SearchingModel.State;

public class PuzzleSolver {

	public static void main(String[] args) {
		
		int table[][] = new int[3][3];
		
		table[0][0] = 3;
		table[0][1] = 6;
		table[0][2] = 8;

		table[1][0] = 1;
		table[1][1] = 4;
		table[1][2] = 0;

		table[2][0] = 7;
		table[2][1] = 2;
		table[2][2] = 5;

		Problem p = new PuzzleProblem(table);
		
		System.out.println("Start problem:\n" + p.initialState.state.toString());
		
		Node f = BFSSolver(p);
		
		if (f != null) {
			System.out.println("We found a solution! \n");
			Visit(f);
		} else {
			System.out.println("We didn't find a solution!");
		}
	}

	private static void Visit(Node f) {
		int n = -1;
		while (f != null) {
			System.out.println("\n" + f.state.toString());
			n++;
			f = f.parent;
		}
		System.out.println("\nTotal moves:" + n + "\n");
	}

	public static Node BFSSolver(Problem problem) {
		Node node = problem.initialState;
		if (problem.GoalTest(node.state)) {
			return node;
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
						return child;
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
