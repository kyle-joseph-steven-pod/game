import java.util.Scanner;

public class ControlFlowExercises {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int i = 5;
        while (i <= 15) {
            System.out.println(i);
            ++i;
        }
        //Do While
        int a = 100;
        do {
            System.out.println(a);
            a -= 5;
        } while (a >= -10);

        double b = 2;
        do {
            System.out.println(b);
            b = Math.pow(b, 2);
        } while (b <= 1000000);


        //For
        for (int c = 1; c >= -10; c++) {
            System.out.println(c);
            c -= 5;
        }
        for (double d = 2; d <= 1000000;
             d = Math.pow(d, 2)) {
            System.out.println(d);
        }

//        2
        for (long f = 1; f <= 50; f += 1) {
            if (f % 15 == 0) {
                System.out.println("Fizzbuzz");
            } else if (f % 5 == 0) {
                System.out.println("Buzz");
            } else if (f % 3 == 0) {
                System.out.println("Fizz");
            } else System.out.println(f);
        }
//      3
        System.out.println("What number would you like to go up to? ");
        int userInput = scanner.nextInt()+1;
        System.out.println("Here is your table!");
        System.out.println("number | squared | cubed");
        System.out.println("------ | ------- | -----");
        for (int g = 1; g <= userInput; g += 1) {
            if (g == userInput) {
                break;
            } else {
                System.out.printf("%-7d|%-9d|%-8d%n", g, g*g, g*g*g);
//                System.out.println(g + "      | "+ (Math.pow(g, 2)) +"       | "+ (Math.pow(g, 3)) +"    ");
            }

        }
        System.out.println("Would you like to continue? [y/n]");
        String answer = scanner.next();
        if (answer.equals("y")) {
            int newNum = userInput + 5;
            for (int g = userInput; g <= newNum+1; g += 1) {
                if (g == newNum) {
                    break;
                } else {
                    System.out.printf("%-7d|%-9d|%-8d%n", g, g*g, g*g*g);
                    //                System.out.println(g + "      | "+ (Math.pow(g, 2)) +"       | "+ (Math.pow(g, 3)) +"    ");
                }

            }

        } else {
            System.out.println("Cya!");

        }

//        4
        System.out.println("Lets convert some grades! Enter in a number grade: ");
        int grade = scanner.nextInt();
        if (grade >= 88) {
            System.out.println("That's an A!");
        } else if (grade >=80) {
            System.out.println("That's a B!");
        } else if (grade >=67) {
            System.out.println("That's a C!");
        } else if (grade >=60) {
            System.out.println("That's a D!");
        } else {
            System.out.println("That's an F!");
        }


    }
}
