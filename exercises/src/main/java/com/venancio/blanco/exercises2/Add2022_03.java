package com.venancio.blanco.exercises2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Add2022_03 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la ruta de un archivo existente:");
		File archive = new File(sc.nextLine());
		sc.close();
		if (archive.isFile() && archive.length() > 0) {
			System.out.println("Introduce un formato de salida: caracter, enteros, hexadecimal, octal o binario,");
			String format = sc.nextLine().toLowerCase();

			switch (format) {
			case "caracter":
			case "enteros":
			case "hexadecimal":
			case "octal":
			case "binario":
				createFormatFile(archive, format);
				break;
			default:
				System.err.println("El formato introducido no es valido.\nTerminando programa...");
				break;
			}

		} else {
			System.err.println("El archivo introducido no existe o está vacío.\n" + "Terminando el programa...");
		}
	}

	private static void createFormatFile(File archive, String format) throws IOException {
		String fileName = archive.getName();
		if (fileName.contains(".")) {
			int temp = fileName.lastIndexOf('.');
			fileName = fileName.substring(0, temp);
		}
		String newFileName = fileName + "_" + format + ".txt";

		File newArchive = new File(archive.getParent() + File.separatorChar + newFileName);
		newArchive.createNewFile();

		// 2nd part
		try (FileInputStream is = new FileInputStream(archive);
				FileOutputStream os = new FileOutputStream(newArchive);) {

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
