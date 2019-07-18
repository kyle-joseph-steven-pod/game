var diceRoll= function(sides){
    return Math.ceil(Math.random() * sides);
};
var twoDiceRoll = function(sides1,sides2){
    return (Math.ceil(Math.random() * sides1)+Math.ceil(Math.random() * sides2));
};
var characters = [
    {
        name: "Knight",
        poses: {
            idle_1: "pngs/Knight-Sprite/Kni-idle-Normalized.png",
            idle_2: "",
            left: "",
            right: "",
            attack: "",
            damaged: "",
            death: ""
        },
        base_stats:{
            hp: 16,
            strength: -1,
            agility: 0,
            sharp: 2,
            presence: 1,
            misses: 0,
            damageDie: function(){
                return Math.ceil(Math.random() * 4);
            }
        }
    },
    {
        name: "Mischievous",
        poses: {
            idle_1: "pngs/Mischievous-Sprite/Mis-idle-Normalized.png",
            idle_2: "",
            left: "",
            right: "",
            attack: "",
            damaged: "",
            death: ""
        },
        base_stats:{
            hp: 16,
            strength: -1,
            agility: 0,
            sharp: 2,
            presence: 1,
            misses: 0,
            damageDie: function(){
                return Math.ceil(Math.random() * 4);
            }
        }
    },
    {
        name: "Rouge",
        poses: {
            idle_1: "pngs/Rogue-Sprite/Rog-idle-Normalized.png",
            idle_2: "",
            left: "",
            right: "",
            attack: "",
            damaged: "",
            death: ""
        },
        base_stats:{
            hp: 16,
            strength: -1,
            agility: 0,
            sharp: 2,
            presence: 1,
            misses: 0,
            damageDie: function(){
                return Math.ceil(Math.random() * 4);
            }
        }
    },
    {
        name: "Wizard",
        poses: {
            idle_1: "pngs/Wizard-Sprite/Wiz-idle-Normalized.png",
            idle_2: "",
            left: "",
            right: "",
            attack: "",
            damaged: "",
            death: ""
        },
        base_stats:{
            hp: 16,
            strength: -1,
            agility: 0,
            sharp: 2,
            presence: 1,
            misses: 0,
            damageDie: function(){
                return Math.ceil(Math.random() * 4);
            }
        }
    }
];
var enemies = [{
    badGuy: {
        hp: 6,
        mp: 3,
        chase: -1,
        damageDie: function(){
            return Math.ceil(Math.random() * 6);
        }
    }
}];
