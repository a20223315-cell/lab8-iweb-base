package pe.edu.pucp.iweb.lab8.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pe.edu.pucp.iweb.lab8.beans.Cancion;

public class CancionDao extends BaseDao { // TODO: heredar de BaseDao

    /**
     * Ejercicio 2: todas las canciones (con el nombre de su género, JOIN),
     * ordenadas por título. Use PreparedStatement.
     */
    public List<Cancion> listarCancion() throws SQLException {

        // TODO
        List<Cancion> lista=new ArrayList<>();
        String sql ="SELECT * FROM cancion " +
                "ORDER BY titulo ASC";
        try(Connection conn=getConnection();
            PreparedStatement ps =conn.prepareStatement(sql);
            ResultSet rs =ps.executeQuery()){
            while(rs.next()){
                Cancion cancion=new Cancion();
                cancion.setIdCancion(rs.getInt("idcancion"));
                cancion.setTitulo(rs.getString("titulo"));
                cancion.setArtista(rs.getString("artista"));
                cancion.setDuracion_seg(rs.getInt("duracion_seg"));
                cancion.setAnio(rs.getInt("anio"));
                cancion.setIdGenero(rs.getInt("idgenero"));
                lista.add(cancion);
            }
        }
        return lista;
    }

    /**
     * Ejercicio 2: la canción con ese id, o null si no existe.
     */
    public Cancion buscarPorId(int idCancion) {
        // TODO
        Cancion cancion=null;
        String sql ="SELECT * FROM employees WHERE idcancion=? ";
        try (Connection conn =this.getConnection();
             PreparedStatement pstmt=conn.prepareStatement(sql);){
            pstmt.setInt(1,idCancion);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cancion;
    }

    /**
     * Ejercicio 2: INSERT de una canción nueva (PreparedStatement).
     */
    public void crear(int idCancion, String titulo, String artista, int duracion_seg, int anio, int idGenero) throws SQLException {

        String sql="INSERT INTO cancion " +
                "(idcancion,nombre,artista,duracion_seg,anio,idgenero) " +
                "VALUES (?,?,?,?,?,?)";
        try(Connection conn=getConnection();
            PreparedStatement ps =conn.prepareStatement(sql)){
            ps.setInt(1,idCancion);
            ps.setString(2,titulo);
            ps.setString(3,artista);
            ps.setInt(4,duracion_seg);
            ps.setInt(5,anio);
            ps.setInt(6,idGenero);
            ps.executeQuery();
        }
    }

    /**
     * Ejercicio 2: UPDATE de una canción existente (PreparedStatement).
     */
    public void actualizar(Cancion cancion) throws SQLException {
        String sql= "UPDATE cancion SET titulo = ?, " +
                "artista = ?, duracion_seg = ?, " +
                "anio = ?, idgenero = ? WHERE idcancion = ?";
        try(Connection conn =this.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);){
            pstmt.setString(1, cancion.getTitulo());
            pstmt.setString(2, cancion.getArtista());
            pstmt.setInt(3,cancion.getDuracion_seg());
            pstmt.setInt(4,cancion.getAnio());
            pstmt.setInt(5,cancion.getIdGenero());
            pstmt.setInt(6,cancion.getIdCancion());
            pstmt.executeQuery();
        }
    }



    /**
     * Ejercicio 3: DELETE por id (PreparedStatement).
     */
    public void eliminar(int idCancion) {
        // TODO
        String sql="DELETE FROM cancion " +
                "WHERE idcancion = ? ";

        try(Connection conn =this.getConnection();
            PreparedStatement pstmt= conn.prepareStatement(sql);){
            pstmt.setInt(1,idCancion);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
