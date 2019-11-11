/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author FABIa
 */
public class Cliente extends Usuario {
    private String contraseña;
    private ArrayList<Apuesta> listaDeApuestas;
    private double dinero;
    private int edad;

    public String getContraseña() {
        return contraseña;
    }

    public ArrayList<Apuesta> getListaDeApuestas() {
        return listaDeApuestas;
    }

    public double getDinero() {
        return dinero;
    }

    public int getEdad() {
        return edad;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setListaDeApuestas(ArrayList<Apuesta> listaDeApuestas) {
        this.listaDeApuestas = listaDeApuestas;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    
    
}
