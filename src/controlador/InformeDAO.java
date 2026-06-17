/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexion.Conexion;


/**
 *
 * @author User
 */
public class InformeDAO {
    
    Conexion conexion = new Conexion();
    
    public int totalPrestamos() {

    String sql = "SELECT COUNT(*) AS total FROM prestamos";

    try {

        Connection con = conexion.conectar();

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            return rs.getInt("total");
        }

    } catch (SQLException e) {

        System.out.println(
                "Error al obtener total préstamos: "
                + e.getMessage()
        );
    }

    return 0;
    }
    public int totalDevueltos() {

    String sql = "SELECT COUNT(*) AS total "
               + "FROM prestamos "
               + "WHERE estado = 'DEVUELTO'";

    try {

        Connection con = conexion.conectar();

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            return rs.getInt("total");
        }

    } catch (SQLException e) {

        System.out.println(
                "Error al obtener total devueltos: "
                + e.getMessage()
        );
    }

    return 0;
    }
    public int totalEnMora() {

    String sql = "SELECT COUNT(*) AS total "
               + "FROM prestamos "
               + "WHERE estado = 'EN_MORA'";

    try {

        Connection con = conexion.conectar();

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            return rs.getInt("total");
        }

    } catch (SQLException e) {

        System.out.println(
                "Error al obtener total en mora: "
                + e.getMessage()
        );
    }

    return 0;
    }
}
