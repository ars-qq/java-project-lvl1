package hexlet.code;

import java.util.Scanner;

public class Cli {
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void start() {
        System.out.println("\nWelcome to the Brain Games!");

        var name = this.inputName();
        this.setName(name);
        this.outputWelcome();
    }

    public String inputName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("May I have your name? ");

        return scanner.nextLine();
    }

    public void outputWelcome() {
        System.out.println("Hello, " + this.getName());
    }
}

