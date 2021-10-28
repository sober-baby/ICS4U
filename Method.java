import java.math.*;
public class Method {

    public static double tempConverter (double d){

        double k;

        k = d + 273.15;

        return k;

    }

    public static double disCalculator(double x1, double y1, double x2, double y2){

        double distance;

        distance = Math.sqrt(Math.pow((x1-x2),2) +  Math.pow((y1-y2),2));

        return distance;



    }

    public static void printArray(int[] array){

        int max = array[0];
        for(int i = 1; i<array.length; i++){

            if(array[i] > max){

                max = array[i];
            }
        }

        System.out.println(max);
    }

    public static void main (String args[]){

        int[]arr = {1,2,3,4,5,8,0,-1,1100};
        printArray(arr);
        double n = tempConverter(10);
        System.out.println(n);
        System.out.println(disCalculator(1,1,2,2));

        
    }
    
}
