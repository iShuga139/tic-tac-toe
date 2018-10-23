package com.metronom.tictactoe.bs.services;

public interface RulesService {

	boolean playerHasWon(String[][] board, int playfieldSize, int positionX, int positionY, String playerSymbol);

	boolean isValidMove(String[][] board, int playfieldSize, int positionX, int positionY);

	boolean isTie(String[][] board, int playfieldSize);

}
