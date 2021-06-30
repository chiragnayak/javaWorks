package General.designPatterns.mvc.calculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import General.designPatterns.mvc.calculator.model.CalculatorModel;
import General.designPatterns.mvc.calculator.view.CalculatorView;

public class CalculatorController {
	
	private CalculatorView theView;
	private CalculatorModel theModel;
	
	public CalculatorController(CalculatorView theView, CalculatorModel theModel) {
		this.theView = theView;
		this.theModel = theModel;
		
		this.theView.addCalculationListner(new CalculateListner());
	}
	
	class CalculateListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int firstNumber;
			int secondNumber;
			
			try {
				
				firstNumber = theView.getFirstNumber();
				secondNumber = theView.getSecondNumber();
				
				theModel.addTwoNumber(firstNumber, secondNumber);
				
				theView.setCalcSolution(theModel.getCalculationValue());
				
			}catch (NumberFormatException ex) {
				
				theView.displayErrorMessage("Do number daalo sahi se !!");
			}
			
		}
		
	}

}
