function insertar(parametro) {
    document.getElementById('salida').value += parametro;
}

var tres = document.getElementById("3");
tres.addEventListener("click", function () {
    insertar(3);
})
var cuatro = document.getElementById("4");
cuatro.addEventListener("click", function () {
    insertar(4);
})
var cinco = document.getElementById("5");
cinco.addEventListener("click", function () {
    insertar(5);
})

var igual = document.getElementById("igual");
igual.addEventListener("click", function () {
    document.getElementById('salida').value = eval(document.getElementById('salida').value);
})