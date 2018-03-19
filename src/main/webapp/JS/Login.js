function login() {
    console.log("trying to log in");
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
            console.log("success");
            var storage = JSON.parse(response);
            window.sessionStorage.setItem("sessionToken",storage.token);
            window.sessionStorage.setItem("role", storage.role);
            // window.location.replace("../HTML/Welcome.html");

        }).fail(function(jqXHR, textStatus, errorThrown) {
            console.log("Login Failed!");
            console.log(textStatus);
            console.log(errorThrown);
    })

}