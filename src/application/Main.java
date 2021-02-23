package application;

import java.text.ParseException;
import java.util.Scanner;

import static util.All.composition;
import static util.All.enumerationProgram;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        System.out.println("1 - Enumeration:");
        System.out.println("2 - Composition:");
        System.out.print("Enter a number: ");

        int opc = sc.nextInt();

        switch (opc) {

            case 1 -> enumerationProgram();
            case 2 -> composition();

            default -> System.out.println("Are you kidding me ?");

        }
    }
}
