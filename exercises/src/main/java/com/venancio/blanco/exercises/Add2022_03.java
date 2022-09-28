package com.venancio.blanco.exercises;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author 6002281
 */
public class Add2022_03 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un texto");
		String texto = sc.nextLine();

		System.out.println("Si desea crear un archivo introduzca archivo \n"
				+ "si desea crear un directorio introduzca directorio");
		String creationElement = sc.nextLine();
		sc.close();

		if (isAlphaNumeric(texto)) {
			File objF = new File(texto);
			if (creationElement.equalsIgnoreCase("archivo")) {
				String result = objF.createNewFile() ? "El archivo ha sido creado" : "El archivo ya existe.";
				System.out.println(result);
			} else if (creationElement.equalsIgnoreCase("directorio")) {
				String result = objF.mkdirs() ? "El directorio ha sido creado" : "El directorio ya existe.";
				System.out.println(result);
			} else {
				System.out.println("parámetro no válido");
			}
		} else {
			System.err.println("El nombre contiene caracteres no alfanumericos");
		}

	}

	public static boolean isAlphaNumeric(String s) {
		return s != null && s.matches("^[a-zA-Z0-9]*$");
	}
}
