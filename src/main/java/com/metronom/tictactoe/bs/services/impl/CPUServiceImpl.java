package com.metronom.tictactoe.bs.services.impl;

import com.metronom.tictactoe.bs.services.CPUService;
import com.metronom.tictactoe.bs.services.helpers.CPUHelper;

public class CPUServiceImpl implements CPUService {

	private final CPUHelper cpuMovesHelper;

	public CPUServiceImpl() {
		cpuMovesHelper = new CPUHelper();
	}

	public String getCPUInput(String[][] board, int playfieldSize, String cpuSymbol) {
		return cpuMovesHelper.getBestMove(board, playfieldSize, cpuSymbol);
	}

}
