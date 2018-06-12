package com.game.util;

import static com.game.util.Constant.*;

public class PrintUtilityImpl implements PrintUtility {

	@Override
	public void print(String in) {
		System.out.println(in);
	}

	@Override
	public void printMatrix(int[][] game) {
		System.out.println("Current Game Matrix");
		for(int i=0; i < DIMENSION ; i++) {
			for(int j=0; j < DIMENSION; j++) {
				System.out.print(game[i][j] + " ");
			}
			System.out.println();
		}
	}
}
