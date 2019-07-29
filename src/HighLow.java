import java.util.Scanner;

public class HighLow {
    public static void game() {
        Scanner scanner = new Scanner(System.in);
        int random = (int) (Math.random() * 99 + 1);
        int guesses = 0;
        boolean looper = true;
        do {
            System.out.println("Guess what number I'm thinking of: (you have 5 guesses)");
            guesses += 1;
            int userGuess = scanner.nextInt();
            if (guesses > 5) {
                System.out.println("Sorry but you ran out of guesses, better luck next time!");
                looper = true;
            } else if (userGuess == random) {
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
