window.onload = function (){
    var readmore_btns = document.getElementsByClassName("readmore-btn");
    for (var i = 0; i < readmore_btns.length; i++){
        readmore_btns[i].addEventListener("click", readmore);
    }
    var readless_btns = document.getElementsByClassName("readless-btn");
    for (var i = 0; i < readmore_btns.length; i++){
        readless_btns[i].addEventListener("click",readless);
    }

    setInterval(randomHeader, 5000);

    // Change winner images
    document.getElementById("t_francia").
        addEventListener("mouseover", changeWinnerImg("froome.jpg"));
    document.getElementById("g_italia").
        addEventListener("mouseover", changeWinnerImg("contador.jpg"));
    document.getElementById("v_espana").
        addEventListener("mouseover", changeWinnerImg("aru.jpg"));
    
    //---------------------Countdowns-----------------------------------------
    //  Giro Italia
    var g_italiaBegin = new Date ("2016/4/6");
    var g_italiaCountDown = countdown(g_italiaBegin);

    printCountDown(g_italiaCountDown, "g_italia")();
    setInterval(printCountDown(g_italiaCountDown, "g_italia"), 1000);

    // Tour France
    var t_franciaBegin = new Date ("2016/7/2");
    var t_franciaCountDown = countdown(t_franciaBegin);

    printCountDown(g_italiaCountDown, "t_francia")();
    setInterval(printCountDown(t_franciaCountDown, "t_francia"), 1000);

    //Vuelta España
    var v_espanaBegin = new Date ("2016/8/22");
    var v_espanaCountDown = countdown(v_espanaBegin);
    
    printCountDown(g_italiaCountDown, "v_espana")();
    setInterval(printCountDown(v_espanaCountDown, "v_espana"), 1000);
}

function randomHeader(){
    var imageHeaders = [
        "header1.jpg",
        "header2.jpg",
        "header3.jpg",
        "header4.png",
        "header5.png",
        "header6.jpg",
        ]
    var imgHolder = document.getElementById("img_bottom");
    var regEx = new RegExp("(header[0-9]+\.[a-z]+)");//gets the header file name

    //Get the actual header img background
    var bck_url = window.getComputedStyle(imgHolder, "").backgroundImage;
    var headerActualImg = regEx.exec(bck_url)[0];
    
    //Choose a new image diferent from the actual
    do{
        var randomPosition = Math.floor(Math.random() * imageHeaders.length);
        var newImage = imageHeaders[randomPosition];
    }while(newImage === headerActualImg)

    //Set the image
    imgHolder.style.backgroundImage=bck_url.replace(regEx, newImage);
}

function readmore(){
    var thisPatent = this.parentNode;
    var expandableSection = thisPatent.getElementsByClassName("readmore")[0];
    console.log(expandableSection);
    expandableSection.style.display = "inline";
    this.style.display = "none";
}

function readless(){
    var expandableSection = this.parentNode;
    expandableSection.style.display = "none";
    var readMoreLink = this.parentNode.parentNode.getElementsByClassName("readmore-btn")[0];
    readMoreLink.style.display = "inline";
}

function changeWinnerImg(imgSrc){
    return function(){
        var imgHolder = document.getElementById("winner_photo");
        imgHolder.src="./img/winners/" + imgSrc;
    }
}

function printCountDown(countdown, textHolderId){
    return function(){
        document.getElementById(textHolderId).
            getElementsByTagName("span")[0].innerHTML = countdown();
    }
}
