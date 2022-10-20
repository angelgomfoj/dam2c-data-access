package com.venancio.blanco.exercises2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Add2022_08 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		File archive;
		String line = "";
		do {
			System.out.println("Introduce una ruta que no exista.");
			archive = new File(sc.nextLine());
		} while (archive.exists());
		archive.createNewFile();
		System.out
				.println("Introduce tantas lineas de texto como desees.\nEscribe: Salir... para terminar el programa");
		try (FileWriter fw = new FileWriter(archive)) {
			while (!line.equals("Salir...")) {
				line = sc.nextLine();
				if (!line.equals("Salir...")) {
					fw.write(line + "\n");
				}
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
