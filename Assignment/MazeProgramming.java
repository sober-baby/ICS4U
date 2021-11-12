package Assignment;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.xml.stream.events.EndElement;
import GUI.FlowLayoutDemo;

public class MazeProgramming extends JFrame implements ActionListener {

    public static Font fontbig = new Font("SansSerif", Font.BOLD, 30);
    public static Font fontmedium = new Font("SansSerif", Font.BOLD, 20);
    public static Font fontsmall = new Font("SansSerif", Font.BOLD, 15);
    public static int row, coloumn;
    public static boolean validInput = false;
    public static Color brown = new Color(218, 165, 32);
    public static char[][] pathChar = new char[row][coloumn];
    public static boolean[][] openVisited = new boolean[row][coloumn];
    public static boolean[][] canExit = new boolean[row][coloumn];
    public static JPanel choosePanel = new JPanel();
    public static JPanel fileMazePanel = new JPanel();
    public static JPanel mazePanel = new JPanel();
    public static JPanel randomMazeEnter = new JPanel();
    public static JPanel randomMazeSolve = new JPanel();
    public static JPanel emptyPanel = new JPanel();
    public static JLabel[][] mapLable = new JLabel[row][coloumn];
    public static JLabel descriptionLabel1, descriptionLabel2, chooseRowLabel, chooseColoumnJLabel, emptyLabel,
            noteLabel;
    public static JButton chooseFile, chooseRandom, submitDimention, findPath;
    public static JTextField enterRow, enterColoumn, enterFileName;
    String getText;

    // pop up window that tell user to enter the correct dimention
    public static void infoBox(String infoMessage, String titleBar) {

        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);

    }

    // function to color the specified maze
    public static void colorMaze(int row, int coloumn, char open, char block, char mouse, char exit) {

        for (int r = 0; r < mapLable.length; r++) {

            for (int c = 0; c < mapLable[0].length; c++) {

                if (pathChar[r][c] == open) {

                    mapLable[r][c] = new JLabel(String.valueOf(open));
                    mapLable[r][c].setOpaque(true);
                    mapLable[r][c].setBackground(Color.yellow);

                } else if (pathChar[r][c] == block) {

                    mapLable[r][c] = new JLabel(String.valueOf(open));
                    mapLable[r][c].setOpaque(true);
                    mapLable[r][c].setBackground(brown);

                } else if (pathChar[r][c] == mouse) {

                    mapLable[r][c] = new JLabel(String.valueOf(mouse));
                    mapLable[r][c].setOpaque(true);
                    mapLable[r][c].setBackground(Color.gray);

                } else if (pathChar[r][c] == exit) {

                    mapLable[r][c] = new JLabel(String.valueOf(exit));
                    mapLable[r][c].setOpaque(true);
                    mapLable[r][c].setBackground(Color.green);

                }

                mapLable[r][c].setHorizontalAlignment(SwingConstants.CENTER);
                mapLable[r][c].setFont(fontsmall);
                mazePanel.add(mapLable[r][c]);

            }
        }

    }

    public static void generateRandomMaze() {

        Random rand = new Random();

        for (int r = 0; r < pathChar.length; r++) {

            for (int c = 0; c < pathChar[r].length; c++) {

                int num = rand.nextInt(3) + 1;

                if (r == 0 || c == 0 || r == pathChar.length - 1 || c == pathChar[0].length - 1) {
                    pathChar[r][c] = 'B';
                } else if (num < 2) {
                    pathChar[r][c] = 'B';
                } else {
                    pathChar[r][c] = 'O';

                }
            }
        }

        boolean isUnique = true;

      /*  do {

            isUnique = true;
            int rMouse = rand.nextInt(pathChar.length);
            int cMouse = rand.nextInt(pathChar[0].length);
            int rExit = rand.nextInt(pathChar.length);
            int cExit = rand.nextInt(pathChar[0].length);

            if (rMouse == rExit && cMouse == cExit) {
                isUnique = false;
            } else if (rExit > 0 && rExit < pathChar.length - 1 && cExit > 0 && cExit < pathChar[0].length - 1) {
                isUnique = false;
            } else if ((rExit == 0 && cExit == 0) || (rExit == 0 && cExit == pathChar[0].length - 1)
                    || (cExit == 0 && rExit == pathChar.length - 1)
                    || (rExit == pathChar.length - 1 && cExit == pathChar[0].length - 1)) {
                isUnique = false;
            } else if ((rMouse == 0 && cMouse == 0) || (rMouse == 0 && cMouse == pathChar[0].length - 1)
                    || (cMouse == 0 && rMouse == pathChar.length - 1)
                    || (rMouse == pathChar.length - 1 && cMouse == pathChar[0].length - 1)) {
                isUnique = false;
            }
            if (isUnique) {
                pathChar[rMouse][cMouse] = 'M';
                pathChar[rExit][cExit] = 'E';
            }
        } while (!isUnique);*/
    }

    public static void enterValidNumber() throws NumberFormatException {

        boolean isValid = false;
        try {
            int tempr = Integer.parseInt(enterRow.getText());
            int tempc = Integer.parseInt(enterRow.getText());

            if (tempr > 20 || tempc > 20) {

                throw new NumberFormatException();

            } else if (tempr < 2 && tempc < 3) {

                throw new NumberFormatException();

            } else if (tempr < 3 && tempc < 2) {

                throw new NumberFormatException();

            } else {

                isValid = true;

            }

            if (isValid) {

                row = tempr;
                coloumn = tempc;
                validInput = true;

            }
        } catch (NumberFormatException e) {
            MazeProgramming.infoBox("Enter a valid dimention", "ERROR");

        }
    }

    public MazeProgramming() {

        setTitle("Maze Asignment");
        setSize(1100, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout layout1 = new GridLayout(row + 1, coloumn);
        BoxLayout layout2 = new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS);
        FlowLayout layout3 = new FlowLayout();
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

        findPath = new JButton("Find Path");
        findPath.addActionListener(this);
        fileMazePanel.setVisible(false);
        randomMazeEnter.setVisible(false);
        mazePanel.setVisible(false);
        randomMazeSolve.setVisible(false);
        emptyPanel.setVisible(false);
        setVisible(true);
        setLayout(layout2);
        add(choosePanel);
        add(fileMazePanel);
        add(randomMazeEnter);
        add(mazePanel);
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

            if (validInput == true) {
                mapLable = new JLabel[row][coloumn];
                pathChar = new char[row][coloumn];
                mazePanel.setLayout(new GridLayout(row, coloumn));
                generateRandomMaze();
                colorMaze(row, coloumn, 'O', 'B', 'M', 'E');
                randomMazeEnter.setVisible(false);
                emptyPanel.setVisible(false);
                mazePanel.setVisible(true);
            }
        }
    }

    public static void main(String args[]) {

        MazeProgramming frame = new MazeProgramming();

    }
}
