import java.util.Scanner;

public class ConsoleExercises {

    public static void main(String[] args) {
        double pi = 3.14159;

//        Scanner scan = new Scanner(System.in);
//        System.out.printf("The value of pi is approximately %s", pi);
        System.out.format("The value of pi is approximately %.2f \n", pi);

        Scanner scanner = new Scanner(System.in);
//        this v makes it wait until a next line to run a func (instead of using enter and activating things on a new line, can use commas instead.
        scanner.useDelimiter("\n");

        System.out.print("Enter an integer: ");
        int userInput = scanner.nextInt();
        System.out.println(userInput);

//        throws a fit, mismatch

        System.out.print("Enter three words: ");
        String userInputWord1 = scanner.next();
        String userInputWord2 = scanner.next();
        String userInputWord3 = scanner.next();
//        or
//        String userInputWord3 = scanner.nextLine();
        System.out.println(userInputWord1);
        System.out.println(userInputWord2);
        System.out.println(userInputWord3);

//      nextLint() called to clear input or change ;ast scanner.next in prev to .nextLine
        scanner.nextLine();

        System.out.print("Enter a string: ");
        String userInputWordAll = scanner.nextLine();
        System.out.printf("Here is your sentence: %s%n", userInputWordAll);



//        System.out.print("Enter the Length, then the Width of the classroom: ");
//        float userInputLength = scanner.nextInt();
//        float userInputWidth = scanner.nextInt();
//        float totalPerimeter = (userInputLength + userInputWidth) * 2;
//        System.out.format("The perimeter of the classroom is: %f%n", totalPerimeter);
//
//        OR

        System.out.print("Enter the Width of the classroom: ");
        String userWidth = scanner.nextLine();
        double width = Double.valueOf(userWidth);
        System.out.println(width);
        System.out.print("Enter the Length of the classroom: ");
        String userLen = scanner.nextLine();
        double len = Double.valueOf(userLen);
        System.out.println(len);
        System.out.format("The area of the classroom is: %.2f%n", width * len);
        System.out.format("The perimeter of the classroom is: %.2f%n", 2 * (width + len));
        System.out.format("The volume of the classroom is: %.2f%n", 10 * width * len);


    }
}
