"use strict";

////////////////////////////////////////////////////////////////////////


// READ ME!!!!!


/////////////////////

// the listeners are looking for these ids:

// id="test"
//This is what the image changing is targeting.


//The rest do what you think.


// id="here" - start button?
// id="attack"
// id="run"
// id="talk"
// id="damaged"
// id="dead"


/////////////////////
//Add the following to test with buttons:
/////////////////////

//<button id="attack">Attack</button>
// <button id="run">Run</button>
// <button id="talk">Talk</button>
// <button id="damaged">Damaged</button>
// <button id="dead">Dead</button>

////////////////////////////////////////////////////////////////////////






//////////////////////////////////// Counters
let counter = 0;
let runCounter = 0;
let talkCounter = 0;


//////////////////////////////////// Idle Timer
let mainTimer = setInterval(function () {
    idle();
}, 4000); //4 seconds


function death() {
    $('#con-sprite').css('background-image', 'url(\'pngs/Mis-skull-fell-Normalized.png\')')
    clearTimeout(mainTimer)
}


//////////////////////////////////// Attack Func
function attackEnd() {
    $('#con-sprite').css('background-image', 'url(\'pngs/Mischievous-Sprite/Mis-attack-end-Normalized.png\')')
    setTimeout(function () {
        idle()
    }, 250) //.25 seconds
}


//////////////////////////////////// Running Func
function step() {
    $('#con-sprite').css('background-image', 'url(\'pngs/Mischievous-Sprite/Mis-stepping-Normalized.png\')')
    setTimeout(function () {
        runCounter += 1;
        running()
    }, 250) //.25 seconds
}

function running() {
    $('#con-sprite').css('background-image', 'url(\'pngs/Mischievous-Sprite/Mis-standing-Normalized.png\')')
    setTimeout(function () {
        $('#con-sprite').css('background-image', 'url(\'pngs/Mischievous-Sprite/Mis-stepping-Normalized.png\')');
        if (runCounter >= 3) {
            runCounter = 0;
            return idle()
        } else {
            step()
        }
    }, 250) //.25 seconds
}


//////////////////////////////////// Talking Func
function talking1() {
    $('#con-sprite').css('background-image', 'url(\'pngs/Mischievous-Sprite/Mis-Talk2-Normalized.png\')')
    setTimeout(function () {
        if (talkCounter >= 2) {
            talkCounter = 0;
            return idle()
        } else {
            talking2()
        }
    }, 250) //.25 seconds
}

function talking2() {
    $('#con-sprite').css('background-image', 'url(\'pngs/Mischievous-Sprite/Mis-Talk1-Normalized.png\')')
    setTimeout(function () {
        talkCounter += 1;
        talking1()
    }, 250) //.25 seconds
}


//////////////////////////////////// Idle

function idle() {
    if (counter === 0) {
        $('#con-sprite').css('background-image', 'url(\'pngs/Mischievous-Sprite/Mis-idle-Normalized.png\')');
        counter += 1;
    } else {
        $('#con-sprite').css('background-image', 'url(\'pngs/Mischievous-Sprite/Mis-standing-Normalized.png\')');
        counter -= 1;

    }
}

//////////////////


//The good stuff:


////////////////////////////////////sets the idle change
window.onload = function () {
    console.log(mainTimer);
};
////////////////////////////////////Starts idle on button press

// $('#test').on('click', function () {
//     $('#con-sprite').css('background-image', 'url(\'pngs/Mis-attackNormalized.png\')')
//         .then($(this).off())
//
// });


////////////////////////////////////Attacking Listener
$('#button-fight').on('click', function () {
    $('#con-sprite').css('background-image', 'url(\'pngs/Mischievous-Sprite/Mis-attack-Normalized.png\')');
    setTimeout(function () {
        attackEnd()
    }, 250) //.25 seconds
});


////////////////////////////////////Running Listener
$('#button-run').on('click', function () {
    $('#con-sprite').css('background-image', 'url(\'pngs/Mischievous-Sprite/Mis-stepping-Normalized.png\')');
    setTimeout(function () {
        running()
    }, 250) //.25 seconds
});

////////////////////////////////////Talking Listener
$('#button-talk').on('click', function () {
    $('#con-sprite').css('background-image', 'url(\'pngs/Mischievous-Sprite/Mis-Talk1-Normalized.png\')');
    setTimeout(function () {
        talking1()
    }, 250) //.25 seconds
});

////////////////////////////////////Damaged Listener
$('#damaged').on('click', function () {
    $('#con-sprite').css('background-image', 'url(\'pngs/Mischievous-Sprite/Mis-injured-Normalized.png\')')
    setTimeout(function () {
        idle()
    }, 250) //.25 seconds
});

////////////////////////////////////Dead Listener
$('#dead').on('click', function () {
    $('#con-sprite').css('background-image', 'url(\'pngs/Mischievous-Sprite/Mis-skull-Normalized.png\')')
    setTimeout(function () {
        death()
    }, 250) //.25 seconds
});
