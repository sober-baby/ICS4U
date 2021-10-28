import java.util.*;
public class DoughnutCompany {
    
    public static void main(String args[]){


        Scanner myScanner = new Scanner(System.in);
        double price;

            System.out.println("Enter the number of dougnuts that you want to purchase in dozens");
            int num = myScanner.nextInt();
            double totalprice = 0;
            
            if(num<6){

                price = num*8.99;
                

            }

            if(num>=6 && num<12){


                price = 5*8.99 + (num-5)*7.99;


            }
            if(num>=12 && num<16){

                price = 5*8.99 + 6*7.99 + (num-11)*6.99;
           
            }else{

                price = 5*8.99 + 6*7.99 + 4*6.99 + (num-15)*5.99;





            }

            System.out.println("The total cost of ur purchase is " + price);
            




        }





    }

