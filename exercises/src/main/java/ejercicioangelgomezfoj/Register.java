package ejercicioangelgomezfoj;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

/**
 * @author Angel Gomez Foj
 *
 */
public class Register {
	private int id;
	private String name;
	private int dni;
	private double salary;
	private boolean gender;
	private boolean workRemote;

	/**
	 * Empty constructor to declare a Register object without any attributes.
	 */
	public Register() {

	}

	/**
	 * Constructor to declare a Register object with all the attributes.
	 * 
	 * @param id         used to identify each 50 Bytes register. Length -> 4 Bytes.
	 * @param name       is a value contained in the register that represents its
	 *                   name. Length -> 32 Bytes.
	 * @param dni        is a value contained in the register that represents its
	 *                   dni. Length -> 4 Bytes.
	 * @param salary     is a value contained in the register that represents its
	 *                   salary. Length -> 8 Bytes.
	 * @param gender     is a value contained in the register that represents its
	 *                   gender. Length -> 1 Byte.
	 * @param workRemote is a value contained in the register that represents its
	 *                   working location. Length -> 1 Byte.
	 */
	public Register(int id, String name, int dni, double salary, boolean gender, boolean workRemote) {
		super();
		this.id = id;
		this.name = name;
		this.dni = dni;
		this.salary = salary;
		this.gender = gender;
		this.workRemote = workRemote;
	}

	/**
	 * @return the id of the register.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Updates a register id.
	 * 
	 * @param id value of register.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name of the register.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Updates a register name.
	 * 
	 * @param name value of register.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the dni of the register.
	 */
	public int getDni() {
		return dni;
	}

	/**
	 * Updates a register dni.
	 * 
	 * @param dni value of register.
	 */
	public void setDni(int dni) {
		this.dni = dni;
	}

	/**
	 * @return the salary of the register.
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * Updates a register salary.
	 * 
	 * @param salary value of register.
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * @return the gender of the register.
	 */
	public boolean isGender() {
		return gender;
	}

	/**
	 * Updates a register gender.
	 * 
	 * @param gender value of register.
	 */
	public void setGender(boolean gender) {
		this.gender = gender;
	}

	/**
	 * @return the work location of the register.
	 */
	public boolean isWorkRemote() {
		return workRemote;
	}

	/**
	 * Updates a register work location.
	 * 
	 * @param workRemote value of register.
	 */
	public void setWorkRemote(boolean workRemote) {
		this.workRemote = workRemote;
	}

	/**
	 * Creates a new register of 50 Bytes, generating all the attributes randomly.
	 * 
	 * @param archive is used to retrieve the last id.
	 * @return a register object randomly generated.
	 */
	public static Register createRegister(File archive) {
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

	/**
	 * Generates a random name (String) from 4 to 16 chars and filled with blank
	 * spaces up to 32 Bytes length.
	 * 
	 * @return String name
	 */
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

	/**
	 * Writes a new register in the given file.
	 * 
	 * @param register to write.
	 * @param raf      which is the file object that will be written. (Must have
	 *                 been initialized with the "rw" value).
	 */
	public static void writeRegister(Register register, RandomAccessFile raf) {
		try {
			raf.writeInt(register.getId());
			raf.write(register.getName().getBytes());
			raf.writeInt(register.getDni());
			raf.writeDouble(register.getSalary());
			raf.writeBoolean(register.isGender());
			raf.writeBoolean(register.isWorkRemote());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Writes a new register or modify an existing one in the given file.
	 * 
	 * @param register to write.
	 * @param raf      which is the file object that will be written. (Must have
	 *                 been initialized with the "rw" value).
	 * @param modify   is a boolean value, true indicates the method will modify the
	 *                 register keeping the old Id, false will write a new register
	 *                 with a new Id.
	 */
	public static void writeRegister(Register register, RandomAccessFile raf, boolean modify) {
		try {
			if (modify = false) {
				raf.writeInt(register.getId());
			}
			raf.write(register.getName().getBytes());
			raf.writeInt(register.getDni());
			raf.writeDouble(register.getSalary());
			raf.writeBoolean(register.isGender());
			raf.writeBoolean(register.isWorkRemote());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Read one register from a given file which position is already indicated on
	 * the RandomAccessFile object and returns a register object.
	 * 
	 * @param raf file to perform the read.
	 * @return register read from the given file.
	 * @throws IOException if an operation is interrupted or fails.
	 */
	public static Register readRegister(RandomAccessFile raf) throws IOException {
		Register register = new Register();
		byte[] byteName = new byte[32];
		try {
			register.setId(raf.readInt());
			raf.read(byteName);
			register.setName(new String(byteName));
			register.setDni(raf.readInt());
			register.setSalary(raf.readDouble());
			register.setGender(raf.readBoolean());
			register.setWorkRemote(raf.readBoolean());
		} catch (EOFException e) {
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return register;
	}

	/**
	 * Returns a String containing all the register info.
	 */
	@Override
	public String toString() {
		String genderStr = gender ? "Hombre" : "Mujer";
		String workRemoteStr = workRemote ? "Casa" : "Oficina";
		return "Registro [Id=" + id + ", Nombre=" + name.trim() + ", Dni=" + dni + ", Salario=" + salary + ", Sexo="
				+ genderStr + ", Trabaja desde=" + workRemoteStr + "]";
	}

}
