$(document).ready(initPage());

function initPage() {
    console.log("Initialized page");

    loadSales();
}

function loadSales() {
    console.log("../restservices/sale/1")
    $.ajax({
        url: "../restservices/sale/1",
        method: "GET",
        success: [function(data) {

            $("#s_name").html(data.product.name);
            $("#from").html(data.fromDate);
            $("#todate").html(data.toDate);
            $("#s_descr").html(data.description);
            $("#s_price").html(data.salePrice);
            $("#s_p_descr").html(data.product.description);

        }]
    });
    console.log('einde');
};