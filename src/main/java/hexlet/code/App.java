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

        final var exitNumber = 0;
        final var greetNumber = 1;
        final var evenNumber = 2;
        final var calcNumber = 3;
        final var gcdNumber = 4;
        final var primeNumber = 5;
        final var progressionNumber = 6;

        switch (gameNumber) {
            case exitNumber:
                System.out.println("See you again!");
                return;
            case greetNumber:
                var cli = new Cli();
                cli.start();
                break;
            case evenNumber:
                var evenGame = new Engine(new Even());
                evenGame.start();
                break;
            case calcNumber:
                var calcGame = new Engine(new Calc());
                calcGame.start();
                break;
            case gcdNumber:
                var gcdGame = new Engine(new Gcd());
                gcdGame.start();
                break;
            case primeNumber:
                var progressionGame = new Engine(new Progression());
                progressionGame.start();
                break;
            case progressionNumber:
                var primeGame = new Engine(new Prime());
                primeGame.start();
                break;
            default:
        }
    }
}
