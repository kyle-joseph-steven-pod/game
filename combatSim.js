"use strict";

//Roller
function twoD6PlusRoller(){
    var rolls1d6 = [1,2,3,4,5,6];
    var h = Math.floor(Math.random() * 6);
    // console.log(rolls1d6[h]);
    var j = Math.floor(Math.random() * 6);
    // console.log(rolls1d6[j]);
    return (Number(rolls1d6[h]) + Number(rolls1d6[j]))
}
function d4damage(){
    var rolls1d4 = [1,2,3,4];
    var h = Math.floor(Math.random() * 4);
    return Number(rolls1d4[h])
}
function d6damage() {
    var rolls1dSix = [1, 2, 3, 4, 5, 6];
    var h = Math.floor(Math.random() * 6);
    return Number(rolls1dSix[h])
}
function d8damage(){
    var rolls1d8 = [1,2,3,4, 5,6,7,8];
    var h = Math.floor(Math.random() * 8);
    return Number(rolls1d8[h])
}
function d10damage(){
    var rolls1d10 = [1,2,3,4,5,6,7,8,9,10];
    var h = Math.floor(Math.random() * 10);
    return Number(rolls1d10[h])
}
function baddieDam(a){
    if (a===6) {
        var rolls1d6 = [1, 2, 3, 4, 5, 6];
        var h = Math.floor(Math.random() * 6);
        return Number(rolls1d6[h])
    } else if (a===8) {
        var rolls1d8 = [1, 2, 3, 4, 5, 6, 7, 8];
        var h = Math.floor(Math.random() * 8);
        return Number(rolls1d8[h])
    } else if (a===10) {
        var rolls1d10 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
        var h = Math.floor(Math.random() * 10);
        return Number(rolls1d10[h])
    }
}
function spellDamage() {
    if (spellChoice === "bolt") {
        var dam = userClass.spells.bolt();
        return dam
    } else {
        var dam = userClass.spells.blast();
        var damself = d4damage();
        alert("You hit your target, but that blast was brutal. You take " + damself + " damage from the blast.");
        userClass.hp = userClass.hp - (damself);
        return dam
    }
}

function youDied() {
    alert("Though your journey has come to an end, lets see how far you got! You rolled " + userClass.misses + " misses and got through " + userClass.scenes + " scenes. Better luck next time!")
}

function nextScene() {
    if (userClass.scenes === 0){
        userClass.scenes += 1;
        alert("You continue on through the woods and to the next encounter!");
        var badGuy = {
            hp: 6,
            mp: 3,
            chase: -1,
            damageDie: 6
        };
        window.badGuy = badGuy;
        sceneTwo();
    } else if (userClass.scenes === 1){
        alert("You continue on through the woods and to the next encounter!");
        sceneThree();
    } else if (userClass.scenes === 2){
        alert("You continue on through the woods and to the next encounter!");
        sceneFour();
    }
}

function combatTurnAttack(a) {
    if (a <= 6) {
        alert("You rolled a miss! Oh no!");
        userClass.misses = userClass.misses +1;
        var badDam = baddieDam(badGuy.damageDie);
        userClass.hp -= (badDam);
        alert("You take " + badDam + " damage from their blow!");
        fight()
    } else if (a > 6 && a < 10) {
        alert("You rolled a mixed success!");
        var badDam = baddieDam(badGuy.damageDie);
        var dam = userClass.damageDie;
        userClass.hp -= (badDam);
        badGuy.hp -= (dam);
        alert("You dealt " + dam + " damage, but you opened yourself up to an attack! Take " + badDam + " damage from their blow!");
        fight()
    } else if (a >= 10) {
        alert("You rolled a success with little consequence!");
        var dam = userClass.damageDie;
        badGuy.hp -= (dam);
        alert("You dealt " + dam + " damage!");
        fight()
    }
}
function combatTurnSpell(a) {
    if (a <= 6) {
        alert("You rolled a miss! Oh no!");
        userClass.misses += 1;
        var badDam = baddieDam(badGuy.damageDie);
        userClass.hp -= (badDam);
        alert("You take " + badDam + " damage from their blow!");
        fight()
    } else if (a > 6 && a < 10) {
        alert("You rolled a mixed success!");
        var badDam = baddieDam(badGuy.damageDie);
        var dam = spellDamage();
        userClass.hp -= (badDam);
        badGuy.hp -= (dam);
        alert("You dealt " + dam + " damage, but you opened yourself up to an attack! Take " + badDam + " damage from their blow!");
        fight()
    } else if (a >= 10) {
        alert("You rolled a success with little consequence!");
        var dam = spellDamage();
        badGuy.hp -= (dam);
        alert("You dealt " + dam + " damage!");
        fight()
    }
}
//Running
function combatTurnRun(a) {
    if ((a - badGuy.chase) <= 6) {
        alert("You rolled a miss! Oh no!");
        userClass.misses += 1;
        var badDam = baddieDam(badGuy.damageDie);
        userClass.hp -= (badDam);
        alert("You take " + badDam + " damage from their blow! and couldn't escape!");
        fight()
    } else if ((a - badGuy.chase)  > 6 && (a-badGuy.chase)  < 10) {
        alert("You rolled a mixed success!");
        var badDam = baddieDam(badGuy.damageDie);
        var dam = userClass.damageDie;
        userClass.hp -= (badDam);
        var runChoice = (prompt("You only can do one: Make it away, but take a hit in the escape,  or stay in the fight and avoid the damage. Run or stay?")).toLowerCase();
        if (runChoice === "run") {
            var badDam = baddieDam(badGuy.damageDie);
            userClass.hp -= (badDam * 2);
            alert("You got away, but took " + badDam + " damage in the escape!")
        } else {
            var badDam = baddieDam(badGuy.damageDie);
            userClass.hp -= (badDam - userClass.agility);
            alert("You got away, but took " + badDam + " damage in the escape!");
            fight()
        }
    } else if ((a - badGuy.chase) >= 10) {
        alert("You rolled a success with little consequence!");
        alert("You managed to escape the fight!");
        nextScene()
    }
}




