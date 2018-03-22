$(document).ready(initPage());
var debug = true;

function initPage() {

    loadCategories();
    loadProducts();

}

function loadProducts() {

    $.ajax({
        url: "../restservices/category/1",
        method: "GET",
        success: [function(category) {

            var products = category.products;

            $.each(products,function(i,product) {

                var mainDiv = jQuery('<div/>', {
                    class: 'col-md-4',
                    text: product.name
                });

                jQuery('<div/>', {
                    text: 'Naam: ' + product.name
                }).appendTo(mainDiv);

                jQuery('<div/>', {
                    text: 'Omschrijving: ' + product.description
                }).appendTo(mainDiv);

                jQuery('<div/>', {
                    text: 'Prijs: ' + product.price
                }).appendTo(mainDiv);

                jQuery('<div/>', {
                    onclick: 'addToCart(' + i + ')',
                    class: 'clickerDeClick',
                    text: 'VOEG TE AAN WINKELWAGEN'
                }).appendTo(mainDiv);

                mainDiv.appendTo('.pList');
            });
        }]
    });
}

function addToCart(productId) {
    var pushRequired = true;

    var cart = loadCart();

    if(cart == null){
        cart = [];
    }

    for(var i=0; i < cart.length; i++) {
        if(cart[i].id === productId){
            cart[i].amount += 1;
            pushRequired = false;
        }
    }

    if(pushRequired){
        cart.push({id: productId, amount: 1 });
    }

    var cartStrReturn = JSON.stringify(cart);
    localStorage.setItem("cartProducts", cartStrReturn);

    $("#orderButton").html("Shopping cart: " + cart.length)
}

$(document).ready(function() {
    $("#orderButton").click(function () {
        email = sessionStorage.getItem("sessionToken");

        if(email == null) {
            alert('je moet inloggen om te kunnen bestellen');
            return;
        }

        cart = localStorage.getItem("cartProducts");
        if(cart == null) {
            alert('Je moet wel wat in je winkelwagen hebben.');

        } else {

            var JSONdata =  JSON.parse(localStorage.getItem("cartProducts"));

            JSONdata = JSON.stringify({"orderLines": JSONdata})

            $.ajax({
                url: "../restservices/order",
                method: "POST",
                beforeSend: function(xhr) {
                    var token = window.sessionStorage.getItem("sessionToken");
                    xhr.setRequestHeader('Authorization', 'Bearer ' + token);
                },
                data: JSONdata,
                success: function (response) {
                    alert('Thanks for ordering at Webshop18');
                }
            });
            localStorage.clear();
        }
    });
});