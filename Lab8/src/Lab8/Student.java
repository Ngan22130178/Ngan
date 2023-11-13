package Lab8;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable{
	private String id;
	private String firstName;
	private String lastName;
	private int birthYear;
	private double GPA;

	public Student (String id, String firstName, String lastName, int birthYear, double GPA) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthYear = birthYear;
		this.GPA = GPA;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double gPA) {
		this.GPA = gPA;
	}

	@Override
	public String toString() {
		return "Student [id:" + id + ", firstName:" + firstName + ", lastName:" + lastName + ", birthYear:" + birthYear
				+ ", GPA:" + GPA + "]";
	}
	
	
}
