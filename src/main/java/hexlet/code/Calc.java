package hexlet.code;

public class Calc implements Game {
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
        final var MIN_RANGE = 0;
        final var MAX_RANGE_BASIC = 100;
        final var MAX_RANGE_MULTIPLICATION = 9;

        var operation = OPERATIONS[Util.getRandomNumber(0, OPERATIONS.length - 1)];
        var firstOperand = Util.getRandomNumber(MIN_RANGE, MAX_RANGE_BASIC);

        var maxRange = operation.equals("*") && firstOperand >= 10 ? MAX_RANGE_MULTIPLICATION : MAX_RANGE_BASIC;
        var secondOperand = Util.getRandomNumber(MIN_RANGE, maxRange);

        var question = firstOperand + " " + operation + " " + secondOperand;
        this.setCurrentQuestion(question);

        var correctAnswer = this.calcCorrectAnswer(question);
        this.setCurrentCorrectAnswer(correctAnswer);
    }

    public String calcCorrectAnswer(String question) {
        var firstSpaceIndex = question.indexOf(' ');

        var firstOperand = Integer.parseInt(question.substring(0, firstSpaceIndex), 10);
        var secondOperand = Integer.parseInt(question.substring(firstSpaceIndex + 3), 10);
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
        }

        return Integer.toString(correctAnswer);
    }
}
