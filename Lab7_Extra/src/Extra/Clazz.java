package Extra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;
import java.io.IOException;

public class Clazz {
	
	private ArrayList<Student> students = new ArrayList<Student>();
	
	public static void main(String[] args) {
		
		Clazz stu= new Clazz();
		Student s1= new Student("18130006","Trong", "Nguyen", 1997, 7.5);
		Student s2= new Student("18130090","Phi", "Hoang", 1997, 5.5);
		Student s3= new Student("18130086","An", "Ly", 1998, 8.5);
		Student s4= new Student("18130024","Anh", "Pham", 1998, 9.5);
		Student s5= new Student("18130105","Ngoc", "Phan", 1999, 9.0);
		Student s6= new Student("18130206","Tam", "Ly", 1994, 8.5);
		Student s7= new Student("18130110","Lan", "Nguyen", 1996, 8.0);
		stu.add(s1);
		stu.add(s2);
		stu.add(s3);
		stu.add(s4);
		stu.add(s5);
		stu.add(s6);
		stu.add(s7);
		stu.display();
		System.out.println("\nTop Students: ");
		System.out.println(stu.getTopNStudents(3));
		System.out.println("\nHoc sinh duoc lay ngau nhien: ");
		System.out.println(stu.getRandomNStudents(3));
		/*stu.removeStudent("18130024");
		System.out.println("\nSau khi xoa hoc sinh: ");
		stu.display();*/
		System.out.println("\nNhung hoc sinh co nam sinh duoc chon: ");
		System.out.println(stu.getStudentByBirthYear(1998));
		
		
	}

	
	// sort students according to the given comparator c
	public void sortStudents(Comparator<Student> c) {
		students.sort(c);
		
	}
	
	public void add(Student stu) {
		students.add(stu);
	}

	// get top n students with highest GPA
	public ArrayList<Student> getTopNStudents(int n) {
		ArrayList<Student> re= new ArrayList<>();
		Collections.sort(students, new SortStudentByGPA());
		for (int i = 0; i < n; i++) {
			re.add(students.get(i));
		}
		return re;
	}

	// get random n students from the list of students
	public ArrayList<Student> getRandomNStudents(int n) {
		ArrayList<Student> re= new ArrayList<>();
		Random rd= new Random();
		for (int i = 0; i < n; i++) {
			int num= rd.nextInt(students.size());
			re.add(students.get(num));
			
		}
		return re;
	}

// remove a student with a given id
	public boolean removeStudent(String id) {
		for (int i = 0; i < students.size(); i++) {
			if(students.get(i).getId()== id)
				students.remove(students.get(i));
		}
		return false;
	}

	// get all students who were born in a given birth year.
	public ArrayList<Student> getStudentByBirthYear(int birthYear) {
		ArrayList<Student> re= new ArrayList<>();
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getBirthYear()== birthYear) {
				re.add(students.get(i));
			}
		}
		
		return re;
	}

	// similar as toString method, this method prints the name, year, and all
	// students of the class. Note that, using iterator
	public void display() {
		Iterator<Student> ite= students.iterator();
		while (ite.hasNext()) {
			Student student = ite.next();
			System.out.println(student.toString());
		}
	}
}
