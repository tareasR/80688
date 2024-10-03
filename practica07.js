const app = document.getElementById("app")
let v1 = 1
let v2 = 2
const fieldset = (p1, p2, p3, id1, id2) => {
    return `
        <fieldset>
            <legend>${p1}</legend>
            <label for="${id1}">${p2}</label>
            <input type="text" id="${id1}">
            <label for="${id2}">${p3}</label>
            <input type="text" id="${id2}">
        </fieldset>
    `
}
app.innerHTML = funcionx()

function funcionx(params) {
    let resultado;
    for (let index = 0; index < 2; index++) {
        resultado += fieldset("soy yo", "nombre", "correo", index+1, index+2) 
    }
    return resultado
}