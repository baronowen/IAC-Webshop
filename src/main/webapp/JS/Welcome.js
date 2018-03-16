$(document).ready(initPage());

function initPage() {
    console.log("Initialized page");

    loadSales();
    loadCategories();
}

function loadSales() {
    console.log("../restservices/sale/1");
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

function loadCategories() {
    console.log("../restservices/category");
    var i = 0;
    $.ajax({
        url: "../restservices/category",
        method: "GET",
        success: [function(data) {
            $.each(data,function(i,categories) {
                console.log(categories.name);
                i++;
                if(i>2) {
                    $(".dropdown-menu").append(
                        "<li><a href='productList.html'>" + categories.name + "</a></li>"
                    )
                    //TODO XSS afdekken in bovenstaande link als we XSS gaan afdekken.
                }
                $("#c"+i+"").text(categories.name);

            })
        }]
    })
}