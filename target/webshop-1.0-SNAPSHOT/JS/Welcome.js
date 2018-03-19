$(document).ready(initPage());

function initPage() {
    console.log("Initialized page");

    loadSales();
    // loadCategories();
}

function loadSales() {
    // console.log("../restservices/sale/1");
    $.ajax({
        url: "../restservices/sale",
        method: "GET",
        success: [function(data) {
            // console.log(data);
            // console.log(data.fromDate);
            // console.log(data.product.name);
            $.each(data, function(i,sale) {
                console.log(sale.fromDate);
                // console.log(data.fromDate);
                console.log(sale.product.price);
                // console.log(data.product.price);
                // console.log(data);
                i++;
                $(".sales").append(
                    "<div class=container-fluid>" +
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
                                            "<label id=name>" + sale.product.name + "</label><br>" +
                                            "<label> Price:</label>" +
                                            "<label id=price>" + sale.product.price + "</label><br>" +
                                            "<label> SalePrice:</label>" +
                                            "<label id=saleprice>" + sale.salePrice + "</label><br>" +
                                            "<label> From:</label>" +
                                            "<label id=from>" + sale.fromDate + "</label><br>" +
                                            "<label> To: </label>" +
                                            "<label id=to>" + sale.toDate + "</label><br>" +
                                            "<label> Description: </label>" +
                                            "<label id=descr>" + sale.product.description + "</label>" +
                                        "</div>" +
                                    "</div>" +
                                "</div>" +
                            "</div>" +
                            "<div class=col-md-3>" +
                                "<div class=test></div>" +
                            "</div>" +
                        "</div>" +
                    "</div>"
                )
            });

            // $("#s_name").html(data.product.name);
            // $("#from").html(data.fromDate);
            // $("#todate").html(data.toDate);
            // $("#s_descr").html(data.description);
            // $("#s_price").html(data.salePrice);
            // $("#s_p_descr").html(data.product.description);

        }]
    });
    // console.log('einde');
};