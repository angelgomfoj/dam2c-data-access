package ejercicioangelgomezfoj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;

public class GestionaRegStor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File archive;
		do {
			System.out.println("Introduce la ruta a un archivo existente formado por registros de 50 bytes:");
			archive = new File(sc.nextLine());
		} while (!archive.isFile() || archive.length() == 0);

		System.out.println(
				"Introduce el numero correspondiente a la opcion deseada:\n[1] Nuevo registro\n[2] Eliminar registro\n[3] Modificar registro\n[4] Leer registro\n[5] Buscar registros");

		int option = Integer.valueOf(sc.nextLine());

		switch (option) {
		case 1:
			try (RandomAccessFile raf = new RandomAccessFile(archive, "rw")) {
				raf.seek(raf.length());
				Register register = createRegister(archive);
				raf.writeInt(register.getId());
				raf.write(register.getName().getBytes());
				raf.writeInt(register.getDni());
				raf.writeDouble(register.getSalary());
				raf.writeBoolean(register.isGender());
				raf.writeBoolean(register.isWorkRemote());
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
					if (raf.readInt() == 0) {
						raf.writeInt(0);
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
					raf.seek(((id2 - 1) * 50) + 4);
					Register register = createRegister(archive);
					raf.write(register.getName().getBytes());
					raf.writeInt(register.getDni());
					raf.writeDouble(register.getSalary());
					raf.writeBoolean(register.isGender());
					raf.writeBoolean(register.isWorkRemote());
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
					Register register = new Register();
					byte[] byteName = new byte[32];
					register.setId(raf.readInt());
					raf.read(byteName);
					register.setName(new String(byteName));
					register.setDni(raf.readInt());
					register.setSalary(raf.readDouble());
					register.setGender(raf.readBoolean());
					register.setWorkRemote(raf.readBoolean());
					System.out.println(register);
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
			break;
		default:
			System.err.println("[ERROR] Opcion no valida.");
		}
		sc.close();
	}

	private static Register createRegister(File archive) {
		long id = 1;
		Random r = new Random();
		try (RandomAccessFile raf = new RandomAccessFile(archive, "r")) {
			if (raf.length() != 0) {
				id = (raf.length() / 50) + 1;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Register register = new Register((int) id, getRandomName(), r.nextInt(10000000, 100000000),
				r.nextDouble(600, 2001), r.nextBoolean(), r.nextBoolean());
		return register;
	}

	private static String getRandomName() {
		Random r = new Random();
		int n = r.nextInt(4, 17);
		String word = "";
		for (int i = 0; i < n; i++) {
			word += (char) (r.nextInt(97, 123));
		}
		if (word.length() < 32) {
			while (word.length() < 32) {
				word += " ";
			}
		}
		return word;
	}
}
