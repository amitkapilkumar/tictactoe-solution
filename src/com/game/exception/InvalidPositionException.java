package com.game.exception;

public class InvalidPositionException extends Exception {
	
	private static final long serialVersionUID = 2518052244897703897L;
	
	public InvalidPositionException(String msg) {
		super(msg);
	}
}
