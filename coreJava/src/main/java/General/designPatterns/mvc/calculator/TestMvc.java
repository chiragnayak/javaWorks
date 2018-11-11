package General.designPatterns.mvc.calculator;

import General.designPatterns.mvc.calculator.controller.CalculatorController;
import General.designPatterns.mvc.calculator.model.CalculatorModel;
import General.designPatterns.mvc.calculator.view.CalculatorView;

public class TestMvc {
	
	public static void main(String[] args) {
		
		CalculatorView view = new CalculatorView();
		
		CalculatorModel model = new CalculatorModel();
		
		CalculatorController controller = new CalculatorController(view, model);
		
		view.setVisible(true);
	}

}
