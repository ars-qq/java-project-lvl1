package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.Util;

public final class Prime implements Game {
    private static final String TRUE_ANSWER = "yes";
    private static final String FALSE_ANSWER = "no";


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
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    public void generateQuestion() {
        final var minRange = 1;
        final var maxRange = 100;

        var question = Integer.toString(Util.getRandomNumber(minRange, maxRange));
        this.setCurrentQuestion(question);

        var correctAnswer = this.calcCorrectAnswer();
        this.setCurrentCorrectAnswer(correctAnswer);
    }

    public String calcCorrectAnswer() {
        final var radix = 10;
        var number = Integer.parseInt(this.getCurrentQuestion(), radix);

        return Util.isPrime(number) ? TRUE_ANSWER : FALSE_ANSWER;
    }
}
