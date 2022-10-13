package com.venancio.blanco.exercises2;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class Add2022_06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File archive;
		do {
			System.out.println("Introduce la ruta a un archivo existente:");
			archive = new File(sc.nextLine());

		} while (!archive.isFile());

		sc.close();

		try (FileInputStream fis = new FileInputStream(archive); DataInputStream dis = new DataInputStream(fis)) {
			while (fis.available() > 0) {
				System.out.println(dis.readDouble());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
