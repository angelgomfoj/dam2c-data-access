package com.venancio.blanco.exercises2;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Add2022_LeeDatosPersonas {
	public static void main(String[] args) {
		Person p;
		try (FileInputStream fis = new FileInputStream("C:\\Users\\6002281\\Desktop\\objetos");
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			while (true) {
				try {
					p = (Person) ois.readObject();
					System.out.println(p);
				} catch (EOFException e) {
					System.out.println("Fin de la lectura");
					break;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
