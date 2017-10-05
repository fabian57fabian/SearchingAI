package com.PuzzleProblem;

import com.SearchingModel.Action;

public class PuzzleAction extends Action{

	public PuzzleAction(int a) {
		action = a;
	}

	//     -2
	//      |
	//-1--->-<---1
	//      |
	//      2
	public int action;
}
