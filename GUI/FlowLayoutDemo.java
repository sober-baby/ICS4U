package GUI;
import javax.swing.*;
import java.awt.*;

public class FlowLayoutDemo extends JFrame{

    public FlowLayoutDemo(){

        setTitle("FlowLayoutDemo");
        setSize(320, 200);
        FlowLayout layout1 = new FlowLayout();
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
        setLayout(layout1); 
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

    }



    public static void main (String args[]){

        FlowLayoutDemo myFrame = new FlowLayoutDemo(); 


    }
    
}
