import java.util.Scanner;


public class game_story {
    public static void main(String[] args) {
        intro();
    }
    private static int dice(int side) {
        double roll = Math.ceil(Math.random() * side);
        return (int) roll;
    }

    private static double twoDice(int side) {
        double rollOne = Math.ceil(Math.random() * side);
        double rollTwo = Math.ceil(Math.random() * side);
        return (rollOne + rollTwo);
    }


    //    Intro Section //////////////////////////////////////////////
    private static void intro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(

                "Hello! What is your name?");

        character.name = scanner.nextLine();
        System.out.println(

                "Hey there, " + character.name + "!\n" +
                "Want to go on an adventure? [y/n]");

        String introAnswer = scanner.nextLine();
        if (introAnswer.contentEquals("n")) {
            System.out.println(

                    "Okay! Have a great day!");

        } else if (introAnswer.contentEquals("y")) {
            System.out.println(

                    "Let's get going, then!\n\n");

            classPicker();

        } else {
            System.out.println(

                    "I didnt understand. Please submit your answer again.");

            intro();
        }
    }

    private static class character {
        private static String name;
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
//        for later use
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
        System.out.println(

                "Oh shit, It's an adventurer! \n" +
                "Quick, everyone hide! They always bring trouble. \n" +
                "..." +
                "It looks like it's a...\n\n");

        System.out.println(

                "What kind of adventurer are you? \n\n" +
                "A Washed-Up Knight? [type: Knight] \n" +
                "An Incredibly Inept Wizard? [type: Wizard] \n" +
                "Or a Noisy Thief? [type: Thief]");

        String yourChoice = scanner.nextLine();

        switch (yourChoice.toLowerCase()) {
            case "knight":
                character.yourClass = "Washed-Up Knight";
                System.out.println(

                        "Excelsior!\n" +
                        "You are a " + character.yourClass + ",\n" +
                        "sworn to defend the realms of men from all manner of evil and icky things! \n" +
                        "...Too bad married life caught up with you.\n\n");

                character.hp = 24;
                character.strength = 2;
                character.agility = -1;
                character.sharp = 0;
                character.presence = 1;
                character.damageDie = 10;

                System.out.println(

                        "Your stats are:\n" +
                        "Strength = " + character.strength + "\n" +
                        "Agility = " + character.agility + "\n" +
                        "Sharp = " + character.sharp + "\n" +
                        "Presence = " + character.presence + "\n\n");
                break;

            case "wizard":
                character.yourClass = "Incredibly Inept Wizard";
                System.out.println(

                        "Woah! Careful where you point that wand of yours!\n" +
                        "You are an " + character.yourClass + " of the highest order." + "\n" +
                        "Too bad you have never actually cast a spell before. \n" +
                        "And don't even shpget me started on that pointy hat of yours...\n\n");

                character.hp = 16;
                character.strength = -1;
                character.agility = 0;
                character.sharp = 2;
                character.presence = 1;
                character.damageDie = 4;

                System.out.println(

                        "Your stats are: " + "\n" +
                        "Strength = " + character.strength + " \n" +
                        "Agility = " + character.agility + " \n" +
                        "Sharp = " + character.sharp + " \n" +
                        "Presence = " + character.presence + "\n\n");
                break;

            case "thief":
                character.yourClass = "Noisy Thief";
                System.out.println(

                        "Oh my! You almost very nearly came somewhat close to actually startling me there!\n" +
                        "Your steps as a " + character.yourClass + " might not be as quiet as a panther on the prowl,\n" +
                        "but this little kitty cat has claws.\n" +
                        "Rawr.\n\n");

                character.hp = 20;
                character.strength = 1;
                character.agility = 2;
                character.sharp = 0;
                character.presence = -1;
                character.damageDie = 8;

                System.out.println("Your stats are:\n" +
                        "Strength = " + character.strength + "\n" +
                        "Agility = " + character.agility + "\n" +
                        "Sharp = " + character.sharp + "\n" +
                        "Presence = " + character.presence + "\n\n");
                break;

            default:
                character.yourClass = "Mischievous";
                System.out.println(
                        "Hey, that wasn't an answer listed!\n" +
                        "It seems we have a little troublemaker on our hands." +
                        "Why don't we make you a " + character.yourClass + " instead?\n");

                character.hp = 18;
                character.strength = 0;
                character.agility = 1;
                character.sharp = -1;
                character.presence = 2;
                character.damageDie = 6;

                System.out.println(

                        "Your stats are:\n" +
                        "Strength = " + character.strength + "\n" +
                        "Agility = " + character.agility + "\n" +
                        "Sharp = " + character.sharp + "\n" +
                        "Presence = " + character.presence + "\n\n");
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
        baddie.damageDie = 8;
//        End stats/////////////////////////////////////////

        System.out.println("\n\n\n" +

                "Scene One: Our Journey Begins...\n\n" +

                "What started as a quiet night enjoying\n" +
                "a couple pints of grog at the local pub\n" +
                "ends with the townsfolk of Friendly\n" +
                "chasing you out the city gates with torches,\n" +
                "pitchforks, and other makeshift\n" +
                "weaponry early the next morning.\n\n\n" +

                "After a bath in the local river and a hearty\n" +
                "breakfast of varmint and woodland critters,\n" +
                "you continue along your lonesome journey.\n\n" +
                "Through the forests and dales,\n" +
                "over the valleys and hills you trod,\n" +
                "eager to to overcome whatever might stand \n" +
                "between you and the great City of Whoknowsville...\n");


        System.out.println(

                "\n" +

                "*snap!*\n\n" +

                "What was that?\n" +
                "Hello?\n\n" +

                "What will you do now?\n" +
                        "Will you try to sneak past whatever is there? [type: AGI]\n" +
                        "Will you try to spot the danger before it even strikes? [type: SHP]\n" +
                        "Or will you bellow out a challenge and rush into combat? [type: #bravebutfoolish]\n\n");

        choices.choice1 = scanner.nextLine().toLowerCase();
        switch (choices.choice1) {
            case "agi":
                System.out.println(

                        "As you try to be sneaky,\n" +
                        "we will roll to see what happens.");

                rolls.roll1 = twoDice(6) + character.agility;
                System.out.println("" +

                        "You rolled a " + rolls.roll1 + ".\n" +
                        "Let's see what they means for our adventurer...\n\n");

                agiSceneOne();
                break;
            case "shp":
                System.out.println(

                        "As you try spot the danger before it has the jump\n" +
                        "on you, we will roll to see what happens.\n");

                rolls.roll1 = twoDice(6) + character.sharp;
                System.out.println(

                        "You rolled a " + rolls.roll1 + ".\n" +
                        "Lets see what they means for our adventurer...\n\n");

                shpSceneOne();
                break;
            default:
                System.out.println(

                        "Shit you made a lot of noise!\n" +
                        "Here they come....\n\n");

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
            System.out.println(

                    "You managed to sneak around their ambush!\n" +
                    "You can sneak away? [type: Run]\n" +
                    "Or, you can try and get the jump on them? [type: Fight]\n\n");

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
            System.out.println(

                    "You managed to spot them before they spotted you.\n" +
                    "Will you try and sneak away? [type: Run]\n" +
                    "Or get the jump on them? [type: Fight]\n\n");

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
        System.out.println(
                "Fuuuuuuck....\n" +
                "That hurt. \n" +
                "Like, super bad.\n\n" +

                "Their trap was tripped, hitting you for " + dam + " damage\n" +
                "and they are coming right for you!\n\n");

        character.hp -= dam;
        System.out.println(

                "Will you stand tall and fight? \n" +
                "Or run like a coward?\n\n");

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
        System.out.println(

                "Fuuuuuuck....\n" +
                "That hurt. \n" +
                "Like, super bad.\n\n" +

                "Their trap was tripped, hitting you for " + dam + " damage\n" +
                "and they are coming right for you!\n\n");

        character.hp -= dam;
        System.out.println(
                "Oh no, here they come! \n" +
                "You have no choice but to fight!\n\n");
        fight();
    }


    private static void sceneOneOutro() {
        System.out.println(

                "As you walk into the sunset, \n" +
                "the screen fades to black... \n\n" +

                "Thanks for trying our demo!");

        System.exit(0);
    }


//////Add:
////// level up from misses total, make it XP
////// add +1 scene per scene traversed


    ////////////////////////////////////////////////////////////////////////////////////////////////
//Combat
    ////////////////////////////////////////////////////////////////////////////////////////////////

    private static void youDied() {
        System.out.println(

                "Though your journey has come to an end,\n" +
                "let's see how far you got! \n" +
                "You rolled " + character.misses + " misses and \n" +
                "got through " + character.scenes + " scenes. \n" +
                "Better luck next time!");

        System.exit(0);
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
            System.out.println(

                    "You dealt " + dam + " damage, \n" +
                    "but you opened yourself up to an attack! \n" +
                    "You take " + badDam + " damage from their blow!");

            fight();
        } else if (a >= 10) {
            System.out.println("You rolled a success with little consequence!");
            int dam = dice(character.damageDie);
            baddie.hp -= dam;
            System.out.println("You dealt " + dam + " damage!");
            fight();
        }
    }


    private static void spellDamage() {
        if (character.spell.equalsIgnoreCase("bolt")) {
            double dam = twoDice(4) + character.sharp;
            baddie.hp -= dam;
            System.out.println("Your magical attack hit the foe for " + dam + " damage!");
        } else {
            double dam = twoDice(6) + character.sharp;
            System.out.println("Your magical attack hit the foe for " + dam + " damage!");
            int damself = dice(4);
            System.out.println(

                    "You hit your target, \n" +
                    "but that blast was brutal. \n" +
                    "You take " + damself + " damage from the blast.");

            character.hp -= damself;
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
            spellDamage();
            fight();
        } else if (a >= 10) {
            System.out.println("You rolled a success with little consequence!");
            spellDamage();
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
            System.out.println(

                    "You only can do one: \n" +
                    "Make it away, but take a hit in the escape, [type: Run]  \n" +
                    "or stay in the fight, and avoid the damage? [type: Stay");

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

    private static void combatTurnTalk(double a) {
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
            int dam = dice(character.damageDie) + character.sharp;
            character.hp -= badDam;
            baddie.mp -= dam;
            System.out.println(

                    "Your words are getting to them!\n" +
                    "You dealt " + dam + " damage to their moral but \n" +
                    "you opened yourself up to an attack! \n" +
                    "You take " + badDam + " damage from their blow!");

            fight();
        } else if (a >= 10) {
            System.out.println("You rolled a success with little consequence!");
            int dam = dice(character.damageDie) + character.sharp;
            baddie.mp -= dam;
            System.out.println(

                    "Your words are getting to them! \n" +
                    "You dealt " + dam + " damage to their moral!");
            fight();
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
            System.out.println("You defeated the baddie! Congrats!");
            sceneOneOutro();
        }
//battle
        System.out.println(

                "You're in a fight for your life! What do you do? \n" +
                "[type: Run | Attack | Talk]");

        String everyBodyWas = scanner.nextLine().toLowerCase();
//melee
        if (everyBodyWas.equalsIgnoreCase("attack")) {
            if (character.sharp == 2) {
                System.out.println("Would you like to attack or cast a spell? [type: Y/N]");
                String spellChoice = scanner.nextLine().toLowerCase();
                if (spellChoice.equalsIgnoreCase("y")) {
                    System.out.println("What spell would you like to cast? Bolt or Blast?");
                    character.spell = scanner.nextLine().toLowerCase();
                    System.out.println("Let's see if your spell casted successfully");
                    combatTurnSpell(twoDice(6) + character.sharp);
                }
            } else {
                System.out.println("How do you fight? \n" +
                        "With dexterity and fast moves? [type: AGI} \n" +
                        "Or do you fight with power and prowess? [type: STR]");
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
            System.out.println(

                    "How do you talk them down? \n" +
                    "With quick thinking? [type: SHP] \n" +
                    "Or with your charm and persuasion? [type: PRE]");

            String howAttack = scanner.nextLine().toLowerCase();
            if (howAttack.equalsIgnoreCase("shp")) {
                combatTurnTalk(twoDice(6) + character.sharp);
            } else if (howAttack.equalsIgnoreCase("pre")) {
                combatTurnTalk(twoDice(6) + character.presence);
            } else {
                System.out.println("I didn't understand what you meant, please try again.");
                fight();
            }
        }
// mobs have Health points, Mental points, and Chase value
    }


    //////////////Ambushing gives you a +2 to your first roll
    private static void Ambush() {
        Scanner scanner = new Scanner(System.in);
//battle
        System.out.println(

                "You're in a fight for your life! What do you do? \n" +
                "[type: Run | Attack | Talk]");

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
                    combatTurnSpell(twoDice(6) + character.sharp + 2);
                }
            } else {
                System.out.println(

                        "How do you fight? \n" +
                        "With dexterity and fast moves? [type: AGI] \n" +
                        "Or with power and prowess? [type: STR]");

                String howAttack = scanner.nextLine().toLowerCase();
                if (howAttack.equalsIgnoreCase("agi")) {
                    combatTurnAttack(twoDice(6) + character.strength + 2);
                } else if (howAttack.equalsIgnoreCase("str")) {
                    combatTurnAttack(twoDice(6) + character.agility + 2);
                }
            }

        }
//run
        else if (everyBodyWas.equalsIgnoreCase("run")) {
            combatTurnRun(twoDice(6) + character.agility + 2);
        }
//talk
        else if (everyBodyWas.equalsIgnoreCase("talk")) {
            System.out.println(

                    "How do you talk them down? \n" +
                    "With quick thinking? [type: SHP]\n" +
                    "Or with your charm and persuasion? [type: PRE]");

            String howAttack = scanner.nextLine().toLowerCase();
            if (howAttack.equalsIgnoreCase("shp")) {
                combatTurnTalk(twoDice(6) + character.sharp + 2);
            } else if (howAttack.equalsIgnoreCase("pre")) {
                combatTurnTalk(twoDice(6) + character.presence + 2);
            }
        }
// mobs have Health points, Mental points, and Chase value
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////
//Combat end
////////////////////////////////////////////////////////////////////////////////////////////////


