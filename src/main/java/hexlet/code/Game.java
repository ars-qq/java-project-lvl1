package hexlet.code;

interface Game {
    void showRules();

    String getCurrentQuestion();
    void setCurrentQuestion(String question);

    String getCurrentCorrectAnswer();
    void setCurrentCorrectAnswer(String correctAnswer);

    void generateQuestion();

    String calcCorrectAnswer(String question);

    boolean isAnswerCorrect(String answer);
}