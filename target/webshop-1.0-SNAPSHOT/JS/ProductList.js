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
    var pushRequired = true;

    var cart = loadCart();

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

    $("#orderButton").html("Shopping cart: " + cart.length)
}

$(document).ready(function() {
    $("#orderButton").click(function () {
        email = sessionStorage.getItem("email");

        if(email == null) {
            alert('je moet inloggen om te kunnen bestellen');
            return;
        }

        cart = localStorage.getItem("cartProducts");

        if(cart == null) {
            alert('Je moet wel wat in je winkelwagen hebben.');
            return;
        } else {
            var JSONdata =  JSON.parse(localStorage.getItem("cartProducts"));

            console.log({"orderLines": JSONdata});
            console.log('gets here');
            $.ajax({
                url: "../restservices/order",
                method: "POST",
                beforeSend: function(xhr) {
                    token = window.sessionStorage.getItem("sessionToken");
                    console.log(token);
                    xhr.setRequestHeader('Authorization', 'Bearer ' + token);
                },
                data: JSONdata,
                success: function (response) {
                    console.log('Succes');
                },
                complete: function(response) {
                    if (response.status === 200) {
                        console.log("succes");
                    } else {
                        console.log("failure");
                    }
                }
            });
            localStorage.clear();
            console.log("until next time");
        }

        // formData = new FormData();
        // formData.append('email', email);
        // formData.append('products', cart);
        //
        // $.ajax({
        //     url     : "../restservices/order",
        //     method  : "POST",
        //     data    : formData,
        //     success : function(data) {
        //         alert(data);
        //     }
        // });
    });
});