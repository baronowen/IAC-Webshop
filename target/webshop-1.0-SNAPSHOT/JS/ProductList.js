$(document).ready(initPage());
var debug = true;

function initPage() {

    loadCategories();
    loadProducts();

}

function loadProducts() {
    if(debug) {
        console.log("loadProducts()");
    }
    $.ajax({
        url: "../restservices/category/1",
        method: "GET",
        success: [function(category) {
            if(debug) {
                console.log("Category:");
                console.log(category);
                console.log("\n");
            }
            var products = category.products;

            $.each(products,function(i,product) {
                if(debug) {
                    console.log("Product:");
                    console.log(product);
                    console.log("\n");
                }

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
    if(debug) {
        console.log("addToCart(" + productId + ")");
    }
    var cartStr = localStorage.getItem("cartProducts");
    var cart = JSON.parse(cartStr);
    var pushRequired = true;

    if(cart == null){
        cart = [];
    }

    if(debug) {
        console.log("cart: ");
        console.log(cart);
        console.log("\n");
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
}