$("#log-form").submit(function(e){
    e.preventDefault();
    var pText = "<p class='output-p'><span class='output-arrow'>-></span>"+$('#log-form-input').val()+"</p>";
    // newestP = $("#log-output").children().last().scrollTop();
    $("#log-output").append(pText).scrollTop(9999999999999999);
});