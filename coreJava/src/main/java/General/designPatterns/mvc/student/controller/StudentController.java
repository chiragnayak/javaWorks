package General.designPatterns.mvc.student.controller;

import General.designPatterns.mvc.student.model.StudentModel;
import General.designPatterns.mvc.student.view.StudentView;

public class StudentController {
	
	private StudentModel model;
	   private StudentView view;

	   public StudentController(StudentModel model, StudentView view){
	      this.model = model;
	      this.view = view;
	   }

	   public void setStudentName(String name){
	      model.setName(name);		
	   }

	   public String getStudentName(){
	      return model.getName();		
	   }

	   public void setStudentRollNo(String rollNo){
	      model.setRollNumber(rollNo);		
	   }
	   
	   public void setAge(float age){
		      model.setAge(age);		
	   }

	   public String getStudentRollNo(){
	      return model.getRollNumber();		
	   }

	   public void updateView(){				
	      view.displayDetails(model.getName(), model.getGender().toString(), model.getAge());
	   }	
	
}
