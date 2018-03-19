function login() {

    var data = $("#login").serialize();
    $.post("../restservices/authentication",
        data,
        function(response) {

            var storage = JSON.parse(response);
            window.sessionStorage.setItem("sessionToken",storage.token);
            window.sessionStorage.setItem("role", storage.role);

        }).fail(function(jqXHR, textStatus, errorThrown) {
            console.log("Login Failed!");
            console.log(textStatus);
            console.log(errorThrown);
    })
}