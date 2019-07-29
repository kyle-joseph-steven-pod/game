import java.util.Scanner;

public class gameTranslated {
    public static int dice(int side){
        double roll = Math.ceil(Math.random() * side);
        return (int)roll;
    }
    public static double twoDice(int side){
        double rollOne = Math.ceil(Math.random() * side);
        double rollTwo = Math.ceil(Math.random() * side);
        return (rollOne + rollTwo);
    }
    static String userName;

    //    Intro Section //////////////////////////////////////////////
    public static void intro() {
        Scanner scanner = new Scanner(System.in);
        userName = scanner.nextLine();
        System.out.println("Hey there," + userName + "! Want to go on an adventure? [y/n]");
        String introAnswer = scanner.nextLine();
        if (introAnswer.contentEquals("n")) {
            System.out.println("Okay! Have a great day!");
        } else if (introAnswer.contentEquals("y")) {
            System.out.println("Let's get going, then!");
            classPicker();

        } else {
            System.out.println("I didnt understand. Please submit your answer again.");
            intro();
        }
    }

    private static class character {
        private static String name = userName;
        private static int misses = 0;

        private static String yourClass;
        private static int hp;
        private static int strength;
        private static int agility;
        private static int sharp;
        private static int presence;
        private static int damageDie;


    }

    private static class baddie {
        private static int hp;
        private static int mp;
        private static int chase;
        private static int damageDie;
    }

    private static class rolls {
        private static double roll1;
    }


    //    Class Selection //////////////////////////////////////////////
    public static void classPicker() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Oh shit, It's an adventurer! Quick, everyone hide! They always bring trouble. It looks like it is an....");
        System.out.println("What kind of adventurer are you? A Washed Up Knight? An Incredibly Inept Wizard? Or a Noisy Thief?");

        String yourChoice = scanner.nextLine();

        switch (yourChoice.toLowerCase()) {
            case "washed up knight":
                System.out.println("Dope! You are a knight, sworn to defend the real from all manner of thing. Too bad married life caught up with you.");
                character.yourClass = "Washed-up Knight";
                character.hp = 24;
                character.strength = 2;
                character.agility = -1;
                character.sharp = 0;
                character.presence = 1;
                character.damageDie = 10;

                System.out.println("Your stats are: Strength = " + character.strength + ", Agility = " + character.agility + ", Sharp = " + character.sharp + ", and Presence = " + character.presence);
                break;

            case "incredibly inept wizard":
                System.out.println("Rad! You are a wizard of the high order! Too bad you have never actually casted a spell before...");

                character.yourClass = "Incredibly Inept Wizard";
                character.hp = 16;
                character.strength = -1;
                character.agility = 0;
                character.sharp = 2;
                character.presence = 1;
                character.damageDie = 4;

                System.out.println("Your stats are: Strength = " + character.strength + ", Agility = " + character.agility + ", Sharp = " + character.sharp + ", and Presence = " + character.presence);
                break;
//    {
//        bolt:
//        function twoD4DamRoller () {
//        var rolls1d4 = [1, 2, 3, 4];
//        var h = Math.floor(Math.random() * 4);
//        // console.log(rolls1d6[h]);
//        var j = Math.floor(Math.random() * 4);
//        // console.log(rolls1d6[j]);
//        return (Number(rolls1d4[h]) + Number(rolls1d4[j]));
//    },
//        blast:
//        function twoD6DamRoller () {
//        var rolls1d6 = [1, 2, 3, 4, 5, 6];
//        var h = Math.floor(Math.random() * 4);
//        // console.log(rolls1d6[h]);
//        var j = Math.floor(Math.random() * 4);
//        // console.log(rolls1d6[j]);
//        return (Number(rolls1d6[h]) + Number(rolls1d6[j]));
//    }
//    }
            case "noisy thief":
                System.out.println("Sweet! Your steps might not be as quiet as a cat on the prowl, but you sure can use your claws!.");
                character.yourClass = "Noisy Thief";
                character.hp = 20;
                character.strength = 1;
                character.agility = 2;
                character.sharp = 0;
                character.presence = -1;
                character.damageDie = 8;

                System.out.println("Your stats are: Strength = " + character.strength + ", Agility = " + character.agility + ", Sharp = " + character.sharp + ", and Presence = " + character.presence);
                break;

            default:
                System.out.println("Hey, that wasn't an answer listed. Lets make you a Mischievous instead.");
                character.yourClass = "Mischievous";
                character.hp = 18;
                character.strength = 0;
                character.agility = 1;
                character.sharp = -1;
                character.presence = 2;
                character.damageDie = 6;

                System.out.println("Your stats are: Strength = " + character.strength + ", Agility = " + character.agility + ", Sharp = " + character.sharp + ", and Presence = " + character.presence);
                break;
        }
        sceneOne();
    }

