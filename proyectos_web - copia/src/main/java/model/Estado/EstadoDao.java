package model.Estado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.conexion;

public class EstadoDao {
    // Atributos para realizar operaciones sobre la base de datos
    Connection con; // Objeto de conexión
    PreparedStatement ps; // Preparar las sentencias
    ResultSet rs; // objeto para almacenar consultas
    String sql = null; // variable para guardar sentencias
    int r;// cantidad de filas que devuelve una sentencia
    //

    // REGISTRAR//
    public int Registrar(EstadoVo estados) throws SQLException {
        sql = "INSERT INTO Estado ( `descripcion`,`link`, `cancion`) values (?,?,?)";

        try {
            con = conexion.conectar();// abrir conexion
            // preparar sentencia
            ps = con.prepareStatement(sql);
            ps.setString(1, estados.getDescripcion());
            ps.setString(2, estados.getLinkw());
            ps.setString(3, estados.getCancion());
            System.out.println(sql);
            ps.executeUpdate();

            ps.close(); // CIERRA LA SENTENCIA
            System.out.println("se registro el estado en la base de datos");

        } catch (Exception e) { // define el objeto
            System.out.println("error en el registro" + e.getMessage().toString());
        } finally {
            con.close(); // CIERRA LA CONEXION
        }
        return r;
    }

    // LISTAR
    public List<EstadoVo> Listar() throws SQLException {
        // COMENTARIO PROFE: arraylist-almacena datos en memoria-guardar de manera
        // diferente,forma dinamica
        List<EstadoVo> ListaEstados = new ArrayList<>();
        sql = "SELECT * FROM Estado";
        try {
            con = conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);

            System.out.println(ps);
            System.out.println(rs);
            // Este bucle se ejecuta mientras haya más filas en el conjunto de resultados.
            while (rs.next()) {
                EstadoVo row = new EstadoVo();
                // escribe en el setter los valores encontrados
                row.setId(rs.getInt("id"));
                row.setDescripcion(rs.getString("descripcion"));
                row.setLinkw(rs.getString("link"));
                row.setCancion(rs.getString("cancion"));

                ListaEstados.add(row);
            }
            ps.close();
            System.out.println("Consulta Exitosa");
        } catch (Exception e) {
            System.out.println("la consulta no fue ejecutada" + e.getMessage().toString());
        } finally {
            con.close();
        }
        return ListaEstados;
    }

    // ELIMINAR
    public void Eliminar(int i) throws SQLException {
        sql = "DELETE FROM Estado WHERE id=" + i;
        try {
            con = conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            System.out.println("EL ESTADO SE HA ELIMINADO EXITOSAMENTE");

        } catch (Exception e) {
            System.out.println("Error al eliminar registro" + e.getMessage().toString());
        } finally {
            con.close();
        }
    }

    // SI NO SIRVE ES PQ EL PELOTUDO PUSO QUE SE CAMBIARA EL ID RECUERDE:D
    public void actualizar(int id, String descripcion, String link, String cancion) throws SQLException {
        sql="UPDATE `estado` SET `descripcion`='"+descripcion+"',`link`='"+link+"',`cancion`='"+cancion+"' WHERE id="+id;
        try {
            con=conexion.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            System.out.print("Se actualizo el estado");

        } catch (Exception e) {
            System.out.println("Error al actualizar estado "+e.getMessage().toString());
        }finally{
            con.close();
        }
    }
}