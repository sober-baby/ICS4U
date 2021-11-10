package Assignment;

import java.awt.*;
import javax.swing.*;

public class HR16ComboScroll extends JFrame {

    JComboBox list; 
    public HR16ComboScroll() {
        super("Combo Scroll");
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flo = new FlowLayout();
        setLayout(flo);

        list = new JComboBox();
      
        for(int i = 1; i <= 20; i++){

          //  String temp = String.valueOf(i); 
            list.addItem(i);
           // coloumnBox.addItem(i);

        }


      //  String[] contents = new String[] { "Alem", "Habtam", "Desta", "Almaz", "Zewdit", "Abraham", "Tsehaye" };
        JScrollPane pane = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        // list.addItem(pane);
        add(pane);

        setVisible(true);
    }

    // run
    public static void main(String[] args) {
        HR16ComboScroll pane = new HR16ComboScroll();
    }
}