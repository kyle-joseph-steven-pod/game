"use strict";
//TODO: logic to append text into the console output and have it show up below

// $("#log-form").submit(function(e){
//     e.preventDefault();
//     let input = $("#log-form-input");
//     var pText = `<p class="output-p"><span class="output-arrow">-></span>${input.val()}</p>`;
//     $("#log-form").trigger("reset");
//     $("#log-output").append(pText).scrollTop(9999999999999999);
// });
//Adds text to output log, reuse as possible for dialogue

// TODO Fight and Random talk quotes to be used elsewhere
$("#button-fight").on("click",function(){
    var dmg = characters[0].base_stats.damageDie();
    var pText = `<p class='output-p'><span class='output-arrow'>-></span>Your attack hit, and did ${dmg} damage</p>`;
    $("#log-output").append(pText).scrollTop(9999999999999999);
});
$('#button-talk').on('click', function () {
    var randomPhrase = charSays[Math.floor(Math.random()*charSays.length)];
    var pText = "<p class='output-p'><span class='output-arrow'>-></span>" + randomPhrase + "</p>";
    $("#log-output").append(pText).scrollTop(9999999999999999);
});

//  the function name pretty much explains itself here...//
//  we can use this same code to make pretty much anything flash at a set interval - maybe something to keep in mind for the Character Damage Animation?

function flash() {
    let count = 0;
    let elem = $("#startScreen");
    let flasher = setInterval(function () {
        elem.toggleClass("flash")
    }, 650);

    //  First bit of interactivity for the user to pick their class and name and have the start screen
    //  transition to the written name
    $("#button-talk").on("click",function() {
        if(count === 0){
            count = 4;
        }
        count--;
        $('#con-sprite').css('background-image', 'url(' + characters[count].poses.right[0] + ')');
    });
    $("#button-run").on("click",function() {
        if(count === 3){
            count = -1;
        }
        count++;
        $('#con-sprite').css('background-image', 'url(' + characters[count].poses.right[0] + ')');
    });
    $("#button-fight").on("click",function(){
        elem.html("Choose Your Name");
        $("#log-form").submit(function(e){
            e.preventDefault();
            elem.html($("#log-form-input").val());
            clearInterval(flasher);
            elem.removeClass("flash");
        });
    });
}
flash();
