package com.venancio.blanco.exercises;

import java.io.File;
import java.util.Scanner;

public class Add2022_05 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		File directoryPath;
		String extension;

		do {
			System.out.println("Introduce una ruta a un directorio existente:");
			directoryPath = new File(sc.nextLine());
		} while (!directoryPath.exists());

		do {
			System.out.println("Introduce una extensión de 3 o 4 caracteres alfanumericos:");
			extension = sc.nextLine();
		} while (!isValidExt(extension));

		sc.close();

		File[] files = directoryPath.listFiles();

		for (File file : files) {
			if (file.getName().endsWith("." + extension)) {
				System.out.println(file.getName() + "\t" + file.length() + " BYTES\t" + file.getAbsolutePath());
			}
		}

	}

	private static boolean isValidExt(String ext) {
		return ext.matches("^[a-zA-Z0-9]*$") && (ext.length() == 4 || ext.length() == 3);
	}

}
