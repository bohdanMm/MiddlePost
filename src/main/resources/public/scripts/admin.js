var basicURL = "http://localhost:8080";

document.addEventListener('DOMContentLoaded', showUserInHeader);
document.addEventListener('DOMContentLoaded', setElemVisability);

document.getElementById("itemToConfigure").addEventListener('change', setElemVisability);


document.getElementById('icon').addEventListener('click', function () {
    window.location.href = '../index.html';
});

function setElemVisability(){
    var choose = document.getElementById("itemToConfigure").value;
    var myOpts = document.getElementById('itemToConfigure').options;
    for(var i = 0; i < myOpts.length; i++){
        var opt = myOpts[i].value;
        if( opt == choose){
            var showItems = document.getElementsByClassName(opt);
            for(var j = 0; j < showItems.length; j++){
                showItems[j].style.display='block';
            }
        } else {
            var showItems = document.getElementsByClassName(opt);
            for(var j = 0; j < showItems.length; j++){
                showItems[j].style.display='none';
            }
        }
    }

}