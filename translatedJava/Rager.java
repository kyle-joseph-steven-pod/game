public class Rager {

    static int partyBonus;
    static int allNighter;
    static int kickedOut = 0;

    public static void rager() {

        int result = (int) game_story.twoDice(6) + game_story.character.presence + partyBonus;

        if (result <= 6) {
            System.out.println("You rolled a miss! Oh no! " +
                    "\nThat village grog got the best of you as you did something so shameful and wild, the townies kicked you out of town!" +
                    "\nBetter move on to the next scene then...");
            game_story.character.misses += 1;
            kickedOut += 1;
        } else if (result >= 7 && result <= 9) {
            System.out.println(("You rolled a mixed success!"));
            System.out.println("You're drinking way too much and are going to feel it later. " +
                    "\nYou take a -1 to your next roll, but the party was a huge success! Lets see what happened...");
            game_story.character.negForward += 1;
            goodTimes();
        } else if (result >= 10) {
            System.out.println("You rolled a success with little consequence!");
            System.out.println("The party was a huge success! Lets see what happened...");
            goodTimes();
        }


        if (kickedOut >= 1) {
            kickedOut = 0;
            //Next scene
        } else if (allNighter >= 1) {
            System.out.println("You lost count of how many meads you had. Better start counting again!");
            game_shop.partiesHad = 0;
            allNighter = 0;
            game_shop.party();
        }

        game_shop.partiesHad = 1;
        game_shop.town();

    }

    public static void goodTimes() {
//Party Results
        int partyTime = game_story.dice(6);


        switch (partyTime) {
            case 1:
//                Lost an item instead?
                int dam = game_story.dice(6);
                game_story.character.hp -= dam;
                System.out.println("Oh shit. " +
                        "\nYou're sore as hell and must have started a fight last night." +
                        "\nYou're really feeling it today, you take " + dam + " damage.");
                break;
////////////
            case 2:
                System.out.println("Upon awaking in the morning, you realize your backpack is heavier than it used to be." +
                        "\n When you open the bag to investigate, you find...");
                int rando = game_story.dice(6);

                int killIt2 = 1;
                do {
                    if (rando == 1 && Items.molotov >= 1 ||
                            rando == 2 && Items.charm >= 1 ||
                            rando == 3 && Items.shield >= 1) {
                        rando += 1;
                    } else if (rando == 4 && Items.hat >= 1) {
                        rando = 1;
                    } else {
                        killIt2 = 0;
                    }
                } while (killIt2 == 1);

                switch (rando) {
                    case 1:
                        int gold = (int) game_story.twoDice(6) + game_story.character.presence;
                        Items.gold += gold;
                        System.out.println(gold + " gold!");
                        break;
                    case 2:
                        Items.gold += game_story.character.presence + 1;
                        Items.molotov += 1;
                        System.out.println(game_story.character.presence + 1 + " gold and a Molotov!");

                        break;
                    case 3:
                        Items.gold += game_story.character.presence + 1;
                        Items.charm += 1;
                        System.out.println(game_story.character.presence + 1 + " gold and a Lucky Charm!");

                        break;
                    case 4:
                        Items.gold += game_story.character.presence + 1;
                        Items.potion += 1;
                        System.out.println(game_story.character.presence + 1 + " gold and a \"healing\" potion!");

                        break;
                    case 5:
                        Items.gold += game_story.character.presence + 1;
                        Items.shield += 1;
                        System.out.println(game_story.character.presence + 1 + " gold and a Shield!");

                        break;
                    default:
                        Items.gold += game_story.character.presence + 1;
                        Items.hat += 1;
                        System.out.println(game_story.character.presence + 1 + " gold and a Cool Hat!");
                }
                break;
////////////
            case 3:
                System.out.println("You wake up in the town gym with sore muscles and vague memories of a workout montage." +
                        "\n you gain...");
                int gains = game_story.dice(6);
                int killIt = 1;

                do {
                    if (gains == 1 && game_story.character.strength >= 2 ||
                            gains == 2 && game_story.character.agility >= 2 ||
                            gains == 3 && game_story.character.sharp >= 2 ||
                            gains == 4 && game_story.character.presence >= 2) {
                        gains += 1;
                    } else {
                        killIt = 0;
                    }
                } while (killIt == 1);


                switch (gains) {
                    case 1:
                        game_story.character.strength += 1;
                        System.out.println(" +1 to Strength!");
                        break;
                    case 2:
                        game_story.character.agility += 1;
                        System.out.println(" +1 to Agility!");

                        break;
                    case 3:
                        game_story.character.sharp += 1;
                        System.out.println(" +1 to Sharp!");

                        break;
                    case 4:
                        game_story.character.presence += 1;
                        System.out.println(" +1 to Presence!");

                        break;
                    default:
                        game_story.character.energy += 1;
                        System.out.println(" +1 to Energy!");
                }
                break;
////////////
            case 4:
                System.out.println("You wake up refreshed and in a bed that's not yours! " +
                        "\nTake a +2 forward for feeling so damn good today!");
                game_story.character.bonusForward += 2;
                break;
////////////
            case 5:
                System.out.println("You wake up after a good nights sleep at the crack of noon. You're well rested and ready to take on the day!");
                int healed = game_story.character.maxHP / 2;
                game_story.character.hp += healed;
                if (game_story.character.hp > game_story.character.maxHP) {
                    game_story.character.hp = game_story.character.maxHP;
                }
                System.out.println("You heal " + healed + "HP!");
                break;
////////////
            default:
                System.out.println("Who are you? You feel very different today. 2 of your stats are randomly switched!");
                int switchOne;
                int switchTwo;
                int switcher = game_story.dice(3);
                switch (switcher) {
                    case 1:
                        switchOne = game_story.character.strength;
                        switchTwo = game_story.character.agility;

                        game_story.character.strength = switchTwo;
                        game_story.character.agility = switchOne;
                        System.out.println("Your STR and AGI switched!");
                        break;
                    case 2:
                        switchOne = game_story.character.strength;
                        switchTwo = game_story.character.presence;

                        game_story.character.strength = switchTwo;
                        game_story.character.presence = switchOne;
                        System.out.println("Your STR and PRE switched!");

                        break;
                    default:
                        switchOne = game_story.character.agility;
                        switchTwo = game_story.character.presence;

                        game_story.character.agility = switchTwo;
                        game_story.character.presence = switchOne;
                        System.out.println("Your AGI and PRE switched!");
                        break;
                }

////////////
        }
    }


}
