package General.swing.miniProjects.calculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import General.swing.miniProjects.calculator.model.EnumCalculatorOp;
import General.swing.miniProjects.calculator.model.MyCalculatorModel;
import General.swing.miniProjects.calculator.view.MyCalculatorView;

public class MyCalculatorController {
	
	MyCalculatorView theView;
	MyCalculatorModel myModel;
	
	public MyCalculatorController(MyCalculatorView view, MyCalculatorModel model){
		
		this.theView = view;
		this.theView.getCalculate().addActionListener(new MyCalculateListner());
		this.myModel = model;
	}
	
	public class MyCalculateListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			theView.getStack().push(theView.getDisplayLabel().getText());
			
			double valueToDisplay = 0;
			EnumCalculatorOp nextOperator = null;
			
			while(!theView.getStack().isEmpty()){
				
				System.out.println(theView.getStack().toString());
				
				String element = theView.getStack().pop();
				
				EnumCalculatorOp temp = EnumCalculatorOp.fromString(element); 
				
				if(temp!=null){
					nextOperator = temp;
					
				}else{
					if(nextOperator==null){
						valueToDisplay =  Double.parseDouble(element);
					}else{
						valueToDisplay = myModel.operate(valueToDisplay, Double.parseDouble(element), nextOperator);
					}
				}
				
			}
			
			theView.setCalculatedvalue(valueToDisplay);
			
		}
		
	}

}
