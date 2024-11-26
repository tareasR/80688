const bEnviar = document.getElementById("enviar")
bEnviar.addEventListener("click", () => {
    // creamos un objeto json llamado PARAMS
    const params = new URLSearchParams();
    params.append("nombreColor",document.getElementById("nombre").value)
    params.append("valorColor",document.getElementById("valor").value)
    // imprime el objeto de tipo URLSearchParams
    console.log(params)
    // imprime el objeto convertido a cadena
    console.log(params.toString())
    // imprime el objeto URLSearchParams convertido a un objeto JSON
    console.log(Object.fromEntries(params)) 
    // imprime el objeto como cadena, pero es no utilizable
    console.log(Object.fromEntries(params).toString())
    // imprime el objeto JSON convertido a una cadena 
    console.log(JSON.stringify(Object.fromEntries(params)))
    // llamada al backend
    // axios.post("https://backend-production-3b22.up.railway.app/colores", Object.fromEntries(params))
    axios.post("http://localhost/colores", Object.fromEntries(params))
    .then(
        respuesta => {
            console.log(respuesta)
            console.log(respuesta.data)
            const resultado = document.getElementById("resultado")
            resultado.innerHTML = respuesta.data.id
        }
    )
    .catch(
        error => {
            console.log(error)
        }
    )
})