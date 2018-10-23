package com.metronom.tictactoe.bs.services.helpers;

import java.util.Random;

import com.metronom.tictactoe.bs.services.RulesService;
import com.metronom.tictactoe.bs.services.impl.RulesServiceImpl;

public class CPUHelper {

	private final RulesService rulesService;

	public CPUHelper() {
		rulesService = new RulesServiceImpl();
	}

	/**
	 * Get the best move to do
	 * 
	 * @param board
	 * @param playfieldSize
	 * @param symbol
	 * @return
	 */
	public String getBestMove(String[][] board, int playfieldSize, String symbol) {
		Random rand = new Random();
		int rowPosition = rand.nextInt(playfieldSize) + 1;
		int columnPosition = rand.nextInt(playfieldSize) + 1;
		return rowPosition + "," + columnPosition;
		// return identifyBestMove(board, playfieldSize, symbol);
	}

	/**
	 * Identify which move is better
	 * 
	 * @param board
	 * @param symbol
	 * @return
	 */
	@SuppressWarnings("unused")
	private String identifyBestMove(String[][] board, int playfieldSize, String symbol) {
		return "";
	}

	/**
	 * Create a new board and simulate the next move.
	 * 
	 * @param board
	 * @param symbol
	 * @return
	 */
	@SuppressWarnings("unused")
	private boolean simulateStatusBoard(String[][] board, int playfieldSize, String symbol) {
		int positionX = 3;
		int positionY = 5;
		return rulesService.playerHasWon(board, playfieldSize, positionX, positionY, symbol);
	}

}
