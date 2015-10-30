function reveal(triggerId, target){
  triggerElement = document.getElementById(triggerId);
  targetElement = document.getElementById(target);
  console.log(target);
  return function(){
    console.log(targetElement);
    targetElement.className = 'visible';

    switch(triggerId){
      case "threshLink": changeImage("./image/Thresh_0.jpg");
        break;
      case "sonaLink": changeImage("./image/Sona_0.jpg");
        break;
    }
  }
}

function changeImage(imageUrl){
  document.getElementById('imageHolder').src = imageUrl;
}

window.onload = function(){

  document.getElementById('threshLink').onmouseover = reveal('threshLink', 'threshExtra');

    document.getElementById('sonaLink').onmouseover = reveal('sonaLink', 'sonaExtra');
}

// function setHide(spanElement){
//   (spanElement).className = 'hidden';
// }



// function alertMessage(id){
//   var parent = document.getElementById(id);
//   var newChild = document.createElement('p');
//   newChild.className = 'important';
//   var text = document.createTextNode('Remember that AP supports are squissy');

//   newChild.appendChild(text);
//   parent.insertBefore(newChild, parent.getElementsByTagName('p')[1]);
// }

// function destroyMessage(id){
//   var parent = document.getElementById(id);

//   parent.removeChild(parent.getElementsByTagName('p')[1]);
// }

// function counters(countersArray){
//   var message = "This champ counters are :\n"

//   for (var i = 0; i < countersArray.length; i++) {
//     message +="-- " + countersArray[i] + "\n";
//   };
//   alert(message);
// }