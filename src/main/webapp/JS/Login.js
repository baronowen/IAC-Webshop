function login() {

    var data = $("#login").serialize();

    $.post("../restservices/authentication",
        data,
        function(response) {

            var storage = JSON.parse(response);
            sessionStorage.setItem("sessionToken",storage.token);
            sessionStorage.setItem("role", storage.role);
            sessionStorage.setItem("email", storage.emailAdr);
            location.href=("../HTML/Welcome.html");

        }).fail(function(jqXHR, textStatus, errorThrown) {
            console.log("Login Failed!");
            console.log(textStatus);
            console.log(errorThrown);
    });

}