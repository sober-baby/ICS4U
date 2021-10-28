import java.util.*;
import java.io.*;
public class FilePractice {
    

    public static void main(String args[]){

        Scanner ss = new Scanner (System.in);

        try {

            File myfile = new File ("studentinto.txt");

            PrintWriter output = new PrintWriter(myfile);
    
            Scanner sf = new Scanner ("studentinfo.txt");

            String[] name = new String[10];

            double[] score = new double[10];

            for(int i = 0; i<10; i++){

                System.out.println("Enter a name");
    
                name[i] = ss.nextLine();
    
                output.println(name[i]);
    
                System.out.println("Enter a score");
    
                score[i] = ss.nextDouble();
    
                output.println(score[i]);

                ss.nextLine();
            }

            int j = 0;

            while(sf.hasNext()){

                String tempname = sf.nextLine();

                double tempscore= sf.nextDouble();

                j++;

            }

            String[] names = new String[j];

            double[] scores = new double[j];

            double maxscore = -1; 

            String person = " ";

            for(int i = 0; i<j; i++){

                names[i] = sf.nextLine();

                scores[i] = sf.nextDouble();

                if(scores[i]>maxscore){

                    maxscore = scores[i];

                    person = names[i]; 
                    
                }

            }

            System.out.println(person + " has the hightest score of " + maxscore);

            output.close();
            

        }catch(Exception e){

            System.out.println("error......."); 
            
        }

        ss.close();


        }

    }
    

