import java.util.*;

class Question {
    String question;
    String[] options;
    int correctAnswer; 

    
    public Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    
    public void displayQuestion() {
        System.out.println("\n" + question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    
    public boolean checkAnswer(int userAnswer) {
        return userAnswer == correctAnswer;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Which language is used for Android development?",
                new String[]{"Python", "Java", "C++", "Swift"}, 2));
        questions.add(new Question("Which company developed Java?",
                new String[]{"Microsoft", "Sun Microsystems", "Apple", "Oracle"}, 2));
        questions.add(new Question("Which keyword is used to inherit a class in Java?",
                new String[]{"this", "super", "extends", "implements"}, 3));
        questions.add(new Question("What is the default value of boolean in Java?",
                new String[]{"true", "false", "0", "null"}, 2));

        int score = 0;

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            q.displayQuestion();

            System.out.print("Enter your answer (1-" + q.options.length + "): ");
            int userAnswer = sc.nextInt();

            if (q.checkAnswer(userAnswer)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer: " + q.options[q.correctAnswer - 1]);
            }
        }

        
        System.out.println("\n===== Quiz Finished =====");
        System.out.println("Your Score: " + score + "/" + questions.size());

        if (score == questions.size()) {
            System.out.println("🎉 Excellent! You got all answers right!");
        } else if (score >= questions.size() / 2) {
            System.out.println("🙂 Good job! Keep practicing.");
        } else {
            System.out.println("😕 Better luck next time.");
        }

        sc.close();
    }
}
