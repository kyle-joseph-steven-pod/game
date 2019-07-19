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
            right: ["pngs/Knight-Sprite/Kni-standing-Normalized.png","pngs/Knight-Sprite/Kni-stepping-Normalized.png"],
            talk: ["pngs/Knight-Sprite/Kni-Talk1-Normalized.png","pngs/Knight-Sprite/Kni-Talk2-Normalized.png"],
            attack: ["pngs/Knight-Sprite/Kni-attack-Normalized.png","pngs/Knight-Sprite/Kni-attackend-Normalized.png"],
            damaged: "pngs/Knight-Sprite/Kni-injured-Normalized.png",
            death: ["pngs/Mis-skull-Normalized.png","pngs/Mis-skull-fell-Normalized.png"],
        },
        base_stats:{
            hp: 24,
            strength: 2,
            agility: -1,
            sharp: 0,
            presence: 1,
            misses: 0,
            damageDie: function(){
                return Math.ceil(Math.random() * 10);
            },
        }
    },
    {
        name: "Mischievous",
        poses: {
            idle_1: "pngs/Mischievous-Sprite/Mis-idle-Normalized.png",
            idle_2: "",
            left: "",
            right: ["pngs/Mischievous-Sprite/Mis-standing-Normalized.png","pngs/Mischievous-Sprite/Mis-stepping-Normalized.png"],
            talk: ["pngs/Mischievous-Sprite/Mis-Talk1-Normalized.png","pngs/Mischievous-Sprite/Mis-Talk2-Normalized.png"],
            attack: ["pngs/Mischievous-Sprite/Mis-attack-Normalized.png","pngs/Mischievous-Sprite/Mis-attack-end-Normalized.png"],
            damaged: "pngs/Mischievous-Sprite/Mis-injured-Normalized.png",
            death: ["pngs/Mis-skull-Normalized.png","pngs/Mis-skull-fell-Normalized.png"],
        },
        base_stats:{
            hp: 18,
            strength: 0,
            agility: 1,
            sharp: -1,
            presence: 2,
            misses: 0,
            damageDie: function(){
                return Math.ceil(Math.random() * 6);
            }
        }
    },
    {
        name: "Rogue",
        poses: {
            idle_1: "pngs/Rogue-Sprite/Rog-idle-Normalized.png",
            idle_2: "",
            left: "",
            right: ["pngs/Rogue-Sprite/Rog-standing-Normalized.png","pngs/Rogue-Sprite/Rog-stepping-normalized.png"],
            talk: ["pngs/Rouge-Sprite/Rog-talk1-Normalized.png","pngs/Rogue-Sprite/Rog-talk2-normalized.png"],
            attack: ["pngs/Rogue-Sprite/MRog-attack-Normalized.png","pngs/Rogue-Sprite/Rog-attackend-Normalized.png"],
            damaged: "pngs/Rogue-Sprite/Rog-injured-Normalized.png",
            death: ["pngs/Mis-skull-Normalized.png","pngs/Mis-skull-fell-Normalized.png"],
        },
        base_stats:{
            hp: 20,
            strength: 1,
            agility: 2,
            sharp: 0,
            presence: -1,
            misses: 0,
            damageDie: function(){
                return Math.ceil(Math.random() * 8);
            }
        }
    },
    {
        name: "Wizard",
        poses: {
            idle_1: "pngs/Wizard-Sprite/Wiz-idle-Normalized.png",
            idle_2: "",
            left: "",
            right: ["pngs/Wizard-Sprite/Wiz-standing-normalized.png","pngs/Wizard-Sprite/Wiz-stepping-normalized.png"],
            attack: ["pngs/Wizard-Sprite/Wiz-attack-normalized.png","pngs/Wizard-Sprite/Wiz-attackend-normalized.png"],
            damaged: "pngs/Wizard-Sprite/Wiz-idle-normalized.png",
            death: ["pngs/Mis-skull-Normalized.png","pngs/Mis-skull-fell-Normalized.png"],
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
