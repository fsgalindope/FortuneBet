/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.Stack;


/**
 *
 * @author FABIa
 */
public class Cliente extends Usuario {
    
    private Stack<Apuesta> listaDeApuestas;
    private double dinero;
    private int edad;

    public Cliente(double dinero, int edad, int id, String nombre, String apellido, String correo, String usuario, String contraseña) {
        super(id, nombre, apellido, correo, usuario, contraseña);
        //this.listaDeApuestas = listaDeApuestas;
        this.dinero = dinero;
        this.edad = edad;
    }

    
    
    

   

    public Stack<Apuesta> getListaDeApuestas() {
        return listaDeApuestas;
    }

    public double getDinero() {
        return dinero;
    }

    public int getEdad() {
        return edad;
    }

    

    public void setListaDeApuestas(Stack<Apuesta> listaDeApuestas) {
        this.listaDeApuestas = listaDeApuestas;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    
    
}
