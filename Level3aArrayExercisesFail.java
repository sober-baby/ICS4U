import java.util.*;
public class Level3aArrayExercisesFail {
    
    public static void noDuplicates(){

        Scanner ss = new Scanner(System.in);
        int[] arr = new int[7];
        boolean tF = true;
        
        for(int i = 0; i<arr.length; i++){

            System.out.println("Enter 7 integers");
            arr[i] = ss.nextInt();


                for(int j = 0; j<i; j++){
                    
                    while(tF){

                    if(arr[i] == arr[j]){

                        System.out.println("ERROR. Enter a unique integer");
                        arr[i] = ss.nextInt();

                
                    }else{

                        tF = false;

                    }
                }                 
        }
    }
}

    public static void main(String args[]){

        noDuplicates();
        


    }
}
