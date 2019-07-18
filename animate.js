"use strict";

////////////////////////////////////////////////////////////////////////



// READ ME!!!!!



/////////////////////

// the listeners are looking for these ids:

// id="test"
//This is what the image changing is targeting.


//The rest do what you think.

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
    $('#test').css('background-image', 'url(\'pngs/Mis-skull-fell-Normalized.png\')')
    clearTimeout(mainTimer)
}


//////////////////////////////////// Attack Func
function attackEnd() {
    $('#test').css('background-image', 'url(\'pngs/Mis-attackendNormalized.png\')')
    setTimeout(function () {
        idle()
    }, 250) //.25 seconds
}


//////////////////////////////////// Running Func
function step() {
    $('#test').css('background-image', 'url(\'pngs/Mis-steppingNormalized.png\')')
    setTimeout(function () {
        runCounter += 1;
        running()
    }, 250) //.25 seconds
}

function running() {
    $('#test').css('background-image', 'url(\'pngs/Mis-standingNormalized.png\')')
    setTimeout(function () {
        $('#test').css('background-image', 'url(\'pngs/Mis-steppingNormalized.png\')');
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
    $('#test').css('background-image', 'url(\'pngs/Mis-Talk2-Normalized.png\')')
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
    $('#test').css('background-image', 'url(\'pngs/Mis-Talk1-Normalized.png\')')
    setTimeout(function () {
        talkCounter += 1;
        talking1()
    }, 250) //.25 seconds
}


//////////////////////////////////// Idle

function idle() {
    if (counter === 0) {
        $('#test').css('background-image', 'url(\'pngs/Mis-idleNormalized.png\')');
        counter += 1;
    } else {
        $('#test').css('background-image', 'url(\'pngs/Mis-standingNormalized.png\')');
        counter -= 1;

    }
}

//////////////////


//The good stuff:


////////////////////////////////////sets the idle change
window.onload = function () {
    console.log(mainTimer);
};

////////////////////////////////////Attacking Listener
$('#attack').on('click', function () {
    $('#test').css('background-image', 'url(\'pngs/Mis-attackNormalized.png\')');
    setTimeout(function () {
        attackEnd()
    }, 250) //.25 seconds
});


////////////////////////////////////Running Listener
$('#run').on('click', function () {
    $('#test').css('background-image', 'url(\'pngs/Mis-steppingNormalized.png\')');
    setTimeout(function () {
        running()
    }, 250) //.25 seconds
});

////////////////////////////////////Talking Listener
$('#talk').on('click', function () {
    $('#test').css('background-image', 'url(\'pngs/Mis-Talk1-Normalized.png\')');
    setTimeout(function () {
        talking1()
    }, 250) //.25 seconds
});

////////////////////////////////////Damaged Listener
$('#damaged').on('click', function () {
    $('#test').css('background-image', 'url(\'pngs/Mis-injured-Normalized.png\')')
    setTimeout(function () {
        idle()
    }, 250) //.25 seconds
});

////////////////////////////////////Dead Listener
$('#dead').on('click', function () {
    $('#test').css('background-image', 'url(\'pngs/Mis-skull-nNormalized.png\')')
    setTimeout(function () {
        death()
    }, 250) //.25 seconds
});
