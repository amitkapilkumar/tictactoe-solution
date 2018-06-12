package com.game.service;

import static com.game.util.Constant.*;

import com.game.exception.InvalidPositionException;
import com.game.helper.GameHelper;
import com.game.model.Position;
import com.game.model.Win;

public class GameServiceImpl implements GameService {
	private int[][] game;
	private GameHelper gameHelper;
	
	public GameHelper getGameHelper() {
		return gameHelper;
	}

	public void setGameHelper(GameHelper gameHelper) {
		this.gameHelper = gameHelper;
	}

	@Override
	public void createGame() {
		game = new int[DIMENSION][DIMENSION];
	}

	@Override
	public void tickPlayer1(Position position) throws InvalidPositionException {
		markPostion(position, 1);
	}

	@Override
	public void tickPlayer2(Position position) throws InvalidPositionException {
		markPostion(position, 2);
	}

	@Override
	public Win checkWin() {
		Win win = new Win();
		boolean isGameWin = false;
		
		for(int i=0; i < DIMENSION; i++) {
			isGameWin = gameHelper.checkRowsForGameWin(game[i]);
			if(isGameWin) {
				setWinner(win, i);
				return win;
			}
			isGameWin = gameHelper.checkColsForGameWin(game, i);
			if(isGameWin) {
				setWinner(win, i);
				return win;
			}
		}
		
		isGameWin = gameHelper.checkDiagonalsForGameWin(game);
		if(isGameWin) {
			setWinner(win, DIMENSION/2);
		}
		
 		return win;
	}

	private void setWinner(Win win, int i) {
		win.setGameCompleted(true);
		if(game[i][i] == 1) {
			win.setWinner("Player1");
		}
		else {
			win.setWinner("Player2");
		}
	}
	
	private void markPostion(Position position, int value) throws InvalidPositionException {
		gameHelper.validate(position);
		if(game[position.getX()][position.getY()] == 0) {
			game[position.getX()][position.getY()] = value;
		}
		else {
			throw new InvalidPositionException("Invalid " + position);
		}
	}

	@Override
	public int[][] getMatrix() {
		return game;
	}

	@Override
	public boolean isAllCellFilled() {
		for(int i=0; i < DIMENSION ; i++) {
			for(int j=0; j < DIMENSION; j++) {
				if(game[i][j] == 0)
					return false;
			}
		}
		return true;
	}
	
	
}
