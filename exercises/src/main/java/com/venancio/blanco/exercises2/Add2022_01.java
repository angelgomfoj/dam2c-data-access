package com.venancio.blanco.exercises2;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class Add2022_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la ruta de un archivo: ");
		File archive = new File(sc.nextLine());
		System.out.println("Si desea visualizar la salida en formato ASCII introduzca 1,\n"
				+ "si desea visualizarla en base 2 introduzca 2:");
		int format = sc.nextInt();

		try (FileInputStream fis = new FileInputStream(archive)) {
			// fis.readAllBytes();

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (format == 1) {
			// for (byte temp : archiveBytes) {

		}
	}
}
//}
