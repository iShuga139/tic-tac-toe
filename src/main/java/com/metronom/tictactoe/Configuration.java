package com.metronom.tictactoe;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class Configuration {

	private Map<String, String> properties = new HashMap<String, String>();

	/**
	 * Load the configuration from a file
	 * 
	 * @param fileName
	 */
	public Configuration(String fileName) {
		try {
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			InputStream inputStream = classloader.getResourceAsStream(fileName);
			Reader fileReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String[] dataFromFile;
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				dataFromFile = line.split("=");
				getProperties().put(dataFromFile[0], dataFromFile[1]);
			}
			fileReader.close();
			checkConfiguration();
		} catch (Exception e) {
			System.out.println("An error occurred, Tic-Tac-Toe started with default properties.\n");
			System.out.println("_______________________________________________________________\n");
			setDefaultProperties();
		}
	}

	private void checkConfiguration() {
		getProperties().forEach((key, value) -> {
			if (!key.equals("playfieldSize")) {
				if (value.equals("|") || value.equals("-") || value.equals(" ") || value.length() != 1) {
					System.out.println("The configuration is invalid, Tic-Tac-Toe started with default properties.\n");
					System.out.println("__________________________________________________________________________\n");
					setDefaultProperties();
					return;
				}
			}
		});

		try {
			int size = Integer.parseInt(getProperties().get("playfieldSize"));
			if (size < 3 || size > 10) {
				System.out.println("The playfieldSize is invalid, Tic-Tac-Toe started with default properties.\n");
				System.out.println("__________________________________________________________________________\n");
				setDefaultProperties();
			}
		} catch (Exception e) {
			System.out.println("An error occurred, Tic-Tac-Toe started with default properties.\n");
			System.out.println("_______________________________________________________________\n");
			setDefaultProperties();
		}
	}

	private void setDefaultProperties() {
		getProperties().clear();
		getProperties().put("playfieldSize", "3");
		getProperties().put("symbolPlayerOne", "X");
		getProperties().put("symbolPlayerTwo", "O");
		getProperties().put("symbolPlayerThree", "Z");
	}

	public Map<String, String> getProperties() {
		return properties;
	}

}
