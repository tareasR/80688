const btnColores = document.getElementById("btnColores")
btnColores.addEventListener("click",()=>{
    axios.get('http://localhost:8080/colores')
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