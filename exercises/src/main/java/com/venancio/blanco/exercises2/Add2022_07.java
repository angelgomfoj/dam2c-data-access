package com.venancio.blanco.exercises2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Add2022_07 {
	public static void main(String[] args) {
		final char DATA_SEPARATOR = ',';
		File archive = new File("C:\\Users\\6002281\\Desktop\\csv.txt");
		try {
			archive.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (FileWriter fw = new FileWriter(archive)) {
			for (int i = 0; i < 10000; i++) {
				fw.write(String.valueOf(getNum()));
				fw.write(DATA_SEPARATOR);
				fw.write(getWord());
				fw.write("\n");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static String getWord() {
		Random r = new Random();
		String word = "";
		int numLetters = r.nextInt(8, 17);
		for (int i = 0; i < numLetters; i++) {
			word += (char) r.nextInt(97, 123);
		}
		return word;
	}

	private static int getNum() {
		Random r = new Random();
		return r.nextInt(-1000000, 1000001);
	}
}
