package com.metronom.tictactoe.bs.services.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.metronom.tictactoe.bs.services.CPUService;

public class CPUServiceImplTest {

	private CPUService cpuService;

	@BeforeEach
	public void setUp() {
		cpuService = new CPUServiceImpl();
	}

	@Test
	public void shouldReturnAMove() {
		String cpuMovement = cpuService.getCPUInput(new String[6][6], 5, "*");
		assertTrue(cpuMovement.matches("^(\\d{1},\\d{1})"));
	}

}
