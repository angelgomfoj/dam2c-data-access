package com.venancio.blanco.exercises;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Add2022_07 {
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		String originPath, destinationPath;
		File originPathFile, destinationPathFile;

		do {
			System.out.println("Introduce la ruta de un directorio existente:");
			originPath = sc.nextLine();
			originPathFile = new File(originPath);
		} while (!originPathFile.exists());

		do {
			System.out.println("Introduce una ruta a un directorio NO existente:");
			destinationPath = sc.nextLine();
			destinationPathFile = new File(destinationPath);
		} while (destinationPathFile.exists());

		sc.close();

		File[] filesList = originPathFile.listFiles();
		File newDir = new File(destinationPath);
		newDir.mkdirs();
		for (File file : filesList) {
			String temp = destinationPath + File.separatorChar + file.getName();
			File tempFile = new File(temp);
			if (file.isFile()) {
				tempFile.createNewFile();
			} else {
				tempFile.mkdir();
			}
		}
	}

}
