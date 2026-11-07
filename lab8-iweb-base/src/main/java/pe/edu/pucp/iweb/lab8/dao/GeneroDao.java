package pe.edu.pucp.iweb.lab8.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.pucp.iweb.lab8.beans.Genero;

public class GeneroDao extends BaseDao { // TODO: heredar de BaseDao

    /**
     * Ejercicio 2: todos los géneros ordenados por nombre.
     */
    public List<Genero> listarGenero() throws SQLException {
        // TODO
        List<Genero> lista=new ArrayList<>();
        String sql = "SELECT * FROM genero";
        try(Connection conn=getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery()){
            while (rs.next()){
                Genero genero =new Genero();
                genero.setIdGenero(rs.getInt("idgenero"));
                genero.setNombre(rs.getString("nombre"));
                lista.add(genero);
            }
        }
        return lista;
    }
}
