package com.metronom.tictactoe.bo;

import com.metronom.tictactoe.bo.enums.PlayerType;

public class Player {

	private String name;
	private String symbol;
	private PlayerType playerType;

	public Player() {
	}

	public Player(String name, String symbol, PlayerType playerType) {
		super();
		this.name = name;
		this.symbol = symbol;
		this.playerType = playerType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public PlayerType getPlayerType() {
		return playerType;
	}

	public void setPlayerType(PlayerType playerType) {
		this.playerType = playerType;
	}

}
