var btnNoSubmit = document.getElementById("btnNoSubmit");
btnNoSubmit.addEventListener('click',function () {
    // recupero del formulario los valores de los campos email y password mediante sus IDs
    let email = document.getElementById('exampleInputEmail1').value;
    let pass  = document.getElementById('exampleInputPassword1').value;
    // construyo una URL de parámetros, es decir un quertystring
    var params = new URLSearchParams();
    params.append('nombre', email);
    params.append('password', pass);
    // console.log(params);
    // console.log(params.get('nombre'));
    // console.log(params.get('password'));
    // invocación de la librería AXIOS
    axios.post('http://localhost:4567/saludar', params)
        .then( function (response) {
            console.log("verdad: " + response);
        })
        .catch( function (error) {
            console.log("error: " + error);
        })
});