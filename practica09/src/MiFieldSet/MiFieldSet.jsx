import './MiFieldSet.css'

function MiFieldSet(params) {
    // p1 es el título
    // id1 es el id para p2
    // p2 es el nombre
    // id2 es el ide para p3
    // p3 es el password
    const {p1, id1, p2, id2, p3} = params
    return (
        <>
            <fieldset>
                <legend>{p1}</legend>
                <label htmlFor={id1}>{p2}</label>
                <input type="text" id={id1}></input>
                <label htmlFor={id2}>{p3}</label>
                {/* entidad nula como cierre */}
                <input type="text" id={id2}/>
            </fieldset>
        </>
    )
}

export default MiFieldSet