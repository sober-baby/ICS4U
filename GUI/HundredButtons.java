package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HundredButtons extends JFrame implements ActionListener{

    public HundredButtons(){

        setTitle("Hundred Buttons");
        setSize(1920, 1080);
        GridLayout layout1 = new GridLayout(10, 10);
        FlowLayout layout2 = new FlowLayout();
        JButton[][] button = new JButton[10][10];
        JPanel pan1 = new JPanel();
        JPanel pan2 = new JPanel();

        pan1.setLayout(layout1);
        // panl.setPreferredSize(new Dimension(640, 480));

        for(int r = 0; r<button.length; r++){

            for(int c = 0; c<button[r].length; c++){

                button[r][c] = new JButton("Button " + ((r * 10) + c + 1)); 
                button[r][c].addActionListener(this);
                pan1.add(button[r][c]); 

            }
        } 

        
        add(pan1);
        //add(pan2);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }



    public void actionPerformed(ActionEvent event){

        String command = event.getActionCommand();
        System.out.println(command);

        //nothing is implemented 
    }

    public static void main (String args[]){

        HundredButtons myFrame = new HundredButtons();

    }


    
}
