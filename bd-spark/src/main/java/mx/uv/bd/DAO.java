package mx.uv.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
    private Conexion conexion = new Conexion();

    public String crearUsuario(Usuario u) {
        PreparedStatement stm = null;
        Connection con = null;
        ResultSet rs = null;
        String msj = "";

        con = conexion.getConnection();
        try {
            String sql = "INSERT INTO usuarios (id, email, password) VALUES (?, ?, ?)";
            stm = con.prepareStatement(sql);
            stm.setString(1, u.getId());
            stm.setString(2, u.getEmail());
            stm.setString(3, u.getPassword());

            if (stm.executeUpdate() > 0)
                msj = "El usuario fue agregado";
            else
                msj = "El usuario no se agrego";

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null){
                try {
                    stm.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return msj;
    }
}
