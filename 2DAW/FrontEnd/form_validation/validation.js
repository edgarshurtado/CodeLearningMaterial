window.onload = function(){
    eventListenerToCollection(document.
            getElementsByClassName('alphabetic'), "blur",validateAlphabetic);

    document.getElementById('form_1068625').onsubmit = function(){
        var errorMissages = document.getElementsByClassName('error');
        alert(errorMissages.length);
        return errorMissages.length == 0;
    };
};

function setFieldTestByClassName(targetClass, test){
    var domCollection = document.getElementsByClassName(targetClass);
    for (var i = 0; i < domCollection.length; i++) {
        domCollection[i].addEventListener(eventType, test;
    };
}

function eventListenerToCollection(collection, eventType, callback){
    for (var i = 0; i < collection.length; i++) {
        collection[i].addEventListener(eventType, callback(collection[i]));
    };
}

function validateAlphabetic(form_element){
    function isAlphabetic(string){
        if( string == null || string.length == 0 || /[0-9]+$/.test(string) ) {
            return false;
        }else {
            return true;
        }
    }
    return function(){
        validateField(form_element, isAlphabetic(form_element.value));
        console.log(form_element.value)
    };
}

function isPhoneNumber(string){
    return /^\d{9}$/.test(string);
}

function validateField(domElement, condition){
    function deleteError(domElement){
        var finalClass = domElement.className
            .replace(/(?:^|\s)error(?!\S)/g, '');
        domElement.className = finalClass;
    }

    if (condition) {
        deleteError(domElement);
    } else {
        domElement.className += ' error';
    }
}

function test(){
    console.log(this);
}




