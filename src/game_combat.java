import java.util.Scanner;

public class game_combat {
    public static int dice(int side) {
        double roll = Math.ceil(Math.random() * side);
        return (int) roll;
    }

    public static double twoDice(int side) {
        double rollOne = Math.ceil(Math.random() * side);
        double rollTwo = Math.ceil(Math.random() * side);
        return (rollOne + rollTwo);
    }

