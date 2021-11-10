

/*
 * Program Description: the program created for the assignment to check if the house on the map will be flooded by water or not
 * Programmer Name: Vincent Zhou
 * Teacher Supervisor: Mrs. Andrighetti
 * Date: April 8th, 2021
 */

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;

public class FloodProgrammingAssignment extends JFrame implements ActionListener {

	JFrame frame; // declaration of the frame
	public static JLabel[][] cells; // declaration of the 2d array labels for all cells
	public JLabel[] bottomLabels; // declaration of the bottom labels for making buttons appear at a more user-friendly location
	JButton stop; // declaration of the "stop flood" button
	public static Color BROWN = new Color(218,165,32); // create an instance of the brown color since it's not included

	/**
	 * the constructor for the GUI components
	 */
	public FloodProgrammingAssignment() {
		// declaring and assigning information for the frame, including its size, title, and close operation
		frame = new JFrame(); 
		frame.setTitle("Flood Assignment");
		frame.setSize(2000, 1500);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// declaring and setting up the layout for the frame; having a grid layout to visually display everything
		GridLayout layout1 = new GridLayout(cells.length + 1, cells[0].length);
		frame.setLayout(layout1);

		// create a for loop that adds all cells to the frame
		for (int r = 0; r < cells.length; r++) {
			for (int c = 0; c < cells[0].length; c++) {
				frame.add(cells[r][c]);
			}
		}

		// declaration of the components at the bottom, including the labels and the button for stopping the flood
		bottomLabels = new JLabel[cells[0].length - 1];
		stop = new JButton("Stop Flood");
		stop.addActionListener(this); // add the action listener to allow it interacting

		// add and declare half of the bottom labels onto the frame
		for (int i = 0; i < bottomLabels.length / 2; i++) {
			bottomLabels[i] = new JLabel();
			frame.add(bottomLabels[i]);
		}

		// add the stop button onto the frame so that it's at the middle
		frame.add(stop);

		// add and declare the other half of the labels
		for (int i = bottomLabels.length / 2; i < bottomLabels.length; i++) {
			bottomLabels[i] = new JLabel();
			frame.add(bottomLabels[i]);
		}
		
		frame.setVisible(true); // set the frame to be visible once started

	}

