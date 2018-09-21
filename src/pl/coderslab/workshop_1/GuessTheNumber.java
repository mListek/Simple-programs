package pl.coderslab.workshop_1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        int number = rand.nextInt(100);
        System.out.println("Zgadnij liczbe od 1 do 100:");
        while (true) {
            try {
                int guess = scan.nextInt();

                if (guess < number) {
                    System.out.println("Za mało!");
                } else if (guess > number) {
                    System.out.println("Za dużo!");
                } else if (guess == number) {
                    System.out.println("Brawo, zgadłeś!");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("To nie jest liczba, wpisz jeszcze raz:");
                scan.nextLine();
            }
        }//while

    }
}
