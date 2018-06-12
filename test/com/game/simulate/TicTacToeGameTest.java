package com.game.simulate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.game.builder.WinBuilder;
import com.game.exception.InvalidInput;
import com.game.exception.InvalidPositionException;
import com.game.model.Position;
import com.game.model.Win;
import com.game.service.GameService;
import com.game.util.PrintUtility;
import com.game.util.ScannerUtil;

public class TicTacToeGameTest {
	
	@InjectMocks
	private TicTacToeGame ticTacToeGame;
	
	@Mock
	private GameService mockGameService;
	
	@Mock
	private PrintUtility mockPrintUtility;
	
	@Mock
	private ScannerUtil scanner;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testInitThrowsInvalidInput() throws InvalidInput, InvalidPositionException {
		when(scanner.nextInput()).thenReturn("[0,0]").thenReturn("1,1");
		exception.expect(InvalidInput.class);
		
		ticTacToeGame.init();
		
		verify(mockGameService).createGame();
		verify(mockGameService).tickPlayer1(any(Position.class));
		verify(scanner, times(2)).nextInput();
		verify(mockPrintUtility, times(7)).print(any(String.class));
		verify(mockPrintUtility).printMatrix(any());
	}
	
	@Test
	public void testInit() throws InvalidInput, InvalidPositionException {
		Win win = new WinBuilder().withGameCompleted(true).withWinPlayer("Player1").build();
		when(scanner.nextInput()).thenReturn("[0,0]").thenReturn("[0,1]").thenReturn("[1,1]")
			.thenReturn("[0,2]").thenReturn("[2,2]");
		when(mockGameService.checkWin()).thenReturn(win);
		
		ticTacToeGame.init();
		
		verify(mockGameService).createGame();
		verify(mockGameService, times(3)).tickPlayer1(any(Position.class));
		verify(mockGameService, times(2)).tickPlayer2(any(Position.class));
		verify(scanner, times(5)).nextInput();
		verify(mockPrintUtility, times(11)).print(any(String.class));
		verify(mockPrintUtility, times(5)).printMatrix(any());
	}
}
