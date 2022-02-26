package hexlet.code;

public class Util {
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}