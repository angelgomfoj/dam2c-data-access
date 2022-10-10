package com.venancio.blanco.exercises2;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

public class Add2022_04 {
	public static void main(String[] args) {
		Random r = new Random();
		File archive = new File("C:\\Users\\6002281\\Desktop\\test.txt");
		try (FileOutputStream fos = new FileOutputStream(archive)) {
			for (int i = 0; i < 10000; i++) {
				// (1000001) + min
				int num = r.nextInt(2000001) - 1000000;
				String text = String.valueOf(num);
				fos.write(text.getBytes());
				if (i < 10000 - 1) {
					fos.write(',');
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
