$("#log-form").submit(function(e){
    e.preventDefault();

    //Adds text to output log, reuse as possible for dialogue
    var pText = `<p class='output-p'><span class='output-arrow'>-></span>${$('#log-form-input').val()}</p>`;

    // Trying to make it where when text is entered in the input log and 'enter' is pressed, the input automatically clears itself //

    // 'keydown input[type="text"]': function(event, template) {
    //     if ((27 === event.which) || (13 === event.which)) {
    //         event.preventDefault();
    //         //this should delete value from the input
    //         event.currentTarget.value = "";
    //     }
    // }

    newestP = $("#log-output").children().last().scrollTop();

    //value is set to 99999999999 because i couldnt get the value of the bottom of scroll window so its a jank fix but it works
    $("#log-output").append(pText).scrollTop(9999999999999999);
});
$("#button-fight").on("click",function(){
    var dmg = characters[0].base_stats.damageDie();
    var pText = `<p class='output-p'><span class='output-arrow'>-></span>Your attack hit, and did ${dmg} damage</p>`;
    $("#log-output").append(pText).scrollTop(9999999999999999);
});


//the function name pretty much explains itself here...//
//we can use this same code to make pretty much anything flash at a set interval - maybe something to keep in mind for the Character Damage Animation?

function flash() {
    $('#startScreen').each(function () {
        var elem = $(this);
        setInterval(function () {
            if (elem.css('visibility') == 'hidden') {
                elem.css('visibility', 'visible');
            } else {
                elem.css('visibility', 'hidden')
            }
        }, 650);
    });
}

flash();