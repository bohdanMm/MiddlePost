var basicURL = "http://localhost:8080";

document.getElementById('icon').addEventListener('click', function(){
    window.location.href = '../index.html';
});

function login() {

    console.log("Log in.");
    event.preventDefault();

    var customerForLogIn = {
        email: $('#email').val(),
        password: $('#pasportData').val()
    };

    var needGo = false;
    $.ajax({
        url: basicURL + "/customer/logIn",
        type: "POST",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(customerForLogIn)
    })
        .done(function (data) {
            window.location.href = '../index.html';
        })
        .fail(function (e) {
            alert("ERROR:\n" + e.responseJSON.errors[0].defaultMessage);
        })
}
