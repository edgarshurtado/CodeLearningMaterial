//Images arrays
imgsContador = [ "contador1.jpg", "contador2.jpg", "contador3.jpg",
             "contador4.jpg" ];

imgsIndurain = [ "indurain1.jpg", "indurain2.jpg", "indurain3.jpg",
    "indurain4.jpg" ];

imgsPantani = [ "pantani1.jpg", "pantani2.jpg", "pantani3.jpg",
    "pantani4.jpg" ];

// Set triggers
setImgChange("contador", imgsContador);
setImgChange("indurain", imgsIndurain);
setImgChange("pantani", imgsPantani);

//Helper functions
function setImgChange(divID, imagesArray){
    var divElement = $("#" + divID);
    var imgHolder = divElement.find("img");
    var changeFunction = randomImage(imgHolder, imagesArray);
    var intervalHolder;
    divElement.mouseenter(function(){
        intervalHolder = setInterval(changeFunction, 4000);
    });

    divElement.mouseout(function(){
        clearInterval(intervalHolder);
    });
}

//Change the image from a img element with a random image from imagesArray.
//This function needs that all images are in the same folder as it just change
//the file name but not the path
function randomImage(imgHolder, imagesArray){
    return function() {
        //Get the actual header img background
        currentImage = imgHolder.attr("src").split("/");
        currentImage = currentImage[currentImage.length - 1];
        
        //Choose a new image diferent from the actual
        do{
            var randomPosition = Math.floor(Math.random() * imagesArray.length);
            var newImage = imagesArray[randomPosition];
        }while(newImage === currentImage) //Make sure the new image is different

        //Construct regular expresion
        regEx = new RegExp(currentImage, "g");
        //Set the image
        imgHolder.fadeOut("fast", function(){
            imgHolder.attr("src", imgHolder.attr("src").replace(regEx, newImage));
            imgHolder.fadeIn("fast");
        })

    }
}

