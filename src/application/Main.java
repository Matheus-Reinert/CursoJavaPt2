package application;

import java.util.Scanner;

import static util.All.enumerationProgram;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1 - Enumeration");
        System.out.print("Enter a number: ");

        int opc = sc.nextInt();

        switch (opc) {

            case 1 -> enumerationProgram();

            default -> System.out.println("Are you kidding me ?");

        }
    }
}
