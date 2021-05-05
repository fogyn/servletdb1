var myVar = setInterval(myTimer, 1000);

function myTimer() {
    var d = new Date();
    document.getElementById("data3").innerHTML = d.toLocaleTimeString();
}

function newsClick(param){
    //var t = par;
    //var el = document.getElementByClassName(id);
    //var elements = document.getElementsByClassName(name);
    //console.log(t);
    var el = document.getElementById(param);

    //var el = elements[0];
    if (el.style.display == "block") {
        el.style.display = "none";

    } else {
        el.style.display = "block";

    }

}