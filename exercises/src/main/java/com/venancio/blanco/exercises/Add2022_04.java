package com.venancio.blanco.exercises;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 6002281
 */
public class Add2022_04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una ruta");
		String inputRoute = sc.nextLine();
		sc.close();

		File objF = new File(inputRoute);

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
				File[] archivos = objF.listFiles();
				List<File> files = new ArrayList<>();
				List<File> directories = new ArrayList<>();
				for (File file : archivos) {
					if (file.isFile()) {
						files.add(file);
					} else {
						directories.add(file);
					}
				}

				for (File file : files) {

					System.out.printf("--------------------------------------------------------------%n");
					System.out.printf("| %-10s | %-8s | %4s | %,d %s |%n", "ARCHIVO", file.getName(),
							getExtension(file), file.length(), "Bytes");
					System.out.printf("--------------------------------------------------------------%n");
				}

				for (File file : directories) {
					System.out.printf("----------------------------------%n");
					System.out.printf("| %-10s | %-8s |%n", "DIRECTORIO", file.getName());
					System.out.printf("----------------------------------%n");
				}
			}

		} else

		{
			System.out.println("La ruta no existe...\nFinalizando programa...");
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

}
