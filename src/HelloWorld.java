public class HelloWorld {
    public static void main(String[] args) {
        System.out.print("Hello, World!");
        System.out.print("\n");

//
        int myFavoriteNumber = 42;
        System.out.println(myFavoriteNumber);
//
        String myString = "Chocolate Devotion is the best ice cream at Coldstone";
        System.out.println(myString);
//
        myString = "dogs";
        System.out.println(myString);
//
//        myString = 3.14159;
//        System.out.println(myString);
//
        long myNumber;
//        System.out.println(myNumber);
//        myNumber = 3.14;
        myNumber = 123L;
        System.out.println(myNumber);
//
        myNumber = 123;
        //NEEDS TO BE A DOUBLE FOR 3.14
//
//        float myNumber = 3.14;
        //make the scope float,
//
//        int x = 5;
//        System.out.println(x++);
//        System.out.println(x);

//        int x = 5;
//        System.out.println(++x);
//        System.out.println(x);
        //the position of the ++, on the second makes it increment before the return, it is in the place to increment.
//        String class = "dogs";
        //its a reserved word, cant use it to name a var.


//        String theNumberThree = "three";
//        Object o = theNumberThree;
//        int three = (int) o;
//    int three = (int) "three";

        //cutting the middleman, and object, not hidden in the obj. int cant be assigned a String


//        int x = 4;
//        x += 5;
//
//        int x = 3;
//        int y = 4;
//            y *= x;
//
//        int x = 10;
//        int y = 2;
//        x /= y;
//        y -= x;
//

// Java throws a fit
        int max = Integer.MAX_VALUE;
        System.out.println(max);
        max++;
        System.out.println(max);
//makes it a negative, "rolled over" to the min value
    }
}