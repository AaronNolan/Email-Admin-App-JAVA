package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int emailCapacity = 500;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "anycompany.com";
	
	// Constructor to receive the first and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		// System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);
	
		// Call a method asking for department - return the department
		this.department = setDepartment();
		// System.out.println("Department: " + this.department);
		
		// Call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your Password: " + this.password);
		
		// Combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "."+ companySuffix;
	}

	// Ask for the department
	private String setDepartment() {
		System.out.println("Employee Name: " + firstName + " " + lastName
				+ "\nPlease select your relevant department code below \n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if (depChoice == 1) { return "sales"; }
		else if (depChoice == 2) { return "dev"; }
		else if (depChoice == 3) { return "acct"; }
		else { return ""; }
	}
	
	// Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRDTUVWXYZ123456789$%!@";
		char[] password = new char[length];
		for (int i=0; i<length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
				
	}
	
	// Set the mailbox capacity
	public void setEmailCapacity(int capacity) {
		this.emailCapacity = capacity;
	}
	
	// Set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}	
	
	// Change the password
	public void changePassword(String password) {
		this.password = password;
	}
	
	// Create the get methods
	
	public int getEmailCapacity() { return emailCapacity; }
	public String getAlternateEmail() { return alternateEmail; }
	public String getPassword() { return password; }
	
	// Show information
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName + "\n" +
				"COMPANY EMAIL: " + email + "\n" +
				"EMAIL CAPACITY: " + emailCapacity + "mb";
	}
}
