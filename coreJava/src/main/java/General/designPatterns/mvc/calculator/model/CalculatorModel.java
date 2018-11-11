package General.designPatterns.mvc.calculator.model;

public class CalculatorModel {
	
	int calculationValue;
	
	public void addTwoNumber(int firstNumber, int secondNumber) {
		
		calculationValue = firstNumber + secondNumber;
	}

	public int getCalculationValue() {
		return calculationValue;
	}
	
}
