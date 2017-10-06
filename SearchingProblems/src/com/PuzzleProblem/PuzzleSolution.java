package com.PuzzleProblem;

import com.SearchingModel.Solution;
import com.SearchingModel.Node;;

public class PuzzleSolution extends Solution {
	private Node finalSolution;

	public PuzzleSolution(Node n) {
		finalSolution = n;
	}

	public Node get() {
		return finalSolution;
	}
}
