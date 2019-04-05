package General.swing.components;

import java.awt.Rectangle;

import javax.swing.JFrame;

public class checkBoxExample {
	
	public checkBoxExample() {
		
		JFrame f = new JFrame("CheckBox example");
		
		f.setBounds(new Rectangle(400, 100, 400, 200));
		f.setVisible(true);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new checkBoxExample();
	}
	

}
