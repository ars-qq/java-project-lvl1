package hexlet.code;

public interface Game {
    void showRules();

    String getCurrentQuestion();
    void setCurrentQuestion(String question);

    String getCurrentCorrectAnswer();
    void setCurrentCorrectAnswer(String correctAnswer);

    void generateQuestion();
}
