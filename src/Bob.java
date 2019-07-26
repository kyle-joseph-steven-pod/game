import java.util.Scanner;

public class Bob {
    public static void main(String[] args) {
        System.out.println("Ask Bob the lackadaisical teen a question: ");
        Scanner scanner = new Scanner(System.in);
        String question = scanner.nextLine();
        if (question.endsWith("?")) {
            System.out.println("Sure");
        } else if (question.endsWith("!")) {
            System.out.println("Sure");
        } else  if (question.equals("")) {
            System.out.println("Fine. Be that way!");
        } else {
            System.out.println("Whatever");
        }
    }
}
