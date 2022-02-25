package hexlet.code;

import java.util.Scanner;

public class Cli {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void scanName() {
        System.out.println("\nWelcome to the Brain Games!");

        var nameQuestion = "May I have your name? ";

        Scanner scanner = new Scanner(System.in);

        System.out.print(nameQuestion);

        String name = scanner.nextLine();
        this.setName(name);
        System.out.println("Hello, " + name);
    }
}

