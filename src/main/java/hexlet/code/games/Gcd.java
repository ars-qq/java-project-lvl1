package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.Util;

public class Gcd implements Game {
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
        final var MIN_RANGE = 0;
        final var MAX_RANGE = 100;

        var firstOperand = Util.getRandomNumber(MIN_RANGE, MAX_RANGE);
        var secondOperand = Util.getRandomNumber(MIN_RANGE, MAX_RANGE);

        var question = firstOperand + " " + secondOperand;
        this.setCurrentQuestion(question);

        var correctAnswer = this.calcCorrectAnswer();
        this.setCurrentCorrectAnswer(correctAnswer);
    }

    public String calcCorrectAnswer() {
        var question = this.getCurrentQuestion();
        var firstSpaceIndex = question.indexOf(' ');

        var firstOperand = Integer.parseInt(question.substring(0, firstSpaceIndex), 10);
        var secondOperand = Integer.parseInt(question.substring(firstSpaceIndex + 1), 10);

        var gcd = Util.calcGcd(new int[]{firstOperand, secondOperand});
        return Integer.toString(gcd);
    }
}
