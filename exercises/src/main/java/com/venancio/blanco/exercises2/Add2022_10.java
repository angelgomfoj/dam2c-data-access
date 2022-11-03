package com.venancio.blanco.exercises2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Add2022_10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la ruta a un archivo existente:");
		String archivePath = sc.nextLine();
		sc.close();
		File archiveOrigin = new File(archivePath);
		String parentPath = archiveOrigin.getParent();
		char[] charNewName = archiveOrigin.getName().split("\\.")[0].toCharArray();
		List<Character> listaChars = new ArrayList<>();
		for (char c : charNewName) {
			listaChars.add(c);
		}

		Collections.reverse(listaChars);

		String newName = "";
		for (Character character : listaChars) {
			newName += character;
			System.out.println(character);
		}

		File archiveNew = new File(parentPath + File.separatorChar + newName + ".sever");
		if (archiveNew.exists()) {
			archiveNew.delete();
		}

		try (RandomAccessFile raf1 = new RandomAccessFile(archiveOrigin, "r");
				RandomAccessFile raf2 = new RandomAccessFile(archiveNew, "rw")) {

			for (long i = raf1.length() - 1; i >= 0; i--) {
				raf1.seek(i);
				raf2.writeByte(raf1.readByte());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
