package emailapp.application;

import emailapp.services.Email;

import java.util.Scanner;

public class EmailApp {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("NEW E-MAIL ACCOUNT");
        System.out.println();

        System.out.print("Enter your first name: ");
        String firstName = scan.next();
        System.out.print("Enter your last name: ");
        String lastName = scan.next();

        Email email = new Email(firstName, lastName);

        System.out.print("Do you want to register a altenative email (Y/N)? ");
        char c = scan.next().charAt(0);
        if (c == 'Y' || c == 'y') {
            System.out.print("Enter a alternative email: ");
            String altenativeEmail = scan.next();
            email.setAlternativeEmail(altenativeEmail);
            System.out.println("Altenative email registered!");
        } else {
            System.out.println("Without altenative email registerd!");
        }
        System.out.println();

        System.out.print("Do you want to change your password(Y/N)? ");
        c = scan.next().charAt(0);
        if (c == 'Y' || c == 'y') {
            System.out.print("Enter a new password: ");
            String newPassword = new String(scan.next());
            System.out.println("Password changed!");
            email.changePassword(newPassword);
        }
        System.out.println();
        System.out.println(email.toString());
    }

}
