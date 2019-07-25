import java.util.Scanner;

public class ConsoleExercises {

    public static void main(String[] args) {
        double pi = 3.14159;

        Scanner scan = new Scanner(System.in);
//        System.out.printf("The value of pi is approximately %s", pi);
        System.out.format("The value of pi is approximately %.3f", pi);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int userInput = scanner.nextInt();
        scanner.useDelimiter("\n");

        System.out.println(userInput);
//        throws a fit


        System.out.print("Enter a word: ");
        String userInputWord1 = scanner.next();
        String userInputWord2 = scanner.next();
        String userInputWord3 = scanner.next();
        scanner.useDelimiter("\n");
        System.out.println(userInputWord1);
        System.out.println(userInputWord2);
        System.out.println(userInputWord3);


        System.out.print("Enter a string: ");
        String userInputWordAll = scanner.nextLine();
        scanner.useDelimiter("\n");
        System.out.println(userInputWordAll);




        System.out.print("Enter the Length, then the Width of the classroom: ");
        float userInputLength = scanner.nextInt();
        float userInputWidth = scanner.nextInt();
        scanner.useDelimiter("\n");
        float totalPerimeter = (userInputLength + userInputWidth) * 2;
        System.out.format("The perimeter of the classroom is: %f%n", totalPerimeter);

    }
}
