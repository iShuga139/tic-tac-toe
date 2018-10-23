package com.metronom.tictactoe;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ConfigurationTest {

	@Test
	public void loadConfiguration() {
		Configuration config = new Configuration("tic_tac_toe_mock.txt");

		String playFieldSize = config.getProperties().get("playfieldSize");
		String symbolPlayerOne = config.getProperties().get("symbolPlayerOne");
		String symbolPlayerTwo = config.getProperties().get("symbolPlayerTwo");
		String symbolPlayerThree = config.getProperties().get("symbolPlayerThree");

		assertEquals(playFieldSize, "7");
		assertEquals(symbolPlayerOne, "A");
		assertEquals(symbolPlayerTwo, "B");
		assertEquals(symbolPlayerThree, "C");
	}

	@Test
	public void loadBadConfiguration() {
		Configuration config = new Configuration("tic_tac_toe.txt");

		String playFieldSize = config.getProperties().get("playfieldSize");
		String symbolPlayerOne = config.getProperties().get("symbolPlayerOne");
		String symbolPlayerTwo = config.getProperties().get("symbolPlayerTwo");
		String symbolPlayerThree = config.getProperties().get("symbolPlayerThree");

		assertEquals(playFieldSize, "3");
		assertEquals(symbolPlayerOne, "X");
		assertEquals(symbolPlayerTwo, "O");
		assertEquals(symbolPlayerThree, "Z");
	}

}
