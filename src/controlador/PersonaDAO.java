/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Persona;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class PersonaDAO {

    Conexion conexion = new Conexion();

    public boolean guardarPersona(Persona persona) {

        String sql = "INSERT INTO personas "
                + "(cedula, nombre, apellido, telefono, "
                + "email, username, password, rol) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            Connection con = conexion.conectar();

            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, persona.getCedula());
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getApellido());
            ps.setString(4, persona.getTelefono());
            ps.setString(5, persona.getEmail());
            ps.setString(6, persona.getUsername());
            ps.setString(7, persona.getPassword());
            ps.setString(8, persona.getRol());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println(
                    "Error al guardar persona: "
                    + e.getMessage()
            );

            return false;
        }
    }
    
    public Persona iniciarSesion(String username, String password) {

    String sql = "SELECT * FROM personas "
               + "WHERE username = ? AND password = ?";

    try {

        Connection con = conexion.conectar();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, username);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            return new Persona(
                    rs.getInt("id"),
                    rs.getString("cedula"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("telefono"),
                    rs.getString("email"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("rol")
            );
        }

    } catch (SQLException e) {

        System.out.println(
                "Error al iniciar sesión: "
                + e.getMessage()
        );
    }

    return null;
    }
    
    public Persona buscarPorCedula(String cedula) {

    String sql = "SELECT * FROM personas WHERE cedula = ?";

    try {

        Connection con = conexion.conectar();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, cedula);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            return new Persona(
                    rs.getInt("id"),
                    rs.getString("cedula"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("telefono"),
                    rs.getString("email"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("rol")
            );
        }

    } catch (SQLException e) {

        System.out.println(
                "Error al buscar persona: "
                + e.getMessage()
        );
    }

    return null;
    }
    
    public boolean actualizarPersona(Persona persona) {

    String sql = "UPDATE personas SET "
            + "nombre = ?, "
            + "apellido = ?, "
            + "telefono = ?, "
            + "email = ?, "
            + "username = ?, "
            + "password = ?, "
            + "rol = ? "
            + "WHERE cedula = ?";

    try {

        Connection con = conexion.conectar();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, persona.getNombre());
        ps.setString(2, persona.getApellido());
        ps.setString(3, persona.getTelefono());
        ps.setString(4, persona.getEmail());
        ps.setString(5, persona.getUsername());
        ps.setString(6, persona.getPassword());
        ps.setString(7, persona.getRol());
        ps.setString(8, persona.getCedula());

        ps.executeUpdate();

        return true;

    } catch (SQLException e) {

        System.out.println(
                "Error al actualizar persona: "
                + e.getMessage()
        );

        return false;
    }
    }
    
    public boolean eliminarPersona(String cedula) {

    String sql = "DELETE FROM personas WHERE cedula = ?";

    try {

        Connection con = conexion.conectar();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, cedula);

        ps.executeUpdate();

        return true;

    } catch (SQLException e) {

        System.out.println(
                "Error al eliminar persona: "
                + e.getMessage()
        );

        return false;
    }
    }
    
    public ArrayList<String> listarUsuarios() {

    ArrayList<String> lista = new ArrayList<>();

    String sql = "SELECT cedula, nombre FROM personas "
               + "WHERE rol = 'Usuario'";

    try {

        Connection con = conexion.conectar();

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            lista.add(
                rs.getString("cedula")
                + " - "
                + rs.getString("nombre")
            );
        }

    } catch (SQLException e) {

        System.out.println(
            "Error al listar usuarios: "
            + e.getMessage()
        );
    }

    return lista;
    }
    public Persona buscarPorId(int id) {

    String sql = "SELECT * FROM personas WHERE id = ?";

    try {

        Connection con = conexion.conectar();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            return new Persona(
                    rs.getInt("id"),
                    rs.getString("cedula"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("telefono"),
                    rs.getString("email"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("rol")
            );
        }

    } catch (SQLException e) {

        System.out.println(
                "Error al buscar persona: "
                + e.getMessage()
        );
    }

    return null;
    }
    
}