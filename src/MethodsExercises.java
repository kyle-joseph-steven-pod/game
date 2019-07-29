import java.util.Scanner;

public class MethodsExercises {

    public static void times(int one, int two) {
//        System.out.println( one * two);
        int value = 0;
        for (int i = 0; i <= one; i++) {
            if (i == one) {
                System.out.println(value);
                return;
            } else {
                value += two;
            }
        }
    }

    public static void divide(int one, int two) {
        System.out.println(one / two);
    }

    public static void sub(int one, int two) {
        System.out.println(one - two);
    }

    public static void add(int one, int two) {
        System.out.println(one + two);
    }

    public static void modules(int one, int two) {
        System.out.println(one % two);
    }

    //2
    public static void getInteger() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number between 1 and 10: ");
        int userInput = scanner.nextInt();

        if (userInput >= 1 && userInput <= 10) {
            System.out.println("That's a number between 1 and 10!");

        } else {
            System.out.println("Try again!");
            getInteger();
        }
    }

    //3
    public static void factoral() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number between 1 and 10: ");
        int userAnswer = scanner.nextInt();
        if (userAnswer <= 10 && userAnswer >= 1) {
            System.out.println("Your number is: " + userAnswer);
            int counter = userAnswer;
            int newNum = userAnswer;
            for (int i = 1; i <= counter; i++) {
                userAnswer -= 1;
                System.out.println("newNum = " + newNum);
                System.out.println("userin = " +userAnswer);
                newNum *= userAnswer;
                if (i == userAnswer) {
                    System.out.println(newNum);
                    return;
                }
            }
        } else {
            System.out.println("Try again!");
            factoral();
        }
    }

    //4
    public static void dice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number of sides for a pair od dice: ");
        int diceSides = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Roll the dice? [y/n] ");
        String response = scanner.nextLine();
        if (response.equals("y")) {
            for (int i = 1; i <= 2; i++) {
                int random = (int)(Math.random() * diceSides + 1);
                System.out.println("Dice roll = "+random);
            }
        } else if (response.equals("n")) {
            System.out.println("Cya!");
        } else {
            System.out.println("Try again!");
            dice();
        }


    }



    //Methods Called here
    public static void main(String[] args) {
        times(6, 3);
        divide(6, 3);
        sub(6, 3);
        add(6, 3);
        modules(6, 3);

        getInteger();

        factoral();

        dice();

    }
}
