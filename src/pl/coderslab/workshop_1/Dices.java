package pl.coderslab.workshop_1;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Random;

public class Dices {
    public static void main(String[] args) {
        try {
            int value = throwDice("3d4+5");
            System.out.println(value);
        } catch (Exception e) {
            System.out.println("Wrong data");
        }
    }

    private static int throwDice(String symbol) {
        int[] params = parse(symbol);
        System.out.println(Arrays.toString(params));
        int result = calculateResult(params);
        return result;
    }

    private static int calculateResult(int[] params) {
        int result = params[2];
        Random r = new Random();
        for (int i = 0; i < params[0]; i++) {
            int thisThrow = r.nextInt(params[1]) + 1;
            System.out.println("throw " + (i + 1) + " = " + thisThrow);
            result += thisThrow;
        }
        return result;
    }

    private static int[] parse(String symbol) {
        // result[0] contains how many throws
        // result[1] contains dice type (how many sides)
        // result[2] contains modifier
        try {
            int[] result = {0, 0, 0};
            symbol = symbol.toLowerCase();
            String[] splited = symbol.split("d");
            String throwsStr = splited[0];
            String diceTypeStr = "";
            String modifierStr = "";
            if (splited[1].contains("+")) {
                splited = splited[1].split("\\+");
                diceTypeStr = splited[0];
                modifierStr = splited[1];
            } else {
                splited = splited[1].split("\\-");
                diceTypeStr = splited[0];
                modifierStr = "-" + splited[1];
            }
            // now I have set:
            // throwsStr, diceNumberStr, modifierStr
            // let's use it and get numbers;
            result[0] = Integer.parseInt(throwsStr);
            result[1] = Integer.parseInt(diceTypeStr);
            result[2] = Integer.parseInt(modifierStr);
            Integer[] ALLOWED_DICE_TYPES = {3, 4, 6, 8, 10, 12, 20, 100};
            if (!Arrays.asList(ALLOWED_DICE_TYPES).contains(result[1])) {
                throw new InvalidParameterException("Such dice doesn't exist!");
            }
            return result;
        } catch (Exception e) {
            throw new InvalidParameterException(e.getMessage());
        }
    }
}
