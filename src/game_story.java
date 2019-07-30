import java.util.Scanner;


public class game_story {
    private static int dice(int side) {
        double roll = Math.ceil(Math.random() * side);
        return (int) roll;
    }

    private static double twoDice(int side) {
        double rollOne = Math.ceil(Math.random() * side);
        double rollTwo = Math.ceil(Math.random() * side);
        return (rollOne + rollTwo);
    }

    private static String userName;

    ////////////////////////////////////////////////////////////////////////////////////////////////
//Combat
    ////////////////////////////////////////////////////////////////////////////////////////////////

    private static void spellDamage() {
        if (character.spell.equalsIgnoreCase("bolt")) {
            double dam = twoDice(4) + character.sharp;
            baddie.hp -= dam;
            System.out.println("Your magical attack hit the foe for "+dam+" damage!");
        } else {
            double dam = twoDice(6) + character.sharp;
            System.out.println("Your magical attack hit the foe for "+dam+" damage!");
            int damself = dice(4);
            System.out.println("You hit your target, but that blast was brutal. You take " + damself + " damage from the blast.");
            character.hp -= damself;
        }
    }

    private static void youDied() {
        System.out.println("Though your journey has come to an end, lets see how far you got! You rolled " + character.misses + " misses and got through " + character.scenes + " scenes. Better luck next time!");
    }

//////////////////////////////////////////////////////////
// TODO: 2019-07-30 - Below is hoe we will traverse scenes maybe:

//    public static void nextScene() {
//        if (userClass.scenes === 0){
//            userClass.scenes += 1;
//            System.out.println("You continue on through the woods and to the next encounter!");
//            sceneTwo();
//        } else if (userClass.scenes === 1){
//            System.out.println("You continue on through the woods and to the next encounter!");
//            sceneThree();
//        } else if (userClass.scenes === 2){
//            System.out.println("You continue on through the woods and to the next encounter!");
//            sceneFour();
//        }
//    }
////////////////////////////////////////////////////////

    private static void combatTurnAttack(double a) {
        if (a <= 6) {
            System.out.println("You rolled a miss! Oh no!");
            character.misses = character.misses + 1;
            int badDam = dice(baddie.damageDie);
            character.hp -= badDam;
            System.out.println("You take " + badDam + " damage from their blow!");
            fight();
        } else if (a > 6 && a < 10) {
            System.out.println("You rolled a mixed success!");
            int badDam = dice(baddie.damageDie);
            int dam = character.damageDie;
            character.hp -= badDam;
            baddie.hp -= dam;
            System.out.println("You dealt " + dam + " damage, but you opened yourself up to an attack! Take " + badDam + " damage from their blow!");
            fight();
        } else if (a >= 10) {
            System.out.println("You rolled a success with little consequence!");
            int dam = dice(character.damageDie);
            baddie.hp -= dam;
            System.out.println("You dealt " + dam + " damage!");
            fight();
        }
    }

    private static void combatTurnSpell(double a) {
        if (a <= 6) {
            System.out.println("You rolled a miss! Oh no!");
            character.misses += 1;
            int badDam = dice(baddie.damageDie);
            character.hp -= badDam;
            System.out.println("You take " + badDam + " damage from their blow!");
            fight();
        } else if (a > 6 && a < 10) {
            System.out.println("You rolled a mixed success!");
            int badDam = dice(baddie.damageDie);
            character.hp -= (badDam);
            System.out.println("You take " + badDam + " damage from their blow!");
            fight();
        } else if (a >= 10) {
            System.out.println("You rolled a success with little consequence!");
            fight();
        }
    }

