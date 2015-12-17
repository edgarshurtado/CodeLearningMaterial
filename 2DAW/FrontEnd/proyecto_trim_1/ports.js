var nav_bar = document.getElementsByClassName("nav")[0];
var nav_bar_links = nav_bar.getElementsByTagName("a");
for (var i = 0; i < nav_bar_links.length; i++) {
    nav_bar_links[i].addEventListener("click", clickEvent);

}

function clickEvent(){
    //Change menu focus
    var trigger = this;
    changeActive(trigger);

    //Change shown information
    showPort(trigger);
}

function changeActive(trigger){
    var active_link = nav_bar.getElementsByClassName("active")[0];
    active_link.className = "";
    trigger.parentNode.className = "active";
}

function showPort(trigger){
    var linkDivsReferences = {
        "pirineos-link": "puertos-pirineos",
        "alpes-link": "puertos-alpes",
        "mundo-link": "puertos-mundo"
    };
    var idToShow = linkDivsReferences[trigger.id];
    var currentInfo = document.getElementsByClassName("display")[0];
    console.log(currentInfo);
    currentInfo.className = "no_display";

    document.getElementById(idToShow).className = "display";
}

