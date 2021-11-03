package mx.uv.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private Conexion conexion = new Conexion();

    public String crearUsuario(Usuario u) {
        PreparedStatement stm = null;
        Connection con = null;
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
            if (stm != null) {
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

    public List<Usuario> listaUsuario() {
        Statement stm = null;
        ResultSet rs = null;
        Connection con = null;
        List<Usuario> resultado = new ArrayList<>();

        con = conexion.getConnection();
        try {
            String sql = "SELECT * FROM usuarios";
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Usuario u = new Usuario(rs.getString("id"), rs.getString("email"), rs.getString("password"));
                resultado.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed
        
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { sqlEx.printStackTrace(); } // ignore
                rs = null;
            }
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException sqlEx) { sqlEx.printStackTrace(); } // ignore
                stm = null;
            }
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }
}
