package hexlet.code;

import java.util.Scanner;

public final class Cli {
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }


    public void start() {
        System.out.println("\nWelcome to the Brain Games!");

        var inputtedName = this.inputName();
        this.setName(inputtedName);
        this.outputWelcome();
    }

    public String inputName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("May I have your name? ");

        return scanner.nextLine();
    }

    public void outputWelcome() {
        System.out.println("Hello, " + this.getName() + "!");
    }
}

