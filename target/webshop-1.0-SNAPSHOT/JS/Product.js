$(document).ready(initPage());

function initPage() {
    loadCategories();
    loadProduct();
}

function loadProduct() {

    $.ajax({
        url: "../restservices/product/4",
        method: "GET",
        success: [function(data) {
            $("#name").html(data.name);
            $("#price").html("€ " + data.price);
            $("#descr").html(data.description);
            $("title").html(data.name);
        }]
    });
    
}