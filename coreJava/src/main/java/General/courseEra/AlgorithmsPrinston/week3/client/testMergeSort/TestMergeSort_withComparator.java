package General.courseEra.AlgorithmsPrinston.week3.client.testMergeSort;

import java.util.Arrays;

import General.courseEra.AlgorithmsPrinston.week3.mergeSort.MergeSort_withComparator;
import General.courseEra.AlgorithmsPrinston.week3.using_comparators.Student;
import General.courseEra.AlgorithmsPrinston.week3.using_comparators.StudentNameComparator;
import General.courseEra.AlgorithmsPrinston.week3.using_comparators.StudentSectionComparator;

public class TestMergeSort_withComparator {
	
	public static void main(String[] args) {
		
		Student s1 = new Student("Chirag", 3, "Indore", 101);
		Student s2 = new Student("Russel", 1, "LA", 234);
		Student s3 = new Student("Yamini", 5, "Bhiura", 102);
		Student s4 = new Student("Saanvi", 2, "Thane", 101);
		Student s5 = new Student("Ganesha", 8, "india", 103);
		Student s6 = new Student("Kevin", 6, "California", 104);
		Student s7 = new Student("Fredrikson", 7, "San Diaego", 101);
		Student s8 = new Student("Ellie", 4, "Chicago", 101);
		
		Student [] students = {s1,s2,s3,s4,s5,s6,s7,s8};
		
		MergeSort_withComparator.sort(Student.BY_NAME, students, new Student[students.length], 0, students.length-1);
		
		Arrays.asList(students).stream().forEach(x -> System.out.println(x.toString()));

		System.out.println("=================================");
		
		MergeSort_withComparator.sort(Student.BY_COURSEID, students, new Student[students.length], 0, students.length-1);
		
		Arrays.asList(students).stream().forEach(x -> System.out.println(x.toString()));
	}
	
}
