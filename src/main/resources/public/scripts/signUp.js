var basicURL = "http://localhost:8080";

document.getElementById('icon').addEventListener('click', function () {
    window.location.href = '../index.html';
});

function validate() {
    var pass = document.forms["registrationForm"]["pass"];
    var passConf = document.forms["registrationForm"]["confirmPass"];
    if (pass.value != passConf.value) {
        alert("Passwords do not mutch!");
        pass.value ="";
        passConf.value ="";
        return false;
    }
    event.preventDefault();

    var customerForSave = {
        name: $('#name').val(),
        surname: $('#surname').val(),
        telephoneNumber: $('#phoneNumber').val(),
        email: $('#email').val(),
        password: $('#pass').val(),
        pasportData: $('#pasportData').val()

    };

    $.ajax({
        url: basicURL + "/customer",
        type: "POST",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(customerForSave)
    })
        .done(function (response) {
            sessionStorage.setItem('currentCustomer', JSON.stringify(response));
            window.location.href = '../index.html';
        })
        .fail(function (e) {
            sessionStorage.clear();
            alert("ERROR:\n" + e.responseJSON.errors[0].defaultMessage);
        });
}