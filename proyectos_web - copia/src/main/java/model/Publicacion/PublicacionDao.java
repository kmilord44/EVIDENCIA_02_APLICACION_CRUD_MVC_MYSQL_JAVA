package model.Publicacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.conexion;

import model.Publicacion.PublicacionVo;
import model.Publicacion.PublicacionDao;


public class PublicacionDao {
    // Atributos para realizar operaciones sobre la base de datos
    Connection con; // Objeto de conexión
    PreparedStatement ps; // Preparar las sentencias
    ResultSet rs; // objeto para almacenar consultas
    String sql = null; // variable para guardar sentencias
    int r;// cantidad de filas que devuelve una sentencia
    //

    // REGISTRAR//
    public int Registrarf(PublicacionVo publicacion) throws SQLException {
        sql = "INSERT INTO Publicacion ( `biografia`,`estado_animo`, `link`) values (?,?,?)";

        try {
            con = conexion.conectar();// abrir conexion
            // preparar sentencia
            ps = con.prepareStatement(sql);
            ps.setString(1, publicacion.getBiografia());
            ps.setString(2, publicacion.getEstado_animo());
            ps.setString(3, publicacion.getLinkf());
            System.out.println(sql);
            ps.executeUpdate();

            ps.close(); // CIERRA LA SENTENCIA
            System.out.println("se registro el publicacion en la base de datos");

        } catch (Exception e) { // define el objeto
            System.out.println("error en el registro" + e.getMessage().toString());
        } finally {
            con.close(); // CIERRA LA CONEXION
        }
        return r;
    }

    // LISTAR
    public List<PublicacionVo> Listarf() throws SQLException {
        // COMENTARIO PROFE: arraylist-almacena datos en memoria-guardar de manera
        // diferente,forma dinamica
        List<PublicacionVo> ListaPublicacion = new ArrayList<>();
        sql = "SELECT * FROM Publicacion";
        try {
            con = conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);

            System.out.println(ps);
            System.out.println(rs);
            // Este bucle se ejecuta mientras haya más filas en el conjunto de resultados.
            while (rs.next()) {
                PublicacionVo row = new PublicacionVo();
                // escribe en el setter los valores encontrados
                row.setId(rs.getInt("id"));
                row.setBiografia(rs.getString("biografia"));
                row.setEstado_animo(rs.getString("estado_animo"));
                row.setLinkf(rs.getString("link"));

                ListaPublicacion.add(row);
            }
            ps.close();
            System.out.println("Consulta Exitosa");
        } catch (Exception e) {
            System.out.println("la consulta no fue ejecutada" + e.getMessage().toString());
        } finally {
            con.close();
        }
        return ListaPublicacion;
    }

    // ELIMINAR
    public void Eliminarf(int id) throws SQLException {
        sql = "DELETE FROM Publicacion WHERE id=" + id;
        try {
            con = conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            System.out.println("LA PUBLICACION SE HA ELIMINADO EXITOSAMENTE");

        } catch (Exception e) {
            System.out.println("Error al eliminar registro" + e.getMessage().toString());
        } finally {
            con.close();
        }
    }

    // SI NO SIRVE ES PQ EL PELOTUDO PUSO QUE SE CAMBIARA EL ID RECUERDE:D
    public void Actualizarf(int id, String biografia, String estado_animo, String linkf) throws SQLException {
        sql="UPDATE `publicacion` SET `biografia`='"+biografia+"',`estado_animo`='"+estado_animo+"',`link`='"+linkf+"' WHERE id="+id;
        try {
            con=conexion.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            System.out.print("Se actualizo la publicacion");

        } catch (Exception e) {
            System.out.println("Error al actualizar estado "+e.getMessage().toString());
        }finally{
            con.close();
        }
    }
}