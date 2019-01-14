package General.courseEra.AlgorithmsPrinston.week3.using_comparators;

import java.util.Comparator;

public class StudentSectionComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		
		return o1.section.compareTo(o2.section);
	}

}
