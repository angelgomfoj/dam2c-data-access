package com.venancio.blanco.exercises2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Add2022_09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la ruta a un archivo existente:");
		String archivePath = sc.nextLine();
		sc.close();
		File archiveOrigin = new File(archivePath);
		File archiveNew = new File(archivePath.split(".")[0] + "AlReves" + archivePath.split(".")[1]);
		List<Byte> bytesArchivo = new ArrayList<>();

		try (FileReader fr = new FileReader(archiveOrigin); FileWriter fw = new FileWriter(archiveNew)) {
			while (fr.read() != -1) {
				bytesArchivo.add((byte) fr.read());
			}
			Collections.reverse(bytesArchivo);
			for (Byte byte1 : bytesArchivo) {
				fw.write(0);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
