package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void takeName() {
        var nameQuestion = "May I have your name? ";

        Scanner scanner = new Scanner(System.in);

        System.out.print(nameQuestion);
        String name = scanner.next();
        System.out.println("Hello, " + name);
    }
}

