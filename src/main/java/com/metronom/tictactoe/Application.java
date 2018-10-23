package com.metronom.tictactoe;

import com.metronom.tictactoe.bs.Game;

public class Application {

	/**
	 * Main process to start a new Tic Tac Toe game
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Configuration config = new Configuration("tic_tac_toe_config.txt");

		int playFieldSize = Integer.parseInt(config.getProperties().get("playfieldSize"));
		int maxSize = playFieldSize + 1;

		String symbolPlayerOne = config.getProperties().get("symbolPlayerOne");
		String symbolPlayerTwo = config.getProperties().get("symbolPlayerTwo");
		String symbolPlayerThree = config.getProperties().get("symbolPlayerThree");

		Game game = new Game(playFieldSize, maxSize, symbolPlayerOne, symbolPlayerTwo, symbolPlayerThree);
		game.start();
	}

}
