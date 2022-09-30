package com.venancio.blanco.exercises;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Add2022_09 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la ruta de un archivo:");
		String path = sc.nextLine();
		sc.close();

		File objF = new File(path);

		if (objF.exists()) {
			System.out.println("El fichero introducido existe.");
		} else {
			System.out.println("El fichero no existe, se procedera a su creacion...");
			boolean result = objF.isDirectory() ? objF.createNewFile() : objF.mkdir();
			System.out.println(result ? "El fichero ha sido creado con exito." : "Error al crear el archivo.");
		}
		
		File objDir = new File(path+"dir");
		if(objDir.isDirectory())
			//Esta mal, tengo que crear siempre arichivo a partir del nombre que me den por teclado.

	}
}{

}