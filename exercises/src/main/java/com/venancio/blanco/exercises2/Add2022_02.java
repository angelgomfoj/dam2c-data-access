package com.venancio.blanco.exercises2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Add2022_02 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la ruta a un archivo NO existente:");
		File archive = new File(sc.nextLine());
		sc.close();
		if (!archive.exists()) {
			archive.createNewFile();
			writeFile(archive);

		} else {
			System.err.println("La ruta introducida ya existe.\n" + "Terminando el programa...");
		}
	}

	private static void writeFile(File file) {
		Random r = new Random();
		int n = r.nextInt(1001) + 1000;
		String text = "";
		for (int i = 0; i < n; i++) {
			text += getRandomWord();
			if (i < n - 1) {
				text += ",";
			}
		}
		try (PrintWriter p = new PrintWriter(new FileOutputStream(file))) {
			p.print(text);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

	}

	private static String getRandomWord() {
		// ((max - min +1 ) +min)
		Random r = new Random();
		Random r2 = new Random();
		int n = r.nextInt(11) + 10;
		String word = "";
		for (int i = 0; i < n; i++) {
			word += (char) (r2.nextInt(26) + 97);
		}
		return word;
	}

}
