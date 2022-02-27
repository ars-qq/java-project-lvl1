package hexlet.code.games;

import hexlet.code.Game;
import hexlet.code.Util;

public final class Calc implements Game {
    private static final String[] OPERATIONS = {"+", "-", "*"};


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
        System.out.println("What is the result of the expression?");
    }

    public void generateQuestion() {
        final var minRange = 0;
        final var maxRangeBasic = 100;
        final var maxRangeMultiplication = 9;

        var operation = OPERATIONS[Util.getRandomNumber(0, OPERATIONS.length)];
        var firstOperand = Util.getRandomNumber(minRange, maxRangeBasic);

        final var maxMultiplicationFirstOperand = 10;
        var maxRange = operation.equals("*") && firstOperand >= maxMultiplicationFirstOperand
                ? maxRangeMultiplication
                : maxRangeBasic;
        var secondOperand = Util.getRandomNumber(minRange, maxRange);

        var question = firstOperand + " " + operation + " " + secondOperand;
        this.setCurrentQuestion(question);

        var correctAnswer = this.calcCorrectAnswer();
        this.setCurrentCorrectAnswer(correctAnswer);
    }

    public String calcCorrectAnswer() {
        var question = this.getCurrentQuestion();
        var firstSpaceIndex = question.indexOf(' ');

        final var radix = 10;
        final var secondOperandDiff = 3;
        var firstOperand = Integer.parseInt(question.substring(0, firstSpaceIndex), radix);
        var secondOperand = Integer.parseInt(question.substring(firstSpaceIndex + secondOperandDiff), radix);
        var operation = question.substring(firstSpaceIndex + 1, firstSpaceIndex + 2);
        int correctAnswer = firstOperand;

        switch (operation) {
            case "+":
                correctAnswer += secondOperand;
                break;
            case "-":
                correctAnswer -= secondOperand;
                break;
            case "*":
                correctAnswer *= secondOperand;
                break;
            default:
        }

        return Integer.toString(correctAnswer);
    }
}
