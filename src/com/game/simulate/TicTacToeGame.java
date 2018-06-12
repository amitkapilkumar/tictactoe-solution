package com.game.simulate;

import com.game.exception.InvalidInput;
import com.game.exception.InvalidPositionException;
import com.game.model.Position;
import com.game.model.Win;
import com.game.service.GameService;
import com.game.util.PrintUtility;
import com.game.util.ScannerUtil;

public class TicTacToeGame {
	private GameService gameService;
	private PrintUtility printUtility;
	private ScannerUtil scannerUtil;
	
	public ScannerUtil getScannerUtil() {
		return scannerUtil;
	}
	
	public void setScannerUtil(ScannerUtil scannerUtil) {
		this.scannerUtil = scannerUtil;
	}
	
	public GameService getGameService() {
		return gameService;
	}

	public void setGameService(GameService gameService) {
		this.gameService = gameService;
	}

	public PrintUtility getPrintUtility() {
		return printUtility;
	}

	public void setPrintUtility(PrintUtility printUtility) {
		this.printUtility = printUtility;
	}

	/**
	 * initiate the game
	 * @throws InvalidInput 
	 * @throws InvalidPositionException 
	 */
	public void init() throws InvalidInput, InvalidPositionException {
		Win win = null;
		gameService.createGame();
		initPrintInstructions();
		player1();
		player2();
		player1();
		player2();
		while(true) {
			player1();
			win = gameService.checkWin();
			if(win.isGameCompleted()) {
				printUtility.print("Winner : " + win.getWinner());
				break;
			}
			if(gameService.isAllCellFilled()) {
				printUtility.print("Game completed no winner");
				break;
			}
			player2();
			win = gameService.checkWin();
			if(win.isGameCompleted()) {
				printUtility.print("Winner : " + win.getWinner());
				break;
			}
			if(gameService.isAllCellFilled()) {
				printUtility.print("Game completed no winner");
				break;
			}
		}
	}

	private void initPrintInstructions() {
		printUtility.print("Tic Tac Toe 3x3 Game initated");
		printUtility.print("Below is positions in game matrix ");
		printUtility.print("[0,0] [0,1] [0,2]");
		printUtility.print("[1,0] [1,1] [1,2]");
		printUtility.print("[2,0] [2,1] [2,2]");
	}

	private void player1() throws InvalidInput, InvalidPositionException {
		printUtility.print("Enter location for Player1, ex: [0,0]");
		String input = getInput();
		gameService.tickPlayer1(parsePosition(input));
		printUtility.printMatrix(gameService.getMatrix());
	}

	private String getInput() throws InvalidInput {
		String input = scannerUtil.nextInput();
		if(input.length() != 5) {
			throw new InvalidInput("Invalid Input : " + input);
		}
		return input;
	}
	
	private void player2() throws InvalidInput, InvalidPositionException {
		printUtility.print("Enter location for Player2, ex: [0,0]");
		String input = getInput();
		gameService.tickPlayer2(parsePosition(input));
		printUtility.printMatrix(gameService.getMatrix());
	}
	
	private Position parsePosition(String input) {
		String[] tokens = input.replace("[", "").replace("]", "").trim().split(",");
		
		Position position = new Position();
		position.setX(Integer.parseInt(tokens[0]));
		position.setY(Integer.parseInt(tokens[1]));
		return position;
	}
	
}
