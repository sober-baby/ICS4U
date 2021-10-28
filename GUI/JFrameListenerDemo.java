package GUI;
import javax.accessibility.AccessibleTableModelChange;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JFrameListenerDemo extends JFrame implements ActionListener{

    public JFrameListenerDemo(){
        
        setTitle("BoxLayoutDemo");
        setSize(320, 200);
        FlowLayout layout1 = new FlowLayout();
        JButton saveButton = new JButton ("Save");
        add(saveButton);
        saveButton.addActionListener(this);
        JButton tryButton = new JButton ("Try");
        add(tryButton);
        tryButton.addActionListener(this);
        setLayout(layout1);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent event){

        String command = event.getActionCommand();
        System.out.println(command);

        //nothing is implemented 
    }

    public static void main (String args[]){

        JFrameListenerDemo myFrame = new JFrameListenerDemo();

    }


    
}


