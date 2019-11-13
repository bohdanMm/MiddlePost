var basicURL = "http://localhost:8080";

document.getElementById('icon').addEventListener('click', function () {
    window.location.href = '../index.html';
});

function login() {

    console.log("Log in.");
    event.preventDefault();

    var customerForLogIn = {
        email: $('#email').val(),
        password: $('#pass').val()
    };

    $.ajax({
        url: basicURL + "/customer/logIn",
        type: "POST",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(customerForLogIn)
    })
        .done(function (response) {
            sessionStorage.setItem('currentCustomer', JSON.stringify(response));
            window.location.href = '../index.html';
        })
        .fail(function (e) {
            sessionStorage.clear();
            alert("ERROR:\n" + e.responseJSON.message);
        })
}