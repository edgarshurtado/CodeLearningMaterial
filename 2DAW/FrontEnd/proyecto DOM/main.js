function changeImage(imageUrl){
  document.getElementById('imageHolder').src = imageUrl;
}

function alertMessage(id){
  var parent = document.getElementById(id);
  var newChild = document.createElement('p');
  newChild.className = 'important';
  var text = document.createTextNode('Remember that AP supports are squissy');

  newChild.appendChild(text);
  parent.insertBefore(newChild, parent.getElementsByTagName('p')[1]);
}

function destroyMessage(id){
  var parent = document.getElementById(id);

  parent.removeChild(parent.getElementsByTagName('p')[1]);
}

function counters(countersArray){
  var message = "This champ counters are :\n"

  for (var i = 0; i < countersArray.length; i++) {
    message +="-- " + countersArray[i] + "\n";
  };

  return function(){
    alert(message);
  }
}

function reveal(divID, targetId){

   var spanElement = document.getElementById(targetId);
   var divElement = document.getElementById(divID);
   function action(){
    spanElement.className = 'visible';
    if(divElement.className == "ExtraInfo"){
      alertMessage(divID);
    }
    switch(divID){
      case "threshDiv": changeImage("./image/Thresh_0.jpg");
        break;
      case "sonaDiv": changeImage("./image/Sona_0.jpg");
        break;
    }
  }

  return action;
}

function hide(divID, targetId){

   var spanElement = document.getElementById(targetId);
   var divElement = document.getElementById(divID);

   function action(){
    spanElement.className = 'hidden';
    if(divElement.className == "ExtraInfo"){
      destroyMessage(divID);
    }
  }

  return action;
}


window.onload = function(){

  document.getElementById('threshLink').onmouseover = reveal('threshDiv', "threshExtra");

    document.getElementById('sonaLink').onmouseover = reveal('sonaDiv', 'sonaExtra');

    document.getElementById('threshLink').onmouseout = hide('threshDiv', "threshExtra");
    document.getElementById('sonaLink').onmouseout = hide('sonaDiv', 'sonaExtra');


    document.getElementById('threshCounters').onclick = counters(['Janna', 'Soraka']);
    document.getElementById('sonaCounters').onclick = counters(['Thresh', 'Alistar']);
}
