document.getElementById("form").onsubmit = validateForm;


function validateForm(){
    var sendForm = true;
    // Check name
    if(!validateField("name", isAlphabetic)){
        sendForm = false;
    }

    if(!validateField("last_name", isAlphabetic)){
        sendForm = false;
    }

    //Chake birth date
    if(!validateField("datepicker", checkDate)){
        sendForm = false;
    }

    //Check DNI
    if(!validateField("dni", checkDNI)){
        sendForm = false;
    }

    //Address
    if(!validateField("address", notEmpty)){
        sendForm = false;
    }

    if(!validateField("city", isAlphabetic)){
        sendForm = false;
    }

    if(!validateField("province", notEmpty)){
        sendForm = false;
    }

    //Phone Number
    if(!validateField("phone", isPhoneNumber)){
        sendForm = false;
    }

    //Email
    if(!validateField("email", isEmail)){
        sendForm = false;
    }

    return sendForm;
}

function validateField(fieldID, testFunction){
    var domElement = document.getElementById(fieldID);
    if(testFunction(domElement.value)){
        deleteClass(domElement, "error");
        return true;
    } else {
        deleteClass(domElement, "error"); //Avoid to add multiple times the 
                                        //error class
        domElement.className += " error";
        return false;
    }
}

function deleteClass(domElement, targetClass){
    var re = new RegExp(targetClass, "g");
    var finalClass = domElement.className.replace(re, '');
    domElement.className = finalClass;
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

//------------------------------DATE CHECK-------------------------------------

// Returns if a given date is valid. Months, days and years have the normal 
// numeration starting from 1
// Valid formats dd-mm-yy / dd/mm/yy / dd mm yy
function checkDate(dateString){
    var dateStringParsed = parseDate();
    
    if(dateStringParsed === null){
        return false;
    }

    var day = dateStringParsed.day;
    var month = parseInt(dateStringParsed.month);
    month--; //Change the month to index
    var year = dateStringParsed.year;

    return isValidDate() && dateNotAhead();

    // Parse date string from input field
    // Takes dateString as variable
    function parseDate() {
        var regEx = new RegExp("[-/\\s]", "g");
        dateString = dateString.replace(regEx, "/");
        dateString = dateString.split("/");

        if(dateString.length !== 3){
            return null;
        }
        
        return {day : dateString[0],
                month : dateString[1],
                year : dateString[2]};
    }

    //Checks if day, month and year are a real date
    function isValidDate(){
        var month_short_names = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
            'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
        var dateString = month_short_names[month] + " " +
                day.toString() + " " +
                year.toString();
        console.log(dateString);
        return !isNaN(Date.parse(dateString));
    }

    //Checks that the introduced date (day, month and year variables)
    //isn't ahead
    function dateNotAhead(){
        var currentDateMs = Date.parse(new Date());
        var providedDateMs = Date.parse(new Date(year, month, day));

        return currentDateMs >= providedDateMs;
    }
}

function checkDNI(string){
    var letters = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 
       'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'];
     
    string = string.toUpperCase();

    if( !(/^\d{8}[-\s]?[A-Z]$/.test(string)) ) {
      return false;
    }
     
    if(string.charAt(string.length - 1) != letters[(string.substring(0, 8))%23]) {
      return false;
    }    

    return true;
}


function isEmail(string){
    var re = new RegExp(/@.+\..+$/);
    return re.test(string);
}

function notEmpty(string){
    return string.length !== 0;
}
