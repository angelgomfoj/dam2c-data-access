package ejercicioangelgomezfoj;

public class Register {
	private int id;
	private String name;
	private int dni;
	private double salary;
	private boolean gender;
	private boolean workRemote;

	public Register() {

	}

	public Register(int id, String name, int dni, double salary, boolean gender, boolean workRemote) {
		super();
		this.id = id;
		this.name = name;
		this.dni = dni;
		this.salary = salary;
		this.gender = gender;
		this.workRemote = workRemote;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public boolean isWorkRemote() {
		return workRemote;
	}

	public void setWorkRemote(boolean workRemote) {
		this.workRemote = workRemote;
	}

	@Override
	public String toString() {
		String genderStr = gender ? "Hombre" : "Mujer";
		String workRemoteStr = workRemote ? "Casa" : "Oficina";
		return "Registro [Id=" + id + ", Nombre=" + name.trim() + ", Dni=" + dni + ", Salario=" + salary + ", Sexo="
				+ genderStr + ", Trabaja desde=" + workRemoteStr + "]";
	}

}
