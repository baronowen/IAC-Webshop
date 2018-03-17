//adding a div row for sales dynamically
$("#sales").append(
    // "<div class=container-flluid>" +
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
    "</div>");/* +*/
    // "</div>");

//div row for productList
"<div class=row>" +
"<div class=col-md-3>" +
"<div class=test></div>" +
"</div>" +
"<div class=col-md-6>" +
"<div class=list>" +
"<div class=col-md-4>" +
"<div class=picture></div>" +
"</div>" +
"<div class=col-md-8>" +
"<div class=info>" +
"<label> Name:</label>" +
"<label id=name>" + cat_product.product.name + "</label><br>" +
"<label> Price:</label>" +
"<label id=price>" + cat_product.product.price + "</label><br>" +
"<label> SalePrice:</label>" +
"<label id=saleprice></label><br>" +
"<label> Description: </label>" +
"<label id=descr>" + cat_product.product.description + "</label>" +
"</div>" +
"</div>" +
"</div>" +
"</div>" +
"<div class=col-md-3>" +
"<div class=test></div>" +
"</div>" +
"</div>"