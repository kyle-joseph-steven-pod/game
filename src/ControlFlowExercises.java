public class ControlFlowExercises {
    public static void main(String[] args) {
        int i = 5;
        while (i <= 15) {
            System.out.println(i);
            ++i;
        }
        //2
        int a = 100;
        do {
            System.out.println(a);
            a -= 5;
        }while (a >= -10);

        int b = 2;
        do {
            System.out.println(b);
            b = b * b;
        } while (b < 100000);
    }
}
