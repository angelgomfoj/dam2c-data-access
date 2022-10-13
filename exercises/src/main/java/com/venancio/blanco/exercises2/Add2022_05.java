package com.venancio.blanco.exercises2;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Add2022_05 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		File archive;
		Random r = new Random();
		int numQuantity = r.nextInt(1001) + 1000;
		do {
			System.out.println("Introduce la ruta a un archivo no existente:");
			archive = new File(sc.nextLine());

		} while (archive.isFile());

		sc.close();

		archive.createNewFile();

		try (FileOutputStream fos = new FileOutputStream(archive); DataOutputStream dos = new DataOutputStream(fos)) {
			for (int i = 0; i < numQuantity; i++) {
				dos.writeDouble(r.nextDouble());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("El tamaño del archivo es: " + archive.length() + " BYTES");
		System.out.println("La cantidad de numeros almacenados es: " + numQuantity);

	}
}
