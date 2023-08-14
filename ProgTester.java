import java.util.InputMismatchException;
import java.util.Scanner;

public class ProgTester {

	private static final int minAge = 25;
	private static final int midAge = 31;
	private static final int maxAge = 35;
	private static final int goodPer = 20;

	public static void main(String[] args){

		double per = 15;
		int age = 25;
		char answer = 'y';

		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to the Prog Tester!");
		do{

			boolean ageSet = false;
			do {
					System.out.println("Enter the player's age:");
					String ageStr = scan.nextLine();
					try {
						age = Integer.parseInt(ageStr);

						ageSet = true;
					}
					catch (NumberFormatException nfe){
						System.out.println("Please enter a valid input.");
					}	
			} while (!ageSet);

			boolean perSet =  false;
			do {
				System.out.println("Enter the player's PER:");
				String perStr = scan.nextLine();
				try {
					per = Double.parseDouble(perStr);

					perSet = true;
				}
				catch (NumberFormatException nfe){
					System.out.println("Please enter a valid input.");
				}	
			} while (!perSet);

			if(age<minAge){ System.out.println("Player is too young for the script and will use regular BBGM Progs."); }
			else {getRange((int)per,age);}

			System.out.println("Type 'y' if you want to do another player.");
			
			String answerStr = scan.nextLine();
			try{
				answer = answerStr.charAt(0);
			}
			catch (StringIndexOutOfBoundsException sioobe) {
				answer =  'n';
			}

		} while(answer == 'y');

		scan.close();

	}

	private static void getRange (int per, int age){

		int min = per/5-6;
		int max = Math.min(per/4-1,ageMax(age));

		if (per > goodPer){
			min = per/5-7;
			max = Math.min(per/5-1,ageMax(age));
		}

		System.out.println("Result: "+min+", "+max);
	}

	private static int ageMax(int age){
		if  (age >=  maxAge){
			return 0;
		}
		else if (age >= midAge  && age < maxAge) {
			return 2; 
		}
		else return 4;
	}




}