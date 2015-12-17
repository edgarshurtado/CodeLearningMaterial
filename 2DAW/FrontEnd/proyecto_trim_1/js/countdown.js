// Function inspired by http://www.jose-aguilar.com/blog/countdown-js/

function countdown(dueDate) {
    return function(){
        var now = new Date();
        var days = 0;
        var hours = 0;
        var minutes = 0;
        var seconds = 0;

        if(dueDate > now){
            var difference = (dueDate.getTime()-now.getTime())/1000;
            days=Math.floor(difference/86400);
            difference=difference-(86400*days);
            hours=Math.floor(difference/3600);
            difference=difference-(3600*hours);
            minutes=Math.floor(difference/60);
            difference=difference-(60*minutes);
            seconds=Math.floor(difference);
        }
        
        return days + ":" + hours + ":" + minutes + ":" + seconds; 
    }
}
