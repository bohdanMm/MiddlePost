var isLogIn;


function showUserInHeader() {
    if (sessionStorage.length == 0) {
        document.getElementById("references").innerHTML = '<a href="signIn.html" class="refs">Sign in</a> <a href="signUp.html" class="refs">Sign up</a>';
    } else {
        var pageHref = document.createElement("a");
        var href;
        if(JSON.parse(sessionStorage.getItem('currentCustomer')).status == "admin"){
            href = "adminPage.html";
        } else if(JSON.parse(sessionStorage.getItem('currentCustomer')).status == "worker") {
            href = "worker.html";
        } else {
            href = "personalCabinet.html";
        }
        pageHref.href = href;
        pageHref.className = "refs";
        pageHref.innerHTML = JSON.parse(sessionStorage.getItem('currentCustomer')).name;
        console.log(pageHref);
        var refrences =  document.getElementById('references');
        refrences.appendChild(pageHref);
        var exit = document.createElement("a");
        exit.className = "refs";
        exit.href="#";
        exit.addEventListener("click", logOut);
        exit.innerHTML = "Log out";
        refrences.appendChild(exit);
    }
}

function logOut(){
    sessionStorage.clear();
    window.location.href = '../index.html';
}
