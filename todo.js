const cars = ["de que color es el caballo blanco de napoleon", "que color te gusta más", "Saab", "Ford", "Fiat", "Audi"];
const algo = ["blanco", "rojo", "verde", "amarillo"]

var btnAgregar = document.getElementById("agregar");
btnAgregar.addEventListener("click", marcas);

var txtTarea = document.getElementById("tarea");
var listTareas = document.getElementById("tareas");

function agregar() {
    let tarea = document.createElement("li");
    tarea.textContent = txtTarea.value;
    let boton1 = document.createElement("button")
    let boton2 = document.createElement("button")
    let boton3 = document.createElement("button")
    boton1.innerHTML = "editar"
    boton2.innerHTML = "borrar"
    boton3.innerHTML = "agregar respuestas"
    listTareas.appendChild(tarea);
    listTareas.appendChild(boton3)
    listTareas.appendChild(boton1)
    listTareas.appendChild(boton2)
    console.log("dentro de función" + tarea);
}

console.log("fuera de función:" + tarea);

function marcas() {
    let text = "";
    for (let i = 0; i < cars.length; i++) {
        let tarea = document.createElement("li");
        let video1 = document.createElement("video");
        // let video2 = document.createElement("video");
        // let boton1 = document.createElement("button");
        // let boton2 = document.createElement("button");
        // boton1.innerHTML = "camara"
        // boton2.innerHTML = "parar"
        // video2.src = "video.mp4"
        video1.controls = true
        // video2.controls = true
        tarea.textContent = cars[i];
        listTareas.appendChild(tarea);
        listTareas.appendChild(video1)
        // listTareas.appendChild(video2)
        // listTareas.appendChild(boton1)
        // listTareas.appendChild(boton2)
        for (let i=0; i < algo.length; i++){
            let respuesta = document.createElement("input")
            let texto = document.createTextNode(algo[i])
            respuesta.value = algo[i]
            respuesta.type ="radio"
            listTareas.appendChild(respuesta)
            listTareas.appendChild(texto)

        }
    }
}