	/**
	 * method is used for detecting actions, the stop button, of the GUI and react accordingly 
	 * @param e is the action event for knowing whether is the button clicked
	 */
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if (command.equals("Stop Flood")) { // condition when the button is clicked
			flooding(cells.length, waterCellColumn() - 1, waterCellColumn() + 1); // call the recursive method with the appropriate parameters to flood the map
			if (isSurrounded()) { // condition when the house is surrounded by sand bags
				bottomLabels[bottomLabels.length / 2].setText("Safe!"); // updating safe to the frame
			} else { // condition when the house is not surrounded
				bottomLabels[bottomLabels.length / 2].setText("Unsafe!"); // updating unsafe to the frame
			}
		}
	}

	/**
	 * recursive method used for flooding through the map; the idea of the method is to treat each flooding as a rectangle moving forward
	 * @param waterCellRow is the parameter for the last row that has water cell or the last row being flooded
	 * @param columnStart is the column/land just on the left of the water cell or the land being flooded
	 * @param columnStop is the column/land just on the right of the water cell or the land being flooded
	 */
	public static void flooding(int waterCellRow, int columnStart, int columnStop) {
		for (int r = waterCellRow - 1; r < cells.length; r++) {// go through from each starting row to the bottom since water cell is always at the lowest row
			for (int c = columnStart; c <= columnStop; c++) { // go through from the column not being flooded to the other side of the water cells
				if (r == waterCellRow - 1) { // condition for if it's the first row
					if ((c >= 0 && c < cells[0].length) && (cells[r][c].getText().equals("L")
							|| (cells[r][c].getText().equals("H") && !isSurrounded()))) { // condition for the column is still within the map and the cell is a land, or if the cell is house it is not surrounded by sand bags
						cells[r][c].setBackground(Color.CYAN); // set the cell to a blue color
					}
				} else { // condition for if it's not the first row; in this case only the land cells on the left and right needed to be updated its color
					if (!(c > columnStart && c < columnStop) && (c >= 0 && c < cells[0].length)
							&& (cells[r][c].getText().equals("L")
									|| (cells[r][c].getText().equals("H") && !isSurrounded()))) { // in addition to the conditions above, the added condition is that the cell is not within the two columns to be flooded
						cells[r][c].setBackground(Color.CYAN); // set the cell to a blue color
					}
				}
			}
		}

		if (waterCellRow - 1 >= 0) { // condition when it is the last row of land; it is the condition to determine if the program still needs to call the recursive method
			ActionListener taskPerformer = new ActionListener() { // the declaration of a timer

				@Override
				public void actionPerformed(ActionEvent e) { 

					try { // try if there's stack over flow exception
						flooding(waterCellRow - 1, columnStart - 1, columnStop + 1);
					} catch (Exception ex) { // catch the exception
					}

				}

			};
			new javax.swing.Timer(50, taskPerformer).start(); // set a timer that will wait 50 miliseconds for each recursive method call
		}
	}

	
	/**
	 * the method is used for finding the position of the column of water cell from the last row
	 * @return the index of the water cell in the last row
	 */
	public static int waterCellColumn() {
		int waterCell = 0; // declare a variable for the water cell index
		for (int c = 0; c < cells[cells.length - 1].length; c++) // loop through the last row to find the water cell
		{
			if (cells[cells.length - 1][c].getText().equalsIgnoreCase("W")) { // condition for if it is the water cell
				waterCell = c;
			}
		}
		return waterCell;
	}

	/**
	 * method is used for determining if the house is surrounded by sand bags 
	 * @return true if it's surrounded and false otherwise
	 */
	public static boolean isSurrounded() {
		int houseRow = 0; // declare an integer for storing the row index of the house cell
		int houseColumn = 0; // for the column index of the house cell
		for (int r = 0; r < cells.length; r++) { // set up a for loop that will find the house cell
			for (int c = 0; c < cells[0].length; c++) {
				if (cells[r][c].getText().equalsIgnoreCase("H")) {
					houseRow = r;
					houseColumn = c;
				}
			}
		}
		for (int r = houseRow - 1; r <= houseRow + 1; r++) { // loop through the surrounding cells of the house
			for (int c = houseColumn - 1; c <= houseColumn + 1; c++) {
				if (cells[r][c].getText().equalsIgnoreCase("L")) {
					return false; // return false when the house is not entirely surrounded by sand bags
				}
			}
		}
		return true; // return true when the house is fully surrounded by sand bags
	}

	/**
	 * the method is used for setting the color of each label depending on their status
	 * @param rowNum is the row index of the label for setting color
	 * @param columnNum is the column index of the label for setting color
	 */
	public static void setLabelColour(int rowNum, int columnNum) {
		if (cells[rowNum][columnNum].getText().equalsIgnoreCase("L")) {
			cells[rowNum][columnNum].setBackground(Color.GREEN);
		} else if (cells[rowNum][columnNum].getText().equalsIgnoreCase("S")) {
			cells[rowNum][columnNum].setBackground(BROWN);
		} else if (cells[rowNum][columnNum].getText().equalsIgnoreCase("W")) {
			cells[rowNum][columnNum].setBackground(Color.CYAN);
		} else if (cells[rowNum][columnNum].getText().equalsIgnoreCase("H")) {
			cells[rowNum][columnNum].setBackground(Color.RED);
		}
	}
	
	/**
	 * the method is used for prompting user for the file name, reading information from the file, and declaring labels accordingly
	 * @throws IOException for using File and scanning through the file
	 */
	public static void getMapInfo() throws IOException {
		Scanner in = new Scanner(System.in); // declare a scanner to be used in the console
		System.out.println("Which file would you like to test? (Please include .txt in the end of the name!)"); // prompt the user for the complete file name
		String fileName = in.nextLine(); // take in the file name
		File file = new File(fileName);
		Scanner scan = new Scanner(file); // declare a second scanner for scanning through the file
		int row = scan.nextInt(); // record the number of rows 
		int column = scan.nextInt(); // record the number of columns
		cells = new JLabel[row][column]; // declare the 2d array for the cells accordingly

		for (int r = 0; r < row; r++) { // go through all labels and assign them a color
			for (int c = 0; c < column; c++) {
				cells[r][c] = new JLabel(String.valueOf(scan.next().charAt(0)), SwingConstants.CENTER);
				cells[r][c].setOpaque(true);
				setLabelColour(r, c);
			}
		}
		in.close(); // close both scanners
		scan.close();
	}
	
	public static void main(String[] args) throws IOException {
		getMapInfo(); // invoke the method and get the map information
		FloodProgrammingAssignment frame = new FloodProgrammingAssignment(); // create an instance of the map
	}
	
}
