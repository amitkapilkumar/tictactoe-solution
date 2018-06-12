package com.game.factory;

import org.junit.Assert;
import org.junit.Test;

import com.game.simulate.TicTacToeGame;

public class TicTacToeGameFactoryTest {

	@Test
	public void testGetInstance() {
		TicTacToeGame game = TicTacToeGameFactory.getInstance();

		Assert.assertNotNull(game);
		Assert.assertNotNull(game.getGameService());
		Assert.assertNotNull(game.getPrintUtility());
		Assert.assertNotNull(game.getScannerUtil());
		Assert.assertEquals(game, TicTacToeGameFactory.getInstance());
	}

}