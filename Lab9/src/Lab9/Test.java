package Lab9;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		Student s1= new Student("1", "A", 2000);
		Student s2= new Student("2", "B", 2002);
		Student s3= new Student("3", "C", 2001);
		Student s4= new Student("4", "D", 2002);
		Student s5= new Student("5", "E", 2000);
		Student s6= new Student("6", "F", 2001);
		
		List<Student> l1= new ArrayList<>();
		l1.add(s1);
		l1.add(s4);
		l1.add(s6);
		Course c1= new Course("1", "Toan", "LT", l1, "AA");
		
		List<Student> l2= new ArrayList<>();
		l2.add(s1);
		l2.add(s3);
		l2.add(s4);
		l2.add(s6);
		Course c2= new Course("2", "AV", "TH", l2, "AB");
		
		List<Student> l3= new ArrayList<>();
		l3.add(s1);
		l3.add(s2);
		l3.add(s3);
		l3.add(s4);
		l3.add(s6);
		Course c3= new Course("3", "NV", "TH", l3, "AC");
		c3.add(s5);
		
		List<Student> l4= new ArrayList<>();
		l4.add(s1);
		l4.add(s2);
		l4.add(s4);
		Course c4= new Course("4", "TH", "TH", l4, "AD");
		
		List<Course> cou= new ArrayList<>();
		cou.add(c1);
		cou.add(c2);
		cou.add(c3);
		cou.add(c4);
		
		Faculty f1= new Faculty("CNTT", "NL", cou);
		//System.out.println(l3);
		//System.out.println(f1.getTH());
		//System.out.println(f1.getMaxPracticalCourse());
		//System.out.println(f1.groupStudentsByYear(l2));
		
		System.out.println(f1.filterCourses("TH"));
	}
	
}
