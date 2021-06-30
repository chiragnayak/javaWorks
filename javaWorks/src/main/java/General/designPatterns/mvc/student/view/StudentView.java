package General.designPatterns.mvc.student.view;

public class StudentView {
	
	public void displayDetails(String name, String gender, double age) {
		
		System.out.println("Name : "+name);
		System.out.println("Gender : "+gender.toString());
		System.out.println("Age : "+age);
	}

}
