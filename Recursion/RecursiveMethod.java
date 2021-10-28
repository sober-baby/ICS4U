package Recursion;
public class RecursiveMethod {

    public static int factorial (int number){

        if(number == 1){

        return 1; 

        }else{

            return (number * factorial(number-1));


        }
    }
 

    public static int findGCD(int number1, int number2) {

        if(number2 == 0){
            return number1;      
        }else{
            return findGCD(number2, number1%number2);
        }
    }

    public static double findPower(double base, int power){

        if(power == 0){

            return 1;

        }else{
            
            if(power > 0){

             return base*findPower(base, power-1);
             
            }else{

             return base*findPower(base, power+1);

            }
        }
    }

    public static void recursion(int number) { //method to print the same number again backwards with recursion
        if(number > 0) {
           
            System.out.print((number%10));
            recursion(number/10);
                  
        }
    }

    //method to calculate the value of a fibonaciSequence at a given term 
    public static int fibonaciSequence(int n) {
        
        if(n > 0 && n<3){

            return 1;
            
        }else{

            return fibonaciSequence(n-1) + fibonaciSequence(n-2); 


        }

    }

    public static int fibonacci(int n)  {
        if(n == 0)
            return 0;
        else if(n == 1)
          return 1;
       else
          return fibonacci(n - 1) + fibonacci(n - 2);
    }


    public static void main(String args[]){
        System.out.println(factorial(15));
        recursion(1234);
        System.out.println();
        System.out.println(findGCD(111, 2101));
        System.out.println(findPower(5,-5));
        System.out.println(fibonaciSequence(6));
    }
    
}
