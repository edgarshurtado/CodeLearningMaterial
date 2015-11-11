window.onload = function(){

    setFieldTestByClassName('alphabetic',isAlphabetic);
    setFieldTestByClassName('postalcode',isPostalCode);
    setFieldTestByClassName('url', isWebLink);

    document.getElementById('form_1068625').onsubmit = validateForm;
};
// Sets for every Dom Element with the targetClass to pass (on blur) a test that
//checks it's value
function setFieldTestByClassName(targetClass, valueTest){
    var domCollection = document.getElementsByClassName(targetClass);
    for (var i = 0; i < domCollection.length; i++) {
        domCollection[i].addEventListener(
            'blur', validateField(domCollection[i], valueTest));
    };
}

//Checks if the value of the form_element passes the valueTest. If it doesn't,
//adds the error_class to the DOM element; if it does, removes the
//error class from the DOM element in case it has it.
function validateField(form_element, valueTest){
    return function(){
        var test_result = valueTest(form_element.value);
        var error_class = 'error';
        if (test_result) {
            deleteClass(form_element, error_class);
        } else {
            form_element.className += " " + error_class;
                //I had to add the blank space (" ") for add the class properly
                //if i didn't do it like this I'd merge the adding class with
                //the last prexistent class
        }
    };
}

// Deletes a class from a DOM element
function deleteClass(domElement, targetClass){
    var re = new RegExp(targetClass, "g");
    var finalClass = domElement.className.replace(re, '');
    domElement.className = finalClass;
}

//-----------------
//Test functions
//-----------------
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

function isPostalCode(string){
    return isNumerical(string) && string.length === 5;
}
function isNumerical(string){
    return !isNaN(string);
}

function isWebLink(string){
    var re = new RegExp(/\..+/);
    return re.test(string);
}

function checkDate(){

    var day = document.getElementsByName('day')[0].value;
    var month = document.getElementsByName('month')[0].value - 1;
    var year= document.getElementsByName('year')[0].value;
    
    return isValidDate() && dateNotAhead();

    function isValidDate(){
        var month_short_names = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
            'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
        
        return !isNaN(Date.parse(month_short_names[month] + day.toString() +
                year.toString()));
    }

    function dateNotAhead(){
        var currentDateMs = Date.parse(new Date());
        var providedDateMs = Date.parse(new Date(year, month, day));

        return currentDateMs >= providedDateMs;
    }
}

function validateForm(){
    var errorMessage ="";
    var nErrors = document.getElementsByClassName('error');
    if(nErrors.length > 0){
        errorMessage +=
            "Tienes " + nErrors.length.toString() + " campos erróneos";
    }
    alert(errorMessage);
    return errorMessage.length === 0; //Avoids to send the form is there is
                                        //any error.
}
