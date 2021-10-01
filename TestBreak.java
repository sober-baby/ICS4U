class TestBreak {
    public static void main(String[] args) {

        int count = 0;
    

        while(true){

            if(count > 10000){

                break; 
            }

            count++; 

            System.out.println(count);




        }
    }
}