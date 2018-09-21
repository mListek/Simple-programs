package pl.coderslab.workshop_1;

import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LottoSimulator {
    public static void main(String[] args) {
        int[] numbers = pickNumbers();
        System.out.println("Your numbers: " + Arrays.toString(numbers));
        int[] result = getLottoNumbers();
        System.out.println("Draw result: " + Arrays.toString(result));
        System.out.println(compareNumbers(numbers, result));

    }//main()

    public static int[] pickNumbers() {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[6];
        System.out.println("Type 6 numbers between 1 and 49");

        int i = 0;
        while (numbers[5] == 0) {
            boolean nrArledyExist = false;

            System.out.println("Type " + (i + 1) + " number:");
            try {
                int tempNr = scanner.nextInt();
                if (tempNr >= 1 && tempNr <= 49) {
                    for (int j = 0; j < numbers.length; j++) {
                        if (tempNr == numbers[j]) {
                            System.out.println("You have alredy picked this number, type different one");
                            nrArledyExist = true;
                        }
                    }
                    if (!nrArledyExist) {
                        numbers[i] = tempNr;
                        i++;
                    }
                } else {
                    System.out.println("Wrong number, pick number between 1 and 49");
                }
            } catch (InputMismatchException e) {
                System.out.println("Not a valid number, please type again:");
                scanner.nextLine();
            }
        }
        Arrays.sort(numbers);
        return numbers;
    }

    public static int[] getLottoNumbers() {
        Integer[] arr = new Integer[49];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        Collections.shuffle(Arrays.asList(arr));

        int[] result = new int[6];

        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i];
        }
        Arrays.sort(result);
        return result;
    }

    public static String compareNumbers(int[] numbers, int[] result) {
        int correctNumbers = 0;
        String resultMessage = "";

        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == result[i]) {
                correctNumbers++;
            }
        }

        if(correctNumbers == 0) {
            resultMessage = "Bad luck! You didn't guess any number. Don't give up and good luck next time.";
        } else if(correctNumbers == 1 || correctNumbers == 2) {
            resultMessage = "Almost! You only scored " + correctNumbers + " numbers." +
                    "You need to score at least 3 to win a prize.";
        } else {
            resultMessage = "Congratulations! You guessed " + correctNumbers + " numbers, you win a prize!";
        }
        return resultMessage;
    }
}
