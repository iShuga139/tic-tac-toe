package com.metronom.tictactoe.bs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.metronom.tictactoe.bo.Player;
import com.metronom.tictactoe.bo.enums.PlayerType;
import com.metronom.tictactoe.bs.services.CPUService;
import com.metronom.tictactoe.bs.services.RulesService;
import com.metronom.tictactoe.bs.services.impl.CPUServiceImpl;
import com.metronom.tictactoe.bs.services.impl.RulesServiceImpl;
import com.metronom.tictactoe.cli.Playfield;

public class Game extends Playfield {

	private String[][] board;
	private int playfieldSize;
	private List<Player> playerList = new ArrayList<Player>();

	public Game(int playfieldSize, int maxSize, String symbolPlayerOne, String symbolPlayerTwo,
			String symbolPlayerThree) {
		this.playfieldSize = playfieldSize;
		this.board = new String[maxSize][maxSize];

		Player playerOne = new Player("Player1", symbolPlayerOne, PlayerType.HUMAN);
		Player playerTwo = new Player("Player2", symbolPlayerTwo, PlayerType.HUMAN);
		Player playerThree = new Player("Player3", symbolPlayerThree, PlayerType.CPU);

		setWhoGoesFirst(playerOne, playerTwo, playerThree);
	}

	private void setWhoGoesFirst(Player playerOne, Player playerTwo, Player playerThree) {
		Random rand = new Random();
		int whoStarts = rand.nextInt(3) + 1;

		switch (whoStarts) {
		case 1:
			getPlayerList().add(playerOne);
			getPlayerList().add(playerTwo);
			getPlayerList().add(playerThree);
			break;
		case 2:
			getPlayerList().add(playerTwo);
			getPlayerList().add(playerOne);
			getPlayerList().add(playerThree);
			break;
		case 3:
			getPlayerList().add(playerThree);
			getPlayerList().add(playerTwo);
			getPlayerList().add(playerOne);
			break;
		}
	}

	private List<Player> getPlayerList() {
		return playerList;
	}

	private int getPlayfieldSize() {
		return playfieldSize;
	}

	private String[][] getBoard() {
		return board;
	}

	private void setBoard(int positionX, int positionY, String symbol) {
		board[positionX][positionY] = symbol;
	}

	public void start() {
		final RulesService rulesService = new RulesServiceImpl();
		final CPUService cpuService = new CPUServiceImpl();
		final Scanner scanner = new Scanner(System.in);

		String[] positions = null;
		String option = "";

		boolean endGame = false;
		boolean hasWon = false;
		boolean isValid = true;
		boolean isTie = false;

		Player player = null;

		int myTurn = 0;
		int posX = 0;
		int posY = 0;

		do {
			player = getPlayerList().get(myTurn);
			printHeaders(getPlayerList(), getPlayfieldSize());
			printBoard(getPlayfieldSize(), getBoard());

			printFooterNextTurn(player.getName(), option, isValid);

			if (player.getPlayerType().equals(PlayerType.CPU)) {
				option = cpuService.getCPUInput(getBoard(), playfieldSize, player.getSymbol());
			} else {
				option = scanner.nextLine();
			}

			positions = option.split(",");
			try {
				posX = Integer.parseInt(positions[0]);
				posY = Integer.parseInt(positions[1]);

				isValid = rulesService.isValidMove(getBoard(), getPlayfieldSize(), posX, posY);
			} catch (Exception e) {
				isValid = false;
			}

			if (isValid) {
				setBoard(posX, posY, player.getSymbol());

				hasWon = rulesService.playerHasWon(getBoard(), getPlayfieldSize(), posX, posY, player.getSymbol());
				isTie = rulesService.isTie(board, playfieldSize);

				if (!hasWon) {
					if (myTurn == 2) {
						myTurn = 0;
					} else {
						myTurn++;
					}
				} else {
					endGame = true;
				}

				if (isTie) {
					endGame = true;
				}
			}
		} while (!endGame);

		scanner.close();
		printHeaders(getPlayerList(), getPlayfieldSize());
		printBoard(getPlayfieldSize(), getBoard());

		System.out.println();
		if (hasWon) {
			printFooterHasWon(getPlayerList().get(myTurn).getName());
		} else {
			printFooterHaveTie();
		}
	}

}
