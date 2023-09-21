const loginform = document.getElementById("formulario")
loginform.addEventListener("submit", evento => {
    evento.preventDefault()
    // console.log(evento)
    let u = document.getElementById("user").value
    let p = document.getElementById("password").value
    //alert("Usuario: " + u + "Contraseña: " + p)
    alert(`Usuario: ${u} y Contraseña: ${p}`)
})