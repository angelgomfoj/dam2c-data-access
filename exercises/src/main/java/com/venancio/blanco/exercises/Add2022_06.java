package com.venancio.blanco.exercises;

import java.io.File;
import java.util.Scanner;

public class Add2022_06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una ruta");
		String path = sc.nextLine();
		sc.close();

		File objF = new File(path);

		if (objF.exists()) {
			System.out.println("La ruta introducida existe...\nContinuando con el proceso...");
			if (objF.isFile()) {
				System.out.println("La ruta corresponde a un archivo.");

				System.out.printf("--------------------------------------------------------------%n");
				System.out.printf("| %-10s | %-8s | %4s | %,d %s |%n", "ARCHIVO", objF.getName(), getExtension(objF),
						objF.length(), "Bytes");
				System.out.printf("--------------------------------------------------------------%n");
			} else {
				System.out.println("La ruta corresponde a un directorio.");
				recursiveFiles(objF, "\t");

			}
		} else {

			System.err.println("La ruta no existe...\nFinalizando programa...");
		}
	}

	public static String getExtension(File file) {
		String fileName = file.getName();
		String extension;
		int i = fileName.lastIndexOf('.');
		if (i > 0) {
			extension = fileName.substring(i + 1);
			return extension;
		}
		return "error adquiriendo la extension";
	}

	public static void recursiveFiles(File path, String separator) {
		File[] files = path.listFiles();

		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				System.out.println(separator + files[i].getName());
				if (files[i].isDirectory()) {
					String new_separator = separator + " ";
					recursiveFiles(files[i], new_separator);
				}
			}
		}
	}

}
