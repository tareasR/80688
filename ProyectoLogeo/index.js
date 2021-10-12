var btnLlamar = document.getElementById("llamar")
btnLlamar.addEventListener("click", function () {
    axios.get("http://localhost:4567/usuario")
    .then(function (response) {
        alert("mensaje:"+response.data.password);
    })
    .catch(function (error) {
        console.log(error);
    })
})

var btnUsuarios = document.getElementById("usuarios")
btnUsuarios.addEventListener("click", function () {
    axios.get("http://localhost:4567/usuarios")
    .then(function (response) {
        console.log(response.data);
    })
    .catch(function (error) {
        console.log(error);
    })
})

var btnRegistrar = document.getElementById("registrar")
btnRegistrar.addEventListener("click", function () {
    axios.post("http://localhost:4567/usuario", {
        email : document.getElementById("email").value,
        password : document.getElementById("password").value
    })
    .then(function (response) {
        alert("mensaje: usuario creado "+response.data.status+" con id: "+response.data.id);
    })
    .catch(function (error) {
        console.log(error);
    })
})


var btnPagina = document.getElementById("pagina")
btnPagina.addEventListener("click",function () {
    axios.get("http://localhost:4567/pagina")
    .then(function (response) {
        if(response.data.access =="ok")
            window.location.replace(response.data.page)
        else
            alert("datos equivocados");
    })
    .catch(function (error) {
        console.log(error);
    })
})