package com.venancio.blanco.exercises2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author juan
 */
public class add2022_42GestionaRegStor {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner teclado = new Scanner(System.in);
		boolean salir = false;
		String ruta = "";
		do {
			System.out.println("Introduzca la ruta a un archivo RegStor.db");
			ruta = teclado.nextLine();
			File objF = new File(ruta);
			if (objF.isFile() && (objF.length() % 50 == 0)) {
				salir = true;
			} else {
				System.out.println("El archivo no existe o no tiene un tamaño en bytes múltiplo de 50");
			}
		} while (!salir);

		RandomAccessFile objRAF = new RandomAccessFile(ruta, "rw");

		do {
			mostrarMenu();
			String opcion = teclado.nextLine();
			opcion = opcion.toLowerCase();
			switch (opcion) {
			case "añadir":
			case "a":
//	Añadir registro
//		determinar el id del último registro no nulo
//		el id del nuevo registro será ese último id no nulo más uno
//		pedir datos de nuevo registro
//		situarse en último byte de archivo
//		escribir datos de nuevo registro
//		
				long bytesArchivo = objRAF.length();
				add2022_42Registro objR = new add2022_42Registro();
				rellenaRegistro(objR, bytesArchivo);
				objRAF.seek(bytesArchivo);
				objRAF.writeInt(objR.getId());
				objRAF.write(objR.getNombre().getBytes());
				objRAF.writeInt(objR.getDni());
				objRAF.writeDouble(objR.getSalario());
				objRAF.writeBoolean(objR.isSexo());
				objRAF.writeBoolean(objR.isLugarTrabajo());
				objRAF.close();
				break;
			case "eliminar":
			case "e":
//	Eliminar registro
//		Pedir id de registro a eliminar entre los posibles
//		Buscar registro con id
//		Escribir 0 sobre id de registro
//		
				bytesArchivo = objRAF.length();
				long numRegistros = bytesArchivo / 50;
				salir = false;
				int registroBorrar;
				do {
					System.out.println("Introduzca un número de registro entre 1 y " + numRegistros + " a borrar");
					registroBorrar = teclado.nextInt();
					if (1 <= registroBorrar && registroBorrar <= numRegistros) {
						salir = true;
					} else {
						System.out.println(
								"El número " + registroBorrar + " no está comprendido entre 1 y " + numRegistros);
					}
				} while (!salir);
				long resultadoBusqueda = buscaID(registroBorrar, objRAF);
				if (resultadoBusqueda == -1) {
					System.out.println("El registro con identificador " + registroBorrar + " no existe.");
				} else {
					System.out.println("Escribe 0");
					objRAF.seek(resultadoBusqueda);
					objRAF.writeInt(0);
				}
				objRAF.close();
				break;
			case "leer":
			case "l":
//	Leer registro
//		pedir registro por id
//		buscar registro por id
//		si existe
//			situarse en byte
//			leer datos registro
//			mostrar datos registro
//		si no existe (llegar al final y no haber encontrado ningún registro que cumpla)
//			mensaje
				bytesArchivo = objRAF.length();
				numRegistros = bytesArchivo / 50;
				objRAF.seek(0);
				for (int i = 0; i < numRegistros; i++) {
					muestraRegistro(i, objRAF);
				}
				break;
			case "buscar":
			case "b":
//	Buscar registro
//		pedir campo de búsqueda
//		pedir dato de búsqueda
//		buscar registro con dato en campo
//		si existe
//			situarse en byte inicial de registro
//			leer datos registro
//			mostrar datos registro
//			volver a buscar registro con dato en campo
//		si no existe (llegar al final y no haber encontrado ningún registro que cumpla)
//			mensaje

				break;
			case "modificar":
			case "m":
//	Modificar registro
//		Buscar registro
//		Pedir nuevos datos de registro
//		Reescribir datos de registro

				break;
			case "salir":
			case "s":

				break;
			case "mostrar":
			case "ms":
//	Mostrar todos los registros no eliminados
//		obtener registros del archivo
//		situarse en byte 0
//		leer campo id
//		si campo id != 0
//			leer resto de datos de registro
//			mostrar datos de registro
//		volver a leer campo id

				List<add2022_42Registro> listaRegistrosValidos = new ArrayList<>();
				try (RandomAccessFile raf1 = new RandomAccessFile(ruta, "r")) {
					raf1.seek(0);
					while (true) {
						String name = "";
						for (int i = 0; i < 32; i++) {
							// leo los 32 bytes del name
						}
						add2022_42Registro reg = new add2022_42Registro();
						int id = raf1.readInt();
						raf1.read();
						raf1.readInt();
						raf1.readDouble();
						raf1.readBoolean();
						raf1.readBoolean();
						// creo el obj lo añado al array, se sale del while true en EOF, falta el
						// catch...
					}
				}
//		
				// break;
			case "compactar":
			case "cmp":
//	Compactar archivo regstor.db
//		recoger registros en una lista de objetos Registro
//		recorrer la lista
//			si el objeto tiene id != 0
//				escribir datos del objeto en archivo

				break;

			default:
			}
		} while (!salir);
	}

	private static void mostrarMenu() {
		System.out.println("Elija una de las siguientes opciones");
		System.out.println("Añadir registro (A)");
		System.out.println("Eliminar registro (E)");
		System.out.println("Modificar registro (M)");
		System.out.println("Buscar registro (B)");
		System.out.println("Leer registro (L)");
		System.out.println("Salir (S)");
	}

	private static void rellenaRegistro(add2022_42Registro objR, long bytesArchivo) {
		objR.setId((int) ((bytesArchivo / 50) + 1));
		Random r = new Random();
		String nombreAzar = nombreAzar(4, 16);
		nombreAzar = extiendeBytes(nombreAzar, 32);
		objR.setNombre(nombreAzar);// 32
		objR.setDni(r.nextInt(10000000, 100000000));// 4
		objR.setSalario(r.nextDouble(600, 2001));// 8
		objR.setSexo(r.nextBoolean());// 1
		objR.setLugarTrabajo(r.nextBoolean());// 1
	}

	private static String nombreAzar(int minLetras, int maxLetras) {
		Random r = new Random();
		int numLetras = r.nextInt(minLetras, maxLetras + 1);
		StringBuilder nombreAzar = new StringBuilder();
		nombreAzar = nombreAzar.append((char) (vocal_consonante_minuscula(50) - 32));
		for (int i = 0; i < numLetras; i++) {
			nombreAzar = nombreAzar.append(vocal_consonante_minuscula(50));
		}
//        System.out.println(nombreAzar);
		return nombreAzar.toString();
	}

	private static String extiendeBytes(String nombreAzar, int i) {
		while (nombreAzar.getBytes().length < i) {
			nombreAzar += " ";
		}
		System.out.println(nombreAzar.getBytes().length);
		return nombreAzar;
	}

	private static char vocal_consonante_minuscula(int porcentajeVocalConsonante) {
		Random r = new Random();
		char vocal_consonante_minuscula;
		char[] vocales = { 'a', 'e', 'i', 'o', 'u', 'á', 'é', 'í', 'ó', 'ú', 'ö', 'ü' };
		char[] consonantes = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'ñ', 'p', 'q', 'r', 's', 't', 'v',
				'w', 'x', 'y', 'z' };
		if (r.nextInt(1, 101) < porcentajeVocalConsonante) {
			vocal_consonante_minuscula = vocales[r.nextInt(0, vocales.length)];
		} else {
			vocal_consonante_minuscula = consonantes[r.nextInt(0, consonantes.length)];
		}
		return vocal_consonante_minuscula;
	}

	private static long buscaID(int idBuscado, RandomAccessFile objRAF) throws IOException {
		long numRegistros = objRAF.length() / 50;
		int contador = 0;
		int idLeido;
		do {
			objRAF.seek(50 * contador);
			idLeido = objRAF.readInt();
			contador++;
		} while (contador < numRegistros && idLeido != idBuscado);
		if (idLeido == idBuscado) {
			return objRAF.getFilePointer() - 4;
		} else {
			return -1;
		}
	}

	private static void muestraRegistro(int i, RandomAccessFile objRAF) throws IOException {
		objRAF.seek(i * 50);
		byte[] nombre = new byte[32];// nombre almacenará los 32 bytes de la cadena
		System.out.printf("%10d%18s%10d%5.3f%8s%8s\n", objRAF.readInt(), objRAF.read(nombre), objRAF.readInt(),
				objRAF.readDouble(), (objRAF.readBoolean() ? "H" : "M"),
				(objRAF.readBoolean() ? "Trabajo" : "Domicilio"));
	}

}
