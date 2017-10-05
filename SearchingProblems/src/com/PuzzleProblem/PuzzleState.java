package com.PuzzleProblem;

import com.SearchingModel.State;

public class PuzzleState extends State {
	public int i0;
	public int j0;

	public PuzzleState(int[][] matrix) {
		this.matrix = new int[matrix[0].length][matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				this.matrix[i][j] = matrix[i][j];
				if (matrix[i][j] == 0) {
					i0 = i;
					j0 = j;
				}
			}
		}
	}

	public int[][] matrix;

	@Override
	public boolean equals(Object s) {
		PuzzleState s1 = (PuzzleState) s;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] != s1.matrix[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		int jj = 0;
		for (int i = 0; i < matrix.length; i++) {
			s += "[";
			for (int j = 0; j < matrix[0].length; j++) {
				s += matrix[i][j] + " ";
			}
			s += "]\n";
		}
		return s;
	}
}
