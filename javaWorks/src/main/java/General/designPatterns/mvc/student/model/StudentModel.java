package General.designPatterns.mvc.student.model;

public class StudentModel {
	
	String name;
	
	String rollNumber;
	
	float age;
	
	EnumGender gender;
	
	public enum EnumGender {
		
		MALE, FEMALE;
	}
	
	public StudentModel(String name, EnumGender gender) {
		this.name=name;
		this.gender=gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public StudentModel setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
		return this;
	}

	public float getAge() {
		return age;
	}

	public StudentModel setAge(float age) {
		this.age = age;
		return this;
	}

	public EnumGender getGender() {
		return gender;
	}

	public void setGender(EnumGender gender) {
		this.gender = gender;
	}

}
