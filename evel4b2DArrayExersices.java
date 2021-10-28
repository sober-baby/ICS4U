import java.util.*;
import java.io.*;
public class evel4b2DArrayExersices {

    public static void main (String args[]) throws Exception{


        File myFile = new File("marks.txt");
        Scanner ss = new Scanner(System.in);
        Scanner fileScanner = new Scanner(myFile);
        int studentNum;
        int studentMarks;
        studentNum = fileScanner.nextInt();
        studentMarks = fileScanner.nextInt();
        String[] names = new String[studentNum];
        double[][]marks = new double[studentNum][studentMarks]; 
        int count = 0;
        //while(fileScanner.hasNextLine()){
           
            for(int i = 0; i<studentNum; i++){

                names[count] = fileScanner.next();
                fileScanner.nextLine();
                count++;
            }
           

        //}

        fileScanner.close();
        
        Scanner fS = new Scanner(myFile);

        fS.next();
        fS.next();

            for(int r = 0; r<marks.length; r++){

                fS.next();

                for(int c = 0; c<marks[r].length; c++){
    
                    marks[r][c] = fS.nextDouble();
    
                }
            }

          
            
        double[] studentAvg = new double[studentNum];
        double[] testAvg = new double[studentMarks]; 

        for(int r = 0; r<studentNum; r++){

            System.out.print(names[r] + " ");

            for(int c = 0; c<studentMarks; c++){

                System.out.print(marks[r][c] + " ");
                studentAvg[r] += marks[r][c]; 
                
            }
            System.out.print("Avg: " + studentAvg[r]/studentMarks);
            System.out.println();
        }
        
        System.out.print(" ");
        int counter = 0;
    
        while(counter<studentMarks){

            for(int i = 0; i<studentNum; i++){

                testAvg[counter] += marks[i][counter];
            }
            System.out.print(testAvg[counter]/studentNum + " ");
            counter++;
        }


     
    }
    
}
