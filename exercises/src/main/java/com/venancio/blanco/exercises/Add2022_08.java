package com.venancio.blanco.exercises;

import java.io.File;
import java.util.Scanner;

public class Add2022_08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la ruta del archivo a eliminar:");
		String path = sc.nextLine();

		File objF = new File(path);

		if (objF.isFile()) {
			System.out.println("Se ha encontrado 1 archivo con ese nombre, ¿desea eliminarlo? (Ss/Nn)");
			String deleteConfirm = sc.nextLine();
			if (deleteConfirm.equalsIgnoreCase("s")) {
				objF.delete();
			}

		} else if (objF.isDirectory()) {
			System.out.println(
					"Se ha encontrado 1 directorio con ese nombre, ¿desea eliminarlo?\n(Tambien se eliminaran todos los archivos y carpetas vacias que contenga) (Ss/Nn)");
			String deleteConfirm = sc.nextLine();
			if (deleteConfirm.equalsIgnoreCase("s")) {
				File[] files = objF.listFiles();
				for (File file : files) {
					file.delete();
				}
				objF.delete();
			}
		} else {
			System.err.println("No existe ningun fichero con ese nombre.");
		}
		sc.close();
	}

}
