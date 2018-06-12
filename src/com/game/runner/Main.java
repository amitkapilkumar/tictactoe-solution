package com.game.runner;

import com.game.exception.InvalidInput;
import com.game.exception.InvalidPositionException;
import com.game.factory.TicTacToeGameFactory;
import com.game.simulate.TicTacToeGame;

public class Main {
	public static void main(String[] args) {
		TicTacToeGame game = TicTacToeGameFactory.getInstance();
		try {
			game.init();
		} catch (InvalidInput e) {
			e.printStackTrace();
		} catch (InvalidPositionException e) {
			e.printStackTrace();
		}
	}
}