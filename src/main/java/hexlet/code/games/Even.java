package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.Util;

public class Even implements Game {
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
        System.out.println("Answer \'yes\' if number even otherwise answer \'no\'.");
    }

    public void generateQuestion() {
        final var MIN_RANGE = 1;
        final var MAX_RANGE = 100;

        var question = Integer.toString(Util.getRandomNumber(MIN_RANGE, MAX_RANGE));
        this.setCurrentQuestion(question);

        var correctAnswer = this.calcCorrectAnswer();
        this.setCurrentCorrectAnswer(correctAnswer);
    }

    public String calcCorrectAnswer() {
        var number = Integer.parseInt(this.getCurrentQuestion(), 10);

        return Util.isEven(number) ? TRUE_ANSWER : FALSE_ANSWER;
    }
}

