package ejercicioangelgomezfoj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class AlmacenaRegistros {
	public static void main(String[] args) {
		Random r = new Random();
		File archive = new File("RegStor.db");
		int registersNum = r.nextInt(200, 501);
		try (RandomAccessFile raf = new RandomAccessFile(archive, "rw")) {
			Register register;
			if (raf.length() != 0) {
				raf.seek(raf.length());
			}
			for (int i = 0; i < registersNum; i++) {
				register = createRegister(archive);
				System.out.println(register);
				raf.writeInt(register.getId());
				raf.write(register.getName().getBytes());
				raf.writeInt(register.getDni());
				raf.writeDouble(register.getSalary());
				raf.writeBoolean(register.isGender());
				raf.writeBoolean(register.isWorkRemote());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

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
