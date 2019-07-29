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





    //Methods Called here
    public static void main(String[] args) {
        times(6, 3);
        divide(6, 3);
        sub(6, 3);
        add(6, 3);
        modules(6, 3);

        getInteger();
    }
}
