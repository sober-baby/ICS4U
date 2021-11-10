package Assignment;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.xml.stream.events.EndElement;

public class MazeProgramming extends JFrame implements ActionListener{

    int row, coloumn; 
    char[][] pathChar = new char[row][coloumn]; 
    boolean[][] openVisited = new boolean[row][coloumn]; 
    boolean[][] canExit = new boolean[row][coloumn];
    JFrame frame;
    JPanel choosePanel, fileMazePanel, randomMazePanel; 
    JLabel[][] mapLable = new JLabel[row][coloumn];
    JLabel chooseRowLabel, chooseColoumnJLabel;  
    JButton chooseFile, chooseRandom, submitDimention, findPath; 
    JTextField enterFileName; 
    String getText;
    JComboBox rowBox, coloumnBox; 
   
    

    public MazeProgramming(){

        frame = new JFrame();
        frame.setTitle("Maze Asignment");
        frame.setSize(1980 , 1080);
        GridLayout layout1 = new GridLayout(row + 1, coloumn);
        BoxLayout layout2 = new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        

        //Panel for the user to choose if they want to load data from file or to auto generate a maze
        
        chooseFile = new JButton("Press to Enter From File");
        chooseFile.addActionListener(this);
        chooseRandom = new JButton("Press to auto generate a maze");
        chooseRandom.addActionListener(this);
        choosePanel.add(chooseFile);
        choosePanel.add(chooseRandom); 


        //generate tiles as lables for the maze
        for(int r = 0; r<mapLable.length; r++){

            for(int c = 0; c<mapLable[r].length; c++){

                fileMazePanel.add(mapLable[r][c]); 
                randomMazePanel.add(mapLable[r][c]);

            }
        }

        //If the user chooses to load data from a file

        enterFileName = new JTextField("Enter a file name", 20); 
        fileMazePanel.add(enterFileName);
        getText = enterFileName.getText(); 

        //If the user chooses to auto generate a map

        rowBox = new JComboBox();
        coloumnBox = new JComboBox();
        for(int i = 1; i <= 20; i++){

          //  String temp = String.valueOf(i); 
            rowBox.addItem(i);
            coloumnBox.addItem(i);

        }

        




        //generate tiles as lables for the maze

        for(int r = 0; r<mapLable.length; r++){

            for(int c = 0; c<mapLable[r].length; c++){

                fileMazePanel.add(mapLable[r][c]); 
                randomMazePanel.add(mapLable[r][c]);

            }
        }

        findPath = new JButton("Find Path");
        findPath.addActionListener(this);



        frame.setVisible(true);
        frame.add(fileMazePanel);
        frame.add(randomMazePanel); 
        frame.add(choosePanel); 



        
        

        
    }
    
    


    
    public void actionPerformed(ActionEvent e) {
        
        
    }

    public static void main (String args[]){



    }
}
