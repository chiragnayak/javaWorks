package General.designPatterns.mvc;

import General.designPatterns.mvc.student.controller.StudentController;
import General.designPatterns.mvc.student.model.StudentModel;
import General.designPatterns.mvc.student.model.StudentModel.EnumGender;
import General.designPatterns.mvc.student.view.StudentView;

public class MvcDemo {
	
	public static void main(String[] args) {
		
		StudentModel model = new StudentModel("Chirag", EnumGender.MALE); //data. This can be from other sources like database etc
		
		StudentView view = new StudentView();
		
		StudentController controller = new StudentController(model, view);
		
		controller.updateView();
		
		//update model using controller and not directly.
		controller.setStudentName("Chirag Nayak");
		controller.setStudentRollNo("ANFPD7941E");
		controller.setAge(34);
		
		controller.updateView();
		
	}

}
