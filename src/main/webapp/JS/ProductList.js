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
        success: [function(data) {
            $.each(data.products,function(i,product) {
                console.log(product);
                console.log(product.name);
                console.log(product.price);
                console.log(product.description);
                // console.log(cat_product.product.name);
                // i++;
                $(".pList").append(
                    "<div class=container-fluid>"> +
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
                                            "<label id=name>" + product.name + "</label><br>" +
                                            "<label> Price:</label>" +
                                            "<label id=price>" + product.price + "</label><br>" +
                                            "<label> SalePrice:</label>" +
                                            "<label id=saleprice></label><br>" +
                                            "<label> Description: </label>" +
                                            "<label id=descr>" + product.description + "</label>" +
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
        }]
    });
};