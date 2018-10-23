package com.metronom.tictactoe.bs.services.helpers;

public class RulesHelper {

	public boolean wonInRow(String[][] board, int playfieldSize, int positionX, String playerSymbol) {
		String value = "";

		for (int column = 1; column <= playfieldSize; column++) {
			value = board[positionX][column];

			if (value == null || !value.equals(playerSymbol)) {
				return false;
			}
		}

		return true;
	}

	public boolean wonInColumn(String[][] board, int playfieldSize, int positionY, String playerSymbol) {
		String value = "";

		for (int row = 1; row <= playfieldSize; row++) {
			value = board[row][positionY];

			if (value == null || !value.equals(playerSymbol)) {
				return false;
			}
		}

		return true;
	}

	public boolean wonInDiagonal(String[][] board, int playfieldSize, String playerSymbol) {
		String value = "";

		for (int position = 1; position <= playfieldSize; position++) {
			value = board[position][position];

			if (value == null || !value.equals(playerSymbol)) {
				return false;
			}
		}

		return true;
	}

	public boolean wonInInverseDiagonal(String[][] board, int playfieldSize, String playerSymbol) {
		String value = "";
		int row = 1;

		for (int column = playfieldSize; column >= 1; column--) {
			value = board[row][column];

			if (value == null || !value.equals(playerSymbol)) {
				return false;
			}

			row++;
		}

		return true;
	}

	public boolean playersTie(String[][] board) {
		return true;
	}

}
