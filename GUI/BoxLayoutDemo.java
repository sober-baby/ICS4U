package GUI;
import javax.swing.*;
import java.awt.*;

public class BoxLayoutDemo extends JFrame{    

    public BoxLayoutDemo(){

        setTitle("BoxLayoutDemo");
        setSize(320, 200);
        BoxLayout layout1 = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
        JButton Button1 = new JButton("Button 1");
        JButton Button2 = new JButton("Button 2");
        JButton Button3 = new JButton("Button 4");
        JButton Button4 = new JButton("Long-Named Button 4");
        JButton Button5 = new JButton("5");
        
        add(Button1);
        add(Button2);
        add(Button3);
        add(Button4);
        add(Button5);
        Button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        Button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        Button3.setAlignmentX(Component.CENTER_ALIGNMENT);
        Button4.setAlignmentX(Component.CENTER_ALIGNMENT);
        Button5.setAlignmentX(Component.CENTER_ALIGNMENT);
        setLayout(layout1);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    public static void main (String args[]){

        BoxLayoutDemo myFrame = new BoxLayoutDemo();
        
       
    }
    
}
