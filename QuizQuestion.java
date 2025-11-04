import java.util.Scanner;

// Class representing a quiz question
class QuizQuestion {
    private String question;
    private String[] options;
    private char correctAnswer;

    public QuizQuestion(String question, String[] options, char correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = Character.toUpperCase(correctAnswer);
    }

    public String getQuestion() { return question; }
    public String[] getOptions() { return options; }
    public char getCorrectAnswer() { return correctAnswer; }
}

// Main quiz app class
public class OnlineQuizApp {
    public static void main(String[] args) {
        QuizQuestion[] questions = new QuizQuestion[] {
            new QuizQuestion("What is the capital of France?", new String[] { "A. Paris", "B. Rome", "C. Berlin", "D. Madrid" }, 'A'),
            new QuizQuestion("Which language is used for Android Development?", new String[] { "A. Swift", "B. Java", "C. Python", "D. Kotlin" }, 'D'),
            new QuizQuestion("What is 6 * 7?", new String[] { "A. 36", "B. 42", "C. 56", "D. 28" }, 'B'),
            new QuizQuestion("Who is known as the father of Java?", new String[] { "A. Bjarne Stroustrup", "B. James Gosling", "C. Dennis Ritchie", "D. Guido van Rossum" }, 'B')
        };

        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("Welcome to the Java Online Quiz!\n");

        for (int i = 0; i < questions.length; i++) {
            QuizQuestion q = questions[i];
            System.out.println((i + 1) + ". " + q.getQuestion());
            for (String option : q.getOptions()) {
                System.out.println(option);
            }
            System.out.print("Your answer (A/B/C/D): ");
            String input = scanner.nextLine().trim().toUpperCase();

            // Validate input
            while (!input.matches("[ABCD]")) {
                System.out.print("Invalid input! Please enter A, B, C, or D: ");
                input = scanner.nextLine().trim().toUpperCase();
            }

            char userAnswer = input.charAt(0);
            if (userAnswer == q.getCorrectAnswer()) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong. Correct answer: " + q.getCorrectAnswer() + "\n");
            }
        }

        System.out.println("Quiz completed!");
        System.out.println("Your final score: " + score + " out of " + questions.length);

        scanner.close();
    }
}
