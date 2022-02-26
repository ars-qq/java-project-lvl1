package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        System.out.println("Please enter the game number and press Enter.");

        String[] games = {"Exit", "Greet", "Even", "Calc", "GCD", "Progression", "Prime"};

        for (var i = 0; i < games.length; i++) {
            var isLastIndex = i == games.length - 1;
            var number = isLastIndex
                    ? 0
                    : i + 1;

            var game = games[number];
            System.out.println(number + " - " + game);
        }

        System.out.print("Your choice: ");

        var gameChooser = new Scanner(System.in);

        if (!gameChooser.hasNextInt()) {
            System.out.println("\nIt's not a correct number!");
            start();
            return;
        }

        int gameNumber = gameChooser.nextInt();

        if (gameNumber > games.length - 1) {
            System.out.println("\nWrong game number!");
            start();
            return;
        }

        switch (gameNumber) {
            case 0:
                System.out.println("See you again!");
                return;
            case 1:
                var cli = new Cli();
                cli.start();
                break;
            case 2:
                var evenGame = new Engine(new Even());
                evenGame.start();
                break;
            case 3:
                var calcGame = new Engine(new Calc());
                calcGame.start();
                break;
            case 4:
                var gcdGame = new Engine(new Gcd());
                gcdGame.start();
                break;
            case 5:
                var progressionGame = new Engine(new Progression());
                progressionGame.start();
                break;
            case 6:
                var primeGame = new Engine(new Prime());
                primeGame.start();
                break;
        }
    }
}
