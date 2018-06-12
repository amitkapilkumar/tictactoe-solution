package com.game.model;

public class Win {
	private boolean gameCompleted;
	private String winner;
	
	public boolean isGameCompleted() {
		return gameCompleted;
	}
	
	public void setGameCompleted(boolean gameCompleted) {
		this.gameCompleted = gameCompleted;
	}
	
	public String getWinner() {
		return winner;
	}
	
	public void setWinner(String winner) {
		this.winner = winner;
	}
	
}