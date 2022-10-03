package com.venancio.blanco.exercises;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Add2022_10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File path;
		String newName;
		do {
			System.out.println("Introduce una ruta existente:");
			path = new File(sc.nextLine());
		} while (!path.exists());

		do {
			System.out.println("Introduce un nuevo nombre para el fichero:");
			newName = sc.nextLine();
		} while (!isValidName(newName));

		sc.close();

		path.renameTo(new File(path.getParentFile() + File.separator + newName));

		System.out.println("El nombre del fichero ha sido cambiado correctamente, su nueva ruta es:\n"
				+ path.getParentFile() + File.separator + newName);

	}

	private static boolean isValidName(String newName) {
		// Invalid characters -> (\/ :" *? <>|)
		// Note: () are not invalid characters
		Pattern p = Pattern.compile("[/:\"*?<> \\\\|]");
		Matcher m = p.matcher(newName);

		return !m.find();
	}

}
