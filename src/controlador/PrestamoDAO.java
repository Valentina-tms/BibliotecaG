/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Prestamo;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.Libro;
import modelo.Persona;




/**
 *
 * @author User
 */
public class PrestamoDAO {

    Conexion conexion = new Conexion();

    public boolean registrarPrestamo(Prestamo prestamo) {

        String sql = "INSERT INTO prestamos "
                   + "(persona_id, libro_id, fecha_prestamo, "
                   + "fecha_limite, fecha_devolucion, estado) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try {

            Connection con = conexion.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, prestamo.getPersona().getId());
            ps.setInt(2, prestamo.getLibro().getId());
            ps.setString(3, prestamo.getFechaPrestamo());
            ps.setString(4, prestamo.getFechaLimite());
            
            if (prestamo.getFechaDevolucion() == null) {

            ps.setNull(
            5,
            java.sql.Types.DATE
            );

            } else {

            ps.setString(
            5,
            prestamo.getFechaDevolucion()
            );
            }
            
            ps.setString(6, prestamo.getEstado());

            ps.executeUpdate();

            return true;

            } catch (SQLException e) {

            JOptionPane.showMessageDialog(
            null,
            e.getMessage()
            );

            return false;
        }
    }
    
    public Prestamo buscarPrestamoPorId(int idPrestamo) {

    String sql = "SELECT * FROM prestamos "
               + "WHERE id = ? "
               + "AND estado = 'PENDIENTE'";

    try {

        Connection con = conexion.conectar();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, idPrestamo);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            PersonaDAO personaDAO = new PersonaDAO();
            LibroDAO libroDAO = new LibroDAO();

            Persona persona =
                    personaDAO.buscarPorId(
                            rs.getInt("persona_id")
                    );

            Libro libro =
                    libroDAO.buscarPorId(
                            rs.getInt("libro_id")
                    );

            return new Prestamo(
                    rs.getInt("id"),
                    persona,
                    libro,
                    rs.getString("fecha_prestamo"),
                    rs.getString("fecha_limite"),
                    rs.getString("fecha_devolucion"),
                    rs.getString("estado")
            );
        }

    } catch (SQLException e) {

        System.out.println(
                "Error al buscar préstamo: "
                + e.getMessage()
        );
    }

    return null;
    }
    
    public boolean registrarDevolucion(
        int idPrestamo,
        String fechaDevolucion,
        String estado) {

    String sql = "UPDATE prestamos "
               + "SET fecha_devolucion = ?, "
               + "estado = ? "
               + "WHERE id = ?";

    try {

        Connection con = conexion.conectar();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, fechaDevolucion);
        ps.setString(2, estado);
        ps.setInt(3, idPrestamo);

        ps.executeUpdate();

        return true;

    } catch (SQLException e) {

        System.out.println(
                "Error al registrar devolución: "
                + e.getMessage()
        );

        return false;
    }
    }
    
}