package General.swing.miniProjects.calculator.test;

import General.swing.miniProjects.calculator.controller.MyCalculatorController;
import General.swing.miniProjects.calculator.model.MyCalculatorModel;
import General.swing.miniProjects.calculator.view.MyCalculatorView;

public class TestMyCalculator {
	
	public static void main(String[] args) {

		MyCalculatorView vv = new MyCalculatorView();
		MyCalculatorModel mm = new MyCalculatorModel();
		MyCalculatorController cc = new MyCalculatorController(vv,mm);
		

	}

}
