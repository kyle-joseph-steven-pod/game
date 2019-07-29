import java.util.Scanner;

public class HighLow {
    public static void game() {
        Scanner scanner = new Scanner(System.in);
        int random = (int) (Math.random() * 99 + 1);
        int guesses = 0;
        boolean looper = true;
        do {
            System.out.println("Guess what number I'm thinking of: ");
            guesses += 1;
            int userGuess = scanner.nextInt();
            if (userGuess == random) {
                System.out.println("GOOD GUESS!");
                System.out.println("Number of guesses: " + guesses);
                looper = false;
            } else if (userGuess < random) {
                System.out.println("HIGHER!");
            } else if (userGuess > random) {
                System.out.println("LOWER!");
            } else {
                System.out.println("Something went wrong! Lets start over...");
                game();
            }
        } while (looper);
    }
    public static void main(String[] args) {
        game();
    }


}
