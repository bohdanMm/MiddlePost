var basicURL = "http://localhost:8080";
var distrPage = 0;

document.addEventListener('DOMContentLoaded', showUserInHeader);
document.addEventListener('DOMContentLoaded', setElemVisability);
document.addEventListener('DOMContentLoaded', function () {
    getDistTable(distrPage);
});


document.getElementById("itemToConfigure").addEventListener('change', setElemVisability);



document.getElementById('icon').addEventListener('click', function () {
    window.location.href = '../index.html';
});

function setElemVisability() {
    var choose = document.getElementById("itemToConfigure").value;
    var myOpts = document.getElementById('itemToConfigure').options;
    // var rememberOpt;
    for (var i = 0; i < myOpts.length; i++) {
        var opt = myOpts[i].value;
        if (opt == choose) {
            showItems("." + opt);
            //    rememberOpt = opt;
            //    var whatToDo = document.querySelector('select'+ "." +opt);
            //    whatToDo.addEventListener('change', function(){
            //     for(var j = 0; j < whatToDo.options.length; j++){
            //         if(whatToDo.options[j].value == whatToDo.value){
            //             console.log("." + rememberOpt + " ." + whatToDo.value);
            //             showItems("." + rememberOpt + " ." + whatToDo.value);
            //         } else {
            //             hideItems("." + rememberOpt + " ." + whatToDo.value);
            //         }
            //     }
            // });
        } else {
            hideItems("." + opt);
        }
    }
}

function showItems(querySel) {
    var showItems = document.querySelectorAll(querySel);
    for (var j = 0; j < showItems.length; j++) {
        showItems[j].style.display = 'flex';
    }
}

function hideItems(querySel) {
    var showItems = document.querySelectorAll(querySel);
    for (var j = 0; j < showItems.length; j++) {
        showItems[j].style.display = 'none';
    }
}

function saveDistrict() {
    event.preventDefault();
    var districtForSave = {
        districtName: $('#distrName').val(),
    };

    $.ajax({
        url: basicURL + "/district",
        type: "POST",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(districtForSave)
    })
        .done(function (data) {
            var table = document.getElementById("distrTable");
            for (var i = table.rows.length - 1; i > 1; i--) {
                table.deleteRow(i);
            }
            distrPage = 0;
            getDistTable(distrPage);
        })
        .fail(function (e) {
            alert("ERROR:\n" + e.responseJSON.errors[0].defaultMessage);
        });
}

function getDistTable(page) {
    var url = basicURL + "/district?page= " + page + "&size=20&sortBy=districtName&direction=ASC";
    $.ajax({
        url: url,
        type: "GET",
        dataType: "json"
    })
        .done(function (response) {
            var districts = response.data;
            var table = document.getElementById("distrTable");
            for (var i = 0; i < districts.length; i++) {
                var row = table.insertRow();
                var district = districts[i];
                for (var j = 0; j < table.rows[0].cells.length + 1; j++) {
                    row.insertCell();
                };
                table.rows[table.rows.length - 1].cells[0].innerHTML = district.id;
                table.rows[table.rows.length - 1].cells[1].innerHTML = district.districtName;
                table.rows[table.rows.length - 1].cells[2].innerHTML = '<button onclick="deleteDistrict(' + district.id + ')">X</button>';

            }
        })
        .fail(function (e) {
            alert("Error in load brand. " + e.responseJSON.message)
        })
}

function deleteDistrict(id) {
    $.ajax({
        url: basicURL + "/district?id=" + id,
        type: "DELETE",
        dataType: "json"
    })
        .done(function (data) {
            var table = document.getElementById("distrTable");
            for (var i = table.rows.length - 1; i > 1; i--) {
                table.deleteRow(i);
            }
            distrPage = 0;
            getDistTable(distrPage);
        })
        .fail(function (e) {
            alert("ERROR:\n" + e.responseJSON.message);
        })
}