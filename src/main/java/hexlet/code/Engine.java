package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final int ANSWERS_TO_WIN_COUNT = 3;


    private int correctAnswersCount = 0;
    private Game game;
    private String name;


    public Engine(Game game) {
        this.setGame(game);
    }


    public int getCorrectAnswersCount() {
        return correctAnswersCount;
    }

    public void setCorrectAnswersCount(int correctAnswersCount) {
        this.correctAnswersCount = correctAnswersCount;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void start() {
        var cli = new Cli();
        cli.start();

        this.setName(cli.getName());
        this.getGame().showRules();
        this.askQuestion();
    }

    public void askQuestion() {
        var game = this.getGame();

        game.generateQuestion();
        this.outputQuestion();

        var answer = this.inputAnswer();
        this.onAnswer(answer);
    }

    public void outputQuestion() {
        System.out.println("Question: " + this.game.getCurrentQuestion());
    }

    public String inputAnswer() {
        var answerScanner = new Scanner(System.in);

        System.out.print("Your answer: ");

        return answerScanner.nextLine();
    }

    public void onAnswer(String answer) {
        if (this.game.isAnswerCorrect(answer)) {
            this.onCorrectAnswer();
        }
        else {
            this.onWrongAnswer(answer);
        }
    }

    public void onCorrectAnswer() {
        System.out.println("Correct!");
        this.setCorrectAnswersCount(this.getCorrectAnswersCount() + 1);

        if (this.isUserWin()) {
            this.onWin();
            return;
        }

        this.askQuestion();
    }

    public void onWrongAnswer(String answer) {
        this.onLose(answer);
    }

    public boolean isUserWin() {
        return this.getCorrectAnswersCount() == ANSWERS_TO_WIN_COUNT;
    }

    public void onWin() {
        System.out.println("Congratulations, " + this.getName() + "!");
    }

    public void onLose(String answer) {
        System.out.println("\'" + answer + "\' is wrong answer ;(. Correct answer was \'" + this.game.getCurrentCorrectAnswer() + "\'");
        System.out.println("Let's try again, " + this.getName() + "!");
    }
}
