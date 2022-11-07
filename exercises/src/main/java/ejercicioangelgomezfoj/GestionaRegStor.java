package ejercicioangelgomezfoj;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Angel Gomez Foj
 *
 */
public class GestionaRegStor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File archive;
		do {
			System.out.println("Introduce la ruta a un archivo existente formado por registros de 50 bytes:");
			archive = new File(sc.nextLine());
		} while (!archive.isFile() || archive.length() == 0);

		System.out.println(
				"Introduce el numero correspondiente a la opcion deseada:\n[1] Nuevo registro\n[2] Eliminar registro\n"
						+ "[3] Modificar registro\n[4] Leer registro\n[5] Buscar registros\n[6] Mostrar registros\n[7] Compactar archivo");

		int option = Integer.valueOf(sc.nextLine());
		List<Register> registers = new ArrayList<>();

		switch (option) {
		case 1:
			try (RandomAccessFile raf = new RandomAccessFile(archive, "rw")) {
				raf.seek(raf.length());
				Register register = Register.createRegister(archive);
				Register.writeRegister(register, raf);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			System.out.println("Introduce el id del registro a eliminar:");
			int id = Integer.valueOf(sc.nextLine());
			try (RandomAccessFile raf = new RandomAccessFile(archive, "rw")) {
				if (id >= 1 && id <= raf.length() / 50) {
					raf.seek((id - 1) * 50);
					if (raf.readInt() != 0) {
						raf.seek(raf.getFilePointer() - 4);
						raf.writeInt(0);
						System.out.println("Registro eliminado.");
					} else {
						System.err.println("[ERROR] El registro ya ha sido eliminado.");
					}
				} else {
					System.err.println("[ERROR] El id introducido no existe en el archivo.");
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 3:
			System.out.println("Introduce el id del registro a modificar:");
			// La modificacion consistira simplemente en autogenerar otro registro.
			int id2 = Integer.valueOf(sc.nextLine());
			try (RandomAccessFile raf = new RandomAccessFile(archive, "rw")) {
				if (id2 >= 1 && id2 <= raf.length() / 50) {
					raf.seek((id2 - 1) * 50);
					if (raf.readInt() == 0) {
						System.err.println(
								"[ERROR] El registro que intenta modificar ya no existe, compacte el archivo.");
					} else {
						Register register = Register.createRegister(archive);
						Register.writeRegister(register, raf, true);
						System.out.println("Registro modificado con exito.");
					}
				} else {
					System.err.println("[ERROR] El id introducido no existe en el archivo.");
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 4:
			System.out.println("Introduce el id del registro que desea leer:");
			int id3 = Integer.valueOf(sc.nextLine());
			try (RandomAccessFile raf = new RandomAccessFile(archive, "rw")) {
				if (id3 >= 1 && id3 <= raf.length() / 50) {
					raf.seek((id3 - 1) * 50);
					Register register = Register.readRegister(raf);
					if (register.getId() != 0) {
						System.out.println(register);
					} else {
						System.err.println("[ERROR] El id introducido pertenece a un registro eliminado.");
					}
				} else {
					System.err.println("[ERROR] El id introducido no existe en el archivo.");
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 5:
			try (RandomAccessFile raf = new RandomAccessFile(archive, "rw")) {
				Register register;

				while (true) {
					register = Register.readRegister(raf);
					registers.add(register);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (EOFException e) {
				System.out.println(
						"Selecciona un campo para el filtrado:\n[1] Id  [2] Nombre  [3] Dni  [4] Salario  [5] Sexo  [6] Lugar de trabajo");
				int fieldNum = Integer.valueOf(sc.nextLine());
				int i;
				switch (fieldNum) {
				case 1:
					System.out.println("Introduce el id:");
					int searchId = Integer.valueOf(sc.nextLine());
					i = 0;
					for (Register register : registers) {
						if (register.getId() == searchId) {
							System.out.println(register.toString());
							i++;
						}
					}
					if (i == 0) {
						System.out.println("No se ha encontrado ninguna coincidencia");
					}
					break;
				case 2:
					System.out.println("Introduce el nombre:");
					String searchName = sc.nextLine();
					i = 0;
					for (Register register : registers) {
						if (register.getName().equalsIgnoreCase(searchName) && register.getId() != 0) {
							System.out.println(register.toString());
							i++;
						}
					}
					if (i == 0) {
						System.out.println("No se ha encontrado ninguna coincidencia");
					}
					break;
				case 3:
					System.out.println("Introduce el DNI:");
					int searchDni = Integer.valueOf(sc.nextLine());
					i = 0;
					for (Register register : registers) {
						if (register.getDni() == searchDni && register.getId() != 0) {
							System.out.println(register.toString());
							i++;
						}
					}
					if (i == 0) {
						System.out.println("No se ha encontrado ninguna coincidencia");
					}
					break;
				case 4:
					System.out.println("Introduce el Salario:");
					double searchSalary = Double.valueOf(sc.nextLine());
					i = 0;
					for (Register register : registers) {
						if (register.getSalary() == searchSalary && register.getId() != 0) {
							System.out.println(register.toString());
							i++;
						}
					}
					if (i == 0) {
						System.out.println("No se ha encontrado ninguna coincidencia");
					}
					break;
				case 5:
					System.out.println("Introduce el sexo: [Hh/Mm] (Hombre/Mujer)");
					String searchGender = Character.toString(sc.nextLine().charAt(0));
					boolean gender;
					if (searchGender.equalsIgnoreCase("h")) {
						gender = true;
					} else if (searchGender.equalsIgnoreCase("m")) {
						gender = false;
					} else {
						System.err.println("[ERROR] El valor introducido no es valido.");
						break;
					}
					i = 0;
					for (Register register : registers) {
						if (register.isGender() == gender && register.getId() != 0) {
							System.out.println(register.toString());
							i++;
						}
					}
					if (i == 0) {
						System.out.println("No se ha encontrado ninguna coincidencia");
					}
					break;
				case 6:
					System.out.println("Introduce el lugar de trabajo: [Cc/Oo] (Casa/Oficina)");
					String searchWorkPlace = Character.toString(sc.nextLine().charAt(0));
					boolean workPlace;
					if (searchWorkPlace.equalsIgnoreCase("c")) {
						workPlace = true;
					} else if (searchWorkPlace.equalsIgnoreCase("o")) {
						workPlace = false;
					} else {
						System.err.println("[ERROR] El valor introducido no es valido.");
						break;
					}
					i = 0;
					for (Register register : registers) {
						if (register.isWorkRemote() == workPlace && register.getId() != 0) {
							System.out.println(register.toString());
							i++;
						}
					}
					if (i == 0) {
						System.out.println("No se ha encontrado ninguna coincidencia");
					}
					break;
				default:
					System.err.println("Opcion invalida.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 6:
			try (RandomAccessFile raf = new RandomAccessFile(archive, "r")) {
				raf.seek(0);
				Register register;
				while (true) {
					register = Register.readRegister(raf);
					registers.add(register);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (EOFException e) {
				for (Register register : registers) {
					if (register.getId() != 0) {
						System.out.println(register.toString());
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 7:
			// compactar archivo
			break;
		default:
			System.err.println("[ERROR] Opcion no valida.");
		}
		sc.close();
	}

}
