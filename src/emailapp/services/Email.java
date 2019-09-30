package emailapp.services;

import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLenght = 8;
    private String email;
    private String department;
    private int mailboxCapacity = 500;
    private String alternativeEmail;
    private String companySuffix = "dsweb.com";

    //Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        //Call a method asking for the department - return department
        this.department = setDepartment();
		System.out.println("Department: " + this.department);

		// Call a method that returns a random password;
        this.password = randomPassword(defaultPasswordLenght);
        System.out.println("Your password is: " + this.password);

        // Combine elements to generate email
        email = this.firstName.toLowerCase() + "." +this.lastName.toLowerCase()+ "@" + department + "." + companySuffix;
    }

    // Ask for the department
    private String setDepartment() {
        Scanner scan = new Scanner(System.in);
        System.out.print("DEPARTMENT CODES:\n1 - Sales;\n2 - Development;\n3 - Accounting;\n0 - none;\nEnter " +
				"department code: ");
        int depChoice = scan.nextInt();
        switch (depChoice) {
            case 1:
                return "sales";
            case 2:
                return "dev";
            case 3:
                return "accounting";
            case 0:
                return "";
            default:
                return "Choice invalid";
        }
    }

    // Generate a random password
	private String randomPassword(int lenght) {
    	String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$%";
    	char[] password = new char[lenght];

    	for(int i = 0; i < lenght; i++) {
			int rand = (int)(Math.random()*passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
        return new String(password);
	}

    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // Set the alternative email
    public void setAlternativeEmail(String altEmail) {
        this.alternativeEmail = altEmail;
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    // getters - password, firstName, lastName, email. alternativeEmail, department, mailboxCapacity;
    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternativeEmail() {
        return alternativeEmail;
    }

    @Override
    public String toString() {
        return "DETAILS:\n" +
                "Name: " + firstName + " " + lastName + "\n" +
                "Email: " + email + "\n" +
                "Department: " + department + "\n" +
                "Mailbox Capacity: " + mailboxCapacity + "mb\n" +
                "Alternative Email: " + alternativeEmail + "\n";
    }
}
