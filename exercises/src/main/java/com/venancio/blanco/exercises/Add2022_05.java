package com.venancio.blanco.exercises;

import java.io.File;
import java.util.Scanner;

public class Add2022_05 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		File rutaDir;
		String ext;

		do {
			System.out.println("Introduce una ruta a un directorio existente:");
			rutaDir = new File(sc.nextLine());
		} while (!rutaDir.exists());

		do {
			System.out.println("Introduce una extensión de 3 o 4 caracteres alfanumericos:");
			ext = sc.nextLine();
		} while (!isValidExt(ext));

		sc.close();
		
		rutaDir.

	}

	private static boolean isValidExt(String ext) {
		return ext.matches("^[a-zA-Z0-9]*$") && (ext.length() == 4 || ext.length() == 3);
	}

}
