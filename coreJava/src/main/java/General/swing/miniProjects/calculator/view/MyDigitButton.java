package General.swing.miniProjects.calculator.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyDigitButton extends JButton implements ActionListener {

	MyCalculatorView cl;

	MyDigitButton(int x, int y, int width, int height, String cap, MyCalculatorView clc) {
		super(cap);
		setText(cap);
		setBounds(x, y, width, height);
		this.cl = clc;
		this.cl.add(this);
		addActionListener(this);
		setToolTipText("Digit "+cap);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String textToAppend = ((MyDigitButton)e.getSource()).getLabel();
		
		String currentText = cl.getDisplayLabel().getText();
		
		cl.getDisplayLabel().setText(currentText+textToAppend);

	}

}
