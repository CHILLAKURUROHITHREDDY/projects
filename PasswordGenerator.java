package task2sa;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

	private Scanner scan;
	
	public PasswordGenerator(Scanner scan) {
		this.scan = scan;
	}
	
	public void generator() {
		scan.nextLine();
		System.out.println("\nHello, welcome to the Password Generator :) answer the following questions by Yes or No\n");
		Random rand = new Random();
		String password = "";
		ArrayList<String> requirements = format();
		int length = Integer.parseInt(requirements.get(requirements.size()-1));
		
		for(int i=0; i<length; i++) {
			int temp = rand.nextInt(requirements.size()-1);
			switch(requirements.get(temp)) {
			case "Lowercase" :
				temp = rand.nextInt(26);
				password += (char) (97+temp);
				break;
			case "Uppercase" :
				temp = rand.nextInt(26);
				password += (char) (65+temp);
				break;
			case "Numbers" :
				temp = rand.nextInt(10);
				password += temp;
				break;
			case "Symbols" :
				char[] symbols = {
					    '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', 
					    ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_', '`', '{', '|', '}', '~'
					};
				temp = rand.nextInt(symbols.length);
				password += symbols[temp];

			}
			
			
		}
		System.err.print("\nYour generated password -> ");
		System.out.println(password+'\n');
	}
	
	private ArrayList<String> format() {
		
		
		ArrayList<String> requirements = new ArrayList<>();
		String answer;
		do {
			System.out.println("Do you want Lowercase letters (abcd...) to be used ?");
			answer = scan.nextLine().toLowerCase();
		}while(validation(answer));
		if(answer.contains("yes")) {
			requirements.add("Lowercase");
		}
		
		do {
			System.out.println("Do you want Uppercase letters (ABCD...) to be used ?");
			answer = scan.nextLine().toLowerCase();
		}while(validation(answer));
		if(answer.contains("yes")) {
			requirements.add("Uppercase");
		}
		
		do {
			System.out.println("Do you want Numbers (1234...) to be used ?");
			answer = scan.nextLine().toLowerCase();
		}while(validation(answer));
		if(answer.contains("yes")) {
			requirements.add("Numbers");
		}
		
		do {
			System.out.println("Do you want Symbols (!@#$...) to be used ?");
			answer = scan.nextLine().toLowerCase();
		}while(validation(answer));
		if(answer.contains("yes")) {
			requirements.add("Symbols");
		}
		System.out.print("Great! Now enter the length of the password : ");
		requirements.add(Integer.toString(scan.nextInt()));
		
		return requirements;
	}
	
	private boolean validation(String answer) {
		answer.replace(" ", "");
		answer.replace("	", "");
		if(answer.equals("yes") ||  answer.equals("no")) {
			return false;
		}
		else
			System.out.println("You have entered something incorrect let's go over it again\n");
			return true;
	}
	

}
