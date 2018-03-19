function login() {

    var data = $("#login").serialize();

    console.log(data);

    // $.ajax({
    //     url: "../restservices/authentication",
    //     method: "POST",
    //     data: data,
    //     succes: function (response) {
    //         console.log("SUCCES!");
    //     },
    //     complete: function (response) {
    //         if (response.status === 200) {
    //             console.log("SUCCES");
    //         } else {
    //             console.log("Error");
    //         }
    //     }
    // });

    $.post("../restservices/authentication",
        data,
        function(response) {

            var storage = JSON.parse(response);
            window.sessionStorage.setItem("sessionToken",storage.token);
            window.sessionStorage.setItem("role", storage.role);
            location.replace("../HTML/Welcome.html");

        }).fail(function(jqXHR, textStatus, errorThrown) {
            console.log("Login Failed!");
            console.log(textStatus);
            console.log(errorThrown);
    });

}