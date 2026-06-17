/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Libro;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class LibroDAO {

    Conexion conexion = new Conexion();

    public boolean guardarLibro(Libro libro) {

        String sql = "INSERT INTO libros "
                   + "(titulo, autor, anio_publicacion, estado) "
                   + "VALUES (?, ?, ?, ?)";

        try {

            Connection con = conexion.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setInt(3, libro.getAnioPublicacion());
            ps.setString(4, libro.getEstado());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println(
                    "Error al guardar libro: "
                    + e.getMessage()
            );

            return false;
        }
    }
    public Libro buscarPorTitulo(String titulo) {

    String sql = "SELECT * FROM libros WHERE titulo = ?";

    try {

        Connection con = conexion.conectar();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, titulo);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            return new Libro(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getInt("anio_publicacion"),
                    rs.getString("estado")
            );
        }

    } catch (SQLException e) {

        System.out.println(
                "Error al buscar libro: "
                + e.getMessage()
        );
    }

    return null;
    }
    public boolean actualizarLibro(Libro libro) {

    String sql = "UPDATE libros SET "
            + "autor = ?, "
            + "anio_publicacion = ?, "
            + "estado = ? "
            + "WHERE titulo = ?";

    try {

        Connection con = conexion.conectar();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, libro.getAutor());
        ps.setInt(2, libro.getAnioPublicacion());
        ps.setString(3, libro.getEstado());
        ps.setString(4, libro.getTitulo());

        ps.executeUpdate();

        return true;

    } catch (SQLException e) {

        System.out.println(
                "Error al actualizar libro: "
                + e.getMessage()
        );

        return false;
    }
    }
    public boolean eliminarLibro(String titulo) {

    String sql = "DELETE FROM libros WHERE titulo = ?";

    try {

        Connection con = conexion.conectar();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, titulo);

        ps.executeUpdate();

        return true;

    } catch (SQLException e) {

        System.out.println(
                "Error al eliminar libro: "
                + e.getMessage()
        );

        return false;
    }
    }
    public boolean actualizarEstadoLibro(int idLibro, String estado) {

    String sql = "UPDATE libros SET estado = ? WHERE id = ?";

    try {

        Connection con = conexion.conectar();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, estado);
        ps.setInt(2, idLibro);

        ps.executeUpdate();

        return true;

    } catch (SQLException e) {

        System.out.println(
                "Error al actualizar estado del libro: "
                + e.getMessage()
        );

        return false;
    }
    }
    
    public ArrayList<String> listarLibrosDisponibles() {

    ArrayList<String> lista = new ArrayList<>();

    String sql = "SELECT titulo "
               + "FROM libros "
               + "WHERE estado = 'DISPONIBLE'";

    try {

        Connection con = conexion.conectar();

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            lista.add(
                rs.getString("titulo")
            );
        }

    } catch (SQLException e) {

        System.out.println(
            "Error al listar libros: "
            + e.getMessage()
        );
    }

    return lista;
    }
    public Libro buscarPorId(int id) {

    String sql = "SELECT * FROM libros WHERE id = ?";

    try {

        Connection con = conexion.conectar();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            return new Libro(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getInt("anio_publicacion"),
                    rs.getString("estado")
            );
        }

    } catch (SQLException e) {

        System.out.println(
                "Error al buscar libro: "
                + e.getMessage()
        );
    }
    
    return null;
    }
    
    public List<Libro> obtenerLibrosDisponibles() {

    List<Libro> libros = new ArrayList<>();

    String sql =
            "SELECT * FROM libros "
            + "WHERE estado = 'DISPONIBLE'";

    try {

        Connection con = conexion.conectar();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Libro libro = new Libro(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getInt("anio_publicacion"),
                    rs.getString("estado")
            );

            libros.add(libro);
        }

    } catch (SQLException e) {

        System.out.println(
                "Error al obtener libros disponibles: "
                + e.getMessage()
        );
    }

    return libros;
    }
}