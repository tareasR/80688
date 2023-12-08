import  Button  from "@mui/material/Button"
import  Dialog  from "@mui/material/Dialog"
import  DialogTitle  from "@mui/material/DialogTitle"
import  DialogContent  from "@mui/material/DialogContent"
import  DialogActions  from "@mui/material/DialogActions"
import { useState } from "react"

function Popup ({id}) {
    const [open, setOpen] = useState(true)
    const eventoAbrir = () => {setOpen(true)}
    const eventoCerrar = () => {setOpen(false)}

    return (
        <>
            <div>
                <Button onClick={eventoAbrir}>Mostrar Popup</Button>
                <Dialog open={open} onClose={eventoCerrar}>
                    <DialogTitle>Ejemplo Diálogo</DialogTitle>
                    <DialogContent>
                        Información a mostrar {id}
                    </DialogContent>
                    <DialogActions>
                         <Button onClick={eventoCerrar}>Cerrar</Button>
                    </DialogActions>
                </Dialog>
            </div>
        </>
    )
}

export default Popup