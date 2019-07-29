import java.util.Scanner;

public class gameTranslated {
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
        private volatile String name = userName;
        private volatile int misses = 0;

        private static String yourClass;
        private static int hp;
        private static int strength;
        private static int agility;
        private static int sharp;
        private static int presence;
        private static int damageDie;


    }


//    Class Selection //////////////////////////////////////////////
        public static String classPicker() {
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

                    hp = 20;
                    strength = 2;
                    agility = 2;
                    sharp = 0;
                    presence = -1;
                    misses = 0;
                    damageDie = d8damage();

                    System.out.println("Your stats are: Strength = " + strength + ", Agility = " + agility + ", Sharp = " + sharp + ", and Presence = " + presence);
                    break;

                default:
                    System.out.println("Sweet! Your steps might not be as quiet as a cat on the prowl, but you sure can use your claws!.");

                    hp = 18;
                    strength = 0;
                    agility = 1;
                    sharp = -1;
                    presence = 2;
                    misses = 0;
                    damageDie = d6damage();

                    System.out.println("Your stats are: Strength = " + strength + ", Agility = " + agility + ", Sharp = " + sharp + ", and Presence = " + presence);
                    break;
            }
            sceneOne();
        }

//    Scenario 1: Bandit trap /////////////////////////////////////////


        public static void sceneOne() {
            Scanner scanner = new Scanner(System.in);
            String BadGuyname = "Bandits";
            int BagGuyhp = 6;
            int BagGuymp = 3;
            int BagGuychase = -1;
            int BagGuydamageDie = 6;
            System.out.println("After the town of friendly chased you out with torches and pitchforks, you continue on your way through the woods to get to the city of Whoknowsville.");
            System.out.println("*snap!* What was that? Hello? What do you do? Will you try to sneak past whatever is there? Type: AGI. Will you try to spot the danger before it strikes? Type: SHP. Or will you bellow out a challenge and rush into combat? Type: #bravebutfoolish.");

            String s1ChoiceOne = scanner.nextLine();
        }
//            switch (s1ChoiceOne) {
//                case "agi":
//                    alert("As you try to be sneaky, we will roll to see what happens.");
//                    var roll1 = twoD6PlusRoller() + agility;
//                    window.roll1Global = roll1;
//                    break;
//                case "shp":
//                    alert("As you try spot the danger before it has the jump on you, we will roll to see what happens.");
//                    var roll1 = twoD6PlusRoller() + sharp;
//                    window.roll1Global = roll1;
//                    break;
//                default:
//                    alert("Shit, you made a lot of noise! Here they come....");
//                    break;
//            }
//
//
//        }
//
//        public static void main(String[] args) {
//            intro();
//        }
//    }
//}
//
//
//////scene 1 results
////        if (sceneOneChoiceOne === "agi") {
////            alert("You rolled a " + roll1Global + ". Lets see what they means for our adventurer...");
////            agiSceneOne(roll1Global)
////        } else if (sceneOneChoiceOne === "shp") {
////            alert("You rolled a " + roll1Global + ". Lets see what they means for our adventurer...");
////            shpSceneOne(roll1Global)
////        } else {
////            shitHitsFanSceneOne()
////        }
////
//////Scene 1 agi approach
////        function agiSceneOne(a) {
////        if (a <= 6) {
////            alert("You rolled a miss! Oh no!");
////            userClass.misses = userClass.misses +1;
////            shitHitsFanSceneOne()
////        } else if (a > 6 && a < 10) {
////            alert("You rolled a mixed success!");
////            sceneOneBut()
////        } else if (a >= 10) {
////            alert("You rolled a success with little consequence!");
////            sceneOneSneaked()
////        }
////    }
////
//////Scene 1 shp approach
////        function shpSceneOne(a) {
////        if (a <= 6) {
////            alert("You rolled a miss! Oh no!");
////            userClass.misses = userClass.misses +1;
////            shitHitsFanSceneOne()
////        } else if (a > 6 && a < 10) {
////            alert("You rolled a mixed success!");
////            sceneOneBut()
////        } else if (a >= 10) {
////            alert("You rolled a success with little consequence!");
////            sceneOneSpottedEm()
////        }
////        }
////
//////Scene 1 results
////        function sceneOneBut(){
////            var dam = d6damage();
////            alert("Fuuuuuuck. That hurt. Their trap was tripped, hitting you for " + dam + " damage and they are coming right for you!");
////            userClass.hp = userClass.hp - dam;
////            var maybefight = (prompt("will you stand tall and fight? Or run like a coward?")).toLowerCase();
////            if (maybefight === "fight") {
////                fight();
////            } else {
////                sceneTwo()
////            }
////        }
////        function shitHitsFanSceneOne(){
////            var dam = d6damage();
////            alert("Fuuuuuuck. That hurt. Their trap was tripped, hitting you for " + dam + " damage and they are coming right for you!");
////            userClass.hp = userClass.hp - dam;
////            alert("Oh no, here they come! You have no choice but to fight!");
////            fight()
////        }
////
////    }
////    function sceneTwo() {
////        alert("As you walk into the sunset, the screen fades to black. Thanks for trying the demo!");
////    }
//////Add:
////// level up from misses total, make it XP
////// add +1 scene per scene traversed