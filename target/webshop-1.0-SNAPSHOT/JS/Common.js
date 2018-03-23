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
                        "<li><a href='../HTML/ProductList.html'>" + categories.name + "</a></li>"
                    )
                    // window.sessionStorage.setItem('catId', categories.id);
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