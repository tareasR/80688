function boton4() {
    window.alert('mensaje4');
}

function boton1() {
    window.alert('mensaje1');
}

// defino una variable llamada btnEnviar1 la cual "apunta" al elemento HTML identificado por el ID con nombre "btnEnviar1"
var btnEnviar1 = document.getElementById("btnEnviar1");
btnEnviar1.style.color = "red";
// se agrega un listener (escucha) para cachar el evento de clic en botón
// la acción que ocurrirá al dar clic está determinada por la función es anónima function (){}
btnEnviar1.addEventListener("click", function () { 
    window.alert('mensaje1'); 
});

var btnEnviar5 = document.getElementById("btnEnviar5");
// una función callback se llama sin parentesis, porque de lo contrario es ejecutar la función
// la función callback significa transferir el control a 
btnEnviar5.addEventListener("click", callback);

function callback() {
   cambiarColor("blue");   
   cambiarEstado();
}

var emailHelp = document.getElementById("emailHelp");
function cambiarColor(color) {
    emailHelp.style.color = color;
}

var exampleCheck1 = document.getElementById("exampleCheck1");
function cambiarEstado() {
    exampleCheck1.checked = true;
}

