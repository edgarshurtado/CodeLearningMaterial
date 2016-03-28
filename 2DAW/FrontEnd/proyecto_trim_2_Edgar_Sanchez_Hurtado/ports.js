$content = $("#content");

$.get("./views/ports-selects.html", function(response){
    $content.html(response);

    $zoneSelect = $("#zone");
    $portsSelect = $("#port");

    var zoneSelectOptions = "<option value='00'>----</option>"

    $.get("./server/cargaZonas.php", function(response){
        // Get all the zones
        $(response).find("zona").each(function(){
            // For each zone get the code and name
            zoneSelectOptions += "<option value='" + $(this).find("codigo").text() + "'>" +
                    $(this).find("nombre").text() + "</option>";
        })
        // Add to the select the options created above
        $zoneSelect.html(zoneSelectOptions);
    })


    $zoneSelect.change(function(){
        var selectedZoneCode = $zoneSelect.val();

        var portSelectOptions = "<option value='00'>----</option>";

        if(selectedZoneCode !== '00'){
            $.post("./server/cargaPuertos.php", {zona: selectedZoneCode}, function(response){
                // Convert the response to a jQuery object and for each port introduce an option to the ports select
                $(response).find("puerto").each(function(){
                    portSelectOptions += "<option value='" + $(this).find("codigo").text() + "'>" +
                        $(this).find("nombre").text() + "</option>";

                })
                $portsSelect.html(portSelectOptions);
            })
        }else {
            $portsSelect.html(portSelectOptions); // In case the default option is selected
        }

    })

   $portsSelect.change(function() {
       var portSelectedCode = $(this).val();
       var zoneSelectedCode = $zoneSelect.val();

       var zoneXML = "";

       switch(zoneSelectedCode){
           case "01": zoneXML = "alpes.xml"; break;
           case "02": zoneXML = "pirineus.xml"; break;
           case "03": zoneXML = "resto-mundo.xml"; break;
           default: alert("Unexpected zone code");
       }

       // Load template of a single port for filling it with the ajax request
       $("#port-section").load("./views/single-port-view.html", fillPortTemplate(zoneXML, portSelectedCode));

   })
})

function fillPortTemplate(zoneSelectedXMLName, portSelectedCode){

    return function(){

        // Request the XML by zone and filter the result to retrieve the user selected port
        $.get("./server/" + zoneSelectedXMLName, function(response){
            var selectedPort = $(response).find("puerto")
                .filter(function(){

                    return $(this).find("coding").text() == portSelectedCode;
                });

            $("#port-name").text(selectedPort.find("nombre").text());

            var galleryInnerHtml = "";
            selectedPort.find("imagen").each(function(i){
                if(i == 0){
                    galleryInnerHtml += "<a class='glyphicon glyphicon-picture' ";
                } else {
                    galleryInnerHtml += "<a ";
                }

                galleryInnerHtml += "href='" + $(this).text() + "' data-lightbox='port'></a>"
            })

            // Load gallery and alert information
            $("#gallery-alert-icons").html(galleryInnerHtml);
            var msg_alert = selectedPort.find("alerta").text();
debugger;
            if(msg_alert.length > 0){ // Add alert icon just if there is an alert message
                $("#gallery-alert-icons").append("<a id='alert' class='glyphicon glyphicon-warning-sign' title='"+msg_alert+"'></a>");
                $(document).tooltip();
            }


            // Load the altimetry image
            $("#img-altimetry").attr("src", selectedPort.find("imagen-altimetria").text());

            // Load table content (lenght and high)
            $("#port-length").html(selectedPort.find("longitud").text());
            $("#port-altitud").html(selectedPort.find("altitud").text());


            // -- Aditional Information Section --

            var readmoreInnerHtml = selectedPort.find("informacion-adicional").html();

            // Link that triggers the hide of the additional information
            readmoreInnerHtml += "<a class='readless-btn' onclick='return false'>Leer menos</a>";
            $("#div-readmore").html(readmoreInnerHtml);


            // -- Expandable Divs --
            $(".readmore-btn").click(function(){
                // Show hided content
                $(this).next().slideDown("slow");
                // Hide readmore btn
                $(this).hide();
            });

            $(".readless-btn").click(function(){
                // Hide the shown info from the expandable div
                $expandableDiv = $(this).parent();
                $expandableDiv.slideUp("slow");
                // Show again the readmore-btn for returning to the starting point
                $expandableDiv.siblings(".readmore-btn").show();
            })
        })

    }

}