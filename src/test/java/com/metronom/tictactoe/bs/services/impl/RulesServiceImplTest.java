package com.metronom.tictactoe.bs.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.metronom.tictactoe.bs.services.RulesService;

public class RulesServiceImplTest {

	private RulesService rulesService;
	private String[][] board;
	private static final int PLAYFIELD_SIZE = 5;

	@BeforeEach
	public void setUpTest() {
		rulesService = new RulesServiceImpl();
		board = new String[6][6];

		for (int position = 1; position < PLAYFIELD_SIZE; position++) {
			board[position][position] = "X";
			board[position][5] = "O";
			board[5][position] = "Z";
		}
	}

	@Test
	public void returnTrueWhenIsAValidMove() {
		boolean isValid = rulesService.isValidMove(board, PLAYFIELD_SIZE, 2, 3);

		assertEquals(isValid, Boolean.TRUE);
	}

	@Test
	public void returnFalseWhenIsInvalidMove() {
		boolean isValid = rulesService.isValidMove(board, PLAYFIELD_SIZE, 3, 3);

		assertEquals(isValid, Boolean.FALSE);
	}

	@Test
	public void returnTrueWhenPlayerHasNotWon() {
		boolean hasWon = rulesService.playerHasWon(board, PLAYFIELD_SIZE, 2, 1, "O");

		assertEquals(hasWon, Boolean.FALSE);
	}

	@Test
	public void returnTrueWhenPlayerHasWonInColumn() {
		board[5][5] = "O";
		boolean hasWon = rulesService.playerHasWon(board, PLAYFIELD_SIZE, 5, 5, "O");

		assertEquals(hasWon, Boolean.TRUE);
	}

	@Test
	public void returnTrueWhenPlayerHasWonInRow() {
		board[5][5] = "Z";
		boolean hasWon = rulesService.playerHasWon(board, PLAYFIELD_SIZE, 5, 5, "Z");

		assertEquals(hasWon, Boolean.TRUE);
	}

	@Test
	public void returnTrueWhenPlayerHasWonInDiagonal() {
		board[5][5] = "X";
		boolean hasWon = rulesService.playerHasWon(board, PLAYFIELD_SIZE, 5, 5, "X");

		assertEquals(hasWon, Boolean.TRUE);
	}

	@Test
	public void returnTrueWhenPlayerHasWonInInverseDiagonal() {
		for (int position = PLAYFIELD_SIZE; position > 0; position--) {
			board[position][position] = "Z";
		}

		boolean hasWon = rulesService.playerHasWon(board, PLAYFIELD_SIZE, 5, 5, "Z");

		assertEquals(hasWon, Boolean.TRUE);
	}

	@Test
	public void returnTrueWhenPlayersTie() {
		for (int row = 1; row <= PLAYFIELD_SIZE; row++) {
			for (int column = 1; column <= PLAYFIELD_SIZE; column++) {
				board[row][column] = "Y";
			}
		}

		boolean isTie = rulesService.isTie(board, PLAYFIELD_SIZE);

		assertEquals(isTie, Boolean.TRUE);
	}

}
