package General.swing.miniProjects.chatWindow;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatWindow {
	
	public static void main(String[] args) {
	
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		
		
		//creating menu bar
		JMenuBar menuBar = new JMenuBar();
		frame.add(menuBar);
		
		JMenu m1 = new JMenu("Open");
		JMenu m2 = new JMenu("Save As");
		
		menuBar.add(m1);
		menuBar.add(m2);
		
		JMenuItem m1Item1 = new JMenuItem("From remote filesystem");
		JMenuItem m1Item2 = new JMenuItem("From local filesystem");
		m1.add(m1Item1);
		m1.add(m1Item2);
		
		//creating a panel (panel is not visible in the outout)
		JPanel panel = new JPanel();
		JLabel enterTextLabel = new JLabel("Enter Text");
		JTextField textField = new JTextField(10);
		JButton sendButton = new JButton("Send");
		JButton clearWindow = new JButton("Clean");
		
		panel.add(enterTextLabel);
		panel.add(textField);
		panel.add(sendButton);
		panel.add(clearWindow);
		
		//chat area
		JTextArea chatWindow = new JTextArea();
		chatWindow.setFont(new Font("Courier New", 0, 70));
		
		frame.setLayout(new BorderLayout());
		
		frame.getContentPane().add(BorderLayout.SOUTH,panel);
		frame.getContentPane().add(BorderLayout.CENTER,chatWindow);
		frame.getContentPane().add(BorderLayout.NORTH,menuBar);
		frame.setVisible(true);
	}
	
	
	

}
