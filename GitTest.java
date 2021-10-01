import java.util.*;
public class GitTest{
    public static void main(String args[]){
    
    int i = 100;
    int num = 0;
    int[] arr = new int[(i-50)/5+1];

    while(i>=50){

        arr[num] = i;
        i = i - 5;
        num++; 

    }

    for(int j = 0; j<arr.length ;j++){
        System.out.println(arr[j]);
    }
    
    
    
    
    
    
    
    
    
    }
}