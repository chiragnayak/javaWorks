package General.swing.miniProjects.calculator.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import General.swing.miniProjects.calculator.model.EnumCalculatorOp;

public class MyOperatorButton extends JButton implements ActionListener {

	MyCalculatorView cl;
	
	EnumCalculatorOp currentOp;

	MyOperatorButton(int x, int y, int width, int height, String cap, MyCalculatorView clc) {
		super(cap);
		setText(cap);
		setBounds(x, y, width, height);
		this.cl = clc;
		this.cl.add(this);
		addActionListener(this);
		setToolTipText("Operator "+cap);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String opString = ((MyOperatorButton)e.getSource()).getLabel();
		
		String currValue = cl.getDisplayLabel().getText();
		
		cl.getStack().push(currValue);
		cl.getStack().push(opString);
		cl.getHistoryLabel().setText(cl.getHistoryLabel().getText()+" "+currValue+" "+opString+" ");
		
		cl.getDisplayLabel().setText("0");

	}

}
