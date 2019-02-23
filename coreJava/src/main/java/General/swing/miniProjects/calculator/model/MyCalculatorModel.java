package General.swing.miniProjects.calculator.model;

public class MyCalculatorModel {
	
	public double operate(double num1, double num2, EnumCalculatorOp operator){
		
		switch (operator) {
		case ADD:
			return num1+num2;

		case MULTIPLY:
			return num1*num2;

		case DEVIDE:
			return num2/num1;

		case SUBTRACT:
			return num2-num1;

		default:
			return 0;
		}
		
	}

}
