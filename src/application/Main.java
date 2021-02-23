package application;

import java.text.ParseException;
import java.util.Scanner;

import static util.All.*;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        System.out.println("1 - Composition and enumeration with order:");
        System.out.println("2 - Composition and enumeration with worker contracts:");
        System.out.println("3 - composition with posts:");
        System.out.print("Enter a number: ");

        int opc = sc.nextInt();

        switch (opc) {

            case 1 -> enumerationProgram();
            case 2 -> composition();
            case 3 -> post();

            default -> System.out.println("Are you kidding me ?");

        }
    }
}
