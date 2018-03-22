$(document).ready(initPage());

function initPage() {
    loadCategories();
    loadProduct();
}

function loadProduct() {
    var id = sessionStorage.getItem('id');
    console.log(id);
    $.ajax({
        url: "../restservices/product/" + id,
        method: "GET",
        success: [function(data) {
            $("#name").html(data.name);
            $("#price").html("€ " + data.price);
            $("#descr").html(data.description);
            $("title").html(data.name);
        }]
    });
    
}