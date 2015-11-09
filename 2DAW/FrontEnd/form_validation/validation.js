window.onload = function(){
    setFieldTestByClassName('alphabetic',isAlphabetic);
    document.getElementById('form_1068625').onsubmit = function(){
        var errorMissages = document.getElementsByClassName('error');
        alert(errorMissages.length);
        return errorMissages.length == 0;
    };
};

function setFieldTestByClassName(targetClass, test){
    var domCollection = document.getElementsByClassName(targetClass);
    for (var i = 0; i < domCollection.length; i++) {
        domCollection[i].addEventListener('blur', validate(domCollection[i], test));
    };
}

function validate(form_element, test){
    console.log(form_element);
    return function(){
        validateField(form_element, test(form_element.value));
        console.log(form_element.value)
    };
}

function isAlphabetic(string){
    if( string == null || string.length == 0 || /[0-9]+$/.test(string) ) {
        return false;
    }else {
        return true;
    }
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




