$(document).ready(initPage());

function initPage() {

    loadCategories();
    loadProducts();

}

function loadProducts() {
    // var i = 0;
    $.ajax({
        url: "../restservices/category/1",
        method: "GET",
        success: [function(category) {
            console.log("Category:");
            console.log(category);
            console.log("\n");

            var products = category.products;
            $.each(products,function(i,product) {
                console.log("Product:");
                console.log(product)
                console.log("\n");

                var mainDiv = jQuery('<div/>', {
                    class: 'col-md-4',
                    text: product.name
                })

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
                    text: 'VOEG TE AAN WINKELWAGEN:'
                }).appendTo(mainDiv);


                mainDiv.appendTo('.pList');
            });
        }]
    });
}

function addToCart(i) {
    console.log('Add to cart');
    console.log(i);
}