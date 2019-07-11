"use strict";


// (function() {
//     function twoD6Roller(){
//         var rolls2d6 = [2, 3, 3, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 9, 9, 9, 9, 10, 10, 10, 11, 11, 12];
//         var i = Math.floor(Math.random() * 35);
//         alert("You rolled: " + rolls2d6[i] + "!");
//
//     }
//     // console.log(twoD6Roller());
// })();
//
//
// (function() {
//     function twoD6PlusRoller(){
//         var rolls1d6 = [1,2,3,4,5,6];
//         var h = Math.floor(Math.random() * 6);
//         // console.log(rolls1d6[h]);
//         var j = Math.floor(Math.random() * 6);
//         // console.log(rolls1d6[j]);
//
//         alert("You rolled: " + (Number(rolls1d6[h]) + Number(rolls1d6[j])) + "!");
//     }
//     // console.log(twoD6PlusRoller());
// })();
//

(function() {

//Below is the game start, ask if play

    answer(confirm("Hey there! Want to go on an adventure?"));
function answer(a) {
    if (a === false) {
        alert("Okay! Have a great day!");
    } else if (a === true){
        alert("Let's get going, then!");
        classPicker()
    }
}
//Pick your class below:
function classPicker() {
    alert("Oh shit, It's an adventurer! Quick, everyone hide! They always bring trouble. It looks like it is an....");
    var yourClass = (prompt("What kind of adventurer are you? A Washed Up Knight? An Incredibly Inept Wizard? Or a Noisy Thief?").toLowerCase());
    switch (yourClass) {
        case "washed up knight":
            alert("Dope! You are a knight, sworn to defend the real from all manner of thing. Too bad married life caught up with you.");
            var userClass = {
                hp: 24,
                strength: 2,
                agility: -1,
                sharp: 0,
                presence: 1,
                misses: 0,
                damageDie: d10damage()
            };
            window.userClass = userClass;
            alert("Your stats are: Strength = " + userClass.strength + ", Agility = " + userClass.agility + ", Sharp = " + userClass.sharp + ", and Presence = " + userClass.presence);
            break;
        case "incredibly inept wizard":
            alert("Rad! You are a wizard of the high order! Too bad you have never actually casted a spell before...");
            var userClass = {
                hp: 16,
                strength: -1,
                agility: 0,
                sharp: 2,
                presence: 1,
                misses: 0,
                damageDie: d4damage(),
                scenes: 0,
                spells:{
                    bolt: function twoD4DamRoller(){
                        var rolls1d4 = [1,2,3,4];
                        var h = Math.floor(Math.random() * 4);
                        // console.log(rolls1d6[h]);
                        var j = Math.floor(Math.random() * 4);
                        // console.log(rolls1d6[j]);
                        return (Number(rolls1d4[h]) + Number(rolls1d4[j]));
                    },
                    blast: function twoD6DamRoller(){
                        var rolls1d6 = [1,2,3,4,5,6];
                        var h = Math.floor(Math.random() * 4);
                        // console.log(rolls1d6[h]);
                        var j = Math.floor(Math.random() * 4);
                        // console.log(rolls1d6[j]);
                        return (Number(rolls1d6[h]) + Number(rolls1d6[j]));}
                        }};
            window.userClass = userClass;
            alert("Your stats are: Strength = " + userClass.strength + ", Agility = " + userClass.agility + ", Sharp = " + userClass.sharp + ", and Presence = " + userClass.presence);
            break;
        case "noisy thief":
            alert("Sweet! Your steps might not be as quiet as a cat on the prowl, but you sure can use your claws!.");
            var userClass = {
                hp: 20,
                strength: 1,
                agility: 2,
                sharp: 0,
                presence: -1,
                misses: 0,
                damageDie: d8damage(),
                scenes: 0
            };
            window.userClass = userClass;
            alert("Your stats are: Strength = " + userClass.strength + ", Agility = " + userClass.agility + ", Sharp = " + userClass.sharp + ", and Presence = " + userClass.presence);
            break;
        default:
            alert("Hey, that wasn't an answer listed. Lets make you a Mischievous instead.");
            var userClass = {
                hp: 18,
                strength: 0,
                agility: 1,
                sharp: -1,
                presence: 2,
                misses: 0,
                damageDie: d6damage(),
                scenes: 0
            };
            window.userClass = userClass;
            alert("Your stats are: Strength = " + userClass.strength + ", Agility = " + userClass.agility + ", Sharp = " + userClass.sharp + ", and Presence = " + userClass.presence);
            break;
    }
    sceneOne();
}




//Scenario 1: Bandit trap
    function sceneOne() {
    //bandit
        var badguy = {
            hp: 6,
            mp: 3,
            chase: -1,
            damageDie: 6
        };
        alert("After the town of friendly chased you out with torches and pitchforks, you continue on your way through the woods to get to the city of Whoknowsville.");
        var sceneOneChoiceOne = (prompt("*snap!* What was that? Hello? What do you do? Will you try to sneak past whatever is there? Type: AGI. Will you try to spot the danger before it strikes? Type: SHP. Or will you bellow out a challenge and rush into combat? Type: #bravebutfoolish.").toLowerCase());
        window.sceneOneChoiceOne = sceneOneChoiceOne;
        switch (sceneOneChoiceOne) {
            case "agi":
                alert("As you try to be sneaky, we will roll to see what happens.");
                var roll1 = twoD6PlusRoller() + userClass.agility;
                window.roll1Global = roll1;
                break;
            case "shp":
                alert("As you try spot the danger before it has the jump on you, we will roll to see what happens.");
                var roll1 = twoD6PlusRoller() + userClass.sharp;
                window.roll1Global = roll1;
                break;
            default:
                alert("Shit, you made a lot of noise! Here they come....");
                break;
        }
//scene 1 results
        if (sceneOneChoiceOne === "agi") {
            alert("You rolled a " + roll1Global + ". Lets see what they means for our adventurer...");
            agiSceneOne(roll1Global)
        } else if (sceneOneChoiceOne === "shp") {
            alert("You rolled a " + roll1Global + ". Lets see what they means for our adventurer...");
            shpSceneOne(roll1Global)
        } else {
            shitHitsFanSceneOne()
        }

//Scene 1 agi approach
    function agiSceneOne(a) {
        if (a <= 6) {
            alert("You rolled a miss! Oh no!");
            userClass.misses = userClass.misses +1;
            shitHitsFanSceneOne()
        } else if (a > 6 && a < 10) {
            alert("You rolled a mixed success!");
            sceneOneBut()
        } else if (a >= 10) {
            alert("You rolled a success with little consequence!");
            sceneOneSneaked()
        }
    }

//Scene 1 shp approach
        function shpSceneOne(a) {
            if (a <= 6) {
                alert("You rolled a miss! Oh no!");
                userClass.misses = userClass.misses +1;
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
function sceneOneBut(){
           var dam = d6damage();
    alert("Fuuuuuuck. That hurt. Their trap was tripped, hitting you for " + dam + " damage and they are coming right for you!");
    userClass.hp = userClass.hp - dam;
    var maybefight = (prompt("will you stand tall and fight? Or run like a coward?")).toLowerCase();
    if (maybefight === "fight") {
        fight();
    } else {
        sceneTwo()
    }
}
function shitHitsFanSceneOne(){
            var dam = d6damage();
            alert("Fuuuuuuck. That hurt. Their trap was tripped, hitting you for " + dam + " damage and they are coming right for you!");
            userClass.hp = userClass.hp - dam;
            alert("Oh no, here they come! You have no choice but to fight!");
            fight()
        }

    }
})();
//Add:
// level up from misses total, make it XP
// add +1 scene per scene traversed