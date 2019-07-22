"use strict";
let count;
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

//  the function name pretty much explains itself here...//
//  we can use this same code to make pretty much anything flash at a set interval - maybe something to keep in mind for the Character Damage Animation?

$('#button-talk').on('click', function () {
    var randomPhrase = charSays[Math.floor(Math.random()*charSays.length)];
    var pText = "<p class='output-p'><span class='output-arrow'>-></span>" + randomPhrase + "</p>";
    $("#log-output").append(pText).scrollTop(9999999999999999);
});
$("#button-fight").on("click",function(){
    var dmg = characters[userChar].base_stats.damageDie();
    var pText = `<p class='output-p'><span class='output-arrow'>-></span>Your attack hit, and did ${dmg} damage</p>`;
    $("#log-output").append(pText).scrollTop(9999999999999999);
});

function flash() {
    count = 0;
    let elem = $("#startScreen");
    let flasher = setInterval(function () {
        elem.toggleClass("flash")
    }, 650);

    //  First bit of interactivity for the user to pick their class and name and have the start screen
    //  transition to the written name
    $("#button-left").on("click",function() {
        if(count === 0){
            count = 4;
        }
        count--;
        $('#con-sprite').css('background-image', 'url(' + characters[count].poses.right[0] + ')');
    });
    $("#button-right").on("click",function() {
        if(count === 3){
            count = -1;
        }
        count++;
        $('#con-sprite').css('background-image', 'url(' + characters[count].poses.right[0] + ')');
    });
    $("#button-select").on("click",function(){
        elem.html("Choose Your Name");
        $("#log-form").submit(function(e){
            $("#log-form").trigger("reset");

            let left =  $("#button-left");
            let select =  $("#button-select");
            let right =  $("#button-right");
            const userChar = count;
            e.preventDefault();
            elem.html($("#log-form-input").val());
            clearInterval(flasher);
            left.html("Talk");
            select.html("Fight");
            right.html("Run");
            $(document).on('change', function () {
               left.attr("id", "button-talk");
               select.attr("id", "button-fight");
               right.attr("id", "button-run");
            });
            elem.removeClass("flash");
            part1();


        });
    });
}
flash();
