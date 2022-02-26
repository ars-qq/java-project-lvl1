package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");

        String[] games = {"Exit", "Greet", "Even", "Calc"};

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
        int gameNumber = gameChooser.nextInt();

        switch (gameNumber) {
            case 0:
                break;
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
        }
    }
}
