package GUI;
import javax.swing.*;
import java.awt.*;

public class GuiDemoFrame extends JFrame {
	
	JButton okButton;
	JLabel nameLabel;
	JTextField nameTextField;
	
	public GuiDemoFrame() {
		setTitle("Hello World!");
		setSize(320, 200);
		
		// create components here
		okButton = new JButton("OK");
		nameLabel = new JLabel("Name:");
		nameTextField = new JTextField("   Enter name here", 15);
		
		// add layout manager
		setLayout(new FlowLayout());
		
		// add components to the frame
		add(nameLabel);
		add(nameTextField);
		add(okButton);
		
		setVisible(true);
		
	}


	public static void main(String[] args) {


		GuiDemoFrame myFrame = new GuiDemoFrame();

	}
	
}
