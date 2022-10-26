package com.venancio.blanco.exercises2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Add2022_EscribeDatosPersonas {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		int decision;
		List<Person> people = new ArrayList<>();
		Person p;
		File archive = new File("C:\\Users\\6002281\\Desktop\\objetos");

		do {
			System.out.println("[1] Crear persona\n[2] Salir");
			decision = Integer.parseInt(sc.nextLine());
			if (decision == 1) {
				p = new Person();
				System.out.println("Nombre1:");
				p.setName1(sc.nextLine());
				System.out.println("Nombre2:");
				p.setName2(sc.nextLine());
				System.out.println("Apellido1:");
				p.setSurname1(sc.nextLine());
				System.out.println("Apellido2:");
				p.setSurname2(sc.nextLine());
				System.out.println("ID:");
				p.setId(Integer.parseInt(sc.nextLine()));
				System.out.println("Num tlf:");
				p.setPhoneNumber(Integer.parseInt(sc.nextLine()));
				System.out.println("Fecha de nacimiento: (Hardcoded actual date)");
				p.setDateOfBirth(LocalDate.now());
				System.out.println("Ciudad de nacimiento:");
				p.setBirthCity(sc.nextLine());
				people.add(p);
			} else {
				flag = false;
			}
		} while (flag);

		sc.close();

		if (!people.isEmpty()) {
			if (archive.isFile() && archive.length() != 0) {
				try (FileOutputStream fos = new FileOutputStream("C:\\Users\\6002281\\Desktop\\objetos", true);
						NewWritingWay nww = new NewWritingWay(fos)) {

					for (Person person : people) {
						nww.writeObject(person);
					}

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try (FileOutputStream fos = new FileOutputStream("C:\\Users\\6002281\\Desktop\\objetos", true);
						ObjectOutputStream oos = new ObjectOutputStream(fos)) {

					for (Person person : people) {
						oos.writeObject(person);
					}

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
