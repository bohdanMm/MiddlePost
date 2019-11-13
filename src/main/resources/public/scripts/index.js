document.getElementById('icon').addEventListener('click', function () {
    window.location.href = 'index.html';
});

document.addEventListener('DOMContentLoaded', checkLogIn);
function checkLogIn() {
    if (sessionStorage.length == 0) {
        document.getElementById("references").innerHTML = '<a href="pages/signIn.html" class="refs">Sign in</a> <a href="pages/signUp.html" class="refs">Sign up</a>';
    } else {
        document.getElementById('references').innerHTML = '<a href="pages/personalCabinet.html" class="refs">' +
            JSON.parse(sessionStorage.getItem('currentCustomer')).name + '</a>'+
            '<a href="#" id="exit" class="refs" onclick="exit()">Log out</a>';
    }
}
function exit(){
    sessionStorage.clear();
    window.location.href = '../index.html';
}
