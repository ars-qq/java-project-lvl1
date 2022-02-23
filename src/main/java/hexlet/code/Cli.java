package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void takeName () {
        final var NAME_QUESTION = "May I have your name? ";

        Scanner scanner = new Scanner(System.in);

        System.out.print(NAME_QUESTION);
        String name = scanner.next();
        System.out.println("Hello, " + name);
    }
}

