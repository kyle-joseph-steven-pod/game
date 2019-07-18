$("#log-form").submit(function(e){
    e.preventDefault();

    //Adds text to output log, reuse as possible for dialogue
    var pText = `<p class='output-p'><span class='output-arrow'>-></span>${$('#log-form-input').val()}</p>`;
    // newestP = $("#log-output").children().last().scrollTop();
    //value is set to 99999999999 because i couldnt get the value of the bottom of scroll window so its a jank fix but it works
    $("#log-output").append(pText).scrollTop(9999999999999999);
});
$("#button-fight").on("click",function(){
    var dmg = characters[0].base_stats.damageDie();
    var pText = `<p class='output-p'><span class='output-arrow'>-></span>Your attack hit, and did ${dmg} damage</p>`;
    $("#log-output").append(pText).scrollTop(9999999999999999);
});