    //Running
    private static void combatTurnRun(double a) {
        Scanner scanner = new Scanner(System.in);
        if ((a - baddie.chase) <= 6) {
            System.out.println("You rolled a miss! Oh no!");
            character.misses += 1;
            int badDam = dice(baddie.damageDie);
            character.hp -= (badDam);
            System.out.println("You take " + badDam + " damage from their blow! and couldn't escape!");
            fight();
        } else if ((a - baddie.chase) > 6 && (a - baddie.chase) < 10) {
            System.out.println("You rolled a mixed success!");
            int badDam = dice(baddie.damageDie);
            character.hp -= (badDam);
            System.out.println("You only can do one: Make it away, but take a hit in the escape,  or stay in the fight and avoid the damage. Run or stay?");
            String runChoice = scanner.nextLine().toLowerCase();
            if (runChoice.equalsIgnoreCase("run")) {
                badDam = dice(baddie.damageDie);
                character.hp -= (badDam * 2);
                System.out.println("You got away, but took " + badDam + " damage in the escape!");
            } else {
                badDam = dice(baddie.damageDie);
                character.hp -= (badDam - character.agility);
                System.out.println("You got away, but took " + badDam + " damage in the escape!");
                fight();
            }
        } else if ((a - baddie.chase) >= 10) {
            System.out.println("You rolled a success with little consequence!");
            System.out.println("You managed to escape the fight!");
            sceneOneOutro();
//            change to nextScene in future
        }
    }


