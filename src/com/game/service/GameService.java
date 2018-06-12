package com.game.service;

import com.game.exception.InvalidPositionException;
import com.game.model.Position;
import com.game.model.Win;

public interface GameService {
	public void createGame();
	public void tickPlayer1(Position position) throws InvalidPositionException;
	public void tickPlayer2(Position position) throws InvalidPositionException;
	public Win checkWin();
	public int[][] getMatrix();
	public boolean isAllCellFilled();
}