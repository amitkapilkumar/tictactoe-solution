package com.game.builder;

import com.game.model.Win;

public class WinBuilder {
	private boolean gameCompleted;
	private String winPlayer;
	
	public WinBuilder withGameCompleted(boolean gameCompleted) {
		this.gameCompleted = gameCompleted;
		return this;
	}
	
	public WinBuilder withWinPlayer(String winPlayer) {
		this.winPlayer = winPlayer;
		return this;
	}
	
	public Win build() {
		Win win = new Win();
		win.setGameCompleted(gameCompleted);
		win.setWinner(winPlayer);
		return win;
	}
}