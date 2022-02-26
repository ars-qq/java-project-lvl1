package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.Util;

public class Progression implements Game {
    private static final int PROGRESSION_SIZE = 10;
    private static final String MISSED_NUMBER_SIGN = "..";

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
        System.out.println("What number is missing in the progression?");
    }

    public void generateQuestion() {
        final var FIRST_NUMBER_MIN_RANGE = 0;
        final var FIRST_NUMBER_MAX_RANGE = 100;

        final var STEP_MIN_RANGE = 2;
        final var STEP_MAX_RANGE = 10;

        var firstNumber = Util.getRandomNumber(FIRST_NUMBER_MIN_RANGE, FIRST_NUMBER_MAX_RANGE);
        var progressionStep = Util.getRandomNumber(STEP_MIN_RANGE, STEP_MAX_RANGE);

        var progressionNumbers = new String[PROGRESSION_SIZE];

        for (var i = 0; i < progressionNumbers.length; i++) {
            var number =  firstNumber + i * progressionStep;
            progressionNumbers[i] = Integer.toString(number);
        }

        var missedNumberIndex = Util.getRandomNumber(0, PROGRESSION_SIZE - 1);
        var missedNumberAsStr = progressionNumbers[missedNumberIndex];

        var question = String.join(" ", progressionNumbers)
                .replace(missedNumberAsStr, MISSED_NUMBER_SIGN);
        this.setCurrentQuestion(question);

        this.setCurrentCorrectAnswer(missedNumberAsStr);
    }
}
