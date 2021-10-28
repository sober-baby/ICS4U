public class MethodPractice {

    public static int sum(int [] arr){

        int sum = 0;

        for(int i = 0; i<arr.length; i++){

            sum += arr[i]; 
        }
        return sum; 
    }

    public static void main(String args[]){

        int[] arr = {1,1,1,1,1,1,1};
        System.out.println(sum(arr)); 


    }
 
}
