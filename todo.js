const cars = ["BMW", "Volvo", "Saab", "Ford", "Fiat", "Audi"];

var btnAgregar = document.getElementById("agregar");
btnAgregar.addEventListener("click", marcas);

var txtTarea = document.getElementById("tarea");
var listTareas = document.getElementById("tareas");

function agregar() {
    let tarea = document.createElement("li");
    tarea.textContent = txtTarea.value;
    listTareas.appendChild(tarea);
    console.log("dentro de función" + tarea);
}

console.log("fuera de función:" + tarea);

function marcas() {
    let text = "";
    for (let i = 0; i < cars.length; i++) {
        let tarea = document.createElement("li");
        tarea.textContent = cars[i];
        listTareas.appendChild(tarea);
    }
}