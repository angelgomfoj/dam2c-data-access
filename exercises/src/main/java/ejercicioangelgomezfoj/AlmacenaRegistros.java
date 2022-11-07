package ejercicioangelgomezfoj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

/**
 * @author Angel Gomez Foj
 *
 */
public class AlmacenaRegistros {
	public static void main(String[] args) {

		// The following code creates a new file named RegStor.db if it doesn't exist
		// and writes a random amount (between 200 and 500) of registers in the file.

		// Note: If the file already exists, the program just adds the new registers
		// right after the old ones.

		Random r = new Random();
		File archive = new File("RegStor.db");
		int registersNum = r.nextInt(200, 501);
		try (RandomAccessFile raf = new RandomAccessFile(archive, "rw")) {
			Register register;
			if (raf.length() != 0) {
				raf.seek(raf.length());
			}
			for (int i = 0; i < registersNum; i++) {
				register = Register.createRegister(archive);
				System.out.println(register);
				Register.writeRegister(register, raf);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
