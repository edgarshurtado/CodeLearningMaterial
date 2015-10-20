function animationHandler(seconds, color){
  var loader = document.getElementById("loader");
  var alpha = 0;
  var pi = Math.PI;
  var t = 30;
  var totalTimePeriod = seconds;
  $('#loader').css("fill", color);
  
  function draw(secs) {
    alpha = 360 * (secs/totalTimePeriod);
    var r = ( alpha * pi / 180 );
    var x = Math.sin( r ) * 125;
    var y = Math.cos( r ) * - 125;
    var mid = ( alpha > 180 ) ? 1 : 0;
    var anim = 'M 0 0 v -125 A 125 125 1 ' +
            mid + ' 1 ' +
             x  + ' ' +
             y  + ' z';
   
    loader.setAttribute( 'd', anim );
  }

  return draw;
}
