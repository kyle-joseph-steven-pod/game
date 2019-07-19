

var change = {
	37: {
		left: "-=1"
	},

	38: {
		top: "-=1"
	},

	39: {
		left: "+=1"
	},

	40: {
		top: "+=1"
	},
};

$(document).one("keydown", keyDown)

var movement;

function keyDown(e) {
	console.log("down")
	$(document).one("keyup", keyup)
	var animation = change[e.which];
	movement = setInterval(keepGoing, 1);

	function keepGoing() {
		$("#charBox").css(animation)
	}
}

function keyup(e) {
	console.log("up")
	clearInterval(movement)
	$(document).one("keydown", keyDown)
}
