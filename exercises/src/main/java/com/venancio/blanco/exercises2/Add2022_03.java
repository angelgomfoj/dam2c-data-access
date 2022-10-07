package com.venancio.blanco.exercises2;

import java.io.File;
import java.util.Scanner;

public class Add2022_03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la ruta de un archivo existente:");
		File archive = new File(sc.nextLine());
		sc.close();
		if (archive.isFile() && archive.length() > 0) {
			System.out.println("Introduce un formato de salida: caracter, enteros, hexadecimal, octal o binario,");
			String format = sc.nextLine();

			switch (format) {
			case "caracter":
				readFile();
				writeCharFile();
				break;
			case "enteros":
				readFile();
				writeIntFile();

				break;
			case "hexadecimal":
				readFile();
				writeHexaFile();

				break;
			case "octal":
				readFile();
				writeOctalFile();
				break;
			case "binario":
				readFile();
				writeBinaryFile();
				break;

			default:
				System.err.println("El formato introducido no es valido.\nTerminando programa...");
				break;
			}

		} else {
			System.err.println("El archivo introducido no existe o está vacío.\n" + "Terminando el programa...");
		}
	}

	private static void writeBinaryFile() {
		// TODO Auto-generated method stub

	}

	private static void writeOctalFile() {
		// TODO Auto-generated method stub

	}

	private static void writeHexaFile() {
		// TODO Auto-generated method stub

	}

	private static void writeIntFile() {
		// TODO Auto-generated method stub

	}

	private static void writeCharFile() {
		// TODO Auto-generated method stub

	}

	private static void readFile() {
		// TODO Auto-generated method stub

	}
}
