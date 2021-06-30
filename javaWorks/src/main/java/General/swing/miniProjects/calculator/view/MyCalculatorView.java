package General.swing.miniProjects.calculator.view;

import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import General.courseEra.AlgorithmsPrinston.week2.stack.Stack_usingLinkedList;
import General.swing.miniProjects.calculator.controller.MyCalculatorController;
import General.swing.miniProjects.calculator.controller.MyCalculatorController.MyCalculateListner;
import General.swing.miniProjects.calculator.model.EnumCalculatorOp;
import General.swing.miniProjects.calculator.model.MyCalculatorModel;

public class MyCalculatorView extends JFrame {

	String digitButtonText[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
	
	MyDigitButton digitButton[] = new MyDigitButton[digitButtonText.length];
	MyOperatorButton operatorButton[] = new MyOperatorButton[EnumCalculatorOp.values().length];
	
	Label displayLabel=new Label("0",Label.RIGHT);
	Label historyLabel = new Label("", Label.RIGHT);
	  
	final int FRAME_WIDTH=500,FRAME_HEIGHT=400;  
	final int HEIGHT=30, WIDTH=70, H_SPACE=10,V_SPACE=10;  
	final int TOPX=30, TOPY=80;  
	
	Stack_usingLinkedList stack = new Stack_usingLinkedList();
	
	JButton calculate = new JButton("=");
	JButton clear = new JButton("C");

	public MyCalculatorView() {
		
		super("Calculator");  
		  
		int tempX=TOPX, y=TOPY;  
		displayLabel.setBounds(tempX,y,240,HEIGHT);  
		displayLabel.setBackground(Color.BLUE);  
		displayLabel.setForeground(Color.WHITE);  
		add(displayLabel); 
		
		historyLabel.setBounds(tempX,y-30,240,HEIGHT);  
		historyLabel.setBackground(Color.CYAN);  
		historyLabel.setForeground(Color.RED);  
		add(historyLabel); 

		int tempY = TOPY + 4*V_SPACE;
		int i=0;
		for(MyDigitButton x : digitButton){
			
			if(digitButtonText[i].equalsIgnoreCase("0")){
				
				tempX = tempX + (H_SPACE + WIDTH);
				
			}
			
			x = new MyDigitButton(tempX, tempY, WIDTH, HEIGHT, digitButtonText[i], this);
			i++;
			
			
			if(i%3==0 && i !=0){
				tempY += (V_SPACE + HEIGHT);
				tempX = TOPX;
			}else{
				tempX = tempX + H_SPACE + WIDTH;
			}
			
		
		}
		
		clear.setText("Clear");
		clear.setBounds(tempX, tempY, WIDTH, HEIGHT);
		this.add(clear);
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getDisplayLabel().setText("0");
				getHistoryLabel().setText("0");
				setStack(new Stack_usingLinkedList());
			}
		});
		
		tempY = TOPY + 4*V_SPACE;
		tempX = TOPX + 4*H_SPACE + 3 * WIDTH;
		i=0;
		for(EnumCalculatorOp eVal : EnumCalculatorOp.values()){
			
			MyOperatorButton opB = new MyOperatorButton(tempX, tempY, WIDTH, HEIGHT,eVal.getSymbol() , this);
			i++;

			if(i%2==0 && i !=0){
				tempY += ( V_SPACE + HEIGHT);
				tempX = TOPX + 4*H_SPACE + 3 * WIDTH;;
			}else{
				tempX += (H_SPACE + WIDTH);
			}
		}
		
		setLayout(null);  
		setSize(FRAME_WIDTH,FRAME_HEIGHT);  
		setVisible(true); 
		
		calculate.setText("=");
		calculate.setToolTipText("Press to See final result in display !");
		calculate.setBounds(tempX, tempY, 2*WIDTH, 2*HEIGHT);
		this.add(calculate);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public Label getDisplayLabel() {
		return displayLabel;
	}

	public void setDisplayLabel(Label displayLabel) {
		this.displayLabel = displayLabel;
	}

	public Label getHistoryLabel() {
		return historyLabel;
	}

	public void setHistoryLabel(Label historyLabel) {
		this.historyLabel = historyLabel;
	}

	public Stack_usingLinkedList getStack() {
		return stack;
	}

	public void setStack(Stack_usingLinkedList stack) {
		this.stack = stack;
	}

	public JButton getCalculate() {
		return calculate;
	}

	public void setCalculatedvalue(double valueToDisplay) {
		getDisplayLabel().setText(String.valueOf(valueToDisplay));
		getHistoryLabel().setText("");
	}

}
