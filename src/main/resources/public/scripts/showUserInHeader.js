var isLogIn;


function showUserInHeader() {
    if (sessionStorage.length == 0) {
        document.getElementById("references").innerHTML = '<a href="signIn.html" class="refs">Sign in</a> <a href="signUp.html" class="refs">Sign up</a>';
    } else {
        document.getElementById('references').innerHTML = '<a href="personalCabinet.html" class="refs">' +
            JSON.parse(sessionStorage.getItem('currentCustomer')).name + '</a>' +
            '<a href="#" id="exit" class="refs" onclick="exit()">Log out</a>';
    }
}

function exit(){
    sessionStorage.clear();
    window.location.href = '../index.html';
}
