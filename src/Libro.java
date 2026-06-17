/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author User
 */
public class Informe {
    
    private int id;
    private String fecha;
    private int totalPrestamos;
    private int librosDevueltos;
    private int librosEnMora;
    
    public Informe (int id, String fecha, int totalPrestamos,
                    int librosDevueltos, int librosEnMora){
    this.id = id;
    this.fecha = fecha;
    this.totalPrestamos = totalPrestamos;
    this.librosDevueltos = librosDevueltos;
    this.librosEnMora = librosEnMora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTotalPrestamos() {
        return totalPrestamos;
    }

    public void setTotalPrestamos(int totalPrestamos) {
        this.totalPrestamos = totalPrestamos;
    }

    public int getLibrosDevueltos() {
        return librosDevueltos;
    }

    public void setLibrosDevueltos(int librosDevueltos) {
        this.librosDevueltos = librosDevueltos;
    }

    public int getLibrosEnMora() {
        return librosEnMora;
    }

    public void setLibrosEnMora(int librosEnMora) {
        this.librosEnMora = librosEnMora;
    }
    
}
