const btnColores = document.getElementById("btnColores")
btnColores.addEventListener("click",()=>{
    // axios.get('https://backend-production-3b22.up.railway.app/colores')
    axios.get('http://localhost/colores')
    .then(
        response => {
            console.log(response)
            console.log(response.data)
            const resultado=document.getElementById("resultado")
            e = "<table>"
            response.data.forEach(elemento => {
                console.log (elemento.id)
                e = e + '<tr>' +'<td>' + elemento.id + '</td>' + '<td>'  +elemento.nombreColor+ '</td>' + '</tr>'
            });
            resultado.innerHTML = e + '</table>'
        }
    )
    .catch(
        error => {
            console.log(error)
        }
    )
})