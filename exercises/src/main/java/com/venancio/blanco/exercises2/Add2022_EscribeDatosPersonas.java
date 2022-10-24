package com.venancio.blanco.exercises2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Add2022_EscribeDatosPersonas {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		int decision;
		List<Person> people = new ArrayList<>();

		do {
			System.out.println("[1] Crear persona\n[2] Salir");
			decision = sc.nextInt();
			if (decision == 1) {
				Person p = new Person();
				System.out.println("Nombre1:");
				p.setName1(sc.nextLine());
				System.out.println("Nombre2:");
				p.setName2(sc.nextLine());
				System.out.println("Apellido1:");
				p.setSurname1(sc.nextLine());
				System.out.println("Apellido2:");
				p.setSurname2(sc.nextLine());
				System.out.println("ID:");
				p.setId(sc.nextInt());
				System.out.println("Num tlf:");
				p.setPhoneNumber(sc.nextInt());
				System.out.println("Fecha de nacimiento:");

			}
		} while (flag);
	}

}
