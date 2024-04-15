package task2sa;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int choice = 0;
		System.out.println("Welcome to Ziz Password Services :)\n");
		while(choice != 4) {
			System.out.println("Enter 1 - Password Generator");
			System.out.println("Enter 2 - Password Strength Check");
			System.out.println("Enter 3 - Useful Information");
			System.out.println("Enter 4 - Quit");
			System.out.print("Choice: ");
			choice = scan.nextInt();
			switch(choice) {
				case 1 :
					PasswordGenerator passwordGenerator = new PasswordGenerator(scan); 
					passwordGenerator.generator();
					break;
				case 2 :
					PasswordTester passwordTester = new PasswordTester(scan);
					passwordTester.tester();
					break;
				case 3 :
					PasswordTester.information();
					break;
			}
		}
		scan.close();
	}

}
