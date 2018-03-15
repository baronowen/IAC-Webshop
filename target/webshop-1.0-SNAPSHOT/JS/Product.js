$(document).ready(initPage());

function initPage() {
    console.log("Initialize page");

    loadProduct();
}

function loadProduct() {
    console.log("http://localhost:8081/restservices/product/4")
    $.ajax({
        url: "../restservices/product/4",
        method: "GET",
        success: [function(data) {
            $("#name").html(data.name);
            $("#price").html("€ " + data.price);
            $("#descr").html(data.description);
            $("#title").html(data.name);
            // console.log(data.name);
            // console.log(data.price);
            // console.log(data.description);
        }]
    });
    console.log('einde');
};