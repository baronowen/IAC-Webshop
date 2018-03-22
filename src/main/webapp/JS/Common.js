function loadCategories() {
    var i = 0;
    $.ajax({
        url: "../restservices/category",
        method: "GET",
        success: [function(data) {
            $.each(data,function(i,categories) {
                i++;
                if(i>2) {
                    $(".dropdown-menu").append(
                        "<li><a href='productList.html'>" + categories.name + "</a></li>"
                    )
                    //TODO XSS afdekken in bovenstaande link als we XSS gaan afdekken.
                }
                $("#c"+i+"").text(categories.name);

            });
        }]
    });
}

function loadCart() {

    var cartStr = localStorage.getItem("cartProducts");
    return JSON.parse(cartStr);

}