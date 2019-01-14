package General.courseEra.AlgorithmsPrinston.week3.using_comparators;

import java.util.Comparator;

public class StudentCourseComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		
		return o1.courseId - o2.courseId;
	}

}
