package Lab9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Course {
		String id, title, type;
		List<Student> students;
		String lecturer;
		public Course(String id, String title, String type, List<Student> students, String lecturer) {
			super();
			this.id = id;
			this.title = title;
			this.type = type;
			this.students = students;
			this.lecturer = lecturer;
		}
	public boolean hasMoreStudentThan(Course course) {
			return this.students.size()> course.students.size();
	}
	@Override
	public int hashCode() {
			return Objects.hash(type);
	}
	@Override
	public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Course other = (Course) obj;
			return Objects.equals(type, other.type);
	}
	
	public void add(Student st) {
			students.add(st);
	}
	@Override
	public String toString() {
			return "Course [id=" + id + ", title=" + title + ", type=" + type + ", students=" + students + ", lecturer="
				+ lecturer + "]";
	}
	public String getId() {
			return id;
	}
	public void setId(String id) {
			this.id = id;
	}
	public String getTitle() {
			return title;
	}
	public void setTitle(String title) {
			this.title = title;
	}
	public String getType() {
			return type;
	}
	public void setType(String type) {
			this.type = type;
	}
	public List<Student> getStudents() {
			return students;
	}
	

	
	public void setStudents(List<Student> students) {
			this.students = students;
	}
	public String getLecturer() {
			return lecturer;
	}
	public void setLecturer(String lecturer) {
			this.lecturer = lecturer;
	}

	
	
}
