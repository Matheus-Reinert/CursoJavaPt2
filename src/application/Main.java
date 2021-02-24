package application;

import java.text.ParseException;
import java.util.Scanner;

import static util.All.*;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        System.out.println("1 - Composition and enumeration with order:");
        System.out.println("2 - Composition and enumeration with worker contracts:");
        System.out.println("3 - Composition with posts:");
        System.out.println("4 - Upercasting e Downcasting with Account: ");
        System.out.println("5 - Overlap with Account: ");
        System.out.println("6 - Inheritance and Polymorphism with Employee: ");
        System.out.println("7 - Abstract Class with Account: ");
        System.out.println("8 - Abstract Methods with Shape: ");



        System.out.print("Enter a number: ");

        int opc = sc.nextInt();

        switch (opc) {

            case 1 -> enumerationProgram();
            case 2 -> composition();
            case 3 -> post();
            case 4 -> accountCasting();
            case 5 -> accountOverlap();
            case 6 -> employeePayment();
            case 7 -> abstractClasses();
            case 8 -> abstractMethods();

            default -> System.out.println("Are you kidding me ?");

        }
    }
}
