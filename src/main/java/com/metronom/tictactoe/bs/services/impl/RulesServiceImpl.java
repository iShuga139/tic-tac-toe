package com.metronom.tictactoe.bs.services.impl;

import com.metronom.tictactoe.bs.services.RulesService;
import com.metronom.tictactoe.bs.services.helpers.RulesHelper;

public class RulesServiceImpl implements RulesService {

	private final RulesHelper rulesHelper;

	public RulesServiceImpl() {
		this.rulesHelper = new RulesHelper();
	}

	public boolean playerHasWon(String[][] board, int playfieldSize, int positionX, int positionY,
			String playerSymbol) {
		boolean hasWon = rulesHelper.wonInRow(board, playfieldSize, positionX, playerSymbol);
		if (hasWon) {
			return hasWon;
		}

		hasWon = rulesHelper.wonInColumn(board, playfieldSize, positionY, playerSymbol);
		if (hasWon) {
			return hasWon;
		}

		hasWon = rulesHelper.wonInDiagonal(board, playfieldSize, playerSymbol);
		if (hasWon) {
			return hasWon;
		}

		return rulesHelper.wonInInverseDiagonal(board, playfieldSize, playerSymbol);
	}

	public boolean isValidMove(String[][] board, int playfieldSize, int positionX, int positionY) {
		if (positionX >= 1 && positionX <= playfieldSize && positionY >= 1 && positionY <= playfieldSize) {
			return board[positionX][positionY] == null;
		}

		return false;
	}

	public boolean isTie(String[][] board, int playfieldSize) {
		for (int row = 1; row <= playfieldSize; row++) {
			for (int column = 1; column <= playfieldSize; column++) {
				if (board[row][column] == null) {
					return false;
				}
			}
		}

		return true;
	}

}
