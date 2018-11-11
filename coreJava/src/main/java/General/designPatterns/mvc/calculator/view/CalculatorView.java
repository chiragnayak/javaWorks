package General.designPatterns.mvc.calculator.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorView extends JFrame {

	private JTextField firstNumber = new JTextField(10);
	private JLabel additionalLabel = new JLabel("+");
	private JTextField SecondNumber = new JTextField(10);
	private JButton calculateButton = new JButton("calculate");
	private JTextField calcSolution = new JTextField(10);

	public CalculatorView(){
		
		JPanel calcPanel = new JPanel();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,200);
		
		calcPanel.add(firstNumber);
		calcPanel.add(additionalLabel);
		calcPanel.add(SecondNumber);
		calcPanel.add(calculateButton);
		calcPanel.add(calcSolution);
		
		this.add(calcPanel);
		
	}
	
	public int getFirstNumber() {
		return Integer.parseInt(firstNumber.getText());
	}
	
	public int getSecondNumber() {
		return Integer.parseInt(SecondNumber.getText());
	}
	
	public int getCalcSolution() {
		return Integer.parseInt(calcSolution.getText());
	}
	
	public void setCalcSolution(int solution) {
		calcSolution.setText(String.valueOf(solution));
	}
	
	public void addCalculationListner(ActionListener listenForCalcButton) {
		calculateButton.addActionListener(listenForCalcButton);
	}
	
	public void displayErrorMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
}
