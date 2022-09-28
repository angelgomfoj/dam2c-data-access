package com.venancio.blanco.exercises;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author 6002281
 */
public class Add2022_02 {
	public static void main(String[] args) {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		int num = r.nextInt(26) + 25;
		System.out.println("Introduce un nombre para los directorios:");
		String dirName = sc.nextLine();
		sc.close();

		for (int i = 0; i < num; i++) {
			String path = "DirContenedor";
			path += "\\" + dirName;
			if (i < 10) {
				path += "0";
			}
			path += i;
			File objF = new File(path);
			objF.mkdirs();
		}
	}
}
