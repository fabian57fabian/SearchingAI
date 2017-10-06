package com.PuzzleProblem;

import java.util.ArrayList;
import java.util.List;

import com.SearchingModel.Action;
import com.SearchingModel.Node;
import com.SearchingModel.Problem;
import com.SearchingModel.State;

public class PuzzleProblem extends Problem {

	public PuzzleProblem(int[][] board) {
		Node n = new Node();
		n.action = null;
		n.parent = null;
		n.pathCost = 0;
		n.state = new PuzzleState(board);
		initialState = n;
	}

	@Override
	public boolean GoalTest(State s) {
		int[][] gameTable = ((PuzzleState) s).matrix;
		int count = 1;
		for (int i = 0; i < gameTable.length; i++) {
			for (int j = 0; j < gameTable[i].length; j++) {
				if (gameTable[i][j] != count) {
					return false;
				} else {
					count++;
					if (count==9) {
						count=0;
					}
				}
			}
		}
		return true;
	}

	@Override
	public State Result(State state, Action a) {
		PuzzleState s1 = (PuzzleState) state;
		PuzzleAction a1 = (PuzzleAction) a;
		PuzzleState nextState = new PuzzleState(s1.matrix);
		if (abs(a1.action) == 1) {
			nextState.matrix[nextState.i0][nextState.j0] = nextState.matrix[nextState.i0][nextState.j0 + a1.action];
			nextState.matrix[nextState.i0][nextState.j0 + a1.action] = 0;
			nextState.j0 += +a1.action;
		} else if (abs(a1.action) == 2) {
			nextState.matrix[nextState.i0][nextState.j0] = nextState.matrix[nextState.i0
					+ (a1.action / 2)][nextState.j0];
			nextState.matrix[nextState.i0 + (a1.action / 2)][nextState.j0] = 0;
			nextState.i0 += a1.action / 2;
		}
		return nextState;
	}

	private int abs(int number) {
		if (number < 0) {
			return -number;
		} else {
			return number;
		}
	}

	@Override
	public int StepCost(State state, Action a) {
		return 1;
	}

	@Override
	public Action[] Actions(State s) {
		PuzzleState s1 = (PuzzleState) s;
		List<Action> actions = new ArrayList<Action>();
		int dimi = s1.matrix[0].length;
		int dimj = s1.matrix.length;
		if (s1.j0 - 1 >= 0) {
			actions.add(new PuzzleAction(-1));
		}
		if (s1.j0 + 1 < dimi) {
			actions.add(new PuzzleAction(1));
		}
		if (s1.i0 - 1 >= 0) {
			actions.add(new PuzzleAction(-2));
		}
		if (s1.i0 + 1 < dimj) {
			actions.add(new PuzzleAction(2));
		}
		return actions.toArray(new Action[actions.size()]);
	}

}
