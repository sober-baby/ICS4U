package arrays;

import java.util.Random;
import java.util.Scanner;

/**
 * Name: Mrs. Andrighetti
 * Date: Oct 13, 2021
 * Description: Sample solution program that will generate & store unique random numbers within a 
 *              certain range.
 */

public class RandomNoDuplicates {
	
	/**
	 * @param list -- the array that is being populated
	 * @param target -- this value that we want to store (should be unique)
	 * @param index -- this the number of values stored so far
	 * @return
	 */
	public static boolean contains(int[] list, int target, int index) {
		boolean found = false;
		
		for (int i = 0; i < index; i++) {
			if (list[i] == target) {
				found = true;
				break;
			}
		}
		return found;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random randGen = new Random();
		
		System.out.println("Enter min value for random range:");
		int min = input.nextInt();  // this is the min value for the range of numbers generated
		
		System.out.println("Enter max value for random range:");
		int max = input.nextInt(); // max value for the range of numbers generated
		
		int[] uniqueList = new int[10]; // array to store the unique numbers
		
		for (int i = 0; i < uniqueList.length; i++) { // for each cell in the array
			 
			int num = randGen.nextInt((max-min) + 1) + min; // generate a random number within range
			
			while(contains(uniqueList, num, i) == true) { // if the list contains the number generated
				System.out.println("Duplicate: " + num  + " regenerating....");
				num =  randGen.nextInt((max-min) + 1) + min; // regenerate
			}
			
			System.out.println("Storing: " + num);
			uniqueList[i] = num;  // store the unique number in the array
		}
		
		
		// print out all the values generated & stored
		for (int num : uniqueList) {
			System.out.println(num);
		}
		

	}

}
