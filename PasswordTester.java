package task2sa;

import java.util.Scanner;

public class PasswordTester {
	
	private Scanner scan;
	
	public PasswordTester(Scanner scan) {
		this.scan = scan;
	}
	
	public void tester() {
		
		scan.nextLine();
		System.out.print("\nEnter your password: ");
		String password = scan.nextLine();
		
		int strength = lowerCaseCount(password) * 2;
		strength += upperCaseCount(password) * 2;
		strength += numbersCount(password) * 2;
		strength += symbolsCount(password) * 3;
		strength += password.length() * 3;
		
		if(strength <= 25)
			System.out.println("\nThis is a very good password :D check the Useful Information section to make sure it satisfies the guidelines\n");
		else if(strength <= 50)
			System.out.println("\nThis is a good password :) but you can still do better\n");
		else if(strength <= 75)
			System.out.println("\nThis is a medium password :/ try making it better\n");
		else
			System.out.println("\nThis is a weak password :( definitely find a new one\n");
			
		
	}

	private static int lowerCaseCount(String password) {
		return (int) password.chars().filter(Character::isLowerCase).count();
	}
	
	private static int upperCaseCount(String password) {
		return (int) password.chars().filter(Character::isUpperCase).count();
	}
	
	private static int numbersCount(String password) {
		return (int) password.chars().filter(Character::isDigit).count();
	}
	
	private static int symbolsCount(String password) {
		return (int) password.chars().filter(ch -> !Character.isLetterOrDigit(ch)).count();
	}
	
	public static void information() {
		
		 System.out.println();
	     System.out.println("Use a minimum password length of 8 or more characters if permitted");
	     System.out.println("Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted");
	     System.out.println("Generate passwords randomly where feasible");
	     System.out.println("Avoid using the same password twice (e.g., across multiple user accounts and/or software systems)");
	     System.out.println("Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences," +
	             "\nusernames, relative or pet names, romantic links (current or past) " +
	             "and biographical information (e.g., ID numbers, ancestors' names or dates).");
	     System.out.println("Avoid using information that the user's colleagues and/or " +
	             "acquaintances might know to be associated with the user");
	     System.out.println("Do not use passwords which consist wholly of any simple combination of the aforementioned weak components\n");
	}

}
