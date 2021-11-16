package Assignment;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class MazeProgramming extends JFrame implements ActionListener {

    public static Stack<Pair> stack = new Stack<Pair>();
    public static Font fontbig = new Font("SansSerif", Font.BOLD, 30);
    public static Font fontmedium = new Font("SansSerif", Font.BOLD, 20);
    public static Font fontsmall = new Font("SansSerif", Font.BOLD, 15);
    public static File file;
    public static char border, open, mouse, exit;
    public static char correctPath = '+';
    public static int row, coloumn, startr, startc, exitr, exitc;
    public static int[] rx = { 0, 0, 1, -1 };
    public static int[] ry = { 1, -1, 0, 0 };
    public static boolean validInput = false;
    public static Color brown = new Color(218, 165, 32);
    public static Color red = new Color(255, 51, 51);
    public static char[][] pathChar = new char[row][coloumn];
    public static boolean[][] isVisited = new boolean[row][coloumn];
    public static boolean hasPath = false;
    public static JPanel choosePanel = new JPanel();
    public static JPanel fileMazePanel = new JPanel();
    public static JPanel mazePanel = new JPanel();
    public static JPanel randomMazeEnter = new JPanel();
    public static JPanel randomMazeSolve = new JPanel();
    public static JPanel emptyPanel = new JPanel();
    public static JPanel bottomFilePanel = new JPanel();
    public static JPanel bottomRandomPanel = new JPanel();
    public static JLabel[][] mapLable = new JLabel[row][coloumn];
    public static JLabel descriptionLabel1, descriptionLabel2, chooseRowLabel, chooseColoumnJLabel, emptyLabel,
            noteLabel, mazeResultLable1, mazeResultLable2;
    public static JButton chooseFile, proceed, chooseRandom, submitDimention, findPath, homeButton, findPath1,
            homeButton1, reenterDimentonButton, reenterFileButton;
    public static JTextField enterRow, enterColoumn, enterFileName;
    String getText;

    // pop up window that tell user to enter the correct dimention or correct file
    // name
    public static void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    // recursive method that finds the path of the maze and displays it

    public static void findPath(int x, int y) {
        if (x == exitr && y == exitc) {
            System.out.println(stack.peek().fir + " " + stack.peek().sec);
            Stack<Pair> temp = (Stack<Pair>) stack.clone();
            while (!temp.isEmpty()) {
                int pathx = temp.peek().fir;
                int pathy = temp.peek().sec;
                if (pathChar[pathx][pathy] != exit && pathChar[pathx][pathy] != mouse) {
                    pathChar[pathx][pathy] = correctPath;
                }
                temp.pop();
            }
            stack.pop();
            isVisited[x][y] = false;
            return;
        } else {
            for (int i = 0; i < 4; i++) {
                int dx = x + rx[i];
                int dy = y + ry[i];
                if (dx >= 0 && dx <= row - 1 && dy >= 0 && dy <= coloumn - 1 && pathChar[dx][dy] != border
                        && !isVisited[dx][dy] && pathChar[dx][dy] != mouse) {
                    isVisited[dx][dy] = true;
                    stack.push(new Pair(dx, dy));
                    findPath(dx, dy);
                }
            }
            stack.pop();
            isVisited[x][y] = false;
            return;
        }
    }

    public static void getMapFromFile(String fileName) throws IOException {

        Scanner fs = new Scanner(file); // declare a scanner for scanning through the file
        row = fs.nextInt(); // record the number of rows
        coloumn = fs.nextInt(); // record the number of columns
        border = fs.next().charAt(0);
        open = fs.next().charAt(0);
        mouse = fs.next().charAt(0);
        exit = fs.next().charAt(0);
        pathChar = new char[row][coloumn];
        mapLable = new JLabel[row][coloumn];
        fs.close();
        fs = new Scanner(file);
        for (int i = 0; i < 6; i++) {
            fs.nextLine();
        }
        String line = ""; // declare a string to store the line of the file
        for (int r = 0; r < row; r++) { // go through all labels and assign them a color
            line = fs.nextLine();
            for (int c = 0; c < coloumn; c++) {
                pathChar[r][c] = line.charAt(c); // record the character in the file
            }
        }
        fs.close(); // close the file scanner
    }

    // function to color the specified maze
    public static void colorMaze() {

        for (int r = 0; r < mapLable.length; r++) {
            for (int c = 0; c < mapLable[0].length; c++) {
                if (pathChar[r][c] == border) {
                    mapLable[r][c] = new JLabel(String.valueOf(border));
                    mapLable[r][c].setOpaque(true);
                    mapLable[r][c].setBackground(brown);
                } else if (pathChar[r][c] == open) {
                    mapLable[r][c] = new JLabel(String.valueOf(open));
                    mapLable[r][c].setOpaque(true);
                    mapLable[r][c].setBackground(Color.yellow);
                } else if (pathChar[r][c] == mouse) {
                    mapLable[r][c] = new JLabel(String.valueOf(mouse));
                    mapLable[r][c].setOpaque(true);
                    mapLable[r][c].setBackground(Color.gray);
                } else if (pathChar[r][c] == exit) {
                    mapLable[r][c] = new JLabel(String.valueOf(exit));
                    mapLable[r][c].setOpaque(true);
                    mapLable[r][c].setBackground(Color.green);
                } else if (pathChar[r][c] == correctPath) {
                    mapLable[r][c] = new JLabel(String.valueOf(correctPath));
                    mapLable[r][c].setOpaque(true);
                    mapLable[r][c].setBackground(Color.cyan);
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
                int num = rand.nextInt(100) + 1;
                if (r == 0 || c == 0 || r == pathChar.length - 1 || c == pathChar[0].length - 1) {
                    pathChar[r][c] = 'B';
                } else if (num <= 45) {
                    pathChar[r][c] = 'B';
                } else {
                    pathChar[r][c] = 'O';
                }
            }
        }

        boolean isUnique = true;

        do {
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
        } while (!isUnique);
    }

    public static void enterValidNumber() throws NumberFormatException {

        boolean isValid = false;
        try {
            int tempr = Integer.parseInt(enterRow.getText());
            int tempc = Integer.parseInt(enterColoumn.getText());
            if (tempr > 20 || tempc > 20 || tempr < 2 || tempc < 2) {
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
        setSize(1920, 1080);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // set the frame to full screen
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        BoxLayout boxLayout = new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS);
        GridLayout choosePanelLayout = new GridLayout(2, 2);
        descriptionLabel1 = new JLabel("Welcome to the maze path finder program");
        descriptionLabel2 = new JLabel("Press a button of you choice to continue");
        chooseFile = new JButton("Press to enter a file");
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
        reenterDimentonButton = new JButton("Re_Enter Dimention");
        reenterDimentonButton.addActionListener(this);
        homeButton = new JButton("Home Button");
        homeButton.addActionListener(this);
        findPath = new JButton("Find Path");
        findPath.addActionListener(this);
        mazeResultLable1 = new JLabel("Maze Result Will be Shown HERE");
        mazeResultLable1.setHorizontalAlignment(SwingConstants.CENTER);
        mazeResultLable1.setFont(fontmedium);
        mazeResultLable1.setOpaque(true);
        mazeResultLable1.setBackground(Color.gray);
        bottomRandomPanel.add(mazeResultLable1);
        bottomRandomPanel.add(findPath);
        bottomRandomPanel.add(homeButton);
        bottomRandomPanel.add(reenterDimentonButton);
        bottomRandomPanel.setLayout(new GridLayout(1, 4));
        bottomRandomPanel.setMaximumSize(new Dimension(20000, 20000));

        // If the user chooses to load data from a file
        enterFileName = new JTextField("Enter a file name", 20);
        enterFileName.setFont(fontmedium);
        enterFileName.setHorizontalAlignment(SwingConstants.CENTER);
        proceed = new JButton("Proceed");
        proceed.addActionListener(this);
        proceed.setFont(fontmedium);
        reenterFileButton = new JButton("Re_Enter File");
        reenterFileButton.addActionListener(this);
        homeButton1 = new JButton("Home Button");
        homeButton1.addActionListener(this);
        findPath1 = new JButton("Find Path");
        findPath1.addActionListener(this);
        mazeResultLable2 = new JLabel("Maze Result Will be Shown HERE");
        mazeResultLable2.setHorizontalAlignment(SwingConstants.CENTER);
        mazeResultLable2.setFont(fontmedium);
        mazeResultLable2.setOpaque(true);
        mazeResultLable2.setBackground(Color.gray);
        bottomFilePanel.add(mazeResultLable2);
        bottomFilePanel.add(findPath1);
        bottomFilePanel.add(homeButton1);
        bottomFilePanel.add(reenterFileButton);
        bottomFilePanel.setLayout(new GridLayout(1, 4));
        bottomFilePanel.setMaximumSize(new Dimension(20000, 20000));
        fileMazePanel.add(enterFileName);
        fileMazePanel.add(proceed);
        fileMazePanel.setLayout(new GridLayout(1, 2));
        fileMazePanel.setMaximumSize(new Dimension(20000, 20000));

        // generate tiles as lables for the maze
        fileMazePanel.setVisible(false);
        randomMazeEnter.setVisible(false);
        mazePanel.setVisible(false);
        randomMazeSolve.setVisible(false);
        emptyPanel.setVisible(false);
        bottomRandomPanel.setVisible(false);
        bottomFilePanel.setVisible(false);
        setVisible(true);
        setLayout(boxLayout);
        add(choosePanel);
        add(fileMazePanel);
        add(randomMazeEnter);
        add(mazePanel);
        add(randomMazeSolve);
        add(emptyPanel);
        add(bottomRandomPanel);
        add(bottomFilePanel);

    }

    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();
        if (command.equals("Press to auto generate a maze")) {
            choosePanel.setVisible(false);
            randomMazeEnter.setVisible(true);
            emptyPanel.setVisible(true);
        }
        if (command.equals("Press to enter a file")) {
            choosePanel.setVisible(false);
            fileMazePanel.setVisible(true);
            emptyPanel.setVisible(true);
        }
        if (command.equals("Enter")) {
            validInput = false;
            enterValidNumber();
            if (validInput == true) {
                border = 'B';
                open = 'O';
                mouse = 'M';
                exit = 'E';
                mapLable = new JLabel[row][coloumn];
                pathChar = new char[row][coloumn];
                mazePanel.setLayout(new GridLayout(row, coloumn));
                generateRandomMaze();
                colorMaze();
                randomMazeEnter.setVisible(false);
                emptyPanel.setVisible(false);
                mazePanel.setVisible(true);
                bottomRandomPanel.setVisible(true);
            }
        }
        if (command.equals("Proceed")) {
            String fileName = enterFileName.getText();
            file = new File(fileName);
            if (file.isFile()) {
                try {
                    fileMazePanel.setVisible(false);
                    emptyPanel.setVisible(false);
                    mazePanel.setVisible(true);
                    bottomFilePanel.setVisible(true);
                    getMapFromFile(fileName);
                    mazePanel.setLayout(new GridLayout(row, coloumn));
                    colorMaze();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } else {
                MazeProgramming.infoBox("Enter a valid file name", "ERROR");
            }
        }
        if (command.equals("Re_Enter Dimention")) {
            randomMazeEnter.setVisible(true);
            emptyPanel.setVisible(true);
            mazePanel.setVisible(false);
            bottomRandomPanel.setVisible(false);
            mazePanel.removeAll();
        }
        if (command.equals("Re_Enter File")) {
            fileMazePanel.setVisible(true);
            emptyPanel.setVisible(true);
            mazePanel.setVisible(false);
            bottomFilePanel.setVisible(false);
            mazePanel.removeAll();
        }
        if (command.equals("Home Button")) {
            choosePanel.setVisible(true);
            mazePanel.setVisible(false);
            bottomFilePanel.setVisible(false);
            bottomRandomPanel.setVisible(false);
            mazePanel.removeAll();
        }
        if (command.equals("Find Path")) {
            hasPath = false;
            mazePanel.removeAll();
            isVisited = new boolean[row][coloumn];
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < coloumn; c++) {
                    if (pathChar[r][c] == mouse) {
                        startr = r;
                        startc = c;
                    }
                    if (pathChar[r][c] == exit) {
                        exitr = r;
                        exitc = c;
                    }
                }
            }
            stack.push(new Pair(startr, startc));
            findPath(startr, startc);
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < coloumn; c++) {
                    if (pathChar[r][c] == correctPath) {
                        hasPath = true;
                        break;
                    }
                }
                if (hasPath == true || (startc == exitc - 1 && startr == exitr) || (startc == exitc + 1 && startr == exitr) ||
                 (startc == exitc && startr == exitr - 1) || (startc == exitc && startr == exitr + 1)) {
                    mazeResultLable1.setText("There is a path from the mouse to the exit");
                    mazeResultLable1.setBackground(Color.green);
                    mazeResultLable2.setText("There is a path from the mouse to the exit");
                    mazeResultLable2.setBackground(Color.green);
                } else {
                    mazeResultLable1.setText("There is no path from the mouse to the exit");
                    mazeResultLable1.setBackground(red);
                    mazeResultLable2.setText("There is no path from the mouse to the exit");
                    mazeResultLable2.setBackground(red);
                }
            }
            colorMaze();
            invalidate();
            validate();
            repaint();
        }
        if (command.equals("Home Button") || command.equals("Re_Enter Dimention") || command.equals("Re_Enter File")) {
            mazeResultLable1.setText("Maze Result Will be Shown HERE");
            mazeResultLable2.setText("Maze Result Will be Shown HERE");
            mazeResultLable1.setBackground(Color.gray);
            mazeResultLable2.setBackground(Color.gray);
        }
    }

    public static void main(String args[]) {

        MazeProgramming frame = new MazeProgramming();
        Pair pair = new Pair(startr, startc);

    }
}
