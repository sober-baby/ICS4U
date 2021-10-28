

import java.util.Scanner;

public class Level3aArrayExercisesCici {
	
	public static void noDuplicates() {
		Scanner scan = new Scanner(System.in);
		
		int[] array = new int[7];
		
		
		int i=0;
		do {
			System.out.print("Enter a unique number: ");
			int temp = scan.nextInt();
			for(int k=0; k<i; k++) {
				if(temp!=array[k]) {
					array[i]=temp;
				}else {
					boolean tf=true;
					do {
						
						System.out.print("Enter another number: ");
						temp=scan.nextInt();
							for(int j=0; j<i; j++) {
								if(temp!=array[j]) {
									array[i]=temp;
									tf=true;
								}
							}
					}while(tf!=true);
				}
			}
		i+=1;
		}while(i<7);
		
		for(int k=0; k<7; k++) {
			System.out.print(array[k]);
		}
	}
	
	public static void main(String[] args) throws Exception{
		noDuplicates();
	}

}
