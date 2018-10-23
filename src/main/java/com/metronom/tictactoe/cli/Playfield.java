package com.metronom.tictactoe.cli;

import java.util.List;

import com.metronom.tictactoe.bo.Player;

public class Playfield {

	private static final int SIZE_LINE = 5;
	private static final int MORE_SIZE_LINE = 5;
	private static final int CELL_SIZE = 5;

	protected void printHeaders(List<Player> playerList, int playfieldSize) {
		System.out.println();
		System.out.println("TIC-TAC-TOE 2.0 (" + playfieldSize + "x" + playfieldSize + ")");
		System.out.println("=======================");

		for (Player player : playerList) {
			System.out.println(player.getName() + " => " + player.getPlayerType() + " (" + player.getSymbol() + ")");
		}

		System.out.println();
	}

	protected void printBoard(int playfieldSize, String[][] positions) {
		for (int row = 1; row <= playfieldSize; row++) { // number of row to draw
			for (int column = 1; column <= playfieldSize; column++) { // number of columns to draw
				for (int cell = 0; cell < CELL_SIZE; cell++) { // fill the cell with a symbol if applies
					if (positions[column][row] != null && cell == 2) {
						System.out.print(positions[column][row]);
					} else {
						System.out.print(" ");
					}
				}

				if (column != playfieldSize) {
					System.out.print("|");
				}
			}

			System.out.println();
			if (row != playfieldSize) {
				for (int positionLine = 0; positionLine < ((playfieldSize * SIZE_LINE)
						+ MORE_SIZE_LINE); positionLine++) {
					System.out.print("-");
				}

				System.out.println();
			}
		}
	}

	protected void printFooterNextTurn(String playerName, String badPosition, boolean isValid) {
		if (!isValid) {
			System.out.println("The position " + badPosition + " is invalid");
		}

		System.out.println(playerName + " is your turn, type your next position:");
	}

	protected void printFooterHasWon(String playerName) {
		System.out.println(playerName + " you won. Congratulations!!");
	}

	protected void printFooterHaveTie() {
		System.out.println("It is a tie!!");
	}

}
