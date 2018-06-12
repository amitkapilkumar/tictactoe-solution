package com.game.helper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.game.builder.PositionBuilder;
import com.game.exception.InvalidPositionException;
import com.game.model.Position;

public class GameHelperImplTest {
	private GameHelper gameHelper;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setup() {
		gameHelper = new GameHelperImpl();
	}

	@Test
	public void testValidate() throws InvalidPositionException {
		Position position = new PositionBuilder().withX(1).withY(1).build();
		gameHelper.validate(position);
	}
	
	@Test
	public void testValidateException() throws InvalidPositionException {
		Position position = new PositionBuilder().withX(4).withY(1).build();
		exception.expect(InvalidPositionException.class);
		gameHelper.validate(position);
	}
	
	@Test
	public void testCheckRowsForGameWinFalse() {
		int[] arr = new int[] {1,0,2};
		boolean status = gameHelper.checkRowsForGameWin(arr);
		Assert.assertFalse(status);
	}
	
	@Test
	public void testCheckRowsForGameWin() {
		int[] arr = new int[] {1,1,1};
		boolean status = gameHelper.checkRowsForGameWin(arr);
		Assert.assertTrue(status);
	}
	
	@Test
	public void testCheckColsForGameWin() {
		int[][] game = new int[3][3];
		game[0][0] = 1;
		game[1][0] = 1;
		game[2][0] = 1;
		boolean status = gameHelper.checkColsForGameWin(game, 0);
		Assert.assertTrue(status);
	}
	
	@Test
	public void testCheckColsForGameWinFalse() {
		int[][] game = new int[3][3];
		boolean status = gameHelper.checkColsForGameWin(game, 0);
		Assert.assertFalse(status);	
	}
	
	@Test
	public void testCheckDiagonalsForGameWin() {
		int[][] game = new int[3][3];
		game[0][0] = 1;
		game[1][1] = 1;
		game[2][2] = 1;
		boolean status = gameHelper.checkDiagonalsForGameWin(game);
		Assert.assertTrue(status);
	}
	
	@Test
	public void testCheckDiagonalsForGameWinFalse() {
		int[][] game = new int[3][3];
		game[0][0] = 1;
		game[1][1] = 0;
		game[2][2] = 1;
		boolean status = gameHelper.checkDiagonalsForGameWin(game);
		Assert.assertFalse(status);
	}
}
