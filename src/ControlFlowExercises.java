public class ControlFlowExercises {
    public static void main(String[] args) {
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

        int b = 2;
        do {
            System.out.println(b);
            b = b * b;
        } while (b < 1000000);
        //For
        for (int c = 1; c >= -10; c++) {
            System.out.println(c);
            c -= 5;
        }
        for (int d = 1; d <= 1000000; d*=d) {
            System.out.println(d);
        }

//        2
        for (int f = 1; f <= 50; f++) {
            if (f % 15 == 0) {
                System.out.println("Fizzbuzz");
            } else if (f == 5) {
                System.out.println("Buzz");
            } else if (f == 3) {
                System.out.println("Fizz");
            } else System.out.println(i);
        }
    }
}
