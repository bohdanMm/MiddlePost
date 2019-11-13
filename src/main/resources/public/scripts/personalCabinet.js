var basicURL = "http://localhost:8080";

document.addEventListener('DOMContentLoaded', showUserInHeader);
document.addEventListener('DOMContentLoaded', getPackagesData);

document.getElementById('icon').addEventListener('click', function () {
    window.location.href = '../index.html';
});

function getPackagesData() {
    var table = document.getElementById("usersHistoryTable");

    var custFromIdArr = [];

    var custToIdArr = [];

    $.ajax({
        url: basicURL + "/package?page=0&size=100&",
        type: "GET",
        dataType: "json"
    })
        .done(function (response) {
            var packages = response.data;
            for (var i = 0; i < packages.length; i++) {
                var row = table.insertRow();
                var package = packages[i];
                for (var j = 0; j < 9; j++) {
                    row.insertCell();
                };
                table.rows[table.rows.length - 1].cells[0].innerHTML = package.id;
                table.rows[table.rows.length - 1].cells[1].innerHTML = package.weight;
                table.rows[table.rows.length - 1].cells[2].innerHTML = package.statusName;
                getCustomerFrom(package.customerFromId, table, table.rows.length - 1);
                getCustomerTo(package.customerToId, table, table.rows.length - 1);
                table.rows[table.rows.length - 1].cells[7].innerHTML = package.sandDate;
                if (package.reciveDate == null) {
                    table.rows[table.rows.length - 1].cells[8].innerHTML = "In the way";
                } else {
                    table.rows[table.rows.length - 1].cells[8].innerHTML = package.reciveDate;
                }
            }
        })
        .fail(function (e) {
            custFromIdArr = [];
            custToIdArr = [];
            alert("ERROR:\n" + e.responseJSON.message);
        })
}

function getCustomerFrom(id, table, row) {
    $.ajax({
        url: basicURL + "/customer/" + id,
        type: "GET",
        dataType: "json"
    })
        .done(function (response) {
            console.log(response);
            table.rows[row].cells[5].innerHTML = response.name + " " + response.surname;
        })
        .fail(function (e) {
            alert("ERROR:\n" + e.responseJSON.message);
        });
}

function getCustomerTo(id, table, row) {
    $.ajax({
        url: basicURL + "/customer/" + id,
        type: "GET",
        dataType: "json"
    })
        .done(function (response) {
            console.log(response);
            table.rows[row].cells[6].innerHTML = response.name + " " + response.surname;
        })
        .fail(function (e) {
            alert("ERROR:\n" + e.responseJSON.message);
        });
}