    //fighting
    private static void fight() {
        Scanner scanner = new Scanner(System.in);
        //Dead
        if (character.hp <= 0) {
            System.out.println("Shit, you died!");
            youDied();
        } else if (baddie.hp <= 0 || baddie.mp <= 0) {
            System.out.println("You killed the baddie! Congrats!");
            sceneOneOutro();
        }
//battle
        System.out.println("You're in a fight for your life! What do you do? Run, Attack, or Talk?");
        String everyBodyWas = scanner.nextLine().toLowerCase();
//melee
        if (everyBodyWas.equalsIgnoreCase("attack")) {
            if (character.sharp == 2) {
                System.out.println("Would you like to attack or cast a spell? [y/n]");
                String spellChoice = scanner.nextLine().toLowerCase();
                if (spellChoice.equalsIgnoreCase("y")) {
                    System.out.println("What spell would you like to cast? Bolt or Blast?");
                    character.spell = scanner.nextLine().toLowerCase();
                    System.out.println("Let's see if your spell casted successfully");
                    combatTurnSpell(twoDice(6) + character.sharp);
                }
            } else {
                System.out.println("How do you fight? With dexterity and fast moves? = AGI Or do you fight with power and prowess? = STR ");
                String howAttack = scanner.nextLine().toLowerCase();
                if (howAttack.equalsIgnoreCase("agi")) {
                    combatTurnAttack(twoDice(6) + character.strength);
                } else if (howAttack.equalsIgnoreCase("str")) {
                    combatTurnAttack(twoDice(6) + character.agility);
                }
            }

        }
//run
        else if (everyBodyWas.equalsIgnoreCase("run")) {
            combatTurnRun(twoDice(6) + character.agility);
        }
//talk
        else if (everyBodyWas.equalsIgnoreCase("talk")) {
            System.out.println("How do you talk them down? With quick thinking? = SHP Or with your charm and persuasion? = PRE ");
            String howAttack = scanner.nextLine().toLowerCase();
            if (howAttack.equalsIgnoreCase("shp")) {
                combatTurnTalk(twoDice(6) + character.sharp);
            } else if (howAttack.equalsIgnoreCase("pre")) {
                combatTurnTalk(twoDice(6) + character.presence);
            }
        }
// mobs have Health points, Mental points, and Chase value
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
//Combat end
    ////////////////////////////////////////////////////////////////////////////////////////////////


    //    Intro Section //////////////////////////////////////////////
    private static void intro() {
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
        private static String spell;
        private static int scenes;
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

    private static class choices {
        private static String choice1;
        private static String choice2;
    }


    //    Class Selection //////////////////////////////////////////////
    private static void classPicker() {
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


    private static void sceneOne() {
        Scanner scanner = new Scanner(System.in);

//            Bandit stats declared/////////////////////////////////////////
        baddie.hp = 6;
        baddie.mp = 3;
        baddie.chase = -1;
        baddie.damageDie = 6;
//        End stats/////////////////////////////////////////

        System.out.println("After the town of friendly chased you out with torches and pitchforks, you continue on your way through the woods to get to the city of Whoknowsville.");
        System.out.println("*snap!* What was that? Hello? What do you do? Will you try to sneak past whatever is there? Type: AGI. Will you try to spot the danger before it strikes? Type: SHP. Or will you bellow out a challenge and rush into combat? Type: #bravebutfoolish.");

        choices.choice1 = scanner.nextLine().toLowerCase();
        switch (choices.choice1) {
            case "agi":
                System.out.println("As you try to be sneaky, we will roll to see what happens.");
                rolls.roll1 = twoDice(6) + character.agility;
                System.out.println("You rolled a " + rolls.roll1 + ". Lets see what they means for our adventurer...");
                agiSceneOne();
                break;
            case "shp":
                System.out.println("As you try spot the danger before it has the jump on you, we will roll to see what happens.");
                rolls.roll1 = twoDice(6) + character.sharp;
                System.out.println("You rolled a " + rolls.roll1 + ". Lets see what they means for our adventurer...");
                shpSceneOne();
                break;
            default:
                System.out.println("Shit, you made a lot of noise! Here they come....");
                shitHitsFanSceneOne();
                break;
        }
    }

    ///////////////////////////////////////////////////////Left off here
//Scene 1 agi approach
    private static void agiSceneOne() {
        if (rolls.roll1 <= 6) {
            System.out.println("You rolled a miss! Oh no!");
            character.misses += 1;
            shitHitsFanSceneOne();
        } else if (rolls.roll1 > 6 && rolls.roll1 < 10) {
            System.out.println(("You rolled a mixed success!"));
            sceneOneBut();
        } else if (rolls.roll1 >= 10) {
            System.out.println("You rolled a success with little consequence!");
            System.out.println("You managed to sneak around their ambush. You can sneak away or get the jump on them. [fight/run]");
            Scanner scanner = new Scanner(System.in);
            choices.choice2 = scanner.nextLine();
            if (choices.choice2.equalsIgnoreCase("fight")) {
                Ambush();
            } else {
                sceneOneOutro();
            }
        }
    }

    //Scene 1 shp approach
    private static void shpSceneOne() {
        if (rolls.roll1 <= 6) {
            System.out.println("You rolled a miss! Oh no!");
            character.misses += 1;
            shitHitsFanSceneOne();
        } else if (rolls.roll1 > 6 && rolls.roll1 < 10) {
            System.out.println("You rolled a mixed success!");
            sceneOneBut();
        } else if (rolls.roll1 >= 10) {
            System.out.println("You rolled a success with little consequence!");
            System.out.println("You managed to spot them before they spotted you. You can sneak away or get the jump on them. [fight/run]");
            Scanner scanner = new Scanner(System.in);
            choices.choice2 = scanner.nextLine();
            if (choices.choice2.equalsIgnoreCase("fight")) {
                Ambush();
            } else {
                sceneOneOutro();
            }
        }
    }

    //Scene 1 results
    private static void sceneOneBut() {
        int dam = dice(baddie.damageDie);
        System.out.println("Fuuuuuuck. That hurt. Their trap was tripped, hitting you for " + dam + " damage and they are coming right for you!");
        character.hp -= dam;
        System.out.println("will you stand tall and fight? Or run like a coward?");
        Scanner scanner = new Scanner(System.in);
        choices.choice2 = scanner.nextLine().toLowerCase();
        if (choices.choice2.equalsIgnoreCase("fight")) {
            fight();
        } else {
            sceneOneOutro();
        }
    }

    private static void shitHitsFanSceneOne() {
        int dam = dice(baddie.damageDie);
        System.out.println("Fuuuuuuck. That hurt. Their trap was tripped, hitting you for " + dam + " damage and they are coming right for you!");
        character.hp -= dam;
        System.out.println("Oh no, here they come! You have no choice but to fight!");
        fight();
    }


    private static void sceneOneOutro() {
        System.out.println("As you walk into the sunset, the screen fades to black. Thanks for trying the demo!");
    }
}


//////Add:
////// level up from misses total, make it XP
////// add +1 scene per scene traversed
