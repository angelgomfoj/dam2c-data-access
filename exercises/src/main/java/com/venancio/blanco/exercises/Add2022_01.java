package com.venancio.blanco.exercises;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author 6002281
 */
public class Add2022_01 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un nombre de fichero");
		String fileName = sc.nextLine();

		System.out.println("Si desea crear un archivo introduzca archivo \n"
				+ "si desea crear un directorio introduzca directorio");
		String creationElementType = sc.nextLine();
		sc.close();
		File objF = new File(fileName);

		if (creationElementType.equalsIgnoreCase("archivo")) {
			String result = objF.createNewFile() ? "El archivo ha sido creado" : "El archivo ya existe.";
			System.out.println(result);
		} else if (creationElementType.equalsIgnoreCase("directorio")) {
			String result = objF.mkdirs() ? "El directorio ha sido creado" : "El directorio ya existe.";
			System.out.println(result);
		} else {
			System.err.println("Parámetro no válido");
		}
	}

}
