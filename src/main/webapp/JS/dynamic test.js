//adding a div row dynamically
$("#sales").append(
    "<div class=container-flluid>" +
    "<div class=row>" +
    "<div class=col-md-3>" +
    "<div class=test></div>" +
    "</div>" +
    "<div class=col-md-6>" +
    "<div class=test>" +
    "<div class=col-md-5>" +
    "<div class=picture></div>" +
    "</div>" +
    "<div class=col-md-7>" +
    "<div class=product>" +
    "<label> Name: </label>" +
    "<label id=s_name_i" + (i+1) + "></label>" +
    "<br>" +
    "<label> From: </label>" +
    "<label id=from_i" + (i+1) + "></label>" +
    "<br>" +
    "<label> To: </label>" +
    "<label id=todate_i" + (i+1) + "></label>" +
    "<br>" +
    "<label> Sale description: </label>" +
    "<label id=s_descr_i" + (i+1) + "></label>" +
    "<br>" +
    "<label> Price: </label>" +
    "<label id=s_price_i" + (i+1) + "></label>" +
    "<br>" +
    "<label> Description: </label>" +
    "<label id=s_p_descr_i" +(i+1) + "></label>" +
    "</div>" +
    "</div>" +
    "</div>" +
    "</div>" +
    "<div class=col-md-3>" +
    "<div class=test></div>" +
    "</div>" +
    "</div>" +
    "</div>");