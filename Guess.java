package java_prac_package;
 //importing scanner class and random class 
import java.util.Scanner; 
import java.util.Random;

public class Guess {
	//declaring a method to show options
	public static void choice() {
		System.out.println("1.Yes 2.No");
	}
	//declaring a method to show more hints to the user
	public static void hints(int x) {
		if(x%2==0) {
			System.out.println("Its an even number.");
		}
		else {
			System.out.println("Its an odd number.");
		}
	}
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		Random r=new Random();
		int x=r.nextInt(50); //random number to be guessed by the user.
		int guess; //number guessed by the user
		int c=1;
		int count=0;
		System.out.println("Enter a number in between 1 to 50.");
		while (c==1){
			
			guess=sc.nextInt(); 
			count++;
			if(guess!=x) {
				System.out.println("Oops! you got the wrong number.\nDo you want to continue the game?");
				
				Guess.choice();
				c=sc.nextInt();
				if (c!=1) {
					System.out.println("Game is ended by the user!\nThe right answer was "+x+".");
					break;
				}
				
			}
			
			int b=0;
			if(guess<x) {
				System.out.println("Your number is too low, guess a little higher one.");
				if(count>3) {
				System.out.println("Want some more hints?");
				Guess.choice();
				b=sc.nextInt();
				if(b==1){
					Guess.hints(x);
				   
				}
				}
					
			}
			else if(guess>x) {
				System.out.println("Your number is too high, guess a little lower one.");
				if(count>3) {
					System.out.println("Want some more hints?");
					Guess.choice();
					b=sc.nextInt();
					if(b==1){
						Guess.hints(x);
					    
					}
					}
			}
			else if(guess==x) {
				System.out.println("Congratulations! you got the right number in "+count+" tries.");
			}
		}
		
	}

}
