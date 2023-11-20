package Lab9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


	public class Faculty {
		String name, address;
		List<Course> courses;
		public Faculty(String name, String address, List<Course> courses) {
			super();
			this.name = name;
			this.address = address;
			this.courses = courses;
		}
		
		/*Phương thức public Course getMaxPracticalCourse() trả về course thực 
		hành có nhiều sinh viên đăng ký học nhất.*/
		public Course getMaxPracticalCourse() {
			
			
			Course re= courses.get(getTH());
			
			for (int i = 1; i < courses.size(); i++) {
				if (courses.get(i).type.equals("TH") &&!re.hasMoreStudentThan(courses.get(i))) {
					re= courses.get(i);
					if (re.type.equals("TH")) {
						re= courses.get(i);
					}
				
				}
			}
			return re;
		}
		
		public int getTH() {
			int re= 0;
			for (int i = 0; i < courses.size(); i++) {
				if (courses.get(i).type.equals("TH")) {
					re= i;
				}
			}
			
			return re;
		}
		
		
		
		
		/*Phương thức public Map<Integer, List<Student>> groupStudentsByYear()
	để thống kê danh sách sinh viên theo năm vào học, với key là năm vào học và 
	value là các sinh viên tương ứng*/
		public Map<Integer, List<Student>> groupStudentsByYear(List<Student> students){
			
			Map<Integer, List<Student>> re= new HashMap<>();
			for (Student stu: students) {
				int year= stu.getYear();
				if (!re.containsKey(year)) {
					re.put(year, new ArrayList<>());
				}
				re.get(year).add(stu);
			}
			return re;
		}
		
		@Override
		public String toString() {
			return "Faculty [name=" + name + ", address=" + address + ", courses=" + courses + "]";
		}
	
		/*Phương thức public Set<Course> filterCourses(String type) trả về các 
	course theo loại cho trước (type). Các course được sắp xếp giảm dần theo số 
	lượng sinh viên đăng ký học.*/
		public Set<Course> filterCourses( String type){
			Set<Course> re =new TreeSet<>(new Comparator<Course>() {
				public int compare(Course c1, Course c2) {
					return (c1.students.size()- c2.students.size());
				}
			});
			
				for (Course course : courses) {
					 if (course.getType().equals(type)) {
		                re.add(course);              
		            }			
				}
	        return re;
	    
		}
		
	}
