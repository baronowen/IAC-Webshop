$(document).ready(initPage());

function initPage() {

    loadCategories();
    loadProducts();

}

function loadProducts() {
    console.log("../restservices/category/2");
    var i = 0;
    $.ajax({
        url: "../restservices/category/2",
        method: "GET",
        success: [function(data) {
            $.each(data,function(i,cat_product) {
                console.log(cat_product.product.name);
                // i++;
                // if(i>1) {
                //     $(".pList").append(
                //         "<div class=row>" +
                //             "<div class=col-md-3>" +
                //                 "<div class=test></div>" +
                //             "</div>" +
                //             "<div class=col-md-6>" +
                //                 "<div class=list>" +
                //                     "<div class=col-md-4>" +
                //                         "<div class=picture></div>" +
                //                     "</div>" +
                //                     "<div class=col-md-8>" +
                //                         "<div class=info>" +
                //                             "<label> Name:</label>" +
                //                             "<label id=name>" + cat_product.product.name + "</label><br>" +
                //                             "<label> Price:</label>" +
                //                             "<label id=price>" + cat_product.product.price + "</label><br>" +
                //                             "<label> SalePrice:</label>" +
                //                             "<label id=saleprice></label><br>" +
                //                             "<label> Description: </label>" +
                //                             "<label id=descr>" + cat_product.product.description + "</label>" +
                //                         "</div>" +
                //                     "</div>" +
                //                 "</div>" +
                //             "</div>" +
                //             "<div class=col-md-3>" +
                //                 "<div class=test></div>" +
                //             "</div>" +
                //         "</div>"
                //     )
                // }
                $("#name_"+i+"").text(cat_product.products.name);
                $("#price_"+i+"").text(cat_product.products.price);
                $("#descr_"+i+"").text(cat_product.products.description);
            });
        }]
    });
};