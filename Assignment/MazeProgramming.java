package Assignment;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.xml.stream.events.EndElement;
import GUI.FlowLayoutDemo;

public class MazeProgramming extends JFrame implements ActionListener {

    public static int row, coloumn;
    public static char[][] pathChar = new char[row][coloumn];
    public static boolean[][] openVisited = new boolean[row][coloumn];
    public static boolean[][] canExit = new boolean[row][coloumn];
    public static JPanel choosePanel = new JPanel();
    public static JPanel fileMazePanel = new JPanel();
    public static JPanel randomMazePanel = new JPanel();
    public static JPanel randomMazeEnter = new JPanel();
    public static JPanel randomMazeSolve = new JPanel();
    public static JPanel emptyPanel = new JPanel();
    public static JLabel[][] mapLable = new JLabel[row][coloumn];
    public static JLabel descriptionLabel1, descriptionLabel2, chooseRowLabel, chooseColoumnJLabel, emptyLabel, noteLabel;
    public static JButton chooseFile, chooseRandom, submitDimention, findPath;
    public static JTextField enterRow, enterColoumn, enterFileName;
    String getText;

    public static void infoBox(String infoMessage, String titleBar) {

        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);

    }

    public static void generateRandomMaze(){   
        
        Random rand = new Random(); 

        for (int r = 0; r < mapLable.length; r++) {

            for (int c = 0; c < mapLable[r].length; c++) {

                int num = rand.nextInt(3) + 1; 
                fileMazePanel.add(mapLable[r][c]);
                randomMazePanel.add(mapLable[r][c]);
        
                if(num < 2){

                    mapLable[r][c].setBackground(new Color (150 , 10 , 1)); 


                }else{



                }
                fileMazePanel.add(mapLable[r][c]);
                randomMazePanel.add(mapLable[r][c]);

            }
        }

    

        


    }

    public static void enterValidNumber() throws NumberFormatException{

        boolean isValid = false;
        try {
            int tempr = Integer.parseInt(enterRow.getText());
            int tempc = Integer.parseInt(enterRow.getText());

            if (tempr > 20 || tempc > 20 || (tempr < 2 && tempc < 3) || (tempr < 3 && tempc < 2)) {

                throw new NumberFormatException();

            } else {   
                isValid = true;

            }
    
            if (isValid) {
    
                row = tempr;
                coloumn = tempc;
    
            }

        } catch (NumberFormatException e) {
            MazeProgramming.infoBox("Enter a valid dimention", "ERROR");
            //TODO: handle exception
        }           
    }

    public MazeProgramming() {

        setTitle("Maze Asignment");
        setSize(1980, 1080);
        GridLayout layout1 = new GridLayout(row + 1, coloumn);
        BoxLayout layout2 = new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS);
        FlowLayout layout3 = new FlowLayout();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Font fontbig = new Font("SansSerif", Font.BOLD, 30);
        Font fontmedium = new Font("SansSerif", Font.BOLD, 20);
        Font fontsmall = new Font("SansSerif", Font.BOLD, 15);

        // Panel for the user to choose if they want to load data from file or to auto

        GridLayout choosePanelLayout = new GridLayout(2, 2);
        descriptionLabel1 = new JLabel("Welcome to the maze path finder program");
        descriptionLabel2 = new JLabel("Press a button of you choice to continue");
        chooseFile = new JButton("Press to Enter From File");
        chooseFile.addActionListener(this);
        chooseFile.setFont(fontbig);
        chooseRandom = new JButton("Press to auto generate a maze");
        chooseRandom.addActionListener(this);
        chooseRandom.setFont(fontbig);
        descriptionLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        descriptionLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        descriptionLabel1.setFont(fontbig);
        descriptionLabel2.setFont(fontbig);
        descriptionLabel1.setOpaque(true);
        descriptionLabel2.setOpaque(true);
        descriptionLabel1.setBackground(Color.gray);
        descriptionLabel2.setBackground(Color.gray);
        choosePanel.setLayout(choosePanelLayout);
        choosePanel.add(descriptionLabel1);
        choosePanel.add(descriptionLabel2);
        choosePanel.add(chooseFile);
        choosePanel.add(chooseRandom);

        // If the user want to enter the dimentions manually

        GridLayout randomPanelLayout = new GridLayout(2, 2);
        enterRow = new JTextField("Enter how many rows HERE ");
        enterRow.setHorizontalAlignment(SwingConstants.CENTER);
        enterColoumn = new JTextField("Enter how many coloumns HERE");
        enterColoumn.setHorizontalAlignment(SwingConstants.CENTER);
        submitDimention = new JButton("Enter");
        submitDimention.addActionListener(this);
        noteLabel = new JLabel("Please enter a grid that is greater than 2x3, and smaller than 20x20");
        noteLabel.setHorizontalAlignment(SwingConstants.CENTER);
        enterRow.setFont(fontmedium);
        enterColoumn.setFont(fontmedium);
        submitDimention.setFont(fontmedium);
        noteLabel.setFont(fontsmall);
        randomMazeEnter.add(enterRow);
        randomMazeEnter.add(enterColoumn);
        randomMazeEnter.add(submitDimention);
        randomMazeEnter.add(noteLabel);
        randomMazeEnter.setLayout(randomPanelLayout);

        /*
         * If the user chooses to load data from a file
         * 
         * enterFileName = new JTextField("Enter a file name", 20);
         * fileMazePanel.add(enterFileName); getText = enterFileName.getText();
         * 
         */

        // If the user chooses to auto generate a map

        // generate tiles as lables for the maze

        for (int r = 0; r < mapLable.length; r++) {

            for (int c = 0; c < mapLable[r].length; c++) {

                fileMazePanel.add(mapLable[r][c]);
                randomMazePanel.add(mapLable[r][c]);

            }
        }

        findPath = new JButton("Find Path");
        findPath.addActionListener(this);
        fileMazePanel.setVisible(false);
        randomMazeEnter.setVisible(false);
        randomMazePanel.setVisible(false);
        randomMazeSolve.setVisible(false);
        emptyPanel.setVisible(false);
        setVisible(true);
        setLayout(layout2);
        add(choosePanel);
        add(fileMazePanel);
        add(randomMazeEnter);
        add(randomMazePanel);
        add(randomMazeSolve);
        add(emptyPanel);

    }

    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();
        if (command.equals("Press to auto generate a maze")) {

            choosePanel.setVisible(false);
            randomMazeEnter.setVisible(true);
            emptyPanel.setVisible(true);

        }

        if (command.equals("Enter")) {

            enterValidNumber();

        }

        

        // nothing is implemented
    }

    public static void main(String args[]) {

        MazeProgramming frame = new MazeProgramming();

    }
}
