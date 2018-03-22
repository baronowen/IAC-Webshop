$(document).ready(function () {

    $('#orderForm').submit( function (event) {
        event.preventDefault();

        // var JSONdata = localStorage.getItem("cartProducts");
        // $.ajax({
        //     url: "../restservices/order",
        //     method: "POST",
        //     beforeSend: [function(xhr) {
        //         window.sessionStorage.getItem("sessionToken");
        //         xhr.setRequestHeader('Authorization', 'Bearer ' + token);
        //     }],
        //     data: JSONdata,
        //     success: function (response) {
        //         console.log('Succes');
        //     },
        //     complete: [function(response) {
        //         if (response.status === 200) {
        //             console.log("succes");
        //         } else {
        //             console.log("failure");
        //         }
        //     }]
        // });

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