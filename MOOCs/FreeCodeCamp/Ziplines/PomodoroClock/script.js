$(document).ready(function(){

	timer.setTimer();
	$('#timer').text(timer.getTime());

	$('#start').click(function(){
		timer.startTimer();
	});

	$('#stop').click(function(){
		timer.stopTimer();
	});

	$('#reset').click(function(){
		timer.resetTime();
		$('#timer').text(timer.getTime());
	});

	$('#plusWork').click(function(){
		modifyNumber("#workTime", +1);
		timer.setTimer();
	});

	$('#plusRest').click(function(){
		modifyNumber("#restTime", +1);
	});

	$('#lessWork').click(function(){
		modifyNumber("#workTime", -1);
		timer.setTimer();
	});

	$('#lessRest').click(function(){
		modifyNumber("#restTime", -1);
	});

});

function modifyNumber(numberId, modifier){
	var current = parseInt($(numberId).text(), 10);
		$(numberId).text(current + modifier);
}

function getUserTime(timerId){
	//gets the time in minutes and returns it as seconds
	return parseInt($(timerId).text(), 10) * 60;
}

var timer = {
	totalSeconds: null,
	runningTime: null,

	timeHandler: null,	//handler which will run the setInterval function
	svgHandler: null,	//handler for the svg animation

	isWorkTime: true,	//For knowing if we must run the work timer or
						//the rest timer

	getTime: function(){
		function formating(value){
			value = value.toString();
			if(value.length < 2){
				return '0' + value;
			} else {
				return value;
			}
		}
		var minutes = Math.floor(this.runningTime / 60);
		var totalSeconds = this.runningTime - (minutes * 60);
		return formating(minutes) + " : " + formating(totalSeconds);
	},
	resetTime: function(){
		this.stopTimer();
		this.setTimer();
	},
	startTimer: function(){
		var that = this; //Allows to refer to the timer object inside the setInterval
										//function call
		this.timeHandler = setInterval(function(){

			if(that.runningTime > 0){
				that.runningTime--;
			} else{
				that.stopTimer();

				that.isWorkTime = !that.isWorkTime;	//changes the bool value of
													//the variable when the timer
													//is out of time

				that.setTimer();
			}
			$('#timer').text(that.getTime());
			that.svgHandler(that.totalSeconds - that.runningTime);
		}, 1000);
	},
	stopTimer: function(){
		clearInterval(this.timeHandler);
	},
	setTimer: function(){
		var color; //color for the svg animation
		var timerId;
		var timerMessage;
		if(this.isWorkTime){
			color = "red";
			timerId = "#workTime";
			timerMessage = "WORK TIME!!";
		} else {
			color = "green";
			timerId = "#restTime";
			timerMessage = "REST TIME!!";
		}

		var seconds = parseInt($(timerId).text(), 10) * 60;
		this.totalSeconds = seconds;
		this.runningTime = seconds;

		$('#announcment').text(timerMessage);
		this.svgHandler = animationHandler(seconds, color);
		this.svgHandler(this.totalSeconds - this.runningTime);
		$('#timer').text(this.getTime());
	},

	getIsWorkTime: function(){
		return this.isWorkTime;
	}
};