//fighting
function fight(){
    //Dead
    if (userClass.hp <= 0) {
        alert("Shit, you died!");
        youDied();
        return
    } else if (badGuy.hp <= 0 || badGuy.mp <= 0) {
        alert("You killed the baddie! Congrats!");
        nextScene();
    }
//battle
    var everyBodyWas = (prompt("You're in a fight for your life! What do you do? Run, Attack, or Talk?")).toLowerCase();
//melee
    if (everyBodyWas === "attack") {
        if (userClass.sharp === 2) {
                var spellAttack =confirm("Would you like to attack or cast a spell?");
                if (spellAttack === true) {
                    var spellChoice = (prompt("What spell would you like to cast? Bolt or Blast?")).toLowerCase();
                    window.spellChoice = spellChoice;
                    alert("Let's see if your spell casted successfully");
                    combatTurnSpell(twoD6PlusRoller() + userClass.sharp);
                } } else {
           var howAttack = (prompt("How do you fight? With dexterity and fast moves? = AGI Or do you fight with power and prowess? = STR ")).toLowerCase();
}
          if(howAttack === "agi") {
            combatTurnAttack(twoD6PlusRoller() + userClass.strength);
        } else if (howAttack === "str") {
            combatTurnAttack(twoD6PlusRoller() + userClass.agility);
        }
    }
//run
    else if(everyBodyWas === "run") {
    combatTurnRun(twoD6PlusRoller() + userClass.agility);
    }
//talk
    else if (everyBodyWas === "talk") {
        var howAttack = (prompt("How do you talk them down? With quick thinking? = SHP Or with your charm and persuasion? = PRE ")).toLowerCase();
        if(howAttack === "shp") {
            combatTurnTalk(twoD6PlusRoller() + userClass.sharp);
        } else if (howAttack === "pre") {
            combatTurnTalk(twoD6PlusRoller() + userClass.presence);
        }
    }
// mobs have Health points, Mental points, and Chase value
}



//
    //     }
    // } else {
    //     var meleeCombat = (prompt("Would you like to attack or maneuver?")).toLowerCase();
    //     if (meleeCombat==="attack") {
    //         var dam = userClass.damageDie;
    //         alert("You dealt " + dam + " damage!");
    //         return dam;
    //     }
    //
    // }


// var userClass = {
//     hp: 16,
//     strength: -1,
//     agility: 0,
//     sharp: 2,
//     presence: 1,
//     misses: 0,
//     damageDie: d4damage(),
//     scenes: 0,
//     spells:{
//         bolt: function twoD4DamRoller(){
//             var rolls1d4 = [1,2,3,4];
//             var h = Math.floor(Math.random() * 4);
//             // console.log(rolls1d6[h]);
//             var j = Math.floor(Math.random() * 4);
//             // console.log(rolls1d6[j]);
//             return (Number(rolls1d4[h]) + Number(rolls1d4[j]));
//         },
//         blast: function twoD6DamRoller(){
//             var rolls1d6 = [1,2,3,4,5,6];
//             var h = Math.floor(Math.random() * 6);
//             // console.log(rolls1d6[h]);
//             var j = Math.floor(Math.random() * 6);
//             // console.log(rolls1d6[j]);
//             return (Number(rolls1d6[h]) + Number(rolls1d6[j]));}
//     }};
//
// //bandit
// var badGuy = {
//     hp: 6,
//     mp: 3,
//     chase: -1,
//     damageDie: 6
// };
//
