import java.util.ArrayList;
import java.util.List;

class QuizTaker {
  String name;
  String answer;
  int score = 0;

  public String getName() {
    return this.name;
  }

  public String getAnswer() {
    return this.answer;
  }

  public int getScore() {
    return this.score;
  }

  void setName(String name) {
    this.name = name;
  }

  void setAnswer(String answer) {
    this.answer = answer;
  }

  void addScore() {
    this.score += 1;
  }

  public QuizTaker(String name, String answer) {
    this.name = name;
    this.answer = answer;
  }
}

public class QuizChecker {

  static final String modelAnswer = "BDDAAECAACDADACAC";
  static List<QuizTaker> quizTakers = new ArrayList<>();

  public static void main(String[] args) {
    char[] modelAnswers = modelAnswer.toCharArray();
    int[] correctCount = new int[modelAnswers.length];

    QuizTaker alan = new QuizTaker("Alan", "ECCDEDEACCBEECCCC");
    QuizTaker vanus = new QuizTaker("Vanus", "DADDADADABBEEACAA");
    QuizTaker sunny = new QuizTaker("Sunny", "DBBDBDEBCDBABADED");
    QuizTaker owie = new QuizTaker("Owie", "ADDDAECACCDACABED");
    QuizTaker amir = new QuizTaker("Amir", "ABDBEEADCDBDAECDD");
    QuizTaker karson = new QuizTaker("Karson", "EDDAAECACCAADDDAE");
    QuizTaker gary = new QuizTaker("Gary", "AADBBDECDDDCAAACB");
    QuizTaker wilson = new QuizTaker("Wilson", "CDDCDDCACDABDEBAD");
    QuizTaker steve = new QuizTaker("Steve", "BDDADECAACDAEACAC");
    QuizTaker ursula = new QuizTaker("Ursula", "BDCAACECCCADEAAEA");
    QuizTaker tommy = new QuizTaker("Tommy", "BDDAAECAACAADDBEC");

    quizTakers.add(alan);
    quizTakers.add(vanus);
    quizTakers.add(sunny);
    quizTakers.add(owie);
    quizTakers.add(amir);
    quizTakers.add(karson);
    quizTakers.add(gary);
    quizTakers.add(wilson);
    quizTakers.add(steve);
    quizTakers.add(ursula);
    quizTakers.add(tommy);

    // modelAnswers
    System.out.println("Quiz 1 Result (Week3):");
    quizTakers.stream().forEach(s -> {
      if (s.answer.length() != modelAnswers.length) {
        System.out.println(s.name + " " + s.answer);
      }
      for (int i = 0; i < modelAnswers.length; i++) {
        if (modelAnswers[i] == s.getAnswer().charAt(i)) {
          correctCount[i] += 1;
          s.addScore();
        }
      }
      System.out.println(s.getName() + ":" + s.getScore() + "/" + modelAnswer.length());
    });
    // Passing Rate
    System.out.println("Passing rate for each question:");
    for (int i = 0; i < modelAnswers.length; i++) {
      System.out.println("Question " + (i + 1) + ": " //
          + Math.round((double) correctCount[i] / (double) quizTakers.size() * 100d) + "%");
    }
  }
}
