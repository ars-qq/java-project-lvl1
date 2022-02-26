package hexlet.code;

import java.io.NotActiveException;

public class Util {
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int calcGcd(int[] numbers) {
        var absNumbers = toAbsNumbers(numbers);
        var min = calcMin(numbers);

        var gcd = 1;

        for (var i = gcd + 1; i <= min; i++) {
            var isCd = true;

            for (var number : absNumbers) {
                if (number % i != 0) {
                    isCd = false;
                }
            }

            gcd = isCd ? i : gcd;
        }

        return gcd;
    }

    public static int calcMin(int[] numbers) {
        var min = numbers[0];

        for (var i = 1; i < numbers.length; i++) {
            var number = numbers[i];

            if (number < min) {
                min = number;
            }
        }

        return min;
    }

    public static int[] toAbsNumbers (int[] numbers) {
        var absNumbers = new int[numbers.length];
        var index = 0;

        for (var number : numbers) {
            absNumbers[index] = Math.abs(number);
            index++;
        }

        return absNumbers;
    }
}