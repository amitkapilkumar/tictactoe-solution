package com.game.helper;

import com.game.exception.InvalidPositionException;
import com.game.model.Position;

public interface GameHelper {
	public void validate(Position position) throws InvalidPositionException;
	public boolean checkRowsForGameWin(int[] arr);
	public boolean checkColsForGameWin(int[][] arr, int indexCol);
	public boolean checkDiagonalsForGameWin(int[][] arr);
}
