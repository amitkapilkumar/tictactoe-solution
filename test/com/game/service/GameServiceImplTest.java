package com.game.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.game.builder.PositionBuilder;
import com.game.exception.InvalidPositionException;
import com.game.helper.GameHelper;
import com.game.model.Position;
import com.game.model.Win;

public class GameServiceImplTest {
	@InjectMocks
	private GameServiceImpl gameServiceImpl;
	
	@Mock
	private GameHelper gameHelper;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreateGame() {
		gameServiceImpl.createGame();
		Assert.assertNotNull(gameServiceImpl.getMatrix());
	}
	
	@Test
	public void testIsAllCellFilledTrue() {
		gameServiceImpl.createGame();
		int[][] game = gameServiceImpl.getMatrix();
		for(int i=0; i < 3 ; i++) {
			for(int j=0; j < 3; j++) {
				game[i][j] = 1;
			}
		}
		Assert.assertTrue(gameServiceImpl.isAllCellFilled());
	}
	
	@Test
	public void testIsAllCellFilledFalse() {
		gameServiceImpl.createGame();
		Assert.assertFalse(gameServiceImpl.isAllCellFilled());
	}
	
	@Test
	public void testTickPlayer1() throws InvalidPositionException {
		Position pos = new PositionBuilder().withX(1).withY(1).build();
		gameServiceImpl.createGame();
		gameServiceImpl.tickPlayer1(pos);
		
		verify(gameHelper).validate(pos);
	}

	@Test
	public void testTickPlayer1Exception() throws InvalidPositionException {
		Position pos = new PositionBuilder().withX(1).withY(1).build();
		gameServiceImpl.createGame();
		int[][] game = gameServiceImpl.getMatrix();
		game[1][1] = 1;
		exception.expect(InvalidPositionException.class);
		gameServiceImpl.tickPlayer1(pos);
		
		verify(gameHelper).validate(pos);
	}
	
	@Test
	public void testCheckWin() {
		gameServiceImpl.createGame();
		int[][] game = gameServiceImpl.getMatrix();
		game[0][0] = 1;
		when(gameHelper.checkRowsForGameWin(any())).thenReturn(true);
		
		Win win = gameServiceImpl.checkWin();
		Assert.assertTrue(win.isGameCompleted());
		Assert.assertEquals(win.getWinner(), "Player1");
	}
}
