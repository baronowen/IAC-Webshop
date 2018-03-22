$(document).ready(function () {

    $('#orderForm').submit( function (event) {
        event.preventDefault();

        if(checkValidation())
        {
            return null;
        }

        var form = $(this);
        var formData = form.serialize();
        var cart = loadCart();


    })

});

function errorLabel(errorMsg){
    return jQuery('<div/>', {
        class: 'alert alert-danger',
        text: errorMsg
    });
}