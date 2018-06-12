package com.game.helper;

import static com.game.util.Constant.DIMENSION;

import com.game.exception.InvalidPositionException;
import com.game.model.Position;

public class GameHelperImpl implements GameHelper {

	@Override
	public void validate(Position position) throws InvalidPositionException {
		if(position.getX() < DIMENSION && position.getX() >= 0) {
			if(position.getY() < DIMENSION && position.getY() >= 0)
				return;
		}
		throw new InvalidPositionException("Invalid " + position);
	}

	@Override
	public boolean checkRowsForGameWin(int[] arr) {
		for(int i=0; i<DIMENSION-1; i++) {
			if(arr[i] == 0)
				return false;
			
			if(arr[i] != arr[i+1])
				return false;
		}
		return true;
	}

	@Override
	public boolean checkColsForGameWin(int[][] arr, int indexCol) {
		for(int j=0; j < DIMENSION-1; j++) {
			if(arr[j][indexCol] == 0)
				return false;

			if(arr[j][indexCol] != arr[j+1][indexCol])
				return false;
		}
		return true;
	}

	@Override
	public boolean checkDiagonalsForGameWin(int[][] game) {
		boolean win = false;
		for(int i=0; i < DIMENSION-1; i++) {
			if(game[i][i] == 0) 
				break;

			if(game[i][i] != game[i+1][i+1])
				break;
			
			if(i+1 == DIMENSION-1) 
				win = true;
		}
		if(win)
			return win;
		
		for(int i=DIMENSION-1, j=0; i > 0; i--, j++) {
			if(game[j][i] == 0)
				return false;
			
			if(game[j][i] != game[j+1][i-1])
				return false;
		}
		return true;
	}
}