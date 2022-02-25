package hexlet.code;

import java.util.Scanner;

public class Even {
    private static final String TRUE_ANSWER = "yes";
    private static final String FALSE_ANSWER = "no";
    private static final int ANSWERS_TO_WIN_COUNT = 3;

    private Cli cli;
    private int correctAnswersCount = 0;

    public Even (Cli cli) {
        this.setCli(cli);
    }

    public Cli getCli() {
        return cli;
    }

    public int getCorrectAnswersCount() {
        return correctAnswersCount;
    }

    public void setCorrectAnswersCount(int correctAnswersCount) {
        this.correctAnswersCount = correctAnswersCount;
    }

    public void setCli(Cli cli) {
        this.cli = cli;
    }

    public void startGame() {
        this.cli.scanName();
        System.out.println("Answer \'yes\' if number even otherwise answer \'no\'.");

        this.scanAnswer();
    }

    public void scanAnswer() {
        final var MIN_RANGE = 1;
        final var MAX_RANGE = 100;

        var questionNumber = Util.getRandomNumber(1, 100);
        var answerScanner = new Scanner(System.in);

        System.out.println("Question: " + questionNumber);
        System.out.print("Your answer: ");

        var answer = answerScanner.next();
        this.onAnswer(answer, questionNumber);
    }

    public void onAnswer(String answer, int questionNumber) {
        if (!isAnswerCorrect(answer, questionNumber)) {
            this.onWrongAnswer(answer, questionNumber);
            return;
        }

        this.onCorrectAnswer();
    }

    public void onWrongAnswer(String answer, int questionNumber) {
        var correctAnswer = isEven(questionNumber) ? TRUE_ANSWER : FALSE_ANSWER;

        System.out.println("\'" + answer + "\' is wrong answer ;(. Correct answer was \'" + correctAnswer + "\'");
        System.out.println("Let's try again, " + this.getCli().getName() + "!");
    }

    public void onCorrectAnswer() {
        System.out.println("Correct!");
        this.setCorrectAnswersCount(this.getCorrectAnswersCount() + 1);

        if (this.isUserWin()) {
            this.showCongratulations();
            return;
        }

        this.scanAnswer();
    }

    public boolean isUserWin() {
        return this.getCorrectAnswersCount() == ANSWERS_TO_WIN_COUNT;
    }

    public void showCongratulations() {
        System.out.println("Congratulations, " + this.getCli().getName() + "!");
    }

    public static boolean isAnswerCorrect(String answer, int number) {
        if (!answer.equals(TRUE_ANSWER) && !answer.equals(FALSE_ANSWER)) {
            return false;
        }

        if (answer.equals(TRUE_ANSWER) && isEven(number)) {
            return true;
        }

        if (answer.equals(FALSE_ANSWER) && !isEven(number)) {
            return true;
        }

        return false;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}

