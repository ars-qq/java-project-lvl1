package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.Util;

public final class Gcd implements Game {
    private String currentQuestion;
    private String currentCorrectAnswer;


    public String getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(String question) {
        this.currentQuestion = question;
    }

    public String getCurrentCorrectAnswer() {
        return currentCorrectAnswer;
    }

    public void setCurrentCorrectAnswer(String correctAnswer) {
        this.currentCorrectAnswer = correctAnswer;
    }


    public void showRules() {
        System.out.println("Find the greatest common divisor of given numbers.");
    }

    public void generateQuestion() {
        final var minRange = 0;
        final var maxRange = 100;

        var firstOperand = Util.getRandomNumber(minRange, maxRange);
        var secondOperand = Util.getRandomNumber(minRange, maxRange);

        var question = firstOperand + " " + secondOperand;
        this.setCurrentQuestion(question);

        var correctAnswer = this.calcCorrectAnswer(firstOperand, secondOperand);
        this.setCurrentCorrectAnswer(correctAnswer);
    }

    public String calcCorrectAnswer(int firstOperand, int secondOperand) {
        var gcd = Util.calcGcd(new int[]{firstOperand, secondOperand});
        return Integer.toString(gcd);
    }
}
