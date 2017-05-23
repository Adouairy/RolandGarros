$(function() {
	$("#datepicker").datepicker({
		maxDate : new Date()
	});
});
$(function() {
	$("#datepicker2").datepicker({
		maxDate : new Date()
	});
});

$(function() {
	// run the currently selected effect
	function runEffect() {
		// get effect type from
		var selectedEffect = $("#effectTypes").val();

		// Most effect types need no options passed by default
		var options = {};
		// some effects have required parameters
		if (selectedEffect === "scale") {
			options = {
				percent : 50
			};
		} else if (selectedEffect === "size") {
			options = {
				to : {
					width : 280,
					height : 185
				}
			};
		}

		// Run the effect
		$("#echecCo").show(selectedEffect, options, 50000, callback);
	}
	;

	// callback function to bring a hidden box back
	function callback() {
		setTimeout(function() {
			$("#echecCo:visible").removeAttr("style").fadeOut();
		}, 50000);
	}
	;

	// Set effect from select menu value
	$("#buttonConnection").on("click", function() {
		runEffect();
	});

	$("#echecCo").hide();
});