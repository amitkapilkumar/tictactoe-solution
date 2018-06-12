package com.game.factory;

import com.game.helper.GameHelper;
import com.game.helper.GameHelperImpl;
import com.game.service.GameServiceImpl;
import com.game.simulate.TicTacToeGame;
import com.game.util.PrintUtilityImpl;
import com.game.util.ScannerUtil;
import com.game.util.ScannerUtilImpl;

public class TicTacToeGameFactory {
	private static TicTacToeGame game;
	public static TicTacToeGame getInstance() {
		if(game == null) {
			game = new TicTacToeGame();
			GameServiceImpl gameService = new GameServiceImpl();
			GameHelper gameHelper = new GameHelperImpl();
			ScannerUtil scanner = new ScannerUtilImpl();
			gameService.setGameHelper(gameHelper);
			game.setGameService(gameService);
			game.setPrintUtility(new PrintUtilityImpl());
			game.setScannerUtil(scanner);
		}
		return game;
	}
}
