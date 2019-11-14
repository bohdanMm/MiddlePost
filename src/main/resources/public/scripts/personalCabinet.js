var basicURL = "http://localhost:8080";

document.addEventListener('DOMContentLoaded', showUserInHeader);
document.addEventListener('DOMContentLoaded', getPackagesData);

document.getElementById('icon').addEventListener('click', function () {
    window.location.href = '../index.html';
});

function getPackagesData() {
    var table = document.getElementById("usersHistoryTable");

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
                for (var j = 0; j < table.rows[0].cells.length; j++) {
                    row.insertCell();
                };
                table.rows[table.rows.length - 1].cells[0].innerHTML = package.id;
                table.rows[table.rows.length - 1].cells[1].innerHTML = package.weight;
                table.rows[table.rows.length - 1].cells[2].innerHTML = package.statusName;

                table.rows[table.rows.length - 1].cells[3].innerHTML = package.localityFromName;
                table.rows[table.rows.length - 1].cells[4].innerHTML = package.localityToName;

                table.rows[table.rows.length - 1].cells[5].innerHTML = package.locationFromStreet;
                table.rows[table.rows.length - 1].cells[6].innerHTML = package.locationToStreet;

                table.rows[table.rows.length - 1].cells[7].innerHTML = package.buildingFromNumber;
                table.rows[table.rows.length - 1].cells[8].innerHTML = package.buildingFromNumber;


                getCustomer(package.customerFromId, table, table.rows.length - 1, 9);
                getCustomer(package.customerToId, table, table.rows.length - 1, 10);
                table.rows[table.rows.length - 1].cells[11].innerHTML = package.sandDate;
                if (package.reciveDate == null) {
                    table.rows[table.rows.length - 1].cells[12].innerHTML = "In the way";
                } else {
                    table.rows[table.rows.length - 1].cells[12].innerHTML = package.reciveDate;
                }
            }
        })
        .fail(function (e) {
            custFromIdArr = [];
            custToIdArr = [];
            alert("ERROR:\n" + e.responseJSON.message);
        })
}

function getCustomer(id, table, row, cell) {
    $.ajax({
        url: basicURL + "/customer/" + id,
        type: "GET",
        dataType: "json"
    })
        .done(function (response) {
            table.rows[row].cells[cell].innerHTML = response.name + " " + response.surname;
        })
        .fail(function (e) {
            alert("ERROR:\n" + e.responseJSON.message);
        });
}
