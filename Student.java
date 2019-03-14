package upgrad.assgn;

public class Student implements Comparable<Student> {

	private String name;
	private float cgpa;
	private int token;

	public Student() {
	}

	public Student(String name, float cgpa, int token) {
		this.name = name;
		this.cgpa = cgpa;
		this.token = token;
	}

	@Override
	public int compareTo(Student student) {

		if (this.cgpa > student.cgpa)
			return 1;
		else if (this.cgpa == student.cgpa) {
			if (student.name.compareTo(this.name) > 0)
				return 1;
			else if (student.name.compareTo(this.name) == 0) {
				if (this.token > student.token)
					return 1;
				else if (this.token == student.token)
					return 0;
				else
					return -1;
			} else
				return -1;
		} else
			return -1;
	}

	@Override
	public String toString() {
		return this.name + " " + this.cgpa + " " + this.token;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getCgpa() {
		return cgpa;
	}

	public void setCgpa(float cgpa) {
		this.cgpa = cgpa;
	}

	public int getToken() {
		return token;
	}

	public void setToken(int token) {
		this.token = token;
	}
}