//    Scenario 1: Bandit trap /////////////////////////////////////////


    public static void sceneOne() {
        Scanner scanner = new Scanner(System.in);

//            Bandit stats declared/////////////////////////////////////////
        baddie.hp = 6;
        baddie.mp = 3;
        baddie.chase = -1;
        baddie.damageDie = 6;
//        End stats/////////////////////////////////////////

        System.out.println("After the town of friendly chased you out with torches and pitchforks, you continue on your way through the woods to get to the city of Whoknowsville.");
        System.out.println("*snap!* What was that? Hello? What do you do? Will you try to sneak past whatever is there? Type: AGI. Will you try to spot the danger before it strikes? Type: SHP. Or will you bellow out a challenge and rush into combat? Type: #bravebutfoolish.");

        String s1ChoiceOne = scanner.nextLine().toLowerCase();
        switch (s1ChoiceOne) {
            case "agi":
                System.out.println("As you try to be sneaky, we will roll to see what happens.");
                rolls.roll1 = twoDice(6) + character.agility;
                break;
            case "shp":
                System.out.println("As you try spot the danger before it has the jump on you, we will roll to see what happens.");
                rolls.roll1 = twoDice(6) + character.sharp;
                break;
            default:
                System.out.println("Shit, you made a lot of noise! Here they come....");
                break;
        }
        //scene 1 results
        if (s1ChoiceOne.contentEquals("agi")) {
            System.out.println("You rolled a " + rolls.roll1 + ". Lets see what they means for our adventurer...");
            agiSceneOne(rolls.roll1);
        } else if (s1ChoiceOne.contentEquals("shp")) {
            System.out.println("You rolled a " + rolls.roll1 + ". Lets see what they means for our adventurer...");
            shpSceneOne(rolls.roll1);
        } else {
            shitHitsFanSceneOne();
        }
///////////////////////////////////////////////////////Left off here
//Scene 1 agi approach
        public static void agiSceneOne() {
            if (rolls.roll1 <= 6) {
            System.out.println("You rolled a miss! Oh no!");
            character.misses += 1;
            shitHitsFanSceneOne();
        } else if (rolls.roll1 > 6 && rolls.roll1 < 10) {
            System.out.println(("You rolled a mixed success!");
            sceneOneBut();
        } else if (rolls.roll1 >= 10) {
            System.out.println(("You rolled a success with little consequence!");
            sceneOneSneaked();
        }
    }

//Scene 1 shp approach
        function shpSceneOne (a) {
        if (a <= 6) {
            alert("You rolled a miss! Oh no!");
            userClass.misses = userClass.misses + 1;
            shitHitsFanSceneOne()
        } else if (a > 6 && a < 10) {
            alert("You rolled a mixed success!");
            sceneOneBut()
        } else if (a >= 10) {
            alert("You rolled a success with little consequence!");
            sceneOneSpottedEm()
        }
        }

//Scene 1 results
        function sceneOneBut () {
            var dam = d6damage();
            alert("Fuuuuuuck. That hurt. Their trap was tripped, hitting you for " + dam + " damage and they are coming right for you!");
            userClass.hp = userClass.hp - dam;
            var maybefight = (prompt("will you stand tall and fight? Or run like a coward?")).toLowerCase();
            if (maybefight == = "fight") {
                fight();
            } else {
                sceneTwo()
            }
        }
        function shitHitsFanSceneOne () {
            var dam = d6damage();
            alert("Fuuuuuuck. That hurt. Their trap was tripped, hitting you for " + dam + " damage and they are coming right for you!");
            userClass.hp = userClass.hp - dam;
            alert("Oh no, here they come! You have no choice but to fight!");
            fight()
        }

    }

    function sceneTwo() {
        alert("As you walk into the sunset, the screen fades to black. Thanks for trying the demo!");

    }
}

//////Add:
////// level up from misses total, make it XP
////// add +1 scene per scene traversed