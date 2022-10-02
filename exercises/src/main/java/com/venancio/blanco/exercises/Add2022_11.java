package com.venancio.blanco.exercises;

import java.io.File;
import java.util.Scanner;

public class Add2022_11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File path;

		do {
			System.out.println("Introduce una ruta correspondiente a un directorio existente:");
			path = new File(sc.nextLine());
		} while (!path.isDirectory());

		System.out.println("Introduce la extension a reemplazar:");
		String ext1 = sc.nextLine().toLowerCase();
		System.out.println("Introduce la nueva extension:");
		String ext2 = sc.nextLine().toLowerCase();
		sc.close();
		File[] files = path.listFiles();

		for (File file : files) {
			if (file.getName().toLowerCase().endsWith("." + ext1)) {
				int temp = file.getName().toLowerCase().lastIndexOf(".");
				String name = file.getName().substring(0, temp);

				file.renameTo(new File(file.getParentFile() + File.separator + name + "." + ext2));
			}
		}
	}
}