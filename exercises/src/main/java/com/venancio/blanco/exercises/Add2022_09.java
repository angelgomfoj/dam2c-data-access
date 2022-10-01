package com.venancio.blanco.exercises;

import java.io.File;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Add2022_09 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la ruta de un archivo:");
		String path = sc.nextLine();
		sc.close();

		File objF = new File(path);

		boolean createdArchive = false;

		if (objF.exists()) {
			System.out.println("El fichero introducido existe.");
			createdArchive = true;
		} else {
			System.out.println("El fichero no existe, se procedera a la creación de un archivo...");
			if (path != "" && isValidPath(path)) {
				createdArchive = objF.createNewFile();
				System.out.println("El archivo ha sido creado con exito.");
			}
		}

		if (createdArchive) {

			File objDir = new File(path + "dir");

			if (!objDir.exists() || objDir.isDirectory()) {
				if (!objDir.exists()) {
					objDir.mkdirs();
				}
				long fileLength = objF.length();
				String destinationPath = objDir.getAbsolutePath() + File.separator + objF.getName();
				objF.renameTo(new File(destinationPath));
				// The commented code below wont work because: Instances of the File class are
				// immutable; that is,
				// once created, the abstract pathname represented by a File object will never
				// change.

				// System.out.println(objF.getAbsolutePath() + " " + objF.length() + " BYTES");

				// So we're doing this instead:

				System.out.println("La nueva ruta del fichero es:\n" + destinationPath + " " + fileLength + " BYTES");

			} else {
				System.err.println("Existe un fichero con el nombre " + objDir.getName()
						+ " ,\n por tanto no se puede realizar el ejercicio;\nTerminando programa...");
			}
		} else {
			System.err.println(
					"ERROR al crear el archivo.\nEl nombre del fichero introducido no es valido...\nTerminando programa...");
		}

	}

	public static boolean isValidPath(String path) {
		try {
			Paths.get(path);
		} catch (InvalidPathException | NullPointerException ex) {
			return false;
		}
		return true;
	}

}