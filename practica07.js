const loginform = document.getElementById("formulario")
const miFieldset = (legend, txt1, txt2) => {
    return `
    <fieldset>
        <legend>${legend}</legend>
        <label for=${txt1}>${txt1}</label>
        <input type="text" id=${txt1}>
        <label for=${txt2}>${txt2}</label>
        <input type="text" id=${txt2}>
    </fieldset>
    `
}

loginform.innerHTML = miFieldset("Inf Personal", "nombre", "correo")
loginform.innerHTML += miFieldset("Inf Direccion", "direccion", "ciudad")