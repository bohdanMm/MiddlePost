var basicURL = "http://localhost:8080";
var distrPage = 0;
var regionPage = 0;
var localityPage =0;

document.addEventListener('DOMContentLoaded', showUserInHeader);
document.addEventListener('DOMContentLoaded', setElemVisability);
document.addEventListener('DOMContentLoaded', function () {
    getDistTable(distrPage);
});
document.addEventListener('DOMContentLoaded', function () {
    getRegionTable(regionPage);
});
document.addEventListener('DOMContentLoaded', function () {
    getLocalityesTable(localityPage);
});

document.getElementById("itemToConfigure").addEventListener('change', setElemVisability);

document.addEventListener('DOMContentLoaded', getDistrictsForSelect);

document.getElementById("itemToConfigure").addEventListener('change', getRegionForLocalitySelect);
document.getElementById("localityDistrSel").addEventListener('change', getRegionForLocalitySelect);




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
            for (var i = table.rows.length - 1; i > 0; i--) {
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
            alert("Error in load districts. " + e.responseJSON.message)
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
            for (var i = table.rows.length - 1; i > 0; i--) {
                table.deleteRow(i);
            }
            distrPage = 0;
            getDistTable(distrPage);
        })
        .fail(function (e) {
            alert("ERROR:\n" + e.responseJSON.message);
        })
}


function saveRegion() {
    event.preventDefault();
    var regionForSave = {
        regionName: $("#regionName").val(),
        districtName: $('#refionDistrSel').val()
    };

    $.ajax({
        url: basicURL + "/region",
        type: "POST",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(regionForSave)
    })
        .done(function (data) {
            var table = document.getElementById("regionTable");
            for (var i = table.rows.length - 1; i > 0; i--) {
                table.deleteRow(i);
            }
            regionPage = 0;
            getRegionTable(distrPage);
        })
        .fail(function (e) {
            alert("ERROR:\n" + e.responseJSON.errors[0].defaultMessage);
        });
}

function getRegionTable(page) {
    console.log(page);
    var url = basicURL + "/region?page= " + page + "&size=20&sortBy=regionName&direction=ASC";
    $.ajax({
        url: url,
        type: "GET",
        dataType: "json"
    })
        .done(function (response) {
            var regions = response.data;
            var table = document.getElementById("regionTable");
            for (var i = 0; i < regions.length; i++) {
                var row = table.insertRow();
                var region = regions[i];
                for (var j = 0; j < table.rows[0].cells.length + 1; j++) {
                    row.insertCell();
                };
                table.rows[table.rows.length - 1].cells[0].innerHTML = region.id;
                table.rows[table.rows.length - 1].cells[1].innerHTML = region.regionName;
                table.rows[table.rows.length - 1].cells[2].innerHTML = region.districtName;
                table.rows[table.rows.length - 1].cells[3].innerHTML = '<button onclick="deleteRegion(' + region.id + ')">X</button>';

            }
        })
        .fail(function (e) {
            alert("Error in load regions. " + e.responseJSON.message)
        })
}

function deleteRegion(id) {
    $.ajax({
        url: basicURL + "/region?id=" + id,
        type: "DELETE",
        dataType: "json"
    })
        .done(function (data) {
            var table = document.getElementById("regionTable");
            for (var i = table.rows.length - 1; i > 0; i--) {
                table.deleteRow(i);
            }
            regionPage = 0;
            getRegionTable(distrPage);
        })
        .fail(function (e) {
            alert("ERROR:\n" + e.responseJSON.message);
        })
}

function getDistrictsForSelect() {
    var url = basicURL + "/district?page=0&size=100&sortBy=districtName&direction=ASC";
    $.ajax({
        url: url,
        type: "GET",
        dataType: "json"
    })
        .done(function (response) {
            var districts = response.data;
            var distrSelects = document.getElementsByClassName('distrSelect');
            for (var i = 0; i < districts.length; i++) {
                var district = districts[i];
                var opt = document.createElement('option');
                opt.value = district.districtName;
                opt.innerHTML = district.districtName;
                for (var j = 0; j < distrSelects.length; j++) {
                    distrSelects[j].appendChild(opt.cloneNode(true));
                }
            }
        })
        .fail(function (e) {
            alert("Error in load districts. " + e.responseJSON.message)
        })
}

function getRegionForLocalitySelect() {
    var url = basicURL + "/district/byName?name=" + document.getElementsByClassName("distrSelect")[1].value;
    $.ajax({
        url: url,
        type: "GET",
        dataType: "json",
        async: false
    })
        .done(function (response) {
            var regions = response.regions;
            var regionSelect = document.getElementById('localityRegionSel');
            for (var i = 0; i < regions.length; i++) {
                var region = regions[i];
                var opt = document.createElement('option');
                opt.value = region.regionName;
                opt.innerHTML = region.regionName;
                regionSelect.appendChild(opt);
            }
        })
        .fail(function (e) {
            alert("Error in load regions. " + e.responseJSON.message)
        })
}

function saveLocality() {
    event.preventDefault();
    var localityForSave = {
        regionName: $("#localityRegionSel").val(),
        districtName: $('#localityDistrSel').val(),
        localityName: $('#localityName').val()
    };

    $.ajax({
        url: basicURL + "/locality",
        type: "POST",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(localityForSave)
    })
        .done(function (data) {
            console.log(data);
            var table = document.getElementById("loclaitiesTable");
            for (var i = table.rows.length - 1; i > 0; i--) {
                table.deleteRow(i);
            }
            localityPage = 0;
            getLocalityesTable(localityPage);
        })
        .fail(function (e) {
            alert("ERROR:\n" + e.responseJSON.errors[0].defaultMessage);
        });
}

function getLocalityesTable(page) {
    var url = basicURL + "/locality?page= " + page + "&size=20&sortBy=localityName&direction=ASC";
    $.ajax({
        url: url,
        type: "GET",
        dataType: "json"
    })
        .done(function (response) {
            var localities = response.data;
            var table = document.getElementById("loclaitiesTable");
            for (var i = 0; i < localities.length; i++) {
                var row = table.insertRow();
                var locality = localities[i];
                for (var j = 0; j < table.rows[0].cells.length + 1; j++) {
                    row.insertCell();
                };
                table.rows[table.rows.length - 1].cells[0].innerHTML = locality.id;
                table.rows[table.rows.length - 1].cells[1].innerHTML = locality.localityName;
                table.rows[table.rows.length - 1].cells[2].innerHTML = locality.districtName;
                table.rows[table.rows.length - 1].cells[3].innerHTML = locality.regionName;
                table.rows[table.rows.length - 1].cells[4].innerHTML = '<button onclick="deleteLocality(' + locality.id + ')">X</button>';

            }
        })
        .fail(function (e) {
            alert("Error in load localityes. " + e.responseJSON.message)
        })
}

function deleteLocality(id) {
    $.ajax({
        url: basicURL + "/locality?id=" + id,
        type: "DELETE",
        dataType: "json"
    })
        .done(function (data) {
            var table = document.getElementById("loclaitiesTable");
            for (var i = table.rows.length - 1; i > 0; i--) {
                table.deleteRow(i);
            }
            localityPage = 0;
            getLocalityesTable(localityPage);
        })
        .fail(function (e) {
            alert("ERROR:\n" + e.responseJSON.message);
        })
}