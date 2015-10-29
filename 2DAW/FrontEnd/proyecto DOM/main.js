function reveal(trigger, target){
  trigger = document.getElementById(trigger);
  target = document.getElementById(target);
}


function setVisible(spanElement){
  spanElement.className = 'visible';
}

function setHide(spanElement){
  (spanElement).className = 'hidden';
}

function changeImage(champ){
  var champLinks = {
    'sona' : "./image/Sona_0.jpg",
    'thresh': "./image/Thresh_0.jpg"
  }

  document.getElementById('imageHolder').src = champLinks[champ];
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
  alert(message);
}