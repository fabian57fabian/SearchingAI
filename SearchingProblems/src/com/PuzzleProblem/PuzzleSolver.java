package com.PuzzleProblem;

import com.SearchingModel.Node;
import com.SearchingModel.Problem;
import com.SearchingModel.SearchingAlgorythm;
import com.SearchingModel.Solution;

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
		PuzzleSolution sol;
		Solution s = SearchingAlgorythm.BreadthFirstSearch(p);
		sol=(PuzzleSolution)s;
		
		if (sol.get() != null) {
			System.out.println("We found a solution! \n");
			Visit(sol.get());
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
}
