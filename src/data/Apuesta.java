/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author FABIa
 */
public class Apuesta {
    private int codigo;
    private String descripcion;
    private String deporte;
    private String estado;
    private String liga;
    private double cuota;

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDeporte() {
        return deporte;
    }

    public String getEstado() {
        return estado;
    }

    public String getLiga() {
        return liga;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setLiga(String liga) {
        this.liga = liga;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }
    
    
    
}
