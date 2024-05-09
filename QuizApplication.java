import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Question {
 private String questionText;
 private List<String> options;
 private int correctAnswerIndex;
 public Question(String questionText, List<String> options, int correctAnswerIndex) {
 this.questionText = questionText;
 this.options = options;
 this.correctAnswerIndex = correctAnswerIndex;
 }
 public String getQuestionText() {
 return questionText;
 }
 public List<String> getOptions() {
 return options;
 }
 public int getCorrectAnswerIndex() {
 return correctAnswerIndex;
 }
}
class Quiz {
 private List<Question> questions;
 private int score;
 public Quiz() {
    this.questions = new ArrayList<>();
    this.score = 0;
    }
    public void addQuestion(Question question) {
    questions.add(question);
    }
    public Question getQuestion(int index) {
    return questions.get(index);
    }
    public int getSize() {
    return questions.size();
    }
    public void incrementScore() {
    score++;
    }
    public int getScore() {
    return score;
    }
   }
   public class QuizApplication {
    public static void main(String[] args) {
    Quiz quiz = new Quiz();
    quiz.addQuestion(new Question("What is the capital of France?",
    List.of("Paris", "Berlin", "London", "Madrid"), 0));
 quiz.addQuestion(new Question("What is 2 + 2?", List.of("3", "4", "5", "6"), 1));
 Scanner scanner = new Scanner(System.in);
 for (int i = 0; i < quiz.getSize(); i++) {
 Question currentQuestion = quiz.getQuestion(i);
 System.out.println("Question " + (i + 1) + ": " + currentQuestion.getQuestionText());
 List<String> options = currentQuestion.getOptions();
 for (int j = 0; j < options.size(); j++) {
 System.out.println((j + 1) + ". " + options.get(j));
 }
 System.out.print("Enter your answer (1-" + options.size() + "): ");
 int userAnswerIndex = scanner.nextInt() - 1;
 if (userAnswerIndex == currentQuestion.getCorrectAnswerIndex()) {
 quiz.incrementScore();
 System.out.println("Correct!\n");
 } else {
 System.out.println("Incorrect. The correct answer is: " +
 options.get(currentQuestion.getCorrectAnswerIndex()) + "\n");
 }
 }
 System.out.println("Your score: " + quiz.getScore() + "/" + quiz.getSize());
 }
}