import { Button, Box, TextField } from "@mui/material"
import axios from "axios"
import { useState } from "react"
import Popup from "./Popup.jsx"

function Formulario(props) {
    const [Cargando, setCargando] = useState (false)
    const [datosFormulario, setDatosFormulario] = useState( {nombre:'', password:''} )

    const hacerPeticion = async () => {
        try {
            //const response = await axios.post('http://localhost:4567/json',  datosFormulario )
            // const response = await axios.get('http://localhost:4567/tipousuario',  {params:datosFormulario} )
            const response = await axios.post('http://localhost:4567/usuarios',  datosFormulario )
            console.log("hacerPeticion", response)
            setId(response.data.id)
            setMostrarPopup(true)
            return response.data
        } catch (error) {
            throw error
        }
    }

    const [id, setId] = useState('') 
    const [mostrarPopup, setMostrarPopup] = useState (false)

    const cambiosFormulario = (evento) => {
        //console.ºlog(evento.target)
        const {name, value} = evento.target
        setDatosFormulario( { ...datosFormulario, [name] : value })
    }

    const procesarFormulario = async (evento) => {
        evento.preventDefault()
        console.log("datos recuperados el form:", datosFormulario)
        setCargando(true)
        try {
            const response = await hacerPeticion()
            console.log("procesarFormulario", response)
            setCargando(false)
            if (datosFormulario.nombre === response.tipousuario) {
                console.log("ok el usuario es correcto")
            } else {
                console.log("error el usuario es incorrecto")
            }
        } catch (error) {
            console.log("error", error)
            setCargando(false)
        }
    }

    return (
        <>
            <h1>Inicio de Sesión</h1>
            <form onSubmit={ procesarFormulario }>
                <Box m={5}>
                    <TextField label="Nombre:" variant="outlined" fullWidth onChange={cambiosFormulario} name="nombre" value={datosFormulario.nombre}></TextField>
                </Box>
                <Box m={5}>
                    <TextField label="Contraseña:" variant="outlined" fullWidth onChange={cambiosFormulario} name="password" value={datosFormulario.password}></TextField>
                </Box>
                <Box m={5}>
                    <Button variant="contained" type="submit" color="primary" fullWidth disabled={Cargando}>Iniciar Sesión</Button>
                </Box>
                <Box m={5}>
                    {mostrarPopup && <Popup id={id}/>}
                </Box>
            </form>
        </>
    )
}

export default Formulario