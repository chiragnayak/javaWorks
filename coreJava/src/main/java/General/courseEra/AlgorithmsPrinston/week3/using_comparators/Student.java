package General.courseEra.AlgorithmsPrinston.week3.using_comparators;

public class Student implements Comparable <Student> {
	
	public static final StudentNameComparator BY_NAME = new StudentNameComparator();
	public static final StudentSectionComparator BY_SECTION = new StudentSectionComparator();
	public static final StudentCourseComparator BY_COURSEID = new StudentCourseComparator();
	
	String name;
	Integer section;
	String address;
	int courseId;
	
	public Student(String name, Integer section, String address, Integer course) {
		this.name = name;
		this.section = section;
		this.address = address;
		this.courseId = course;
	}
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getSection() {
		return section;
	}



	public void setSection(Integer section) {
		this.section = section;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public int getCourseId() {
		return courseId;
	}



	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}



	@Override
	public int compareTo(Student o) {
		return this.name.compareTo(o.name);
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(this.name+" ");
		sb.append(this.section+" ");
		sb.append(this.address+" ");
		sb.append(this.courseId+" ");
		
		return sb.toString();
	}

}
