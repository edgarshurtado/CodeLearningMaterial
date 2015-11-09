window.onload = function(){
    setFieldTestByClassName('alphabetic',isAlphabetic);
    document.getElementById('form_1068625').onsubmit = function(){
        var errorMissages = document.getElementsByClassName('error');
        alert(errorMissages.length);
        return errorMissages.length == 0;
    };
};

function setFieldTestByClassName(targetClass, stringTest){
    var domCollection = document.getElementsByClassName(targetClass);
    for (var i = 0; i < domCollection.length; i++) {
        domCollection[i].addEventListener('blur', validate(domCollection[i], stringTest));
    };
}

function validate(form_element, stringTest){
    return function(){
        var test_result = stringTest(form_element.value);
        var error_class = 'error';
        if (test_result) {
            deleteClass(form_element, error_class);
        } else {
            form_element.className += " " + error_class;
        }
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

function deleteClass(domElement, error_class){
    var re = new RegExp(error_class, "g");
    var finalClass = domElement.className.replace(re, '');
    domElement.className = finalClass;
}

function test(){
    console.log(this);
}




