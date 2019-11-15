document.getElementById('icon').addEventListener('click', function () {
    window.location.href = 'index.html';
});

document.addEventListener('DOMContentLoaded', checkLogIn);
function checkLogIn() {
    if (sessionStorage.length == 0) {
        document.getElementById("references").innerHTML = '<a href="pages/signIn.html" class="refs">Sign in</a> <a href="pages/signUp.html" class="refs">Sign up</a>';
    } else {
        var pageHref = document.createElement("a");
        var href;
        if(JSON.parse(sessionStorage.getItem('currentCustomer')).status == "admin"){
            href = "pages/adminPage.html";
        } else if(JSON.parse(sessionStorage.getItem('currentCustomer')).status == "worker") {
            href = "pages/workerPage.html";
        } else {
            href = "pages/personalCabinet.html";
        }
        pageHref.href = href;
        pageHref.className = "refs";
        pageHref.innerHTML = JSON.parse(sessionStorage.getItem('currentCustomer')).name;
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
    window.location.href = 'index.html';
}
