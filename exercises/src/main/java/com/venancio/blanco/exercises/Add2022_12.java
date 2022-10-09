package com.venancio.blanco.exercises;

import java.io.File;

public class Add2022_12 {
	public static void main(String[] args) {
		File[] unitsList = File.listRoots();

		for (File file : unitsList) {
			System.out.println("Unidad-> " + file.getAbsolutePath() + "\nEspacio total: " + file.getTotalSpace()
					+ "\nEspacio libre: " + file.getFreeSpace());
			System.out.println();
		}

	}
}
