package pl.coderslab.workshop_1;

import java.util.Scanner;

public class GuessTheNumberReversed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int min = 0;
        int max = 1001;
        String answer = "";

        System.out.println("Pick a number between 1 and 1000 and I will guess it in max 10 moves");

        while(!answer.equals("correct")) {
            int guess = ((max - min) / 2) + min;

            System.out.println("My guess is: " + guess);
            System.out.println("Please type: 'more', 'less' or 'correct'");

            answer = scan.nextLine();

            if(answer.equals("correct")) {
                System.out.println("Haha I won, thanks for playing!");
            } else if(answer.equals("less")) {
                max = guess;
            } else if(answer.equals("more")) {
                min = guess;
            } else {
                System.out.println("Please don't cheat I really want to win:(");
                System.out.println("Let's try again");
            }

        }//wile
    }//main()
}
